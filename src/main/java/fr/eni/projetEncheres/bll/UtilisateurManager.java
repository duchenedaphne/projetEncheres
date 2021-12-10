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
	
	public Utilisateur ajouterUtilisateur	(String pseudo, String nom, String prenom, String mail, String telephone, String rue, String codepostal, 
									 String ville, String password, String passwordCheck, int credit, boolean admin) throws BusinessException {
		
		BusinessException be = new BusinessException();
		this.validerPassword(password, passwordCheck, be);
		
		Utilisateur user = null;
		
		if (!be.hasErreurs()) {
			user = new Utilisateur();
			user.setPseudo(pseudo);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(mail);
			user.setTelephone(telephone);
			user.setRue(rue);
			user.setCode_postal(codepostal);
			user.setVille(ville);
			user.setMot_de_passe(password);
			user.setCredit(credit);
			user.setAdministrateur(admin);
			
			this.utilisateurDAO.insert(user);
			
		} else {
			throw be;
		}
		
		return user;
		
		
	}
	
	public Utilisateur afficherUtilisateur(int no_utilisateur) throws BusinessException {
		
		Utilisateur utilisateur = utilisateurDAO.selectById(no_utilisateur);
		return utilisateur;
	}
	
	public void supprimerUtilisateur(int no_utilisateur) throws BusinessException {
		utilisateurDAO.delete(no_utilisateur);
	}

	
	private void validerPassword(String password, String passwordCheck, BusinessException be) {
		if (password != passwordCheck) {
			be.ajouterErreur(CodesResultatBLL.MISMATCH_PASSWORD);
		}
	}
}


