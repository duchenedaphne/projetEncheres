package fr.eni.projetEncheres.bll;

import java.sql.SQLException;

import fr.eni.projetEncheres.BusinessException;
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
    public void createCategorie(Categorie categorie)throws SQLException, BusinessException{

            dao.insert(categorie);

    }
    
    //---------------------------------------------------------------------
    //READ
    public Categorie getCategorieById(int no_categorie)throws SQLException, BusinessException{
    	
    	
    		Categorie categorie = 
        		dao.selectCategorieById(no_categorie);
        return categorie;
    }
    
    //--------------------------------------------------------------------- 
    //UPDATE
    public void updateCategorie(Categorie categorieUpdate)throws SQLException, BusinessException{

    		dao.update(categorieUpdate);
    }
    
    //--------------------------------------------------------------------- 
    //DELETE
    public void deleteCategorie(int categorieDelete)throws SQLException, BusinessException{
    	
        dao.delete(categorieDelete);
    }
}
