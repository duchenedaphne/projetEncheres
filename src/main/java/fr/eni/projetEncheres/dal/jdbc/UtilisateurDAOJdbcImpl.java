package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.dao.UtilisateurDAO;

/**
 * @author Daphné
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private static final String SQL_SELECT_BY_ID = "select no_utilisateur, pseudo, "
			+ "nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur " 
			+ " from utilisateur where no_utilisateur = ?";
	private static final String SQL_SELECT_ALL = "select no_utilisateur, pseudo, nom, prenom, "
			+ "email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur " +  
			" from utilisateur";
	private static final String SQL_UPDATE = "update utilisateur set pseudo=?,nom=?,"
			+ "prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot-de-passe=?"
			+ " where no_utilisateur = ?";
	private static final String SQL_INSERT = "insert into utilisateur(pseudo,nom,prenom,email,telephone,"
			+ "rue,code_postal,ville,mot_de_passe,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "delete from utilisateur where no_utilisateur = ?";


	@Override
	public Utilisateur selectById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	

}