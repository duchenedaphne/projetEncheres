package fr.eni.projetEncheres.bll;

import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.dal.dao.CategorieDAO;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;

//import fr.eni.projet_encheres.dal.ExceptionDAL;

/**
 * @author Julian
 */

public class CategorieManager {

    //---------------------------------------------------------------------
	//Factory
    private static CategorieDAO dao;

    static {
        dao = FactoryDAO.getCategorieDAO();
    }
    
    //---------------------------------------------------------------------
	//CREATE
    public void createCategorie(Categorie categorie){

            dao.insert(categorie);

    }
    
    //---------------------------------------------------------------------
    //READ
    public Categorie getCategorieById(int no_categorie){
    	
    	
    		Categorie categorie = 
        		dao.selectCategorieById(no_categorie);
        return categorie;
    }
    
    //--------------------------------------------------------------------- 
    //UPDATE
    public void updateCategorie(Categorie categorieUpdate){

    		dao.update(categorieUpdate);
    }
    
    //--------------------------------------------------------------------- 
    //DELETE
    public void deleteCategorie(int categorieDelete){
    	
        dao.delete(categorieDelete);
    }
}
