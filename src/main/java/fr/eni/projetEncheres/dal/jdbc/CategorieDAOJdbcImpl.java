package fr.eni.projetEncheres.dal.jdbc;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.CodesResultatDAL;
import fr.eni.projetEncheres.dal.dao.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.dao.CategorieDAO;
import fr.eni.projetEncheres.dal.dao.EnchereDAO;
import fr.eni.projetEncheres.dal.dao.RetraitDAO;
import fr.eni.projetEncheres.dal.dao.UtilisateurDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Julian
 */

public class CategorieDAOJdbcImpl implements CategorieDAO {

	@Override
	public Categorie selectCategorieById(int no_article) throws BusinessException {

        Categorie c = null;
		try (Connection cnx = JdbcTools.connect()) {
			
			String SELECT_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie = ?";
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, no_article);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
					
					c = new Categorie(rs.getInt("no_categorie"),
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
		return c;
	}

	@Override
	public void insert(Categorie c) throws BusinessException {
		try(Connection cnx = JdbcTools.connect()) {
			try {
	            String INSERT = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
				
				
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, 
						PreparedStatement.RETURN_GENERATED_KEYS);
		        pstmt.setInt(1, c.getNo_categorie());
		        pstmt.setString(2, c.getLibelle());
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					c.setNo_categorie(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.close();
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
	public void update(Categorie c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int no_categorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categorie> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> selectAlCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

}