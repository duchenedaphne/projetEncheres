package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.dal.dao.RetraitDAO;

/**
 * @author Daphné
 */
public class RetraitDAOJdbcImpl implements RetraitDAO {

	@Override
	public Retrait selectById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Retrait> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Retrait retrait) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Retrait data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Retrait delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retrait valider(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	

}