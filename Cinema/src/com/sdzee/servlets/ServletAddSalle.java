package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.*;
import com.sdzee.beans.*;

/**
 * Servlet implementation class ServletAddSalle
 */
@WebServlet("/AddSalle")
public class ServletAddSalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddSalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		bddFilms bdd = new bddFilms();
		if(session.getAttribute("Admin") == "Adminxyzabc12345") {
			request.setAttribute("films", bdd.RecupFilms());
			this.getServletContext().getRequestDispatcher("/WEB-INF/AddSalle.jsp").forward(request, response);;
		}else {
			response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String places = request.getParameter("places");
		String idFilm = request.getParameter("film");
		if((!nom.equals("")) && (!places.equals(""))) {
			bddFilms bdd = new bddFilms();
			bddSalle bddS = new bddSalle();
			if(bddS.ExistSalle(request.getParameter("nom"))) {
				Film f = bdd.RecupFilm(Integer.valueOf(idFilm));
				int nbPlaces = Integer.valueOf(places);
				System.out.println(f.getNomFilm());
				Salle salle = new Salle();
				f.setActif(1);
				bdd.UpdateActif(f);
				salle.setFilm(f);
				salle.setNbPlaces(nbPlaces);
				salle.setNom(nom);
				if(bddS.AddSalle(salle)) {
					response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
				}else {
					response.sendRedirect(request.getContextPath()+"/AddSalle?erreur=True");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/AddSalle?salle=True");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/AddSalle?vide=True");
		}
	}

}
