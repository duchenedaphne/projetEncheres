package fr.eni.projetEncheres.dal.dao;

import java.sql.SQLException;
import java.util.List;
//import java.sql.SQLException;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Utilisateur;
//import fr.eni.eniEncheres.dal.DALException;

/**
 * @author Julian
 */

public interface ArticleVenduDAO {
	
	
	//insert update delete
	
	public void insert(ArticleVendu av)throws  SQLException, BusinessException;
	
	public void update(ArticleVendu av)throws  SQLException, BusinessException;
	
	public void delete(int no_article)throws  SQLException, BusinessException;
	
	//select
	
	public ArticleVendu selectArticleVenduById(int no_article)throws  SQLException, BusinessException;
	
	public List<ArticleVendu> select()throws  SQLException, BusinessException;
	
	public List<ArticleVendu> selectAllArticleVendu()throws  SQLException, BusinessException;
	
	public List<ArticleVendu> selectAllArticleVenduByUtilisateur(Utilisateur u)throws  SQLException, BusinessException;
	

	

}
