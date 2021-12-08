package fr.eni.projetEncheres.bll;

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
	
	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email,
		     String telephone, String rue, String cpo, String ville, String password) {
		
		Utilisateur utilisateur = null;
		
		utilisateur = new Utilisateur();
		
		return utilisateur;
	}

}


