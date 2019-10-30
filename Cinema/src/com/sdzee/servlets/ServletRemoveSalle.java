package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.bddFilms;
import com.sdzee.bdd.bddSalle;
import com.sdzee.beans.Film;
import com.sdzee.beans.Salle;

/**
 * Servlet implementation class ServletRemoveSalle
 */
@WebServlet("/RemoveSalle")
public class ServletRemoveSalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRemoveSalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("Admin") == "Adminxyzabc12345") {
			if((request.getParameter("id") != null) && (!request.getParameter("id").equals(""))) {
				int id = Integer.valueOf(request.getParameter("id"));
				bddSalle bdd = new bddSalle();
				bddFilms bddf = new bddFilms();
				Salle salle = bdd.recupSalle(id);
				Film f = salle.getFilm();
				f.setActif(0);
				bddf.UpdateActif(f);
				bdd.RemoveSalle(id);
				response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
			}else {
				response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
