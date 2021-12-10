package fr.eni.projetEncheres.dal.dao;

import fr.eni.projetEncheres.BusinessException;

/**
 * @author Daphné
 */
public interface RetraitDAO {
	
	public void valider(int no_article) throws BusinessException;

}