package fr.eni.projetEncheres.bll;

import java.sql.Date;
import java.sql.SQLException;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.dao.EnchereDAO;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;

//import fr.eni.projet_encheres.dal.ExceptionDAL;

/**
 * @author Julian
 */

public class EnchereManager {
	
    //---------------------------------------------------------------------
	//Factory
    private static EnchereDAO dao;

    static {
        dao = FactoryDAO.getEnchereDAO();
    }
	
    //---------------------------------------------------------------------
	//CREATE 
    /**
    * @author Adrien Bodin
    */
    public void ajouterEnchere(String NomArticle, String description, String catégories, String photoArticle, int credit, Date DébutEnchère, Date FinEnchère, String rue, String codepostal, String ville  )throws SQLException, BusinessException{

    
		Enchere enchere = null;
		
		if (!be.hasErreurs()) {
			enchere = new Enchere();
			enchere.setNomArticle(NomArticle);
			enchere.setDescription(description);
			enchere.setCatégories(catégories);
			enchere.setPhotoArticle(photoArticle);
			enchere.setCredit(credit);
			enchere.setDébutEnchère(DébutEnchère);
			enchere.setFinEnchère(FinEnchère);
			enchere.setRue(rue);
			enchere.setCodepostal(codepostal);
			enchere.setVille(ville);

			
			this.EnchereDAO.insert(enchere);
			
		} else {
			throw be;
		}
		
		return enchere;

    }
    
    //---------------------------------------------------------------------
    //READ
    public Enchere getEnchereById(int no_enchere)throws SQLException, BusinessException{
    	
    	
    		Enchere enchere = 
        		dao.selectEnchereById(no_enchere);
        return enchere;
    }

    //--------------------------------------------------------------------- 
    //UPDATE
    public void updateEnchere(Enchere enchereUpdate)throws SQLException, BusinessException{

    		dao.update(enchereUpdate);
    }
    
    //--------------------------------------------------------------------- 
    //DELETE
    public void deleteEnchere(int enchereDelete)throws SQLException, BusinessException{
    	
        dao.delete(enchereDelete);
    }
}
