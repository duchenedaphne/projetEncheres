package fr.eni.projetEncheres.dal.jdbc;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.CodesResultatDAL;
import fr.eni.projetEncheres.dal.ConnectionProvider;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Julian
 */

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	
	@Override
	public ArticleVendu selectArticleVenduById(int no_article) throws BusinessException {
		ArticleVendu av = new ArticleVendu();
		
		try (Connection cnx = JdbcTools.connect()) {
			
			cnx.setAutoCommit(false);
			String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, no_article);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
					
					av = new ArticleVendu(rs.getInt("no_article"),
			                rs.getString("nom_article"),
			                rs.getString("description"),
			                rs.getDate("date_debut_encheres"),
			                rs.getDate("date_fin_encheres"),
			                rs.getInt("prix_initial"),
			                rs.getInt("prix_vente"),
			                rs.getInt("utilisateur"),
			                rs.getInt("categorie"));
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
		return av;
	}

	@Override
	public void insert(ArticleVendu av) throws BusinessException {

		try(Connection cnx = JdbcTools.connect()) {
			try {
	            String INSERT = "INSERT INTO ARTICLES_VENDUS " +
	                    "(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie) " +
	                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, 
						PreparedStatement.RETURN_GENERATED_KEYS);
		        pstmt.setString(1, av.getNom_article());
		        pstmt.setString(2, av.getDescription());
		        pstmt.setObject(3, av.getDate_debut_encheres());
		        pstmt.setObject(4, av.getDate_fin_encheres());
		        pstmt.setInt(5, av.getPrix_initial());
		        pstmt.setInt(6, av.getPrix_vente());
		        pstmt.setInt(7, av.getUtilisateur());
		        pstmt.setInt(8, av.getCategorie());
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					av.setNo_article(rs.getInt(1));
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
	public void update(ArticleVendu av) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
            String UPDATE = "UPDATE ARTICLES_VENDUS SET " +
                    "nom_article = ?, " +
                    "description = ?, " +
                    "date_debut_encheres = ?, " +
                    "date_fin_encheres = ?, " +
                    "prix_initial = ?, " +
                    "prix_vente = ?, " +
                    "etat_vente = ?, " +
                    "no_utilisateur = ?, " +
                    "no_categorie = ? " +
                    "WHERE no_article= ?;";
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
	        pstmt.setString(1, av.getNom_article());
	        pstmt.setString(2, av.getDescription());
	        pstmt.setObject(3, av.getDate_debut_encheres());
	        pstmt.setObject(4, av.getDate_fin_encheres());
	        pstmt.setInt(5, av.getPrix_initial());
	        pstmt.setInt(6, av.getPrix_vente());
	        pstmt.setInt(7, av.getUtilisateur());
	        pstmt.setInt(8, av.getCategorie()); 
		    
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
	        String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ? ";
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
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
	public List<ArticleVendu> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectAllArticleVendu() {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
            	String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			ArticleVendu av = null;
			
			while (rs.next()) {
				if (rs.getInt("no_article") != av.getNo_article()) {
					
					av = new ArticleVendu(rs.getInt("no_article"),
			                rs.getString("nom_article"),
			                rs.getString("description"),
			                rs.getDate("date_debut_encheres"),
			                rs.getDate("date_fin_encheres"),
			                rs.getInt("prix_initial"),
			                rs.getInt("prix_vente"),
			                rs.getInt("utilisateur"),
			                rs.getInt("categorie"));
				}
				articleVendus.add(av);
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
		return articleVendus;
		return null;
	}

	@Override
	public List<ArticleVendu> selectAllArticleVenduByUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		return null;
	}
}