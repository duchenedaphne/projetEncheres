package fr.eni.projetEncheres.dal.dao;

import java.util.List;
//import java.sql.SQLException;

import fr.eni.projetEncheres.bo.Categorie;
//import fr.eni.eniEncheres.dal.DalException;

/**
 * @author Julian
 */

public interface CategorieDAO {

	//insert update delete // admin 
	
	public Categorie selectCategorieById(int no_article); //throws  SQLException, DalException;
	
	public void insert(Categorie c); //throws  SQLException, DalException;
	
	public void update(Categorie c); //throws  SQLException, DalException;
	
	public void delete(int no_categorie); //throws  SQLException, DalException;
	
	//select list
	
	public List<Categorie> select(); //throws  SQLException, DalException;
	
	public List<Categorie> selectAlCategorie(); //throws  SQLException, DalException;
	
	}
