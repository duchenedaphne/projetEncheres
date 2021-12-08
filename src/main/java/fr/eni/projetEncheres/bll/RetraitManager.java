package fr.eni.projetEncheres.bll;

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
	
	public Retrait ajouterRetrait(String rue, 
			String code_postal, String ville) {
		
		Retrait retrait = null;
		
		retrait = new Retrait();
		
		return retrait;
	}

}

