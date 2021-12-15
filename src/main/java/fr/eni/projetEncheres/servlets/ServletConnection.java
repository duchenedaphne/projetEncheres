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
import fr.eni.projetEncheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnection
 */
@WebServlet("/ServletConnection")
public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String logged = (String) session.getAttribute("logged");
		if (logged != null) {
		//	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/DejaConnecte.jsp");
		//	rd.forward(request, response);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/DejaConnecte.jsp").forward(request,response);
		}
		else {
		//	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Connection.jsp");
		//	rd.forward(request, response);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connection.jsp").forward(request,response);

		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = null;
		String password = null;
		int no_user;
		List<Integer> listeCodesErreur = new ArrayList<>();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		id = request.getParameter("identifiant");
		password = request.getParameter("loginpassword");
		
		if (id == null || id.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		if (password == null || password.trim().isEmpty()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
		}
		
		if (listeCodesErreur.size() > 0) {
			request.setAttribute("listeCodesErreur",listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Connection.jsp");
			rd.forward(request, response);
		} else {
		
			try {
				no_user = utilisateurManager.logUtilisateur(id, password);
				if (no_user == -1) {
					request.setAttribute("listeCodesErreur",listeCodesErreur);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Connection.jsp");
					rd.forward(request, response);
				} else {
					Utilisateur user = utilisateurManager.afficherUtilisateur(no_user);
					session.setAttribute("username", user.getPseudo());
					session.setAttribute("nom", user.getNom());
					session.setAttribute("prenom", user.getPrenom());
					session.setAttribute("telephone", user.getTelephone());
					session.setAttribute("mail", user.getEmail());
					session.setAttribute("rue", user.getRue());
					session.setAttribute("codepostal", user.getCode_postal());
					session.setAttribute("ville", user.getVille());
					session.setAttribute("MotDePasse", user.getMot_de_passe());
					session.setAttribute("credit", user.getCredit());
					session.setAttribute("userID", no_user);
					
					String logged = "log";
					session.setAttribute("logged", logged);
					
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp");
					rd.forward(request, response);
				}
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/DejaConnecte.jsp");
				rd.forward(request, response);
			}
		
		}
		
		
	}
	
}
