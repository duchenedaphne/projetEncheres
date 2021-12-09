package fr.eni.projetEncheres.bll;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;
import fr.eni.projetEncheres.dal.dao.UtilisateurDAO;

/**
 * @author Daphné
 */
public class UtilisateurManager {
	
	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = FactoryDAO.getUtilisateurDAO();
	}
	
	public void ajouterUtilisateur(Utilisateur utilisateur) throws BusinessException {
		
		utilisateurDAO.insert(utilisateur);
	}
	
	public Utilisateur afficherUtilisateur(int no_utilisateur) throws BusinessException {
		
		Utilisateur utilisateur = utilisateurDAO.selectById(no_utilisateur);
		return utilisateur;
	}
	
	public void supprimerUtilisateur(int no_utilisateur) throws BusinessException {
		utilisateurDAO.delete(no_utilisateur);
	}

}


