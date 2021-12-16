package fr.eni.projetEncheres.dal.dao;

import java.util.List;

import fr.eni.projetEncheres.BusinessException;

/**
 * @author Daphné
 */
public interface DAO<T> {

	//Sélectionner un élément par son Identifiant :
	public T selectById(int id) throws BusinessException;
		
	//Sélectionner tous les éléments : 
	public List<T> selectAll() throws BusinessException;
		
	//Modifier les attributs d'un éléments connu en BDD :
	public void update(T data) throws BusinessException;
		
	//Insérer un nouvel élément :
	public void insert(T data) throws BusinessException;
		
	//Supprimer un élément :
	public void delete(int id) throws BusinessException;


	
}
