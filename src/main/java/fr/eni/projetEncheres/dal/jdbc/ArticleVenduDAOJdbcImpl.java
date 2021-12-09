package fr.eni.projetEncheres.dal.jdbc;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.dao.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.dao.CategorieDAO;
import fr.eni.projetEncheres.dal.dao.EnchereDAO;
import fr.eni.projetEncheres.dal.dao.RetraitDAO;
import fr.eni.projetEncheres.dal.dao.UtilisateurDAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Julian
 */

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	
	@Override
	public ArticleVendu selectArticleVenduById(int no_article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ArticleVendu av) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArticleVendu av) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int no_article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVendu> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectAllArticleVendu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectAllArticleVenduByUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	
}