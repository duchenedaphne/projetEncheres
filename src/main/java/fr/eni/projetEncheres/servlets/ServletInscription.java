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
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo=null;
		String nom=null;
		String prenom=null;
		String telephone=null;
		String mail=null;
		String adresse=null;
		String codepostal=null;
		String ville=null;
		String password=null;
		String passwordcheck=null;
		request.setCharacterEncoding("UTF-8");
		List<Integer> listeCodesErreur=new ArrayList<>();
		
		
		pseudo = request.getParameter("username");
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		telephone = request.getParameter("telephone");
		mail = request.getParameter("mail");
		adresse = request.getParameter("rue");
		codepostal = request.getParameter("codepostal");
		ville = request.getParameter("ville");
		password = request.getParameter("MotDePasse");
		passwordcheck = request.getParameter("CheckMotDePasse");
			
		if (pseudo == null || pseudo.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		if (nom == null || nom.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		if (prenom == null || prenom.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		if (mail == null || mail.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		if (adresse == null || adresse.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		if (codepostal == null || codepostal.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		if (ville == null || ville.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		if (password == null || password.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		if (passwordcheck == null || passwordcheck.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		
		if (listeCodesErreur.size() > 0) {
			request.setAttribute("listeCodesErreur",listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Inscription.jsp");
			rd.forward(request, response);
		} else {
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			HttpSession session = request.getSession();
		//	response.getWriter().append(pseudo).append(nom);
			
			try {
				utilisateurManager.ajouterUtilisateur(pseudo, nom, prenom, mail, telephone, adresse, codepostal, ville, password, passwordcheck, 0, false);
				String logged = "log";
				session.setAttribute("logged", logged);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp");
				rd.forward(request, response);
				
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/DejaConnecte.jsp");
				rd.forward(request, response);
			}	
		}
		
		
		
	

	}
}
