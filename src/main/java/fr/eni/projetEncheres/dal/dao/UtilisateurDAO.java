package fr.eni.projetEncheres.dal.dao;

import java.util.List;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Utilisateur;

/**
 * @author Daphné
 */
public interface UtilisateurDAO {
	
	// Sélectionner un utilisateur par son identifiant :
	public Utilisateur selectById(int no_utilisateur) throws BusinessException;
		
	// Sélectionner tous les utilisateurs : 
	public List<Utilisateur> selectAll() throws BusinessException;
		
	// Modifier les attributs d'un utilisateur connu en BDD :
	public void update(Utilisateur data) throws BusinessException;
		
	// Ajouter un nouvel utilisateur :
	public void insert(Utilisateur utilisateur) throws BusinessException;
		
	//Supprimer un utilisateur :
	public void delete(int no_utilisateur) throws BusinessException;

}


