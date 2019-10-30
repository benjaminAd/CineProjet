package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.*;
import com.sdzee.beans.*;
import com.sdzee.forms.formAddFilm;

/**
 * Servlet implementation class ServletAdmin
 */
@WebServlet("/Edit")
public class ServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEdit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		bddSalle bdd = new bddSalle();
		bddFilms bddF = new bddFilms();
		if(session.getAttribute("Admin") == "Adminxyzabc12345") {
			if((request.getParameter("i") != null) && (request.getParameter("i") != "")) {
				Salle salle = bdd.recupSalle(Integer.valueOf(request.getParameter("i")));
				request.setAttribute("salle", salle);
				request.setAttribute("films",bddF.RecupFilms());
				this.getServletContext().getRequestDispatcher("/WEB-INF/Edit.jsp").forward(request,response);
			}else {
				response.sendRedirect(request.getContextPath()+"/Accueil");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/Accueil");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bddSalle bdd= new bddSalle();
		bddFilms bddF = new bddFilms();
		HttpSession session = request.getSession();
		if(session.getAttribute("Admin") == "Adminxyzabc12345") {
			if((request.getParameter("formid") != null) && (request.getParameter("formid")!="")) {
				if((!request.getParameter("nom").equals("")) && (!request.getParameter("places").equals("")) && (!request.getParameter("film").equals(""))){
					if(!request.getParameter("film").equals(request.getParameter("Film"))) {
						Film nouveau = bddF.RecupFilm(request.getParameter("film"));
						nouveau.setActif(1);
						Film ancien = bddF.RecupFilm(request.getParameter("Film"));
						ancien.setActif(0);
						bddF.UpdateActif(nouveau);
						bddF.UpdateActif(ancien);
					}
					if(bdd.UpdateSalle(request)){
						response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
					}else {
						response.sendRedirect(request.getContextPath()+"/Edit?i="+request.getParameter("formid")+"&erreur=True");
					}
				}else {
					response.sendRedirect(request.getContextPath()+"/Edit?i="+request.getParameter("formid")+"&vide=True");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/Accueil");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/Accueil");
		}
	}
}
	
