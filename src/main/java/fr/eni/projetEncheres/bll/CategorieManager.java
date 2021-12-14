package fr.eni.projetEncheres.bll;

import java.sql.SQLException;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.dal.dao.CategorieDAO;
import fr.eni.projetEncheres.dal.dao.DAO;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;

//import fr.eni.projet_encheres.dal.ExceptionDAL;

/**
 * @author Julian
 */

public class CategorieManager {

    //---------------------------------------------------------------------
	//Factory
    private static DAO<Categorie> categorieDao;

    public CategorieManager() {
        categorieDao = FactoryDAO.getCategorieDAO();
    }
    
    //---------------------------------------------------------------------
	//CREATE
    public Categorie createCategorie(String libelle)throws SQLException, BusinessException{
 
    	BusinessException businessException = new BusinessException(); 
    	
    	this.validerLibelle(libelle, businessException);
    	
    	Categorie categorie = null;
    	
    	if (!businessException.hasErreurs()) {
    		
    		categorie = new Categorie();
    		categorie.setLibelle(libelle);
    		
    		this.categorieDao.insert(categorie);
    	} else {
    		throw businessException;
    	}
    	return categorie;
    }
    
    //---------------------------------------------------------------------
    //READ
    public Categorie getCategorieById(int no_categorie)throws SQLException, BusinessException{
    	
    	
    		Categorie categorie = 
    			categorieDao.selectById(no_categorie);
        return categorie;
    }
    
    //--------------------------------------------------------------------- 
    //UPDATE
    public void updateCategorie(Categorie categorieUpdate)throws SQLException, BusinessException{

    	categorieDao.update(categorieUpdate);
    }
    
    //--------------------------------------------------------------------- 
    //DELETE
    public void deleteCategorie(int categorieDelete)throws SQLException, BusinessException{
    	
    	categorieDao.delete(categorieDelete);
    }
    
    private void validerLibelle(String libelle, BusinessException businessException) {
		if (libelle == null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_LIBELLE_ERREUR);
		} 
	}
}
