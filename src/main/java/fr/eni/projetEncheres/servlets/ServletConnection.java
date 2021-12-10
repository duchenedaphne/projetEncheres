package fr.eni.projetEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String logged = "log";
		
		HttpSession session = request.getSession();
		session.setAttribute("logged", logged);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp");
		rd.forward(request, response);
	}
	
}
