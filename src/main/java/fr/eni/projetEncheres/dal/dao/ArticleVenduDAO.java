package fr.eni.projetEncheres.dal.dao;

import java.util.List;
//import java.sql.SQLException;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Utilisateur;
//import fr.eni.eniEncheres.dal.DalException;

/**
 * @author Julian
 */

public interface ArticleVenduDAO {
	
	//insert update delete

	public ArticleVendu selectArticleVenduById(int no_article); //throws  SQLException, DalException;
	
	public void insert(ArticleVendu av); //throws  SQLException, DalException;
	
	public void update(ArticleVendu av); //throws  SQLException, DalException;
	
	public void delete(int no_article); //throws  SQLException, DalException;
	
	//select list
	
	public List<ArticleVendu> select(); //throws  SQLException, DalException;
	
	public List<ArticleVendu> selectAllArticles(); //throws  SQLException, DalException;
	
	public List<ArticleVendu> selectAllArticlesByUtilisateur(Utilisateur u);  //throws  SQLException, DalException;
	

	

}
