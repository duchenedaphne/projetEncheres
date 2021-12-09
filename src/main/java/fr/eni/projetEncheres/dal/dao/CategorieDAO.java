package fr.eni.projetEncheres.dal.dao;

import java.util.List;
//import java.sql.SQLException;

import fr.eni.projetEncheres.bo.Categorie;
//import fr.eni.eniEncheres.dal.DALException;

/**
 * @author Julian
 */

public interface CategorieDAO {

	
	//insert update delete // admin 
	
	public Categorie selectCategorieById(int no_article); //throws  SQLException, DALException;
	
	public void insert(Categorie c); //throws  SQLException, DALException;
	
	public void update(Categorie c); //throws  SQLException, DALException;
	
	public void delete(int no_categorie); //throws  SQLException, DALException;
	
	//select list
	
	public List<Categorie> select(); //throws  SQLException, DALException;
	
	public List<Categorie> selectAlCategorie(); //throws  SQLException, DALException;
	
	}
