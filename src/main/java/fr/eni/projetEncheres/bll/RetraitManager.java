package fr.eni.projetEncheres.bll;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;
import fr.eni.projetEncheres.dal.dao.RetraitDAO;

/**
 * @author Daphné
 */
public class RetraitManager {
	
	private RetraitDAO retraitDAO;

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

