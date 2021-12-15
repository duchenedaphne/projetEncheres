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
    public void ajouterEnchere( Utilisateur no_utilisateur, int no_article, Date date_enchere, int montant_enchere )throws SQLException, BusinessException{

    	
    
		Enchere enchere = null;
		
		if (!be.hasErreurs()) {
			enchere = new Enchere();
			enchere.setUtilisateur(no_utilisateur);
			enchere.setNo_article(no_article);
			enchere.setDate_enchere(date_enchere);
			enchere.setMontant_enchere(montant_enchere);


			
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
