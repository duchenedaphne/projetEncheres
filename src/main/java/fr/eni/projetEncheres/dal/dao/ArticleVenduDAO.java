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
	
	public List<ArticleVendu> selectAllArticleVenduByUtilisateur(Utilisateur u)throws  SQLException, BusinessException;
	

	

}
