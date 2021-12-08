package fr.eni.projetEncheres.dal.dao;

import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateur;

/**
 * @author Daphné
 */
public interface UtilisateurDAO {
	
	// Sélectionner un utilisateur par son identifiant :
	public Utilisateur selectById(int id); // throws DALException;
		
	// Sélectionner tous les utilisateurs : 
	public List<Utilisateur> selectAll(); // throws DALException;
		
	// Modifier les attributs d'un utilisateur connu en BDD :
	public void update(Utilisateur data); // throws DALException;
		
	// Ajouter un nouvel utilisateur :
	public void insert(Utilisateur utilisateur); // throws DALException; // throws BusinessException;
		
	//Supprimer un utilisateur :
	public void delete(int id); // throws DALException;

}


