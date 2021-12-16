package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.BusinessException;
import fr.eni.projetEncheres.bll.UtilisateurManager;
/**
 * @author Daphné
 */
/**
 * Servlet implementation class ServletSupprimerProfil
 */
@WebServlet("/ServletSupprimerProfil")
public class ServletSupprimerProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		HttpSession session = request.getSession();
		
		int no_utilisateur = (Integer) session.getAttribute("userID");
		
		// SUPPRESION DU COMPTE
		try {
			utilisateurManager.supprimerUtilisateur(no_utilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		// DECONNEXION 
		String logged = null;
		session.setAttribute("logged", logged);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
