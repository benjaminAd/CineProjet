package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sdzee.bdd.*;
import com.sdzee.beans.*;


/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet(
		urlPatterns = { "/Accueil" })
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAccueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		bddFilms bdd = new bddFilms();
		List<Film> message = bdd.RecupFilms();
		bddSalle bddS = new bddSalle();
		Cinema cine = new Cinema();
		cine.setSalles(bddS.RecupSalle());
		cine.setFilms(message);
		cine.setNomCinema("Ciné Inf");
		this.getServletContext().setAttribute("cinema", cine);
		request.setAttribute("cinema", cine);
		HttpSession session = request.getSession();
		request.setAttribute("session", session.getAttribute("Admin"));
		if((request.getParameter("liste") != null) && (request.getParameter("liste").equals("true"))) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/ListFilm.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		}


}
