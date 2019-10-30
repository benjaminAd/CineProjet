package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.bdd.bddFilms;
import com.sdzee.beans.Film;

/**
 * Servlet implementation class ServletEditFilm
 */
@WebServlet("/EditFilm")
public class ServletEditFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((!request.getParameter("id").equals(null))){
			bddFilms bdd = new bddFilms();
			Film f = bdd.RecupFilm(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("film", f);
			this.getServletContext().getRequestDispatcher("/WEB-INF/EditFilm.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((!request.getParameter("titre").equals("")) && (!request.getParameter("genre").equals("")) && (!request.getParameter("rea").equals(""))
				&&(!request.getParameter("resume").equals("")) && (!request.getParameter("annee").equals("")) && (!request.getParameter("lien").equals(""))) {
			bddFilms bdd = new bddFilms();
			if(bdd.UpdateFilm(request)) {
				response.sendRedirect(request.getContextPath()+"/Film?id="+request.getParameter("id"));
			}else {
				response.sendRedirect(request.getContextPath()+"/EditFilm?id="+request.getParameter("id")+"&erreur=true");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/EditFilm?id="+request.getParameter("id")+"&vide=true");
		}
	}

}
