package fr.eni.projetEncheres.dal.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Utilisateur;

/**
 * @author Julian
 */

public interface EnchereDAO {
	
	
	//insert update delete
	
	public void insert(Enchere enc)throws  SQLException, BusinessException;
	
	public void update(Enchere enc)throws  SQLException, BusinessException;
	
	public void delete(int no_enchere)throws  SQLException, BusinessException;
	
	//select
	
	public Enchere selectEnchereById(int no_enchere)throws  SQLException, BusinessException;
	
	public Enchere selectEnchereByUtilisateur(Utilisateur utilisateur,int no_enchere)throws  SQLException, BusinessException;
	
	public List<Enchere> select()throws  SQLException, BusinessException;
	
	public List<Enchere> selectAllEnchere()throws  SQLException, BusinessException;
	
	public List<Enchere> selectAllEnchereByUtilisateur(Utilisateur u)throws  SQLException, BusinessException;
	

}