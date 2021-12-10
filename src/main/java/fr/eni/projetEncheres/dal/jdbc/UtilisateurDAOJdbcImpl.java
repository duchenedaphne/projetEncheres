package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.CodesResultatDAL;
import fr.eni.projetEncheres.dal.ConnectionProvider;
import fr.eni.projetEncheres.dal.dao.DAO;
import fr.eni.projetEncheres.dal.dao.UtilisateurDAO;

/**
 * @author Daphné
 */
public class UtilisateurDAOJdbcImpl implements DAO<Utilisateur>, UtilisateurDAO {
	
	private static final String SQL_SELECT_BY_ID = "select no_utilisateur, pseudo, "
			+ "nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur " 
			+ " from utilisateurs where no_utilisateur = ?";
	private static final String SQL_SELECT_ALL = "select no_utilisateur, pseudo, nom, prenom, "
			+ "email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur " +  
			" from utilisateurs";
	private static final String SQL_UPDATE = "update utilisateurs set pseudo=?,nom=?,"
			+ "prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot-de-passe=?"
			+ " where no_utilisateur = ?";
	private static final String SQL_INSERT = "insert into utilisateurs(pseudo,nom,prenom,email,telephone,"
			+ "rue,code_postal,ville,mot_de_passe,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "delete from utilisateurs where no_utilisateur = ?";

	@Override
	public Utilisateur selectById(int no_utilisateur) throws BusinessException {
		
		Utilisateur utilisateur = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setInt(1, no_utilisateur);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
					
					utilisateur = new Utilisateur(rs.getInt("no_utilisateur"),
							rs.getString("pseudo"),
							rs.getString("nom"),
							rs.getString("prenom"),
							rs.getString("email"),
							rs.getString("telephone"),
							rs.getString("rue"),
							rs.getString("code_postal"),
							rs.getString("ville"),
							rs.getString("mot_de_passe"),
							rs.getInt("credit"),
							rs.getBoolean("administrateur"));
			}
			try {
				if (rs != null){
					rs.close();
				}
				if (pstmt != null){
					pstmt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			throw new BusinessException();
		} 
		return utilisateur;
	}
	
	@Override
	public List<Utilisateur> selectAll() throws BusinessException {
		
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			Utilisateur utilisateur = null;
			
			while (rs.next()) {
				if (rs.getInt("no_utilisateur") != utilisateur.getNo_utilisateur()) {
					
					utilisateur = new Utilisateur(rs.getInt("no_utilisateur"),
							rs.getString("pseudo"),
							rs.getString("nom"),
							rs.getString("prenom"),
							rs.getString("email"),
							rs.getString("telephone"),
							rs.getString("rue"),
							rs.getString("code_postal"),
							rs.getString("ville"),
							rs.getString("mot_de_passe"),
							rs.getInt("credit"),
							rs.getBoolean("administrateur"));
				}
				utilisateurs.add(utilisateur);
				try {
					if (rs != null){
						rs.close();
					}
					if (pstmt != null){
						pstmt.close();
					}
					if(cnx!=null){
						cnx.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch (SQLException e) {
			throw new BusinessException();
		} 
		return utilisateurs;
	}
	
	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {
		
		if(utilisateur == null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, 
						PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCode_postal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMot_de_passe());
				pstmt.setInt(10, utilisateur.getCredit());
				pstmt.setBoolean(11, utilisateur.isAdministrateur());
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					utilisateur.setNo_utilisateur(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}	
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}	
	}

	@Override
	public void update(Utilisateur data) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE);
		    pstmt.setString(1, data.getPseudo());
		    pstmt.setString(2, data.getNom());
		    pstmt.setString(3, data.getPrenom());
		    pstmt.setString(4, data.getEmail());
		    pstmt.setString(5, data.getTelephone());
		    pstmt.setString(8, data.getRue());
		    pstmt.setString(9, data.getCode_postal());
		    pstmt.setString(10, data.getVille());
		    pstmt.setString(11, data.getMot_de_passe());
		    pstmt.setInt(12, data.getCredit());
		    pstmt.setBoolean(13, data.isAdministrateur());
		    
		    pstmt.executeUpdate();
		    try {
		        if (pstmt != null){
		            pstmt.close();
		        }
		        if(cnx !=null){
		            cnx.close();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		} catch (SQLException e) {
		    throw new BusinessException();
		} 
	}

	@Override
	public void delete(int no_utilisateur) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE);
		    pstmt.setInt(1, no_utilisateur);
		    pstmt.executeUpdate();
		    try {
		        if (pstmt != null){
		            pstmt.close();
		        }
		        if(cnx!=null){
		            cnx.close();
		        }
		    } catch (SQLException e) {
		        throw new BusinessException();
		    }
		} catch (SQLException e) {
		    throw new BusinessException();
		} 
	}

}




