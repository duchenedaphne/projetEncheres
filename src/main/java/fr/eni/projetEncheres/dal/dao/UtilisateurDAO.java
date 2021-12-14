package fr.eni.projetEncheres.dal.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Utilisateur;

/**
 * @author Daphné
 */
public interface UtilisateurDAO {
	
	//insert update delete
	
	public void insert(Utilisateur u)throws  SQLException, BusinessException;
	
	public void update(Utilisateur u)throws  SQLException, BusinessException;
	
	public void delete(int no_utilisateur)throws  SQLException, BusinessException;
	
	//select
	
	public Utilisateur selectUtilisateurById(int no_utilisateur)throws  SQLException, BusinessException;
	
	public List<Utilisateur> select()throws  SQLException, BusinessException;
	
	public List<Utilisateur> selectAllUtilisateur()throws  SQLException, BusinessException;
	
	
}


