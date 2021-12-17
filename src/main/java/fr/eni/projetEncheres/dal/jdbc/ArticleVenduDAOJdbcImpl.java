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
import fr.eni.projetEncheres.dal.dao.DAO;
import fr.eni.projetEncheres.dal.dao.EnchereDAO;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;
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

public class ArticleVenduDAOJdbcImpl implements DAO<ArticleVendu>, ArticleVenduDAO {

	
	@Override
	public ArticleVendu selectById(int no_article) throws BusinessException {
		ArticleVendu articleVendu = new ArticleVendu();
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			cnx.setAutoCommit(false);
			String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, no_article);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
		        Utilisateur articleUtilisateur = this.getavUtilisateur(rs.getInt("uid"));
		        Categorie articleCategorie = this.getavCategorie(rs.getInt("cid"));


		        ArticleVendu av = new ArticleVendu();
		        av.setNo_article(rs.getInt("no_article"));
		        av.setNom_article(rs.getString("nom_article"));
		        av.setDescription(rs.getString("description"));
		        av.setDate_debut_encheres( rs.getDate("dateDebutEncheres"));
		        av.setDate_fin_encheres( rs.getDate("dateFinEncheres"));
		        av.setPrix_initial(rs.getInt("prixInitial"));
		        av.setPrix_vente(rs.getInt("prixVente"));
		        av.setUtilisateur(articleUtilisateur);
		        av.setCategorie(articleCategorie);


		        return av;
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
		return articleVendu;
	}


	
	private Utilisateur getavUtilisateur(int uid) throws BusinessException, SQLException {
        Utilisateur avUtilisateur = null;
        DAO<Utilisateur> utilisateurDao = FactoryDAO.getUtilisateurDAO();
        avUtilisateur = utilisateurDao.selectById(uid);

        return avUtilisateur;
    }

    private Categorie getavCategorie(int cid) throws BusinessException, SQLException {
        Categorie avCategorie = null;
        DAO<Categorie> categorieDao = FactoryDAO.getCategorieDAO();
        avCategorie = categorieDao.selectById(cid);

        return avCategorie;
    }
	

	
	@Override
	public void insert(ArticleVendu data) throws BusinessException {

		try(Connection cnx = ConnectionProvider.getConnection()) {
			try {
	            String INSERT = "INSERT INTO ARTICLES_VENDUS " +
	                    "(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie) " +
	                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, 
						PreparedStatement.RETURN_GENERATED_KEYS);
		        pstmt.setString(1, data.getNom_article());
		        pstmt.setString(2, data.getDescription());
		        pstmt.setObject(3, null);
		        pstmt.setObject(4, null);
		        pstmt.setInt(5, data.getPrix_initial());
		        pstmt.setInt(6, data.getPrix_vente());
		        pstmt.setString(7, "Vente en cours");
		        pstmt.setInt(8, data.getUtilisateur().getNo_utilisateur());
		        pstmt.setInt(9, data.getCategorie().getNo_categorie());
		        
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					data.setNo_article(rs.getInt(1));
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
	public void update(ArticleVendu data) throws BusinessException {
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
	        pstmt.setInt(1, data.getNo_article());
	        pstmt.setString(2, data.getNom_article());
	        pstmt.setString(3, data.getDescription());
	        pstmt.setObject(4, data.getDate_debut_encheres());
	        pstmt.setObject(5, data.getDate_fin_encheres());
	        pstmt.setInt(6, data.getPrix_initial());
	        pstmt.setInt(7, data.getPrix_vente());
	        pstmt.setInt(8, data.getUtilisateur().getNo_utilisateur());
	        pstmt.setInt(9, data.getCategorie().getNo_categorie()); 
		    
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
	public List<ArticleVendu> selectAll() throws BusinessException {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
            	String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			ArticleVendu av = null;
			
			while (rs.next()) {
				if (rs.getInt("no_article") != av.getNo_article()) {
					
			        Utilisateur avUtilisateur = this.getavUtilisateur(rs.getInt("utilisateurId"));
			        Categorie avCategorie = this.getavCategorie(rs.getInt("categorieId"));				
					
						av = new ArticleVendu(rs.getInt("no_article"),
				                rs.getString("nom_article"),
				                rs.getString("description"),
				                rs.getDate("date_debut_encheres"),
				                rs.getDate("date_fin_encheres"),
				                rs.getInt("prix_initial"),
				                rs.getInt("prix_vente"),
				                (avUtilisateur),
				                (avCategorie));
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
	}

	@Override
	public List<ArticleVendu> selectAllArticleVenduByUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	 * private Utilisateur getavUtilisateur(int uid) throws BusinessException {
	 * Utilisateur avUtilisateur = null; UtilisateurDAO utilisateurDao =
	 * FactoryDAO.getUtilisateurODAO(); try { avUtilisateur =
	 * utilisateurDao.selectById(uid); } catch (SQLException e) { throw new
	 * BusinessException(); }
	 * 
	 * return avUtilisateur; }
	 */
    
	
	/*
	 * private Categorie getavCategorie(int cid) throws BusinessException {
	 * Categorie avCategorie = null; CategorieDAO categorieDao =
	 * FactoryDAO.getCategorieDAO(); try { avCategorie =
	 * categorieDao.selectCategorieById(cid); } catch (SQLException e) { throw new
	 * BusinessException(); }
	 * 
	 * return avCategorie; }
	 */
	
	/*
	 * private ArticleVendu articleBuilder(ResultSet rs) throws SQLException,
	 * BusinessException {
	 * 
	 * Utilisateur articleUtilisateur =
	 * this.getavUtilisateur(rs.getInt("idUtilisateur")); Categorie articleCategorie
	 * = this.getavCategorie(rs.getInt("idCategorie"));
	 * 
	 * 
	 * ArticleVendu av = new ArticleVendu();
	 * av.setNo_article(rs.getInt("no_article"));
	 * av.setNom_article(rs.getString("nom_article"));
	 * av.setDescription(rs.getString("description")); av.setDate_debut_encheres(
	 * rs.getDate("dateDebutEncheres")); av.setDate_fin_encheres(
	 * rs.getDate("dateFinEncheres")); av.setPrix_initial(rs.getInt("prixInitial"));
	 * av.setPrix_vente(rs.getInt("prixVente"));
	 * av.setUtilisateur(articleUtilisateur); av.setCategorie(articleCategorie);
	 * 
	 * 
	 * return av; }
	 */
}