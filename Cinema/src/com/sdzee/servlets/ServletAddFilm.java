package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.bddFilms;
import com.sdzee.beans.Cinema;
import com.sdzee.forms.formAddFilm;

/**
 * Servlet implementation class ServletAddFilm
 */
@WebServlet("/AddFilm")
public class ServletAddFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Cinema cine = (Cinema)this.getServletContext().getAttribute("cinema");
		bddFilms bdd = new bddFilms();
		if(session.getAttribute("Admin") == "Adminxyzabc12345") {
		this.getServletContext().getRequestDispatcher("/WEB-INF/AddFilm.jsp").forward(request, response);
		}else {
			System.out.println("Accueil 1");
			response.sendRedirect(request.getContextPath()+"/Accueil");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		formAddFilm add = new formAddFilm();
		String res = add.AddFilm(request);
		if(res.equals("OK")) {
			System.out.println(res);
			response.sendRedirect(request.getContextPath()+"/Accueil?liste=true");
		}else if(res.equals("VIDE")) {
			System.out.println(res);
			response.sendRedirect(request.getContextPath()+"/AddFilm?erreur=vide");
		}else {
			response.sendRedirect(request.getContextPath()+"/AddFilm?erreur=erreur");
		}
	}

}
