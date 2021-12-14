package fr.eni.projetEncheres.bll;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.dao.DAO;
import fr.eni.projetEncheres.dal.dao.FactoryDAO;
import fr.eni.projetEncheres.dal.dao.UtilisateurDAO;

/**
 * @author Daphné
 */
public class UtilisateurManager {
	
	private DAO<Utilisateur> utilisateurDAO;
	
	private UtilisateurDAO utilisateurODAO;

	public UtilisateurManager() {
		this.utilisateurDAO = FactoryDAO.getUtilisateurDAO();
		this.utilisateurODAO = FactoryDAO.getUtilisateurODAO();
	}
	
	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String mail, String telephone, String rue, String codepostal, 
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
	
	public void updateProfilUtilisateur(String pseudo, String nom, String prenom, String mail, String telephone, String rue, String codepostal, 
			 							String ville, String password, String checkPassword) throws BusinessException {
		BusinessException be = new BusinessException();
		this.validerPassword(password, checkPassword, be);
		
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
			
			this.utilisateurDAO.update(user);
		} else {
			throw be;
		}
	}
	
	public Utilisateur afficherUtilisateur(int no_utilisateur) throws BusinessException {
		
		Utilisateur utilisateur = utilisateurDAO.selectById(no_utilisateur);
		return utilisateur;
	}
	
	public void supprimerUtilisateur(int no_utilisateur) throws BusinessException {
		utilisateurDAO.delete(no_utilisateur);
	}

	public int logUtilisateur(String id, String password) throws BusinessException {
		int no_utilisateur = utilisateurODAO.selectLog(id, password);
		if (no_utilisateur == -1) {
			no_utilisateur = utilisateurODAO.selectMail(id, password);
		}
		return no_utilisateur;
	}
	
	private void validerPassword(String password, String passwordCheck, BusinessException be) {
		if (!password.equals(passwordCheck)) {
			be.ajouterErreur(CodesResultatBLL.MISMATCH_PASSWORD);
		}
	}
}


