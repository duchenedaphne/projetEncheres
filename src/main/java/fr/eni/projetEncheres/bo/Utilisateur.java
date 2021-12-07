package fr.eni.projetEncheres.bo;

/**
 * @author Aladiel 
 */

public class Utilisateur {
	// Attributs :
	private int idUser;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String cpo;
	private String ville;
	private String password;
	private int credit;
	private boolean admin;
	
	// Constructeurs : 
	public Utilisateur() {
	}
		
	public Utilisateur(int idUser, String pseudo, String nom, String prenom, String email, String rue, String cpo,
			String ville, String password, int credit) {
		this.idUser = idUser;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.cpo = cpo;
		this.ville = ville;
		this.password = password;
		this.credit = credit;
	}
		
	public Utilisateur(int idUser, String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String cpo, String ville, String password, int credit) {
		this.idUser = idUser;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cpo = cpo;
		this.ville = ville;
		this.password = password;
		this.credit = credit;
	}
	
	// Getter / Setter :
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCpo() {
		return cpo;
	}
	public void setCpo(String cpo) {
		this.cpo = cpo;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	// Override toString :
	@Override
	public String toString() {
		return "Utilisateur [idUser=" + idUser + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", cpo=" + cpo + ", ville=" + ville
				+ ", password=" + password + ", credit=" + credit + ", admin=" + admin + "]";
	}	

}