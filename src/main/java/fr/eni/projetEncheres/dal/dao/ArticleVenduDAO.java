package fr.eni.projetEncheres.dal.dao;

import java.util.List;
//import java.sql.SQLException;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Utilisateur;
//import fr.eni.eniEncheres.dal.DALException;

/**
 * @author Julian
 */

public interface ArticleVenduDAO {
	
	
	//insert update delete

	public ArticleVendu selectArticleVenduById(int no_article); //throws  SQLException, DALException;
	
	public void insert(ArticleVendu av); //throws  SQLException, DALException;
	
	public void update(ArticleVendu av); //throws  SQLException, DALException;
	
	public void delete(int no_article); //throws  SQLException, DALException;
	
	//select list
	
	public List<ArticleVendu> select(); //throws  SQLException, DALException;
	
	public List<ArticleVendu> selectAllArticleVendu(); //throws  SQLException, DALException;
	
	public List<ArticleVendu> selectAllArticleVenduByUtilisateur(Utilisateur u);  //throws  SQLException, DALException;
	

	

}
