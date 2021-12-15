package fr.eni.projetEncheres.bo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Daphné 
 */
public class Enchere implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Attributs :
	private int no_enchere; //@Julian
	Utilisateur utilisateur;
    private int no_article;
    private Date date_enchere;
	private String NomArticle;
    private String description;
    private String photoArticle;
    private Date DébutEnchère;
    private Date FinEnchère;
    private int     credit;
    private String rue;
    private String codepostal;
    private String ville;
  
    // Constructeur :
    public Enchere() {
    }
    
	public Enchere(Utilisateur utilisateur, int no_article, Date date_enchere, int montant_enchere) {
		super();
		this.utilisateur = utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		this.NomArticle = NomArticle;
	}
	
	// Getter / Setter :	
	
	public int getNo_enchere() {
		return no_enchere;
	}

	public void setNo_enchere(int no_enchere) {
		this.no_enchere = no_enchere;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public Date getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(Date date_enchere) {
		this.date_enchere = date_enchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	
	public void setNomArticle(String nomArticle) {
		NomArticle = nomArticle;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCatégories(String description) {
		this.description = description;
	}

	public void setPhotoArticle(String photoArticle) {
		this.photoArticle = photoArticle;
	}

	public void setDébutEnchère(Date débutEnchère) {
		DébutEnchère = débutEnchère;
	}

	public void setFinEnchère(Date finEnchère) {
		FinEnchère = finEnchère;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	
    // Overrive toString :
	@Override
	public String toString() {
		return "Enchere [utilisateur=" + utilisateur + ", no_article=" + no_article + ", date_enchere="
				+ date_enchere + ", montant_enchere=" + montant_enchere + NomArticle "]";
	}
   
}



