package fr.eni.projetEncheres.bll;

import fr.eni.projetEncheres.bo.Enchere;
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
    public void createEnchere(Enchere enchere){

            dao.insert(enchere);

    }
    
    //---------------------------------------------------------------------
    //READ
    public Enchere getEnchereById(int no_enchere){
    	
    	
    		Enchere enchere = 
        		dao.selectEnchereById(no_enchere);
        return enchere;
    }

    //--------------------------------------------------------------------- 
    //UPDATE
    public void updateEnchere(Enchere enchereUpdate){

    		dao.update(enchereUpdate);
    }
    
    //--------------------------------------------------------------------- 
    //DELETE
    public void deleteEnchere(int enchereDelete){
    	
        dao.delete(enchereDelete);
    }
}
