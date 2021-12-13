package fr.eni.projetEncheres.bll;

import java.sql.SQLException;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.dal.dao.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;

//import fr.eni.projet_encheres.dal.ExceptionDAL;

/**
 * @author Julian
 */

public class ArticleVenduManager {
	
    //---------------------------------------------------------------------
	//Factory
    private static ArticleVenduDAO dao;

    static {
        dao = FactoryDAO.getArticleVenduDAO();
    }
    
    //---------------------------------------------------------------------
	//CREATE
    public void createArticleVendu(ArticleVendu articleVendu) throws SQLException, BusinessException{

            dao.insert(articleVendu);

    }
    
    //---------------------------------------------------------------------
    //READ
    public ArticleVendu getArticleVenduById(int no_article) throws SQLException, BusinessException{
    	
    	
        ArticleVendu articleVendu = 
        		dao.selectArticleVenduById(no_article);
        return articleVendu;
    }
    
    //--------------------------------------------------------------------- 
    //UPDATE
    public void updateArticleVendu(ArticleVendu articleVenduUpdate) throws SQLException, BusinessException{

    		dao.update(articleVenduUpdate);
    }
    
    //--------------------------------------------------------------------- 
    //DELETE
    public void deleteArticleVendu(int articleVenduDelete) throws SQLException, BusinessException{
    	
        dao.delete(articleVenduDelete);
    }
}
