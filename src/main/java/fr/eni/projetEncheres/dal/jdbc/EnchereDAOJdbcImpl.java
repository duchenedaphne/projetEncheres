package fr.eni.projetEncheres.dal.jdbc;


import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.CodesResultatDAL;
import fr.eni.projetEncheres.dal.ConnectionProvider;
import fr.eni.projetEncheres.dal.dao.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.dao.CategorieDAO;
import fr.eni.projetEncheres.dal.dao.EnchereDAO;
import fr.eni.projetEncheres.dal.dao.RetraitDAO;
import fr.eni.projetEncheres.dal.dao.UtilisateurDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Julian
 */

public class EnchereDAOJdbcImpl implements EnchereDAO {

	@Override
	public Enchere selectEnchereById(int no_enchere) {
        return null;
	}

	@Override
	public void insert(Enchere enc) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			try {
	            String INSERT = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
				
				
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, 
						PreparedStatement.RETURN_GENERATED_KEYS);
		        pstmt.setInt(1, enc.getNo_enchere());
		        pstmt.setInt(2, enc.getUtilisateur().getNo_utilisateur());
		        	pstmt.setInt(2, enc.getNo_article());
		        	pstmt.setDate(2, enc.getDate_enchere());
		        	pstmt.setInt(2, enc.getMontant_enchere());
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					enc.setNo_enchere(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.close();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}	
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}	
		
	}

	@Override
	public void update(Enchere e) {
		
	}

	@Override
	public void delete(int no_enchere) {
		
	}

	@Override
	public List<Enchere> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAllEnchere() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAllEnchereByUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere selectEnchereByUtilisateur(Utilisateur utilisateur, int no_enchere) throws SQLException, BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}