package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.dal.CodesResultatDAL;
import fr.eni.projetEncheres.dal.ConnectionProvider;
import fr.eni.projetEncheres.dal.dao.DAO;
import fr.eni.projetEncheres.dal.dao.RetraitDAO;

/**
 * @author Daphné
 */
public class RetraitDAOJdbcImpl implements DAO<Retrait>, RetraitDAO {

	private static final String SQL_SELECT_BY_ID = "select no_article, rue, code_postal, ville " 
			+ " from retraits where no_article = ?";
	private static final String SQL_SELECT_ALL = "select no_article, rue, code_postal, ville " 
			+ " from retraits";
	private static final String SQL_UPDATE = "update retraits set rue=?,code_postal=?,ville=?"
			+ " where no_article = ?";
	private static final String SQL_INSERT = "insert into retraits(rue,code_postal,ville) "
			+ "values(?,?,?)";
	private static final String SQL_DELETE = "delete from retraits where no_article = ?";

	@Override
	public Retrait selectById(int no_article) throws BusinessException {

		Retrait retrait = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setInt(1, no_article);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
					
					retrait = new Retrait(rs.getInt("no_article"),
							rs.getString("rue"),
							rs.getString("code_postal"),
							rs.getString("ville"));
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
		return retrait;
	}

	@Override
	public List<Retrait> selectAll() throws BusinessException {
		
		List<Retrait> retraits = new ArrayList<Retrait>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			Retrait retrait = null;
			
			while (rs.next()) {
				if (rs.getInt("no_article") != retrait.getNo_article()) {
					
					retrait = new Retrait(rs.getInt("no_article"),
							rs.getString("rue"),
							rs.getString("code_postal"),
							rs.getString("ville"));
				}
				retraits.add(retrait);
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
		return retraits;
	}

	@Override
	public void insert(Retrait retrait) throws BusinessException {
		
		if(retrait == null)
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
				pstmt.setString(1, retrait.getRue());
				pstmt.setString(2, retrait.getCode_postal());
				pstmt.setString(3, retrait.getVille());
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					retrait.setNo_article(rs.getInt(1));
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
	public void update(Retrait data) throws BusinessException {
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE);
		    
		    pstmt.setString(1, data.getRue());
		    pstmt.setString(2, data.getCode_postal());
		    pstmt.setString(3, data.getVille());
		    
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
	public void delete(int no_article) throws BusinessException {
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE);
		    pstmt.setInt(1, no_article);
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

	@Override
	public void valider(int no_article) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectLog(String id, String password) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectMail(String id, String password) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}


