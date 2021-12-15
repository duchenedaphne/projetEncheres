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
	/**
	    * @author Adrien Bodin
	     * @return 
	    */
	
    private EnchereDAO enchereDAO;

    public EnchereManager() {
        this.enchereDAO = FactoryDAO.getEnchereDAO();
        
    }
	
    //---------------------------------------------------------------------
	//CREATE 
    /**
    * @author Adrien Bodin
     * @return 
    */
    public Enchere ajouterEnchere( Utilisateur no_utilisateur, int no_article, Date date_enchere, int montant_enchere )throws SQLException, BusinessException{

    	BusinessException be = new BusinessException();
		this.ValiderEnchere( be);
    
		Enchere enchere = null;
		
		if (!be.hasErreurs()) {
			enchere = new Enchere();
			enchere.setUtilisateur(no_utilisateur);
			enchere.setNo_article(no_article);
			enchere.setDate_enchere(date_enchere);
			enchere.setMontant_enchere(montant_enchere);

			this.enchereDAO.insert(enchere);
			
		} else {
			throw be;
		}
		
		return enchere;

    }
    
    private void ValiderEnchere(BusinessException be) {
		// TODO Auto-generated method stub
		
	}

	//---------------------------------------------------------------------
    //READ
    public Enchere getEnchereById(int no_enchere)throws SQLException, BusinessException{
    	
    	
    		Enchere enchere = enchereDAO.selectEnchereById(no_enchere);
        return enchere;
    }

    //--------------------------------------------------------------------- 
    //UPDATE
    public void updateEnchere(Enchere enchereUpdate)throws SQLException, BusinessException{

    	enchereDAO.update(enchereUpdate);
    }
    
    //--------------------------------------------------------------------- 
    //DELETE
    public void deleteEnchere(int enchereDelete)throws SQLException, BusinessException{
    	
    	enchereDAO.delete(enchereDelete);
    }
}
