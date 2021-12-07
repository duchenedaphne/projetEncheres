package fr.eni.projetEncheres.dal.dao;

import java.util.List;

import fr.eni.projetEncheres.bo.Retrait;

/**
 * @author Daphné
 */

public interface RetraitDAO {
	
	public void insert(Retrait retrait); // throws Exception
	
	public List<Retrait> select(); // throws BusinessException;

}