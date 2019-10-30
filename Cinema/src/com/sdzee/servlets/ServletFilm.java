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
import com.sdzee.beans.Acteurs;
import com.sdzee.beans.Cinema;
import com.sdzee.beans.Film;

/**
 * Servlet implementation class ServletFilm
 */
@WebServlet("/Film")
public class ServletFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((!request.getParameter("id").equals(null)) && (!request.getParameter("id").equals(""))) {
			HttpSession session = request.getSession();
			bddFilms bdd = new bddFilms();
			Film f = bdd.RecupFilm(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("movie", f);
			bddActeurs bddAct = new bddActeurs();
			Cinema cine = (Cinema)this.getServletContext().getAttribute("cinema");
			List<Acteurs> listeActeurs = bddAct.RecupIdAct(f.getId());
			request.setAttribute("Acteurs", listeActeurs);
			request.setAttribute("AllActeurs",bddAct.recupActeurs());
			request.setAttribute("session", session.getAttribute("Admin"));
			request.setAttribute("cinema", cine);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Film.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bddActeurs bdd = new bddActeurs();
			String selectAct = request.getParameter("selectAct");
			if(!selectAct.equals(null)) {
				int idAct = Integer.valueOf(selectAct);
				int idFilm = Integer.valueOf(request.getParameter("idF"));
				bdd.insertidAidF(idFilm, idAct);
				response.sendRedirect(request.getContextPath()+"/Film?id="+idFilm);
			}else {
				response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
			}
		}

}
