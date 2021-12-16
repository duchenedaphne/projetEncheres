package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/DejaConnecte.jsp").forward(request,response);
		}
		else {
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
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(password.getBytes());
				byte byteData[] = md.digest();
				
				StringBuffer hexString = new StringBuffer();
				for (int i = 0; i < byteData.length; i++) {
					hexString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
				}
				password = hexString.toString();
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			
			try {
				no_user = utilisateurManager.logUtilisateur(id, password);
				if (no_user == -1) {
					request.setAttribute("listeCodesErreur",listeCodesErreur);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Connection.jsp");
					rd.forward(request, response);
				} else {
					
					
			//		Utilisateur user = utilisateurManager.afficherUtilisateur(no_user);
					session.setAttribute("username", utilisateurManager.getParameter(no_user, "pseudo"));
					session.setAttribute("nom", utilisateurManager.getParameter(no_user, "nom"));
					session.setAttribute("prenom", utilisateurManager.getParameter(no_user, "prenom"));
					session.setAttribute("telephone", utilisateurManager.getParameter(no_user, "telephone"));
					session.setAttribute("mail", utilisateurManager.getParameter(no_user, "mail"));
					session.setAttribute("rue", utilisateurManager.getParameter(no_user, "rue"));
					session.setAttribute("codepostal", utilisateurManager.getParameter(no_user, "codepostal"));
					session.setAttribute("ville", utilisateurManager.getParameter(no_user, "ville"));
					session.setAttribute("MotDePasse", utilisateurManager.getParameter(no_user, "password"));
					session.setAttribute("credit", utilisateurManager.getCredit(no_user));
					session.setAttribute("userID", no_user);
					System.out.println(password);
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
