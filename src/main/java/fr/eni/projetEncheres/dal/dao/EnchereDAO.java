package fr.eni.projetEncheres.dal.dao;

import java.util.List;
//import java.sql.SQLException;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Utilisateur;
//import fr.eni.eniEncheres.dal.DALException;

/**
 * @author Julian
 */

public interface EnchereDAO {
	
	//insert update delete

	public Enchere selectEnchereById(int no_enchere); //throws  SQLException, DALException;
	
	public void insert(Enchere e); //throws  SQLException, DALException;
	
	public void update(Enchere e); //throws  SQLException, DALException;
	
	public void delete(int no_enchere); //throws  SQLException, DALException;
	
	//select list
	
	public List<Enchere> select(); //throws  SQLException, DALException;
	
	public List<Enchere> selectAllEnchere(); //throws  SQLException, DALException;
	
	public List<Enchere> selectAllEnchereByUtilisateur(Utilisateur u);  //throws  SQLException, DALException;
	

}