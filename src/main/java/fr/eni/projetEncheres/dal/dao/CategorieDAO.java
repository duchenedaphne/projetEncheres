package fr.eni.projetEncheres.dal.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Categorie;

/**
 * @author Julian
 */

public interface CategorieDAO {
	
	public Categorie selectCategorieById(int no_article)throws  SQLException, BusinessException;
	
	public List<Categorie> select()throws  SQLException, BusinessException;
	
	public List<Categorie> selectAlCategorie()throws  SQLException, BusinessException;
	
	}
