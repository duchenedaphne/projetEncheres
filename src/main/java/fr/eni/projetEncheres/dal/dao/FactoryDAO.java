package fr.eni.projetEncheres.dal.dao;

import fr.eni.projetEncheres.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.RetraitDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * @author Daphné
 */
public abstract class FactoryDAO {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
	
}


