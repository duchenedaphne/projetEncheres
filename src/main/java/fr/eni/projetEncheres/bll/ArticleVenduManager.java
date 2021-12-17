package fr.eni.projetEncheres.bll;

import java.sql.Date;
import java.sql.SQLException;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.dao.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.dao.DAO;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;
import fr.eni.projetEncheres.dal.dao.UtilisateurDAO;

//import fr.eni.projet_encheres.dal.ExceptionDAL;

/**
 * @author Julian
 */

@SuppressWarnings("null")
public class ArticleVenduManager {
	
	private DAO<ArticleVendu> articleVenduDAO;
	
    //---------------------------------------------------------------------
	//Factory
    private static ArticleVenduDAO dao;

    static {
        dao = FactoryDAO.getArticleVenduDAO();
    }
    
    public ArticleVenduManager() {
    	this.dao = FactoryDAO.getArticleVenduDAO();
    }
    //---------------------------------------------------------------------
	//CREATE
    public ArticleVendu createArticleVendu(int no_article, String nom_article, String description, //Date date_debut_encheres, Date date_fin_encheres, 
    			int prix_initial, int prix_vente, Utilisateur utilisateur, Categorie categorie) throws BusinessException {
    	
    	BusinessException be = new BusinessException();
    	
        ArticleVendu av = null;
    	
    	if (!be.hasErreurs()) {
    		av = new ArticleVendu();
	        av.setNo_article(no_article);
	        av.setNom_article(nom_article);
	        av.setDescription(description);
	        av.setDate_debut_encheres(null);
	        av.setDate_fin_encheres(null);
	        av.setPrix_initial(prix_initial);
	        av.setPrix_vente(prix_vente);
	        av.setUtilisateur(utilisateur);
	        av.setCategorie(categorie);
	        
			this.articleVenduDAO.insert(av);

	        
        } else {
			throw be;
        }
		return av;
    }
    
    //---------------------------------------------------------------------
    //READ
    public ArticleVendu getArticleVendu(int no_article) throws SQLException, BusinessException{
    	
    	ArticleVendu articleVendu = new ArticleVendu();
    	
    	articleVendu= articleVenduDAO.selectById(no_article);
    	
        return articleVendu;
    }
    
    //--------------------------------------------------------------------- 
    //UPDATE
    public void updateArticleVendu(int no_article, String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, int prix_initial, int prix_vente, Utilisateur utilisateur, Categorie categorie) throws BusinessException{

		BusinessException be = new BusinessException();
		
		ArticleVendu av = null;
		
		if (!be.hasErreurs()) {
	        
			av = new ArticleVendu();
			av.setNo_article(no_article);
	        av.setNom_article(nom_article);
	        av.setDescription(description);
	        av.setDate_debut_encheres(date_debut_encheres);
	        av.setDate_fin_encheres(date_fin_encheres);
	        av.setPrix_initial(prix_initial);
	        av.setPrix_vente(prix_vente);
	        av.setUtilisateur(utilisateur);
	        av.setCategorie(categorie);
			
			this.articleVenduDAO.update(av);
		} else {
			throw be;
		}
    }
    
    //--------------------------------------------------------------------- 
    //DELETE
    public void deleteArticleVendu(int no_articleVendu) throws SQLException, BusinessException{
    	
    	articleVenduDAO.delete(no_articleVendu);
    }
    
}
