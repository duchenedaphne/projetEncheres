package fr.eni.projetEncheres.dal.jdbc;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.dal.CodesResultatDAL;
import fr.eni.projetEncheres.dal.ConnectionProvider;
import fr.eni.projetEncheres.dal.dao.CategorieDAO;
import fr.eni.projetEncheres.dal.dao.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Julian
 */

public class CategorieDAOJdbcImpl implements DAO<Categorie>, CategorieDAO {

	private static final String SQL_SELECT_BY_ID = "select no_categorie, libelle " 
			+ " from categories where no_categorie = ?";
	private static final String SQL_SELECT_ALL = "select no_categorie, libelle " 
			+ " from categories";
	private static final String SQL_UPDATE = "update categories set libelle=?"
			+ " where no_categorie = ?";
	private static final String SQL_INSERT = "insert into categories(libelle) "
			+ "values(?)";
	private static final String SQL_DELETE = "delete from categories where no_categorie = ?";

	@Override
	public Categorie selectById(int no_categorie) throws BusinessException {

        Categorie categorie = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setInt(1, no_categorie);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
					
					categorie = new Categorie(rs.getInt("no_categorie"),
			                rs.getString("libelle"));
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
		return categorie;
	}
	
	@Override
	public List<Categorie> selectAll() throws BusinessException {
		
		List<Categorie> categories = new ArrayList<Categorie>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			Categorie categorie = null;
			
			while (rs.next()) {
				if (rs.getInt("no_categorie") != categorie.getNo_categorie()) {
					
					categorie = new Categorie(rs.getInt("no_categorie"),
							rs.getString("libelle"));
				}
				categories.add(categorie);
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
		return categories;
	}

	@Override
	public void insert(Categorie categorie) throws BusinessException {
		
		if(categorie == null)
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
				pstmt.setString(1, categorie.getLibelle());
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					categorie.setNo_categorie(rs.getInt(1));
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
	public void update(Categorie c) throws BusinessException {
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE);
		    
		    pstmt.setString(1, c.getLibelle());
		    
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
	public void delete(int no_categorie) throws BusinessException {
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE);
		    pstmt.setInt(1, no_categorie);
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