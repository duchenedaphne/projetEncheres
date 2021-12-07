package fr.eni.projetEncheres.dal.dao;

import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateur;

/**
 * @author Daphné
 */

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur); // throws Exception
	
	public List<Utilisateur> select(); // throws BusinessException;

}