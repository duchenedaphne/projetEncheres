package fr.eni.projetEncheres.dal.dao;

import fr.eni.projetEncheres.BusinessException;

/**
 * @author Daphné
 */
public interface UtilisateurDAO {
	

	//Sélectionner en fonction des log utlisateurs à la connexion grâce au pseudo:
	public int selectLog(String id, String password) throws BusinessException;
	
	//Sélectionner en fonction des log utlisateurs à la connexion grâce au mail:
	public int selectMail(String id, String password) throws BusinessException;

	public String selectParameter(int userID, String param) throws BusinessException;

	public int selectCredit(int userID) throws BusinessException;
}


