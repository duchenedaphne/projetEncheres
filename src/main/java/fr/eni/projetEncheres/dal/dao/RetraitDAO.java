package fr.eni.projetEncheres.dal.dao;

import java.util.List;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Retrait;

/**
 * @author Daphné
 */
public interface RetraitDAO {
	
	public Retrait selectById(int id) throws BusinessException;
	
	public List<Retrait> selectAll() throws BusinessException;
	
	public void insert(Retrait retrait) throws BusinessException;
	
	public void update(Retrait data) throws BusinessException;
	
	public Retrait delete(int id) throws BusinessException;
	
	public Retrait valider(int id) throws BusinessException;

}