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
	
	public Retrait ajouterRetrait(String rue,
		    String code_postal,
		    String ville) throws BusinessException {
		
		BusinessException businessException = new BusinessException(); 
		
		this.validerAdresse(rue, businessException);
		
		Retrait retrait = null; 
		
		if (!businessException.hasErreurs()) {
			
			retrait = new Retrait();
			retrait.setRue(rue);
			retrait.setCode_postal(code_postal);
			retrait.setVille(ville);
			
			this.retraitDAO.insert(retrait);
		} else {
			throw businessException;
		}
		return retrait;
	}
	
	public Retrait afficherRetrait(int no_article) throws BusinessException {
		
		Retrait retrait = retraitDAO.selectById(no_article);
		return retrait;
	}
	
	public void supprimerRetrait(int no_article) throws BusinessException {
		retraitDAO.delete(no_article);
	}
	
	private void validerAdresse(String rue, BusinessException businessException) {
		if (rue == null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ADRESSE_ERREUR);
		} 
	}

}

