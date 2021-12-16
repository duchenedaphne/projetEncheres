package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bll.UtilisateurManager;

/**
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ModifierMonProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = null;
		String nom = null;
		String prenom = null;
		String mail = null;
		String password = null;
		String checkPassword = null;
		String telephone = null;
		String adresse=null;
		String codepostal=null;
		String ville=null;
		request.setCharacterEncoding("UTF-8");
		List<Integer> listeCodesErreur=new ArrayList<>();
		
		int userID = 0;
		username = request.getParameter("updateUsername");
		mail = request.getParameter("updateMail");
		password = request.getParameter("updatePassword");
		checkPassword = request.getParameter("checkUpdatedPassword");
		telephone = request.getParameter("updateTelephone");
		adresse = request.getParameter("updateRue");
		codepostal = request.getParameter("updateCodepostal");
		ville = request.getParameter("updateVille");
		
		
		if (	(password.equals(null) && !checkPassword.equals(null))
			||	(!password.equals(null) && checkPassword.equals(null)) ) {
			listeCodesErreur.add(CodesResultatServlets.MISSING_FIELD_ERREUR);
		}
		
		if (listeCodesErreur.size() > 0) {
			request.setAttribute("listeCodesErreur",listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ModifierMonProfil.jsp");
			rd.forward(request, response);
		} else {
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			HttpSession session = request.getSession();
			
			try {
				if (!username.equals(null) && !username.equals(session.getAttribute("username"))) {
					session.setAttribute("username", username);
				} else { username = (String) session.getAttribute("username"); }
				
				if (!mail.equals(null) && !mail.equals(session.getAttribute("mail"))) {
					session.setAttribute("mail", mail);
				} else { mail = (String) session.getAttribute("mail"); }
				
				if (!password.equals(null) && !password.equals(session.getAttribute("MotDePasse"))) {
					session.setAttribute("MotDePasse", password);
				} else { password = (String) session.getAttribute("MotDePasse"); }
				
				if (!checkPassword.equals(null) && !checkPassword.equals(session.getAttribute("CheckMotDePasse"))) {
					session.setAttribute("CheckMotDePasse", checkPassword);
				} else { checkPassword = (String) session.getAttribute("CheckMotDePasse"); }
				
				if (!telephone.equals(null) && !telephone.equals(session.getAttribute("telephone"))) {
					session.setAttribute("telephone", telephone);
				} else { telephone = (String) session.getAttribute("telephone"); }
				
				if (!adresse.equals(null) && !adresse.equals(session.getAttribute("rue"))) {
					session.setAttribute("rue", adresse);
				} else { adresse = (String) session.getAttribute("rue"); }
				
				if (!codepostal.equals(null) && !codepostal.equals(session.getAttribute("codepostal"))) {
					session.setAttribute("codepostal", codepostal);
				} else { codepostal = (String) session.getAttribute("codepostal"); }
				
				if (!ville.equals(null) && !ville.equals(session.getAttribute("ville"))) {
					session.setAttribute("ville", ville);
				} else { ville = (String) session.getAttribute("ville"); }
				
				nom = (String) session.getAttribute("nom");
				prenom = (String) session.getAttribute("prenom");
				userID = utilisateurManager.logUtilisateur(username, password);
				
				utilisateurManager.updateProfilUtilisateur(userID, username, nom, prenom, mail, telephone, adresse, codepostal, ville, password, checkPassword);
				
				request.setAttribute("listeCodesErreur",listeCodesErreur);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/MonProfil.jsp");
				rd.forward(request, response);
				
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
				System.out.println(e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/DejaConnecte.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
