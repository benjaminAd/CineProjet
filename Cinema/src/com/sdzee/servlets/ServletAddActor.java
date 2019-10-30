package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.bddActeurs;
import com.sdzee.bdd.bddFilms;
import com.sdzee.beans.Acteurs;

/**
 * Servlet implementation class ServletAddActor
 */
@WebServlet("/AddActor")
public class ServletAddActor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddActor() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		bddFilms bdd = new bddFilms();
		if(session.getAttribute("Admin").equals("Adminxyzabc12345")) {
			request.setAttribute("session", session);
			request.setAttribute("films",bdd.RecupFilms());
			this.getServletContext().getRequestDispatcher("/WEB-INF/AddActor.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/Accueil");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bddActeurs bdd = new bddActeurs();
		Acteurs act = new Acteurs();
		act.setNom(request.getParameter("nom"));
		act.setPrenom(request.getParameter("prenom"));
		act.setNationalite(request.getParameter("nat"));
		act.setAge(Integer.valueOf(request.getParameter("age")));
		act.setSexe(request.getParameter("sexe"));
		try {
			String[] filmsSelect = request.getParameterValues("films");
			if(bdd.AddActeur(act)) {
				if(filmsSelect.length >= 1) {
				for(int i = 0; i < filmsSelect.length; i++) {
					int idFilm = Integer.valueOf(filmsSelect[i]);
					int idAct = bdd.recupIdFromNom(request.getParameter("nom"), request.getParameter("prenom"));
					bdd.insertidAidF(idFilm, idAct);
				}
				response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/AddActor?erreur=true");
			}
		}catch(NullPointerException e) {response.sendRedirect(request.getContextPath()+"/AddActor?longueur=true");}
	}
}
