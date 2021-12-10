package fr.eni.projetEncheres.bll;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.dal.dao.DAO;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;

/**
 * @author Daphné
 */
public class RetraitManager {
	
	private DAO<Retrait> retraitDAO;

	public RetraitManager() {
		this.retraitDAO = FactoryDAO.getRetraitDAO();
	}
	
	public void ajouterRetrait(Retrait retrait) throws BusinessException {
		retraitDAO.insert(retrait);
	}
	
	public Retrait afficherRetrait(int no_article) throws BusinessException {
		
		Retrait retrait = retraitDAO.selectById(no_article);
		return retrait;
	}
	
	public void supprimerRetrait(int no_article) throws BusinessException {
		retraitDAO.delete(no_article);
	}

}

