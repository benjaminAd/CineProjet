package com.sdzee.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.forms.formSubscribe;

/**
 * Servlet implementation class ServletSubscribe
 */
@WebServlet("/Subscribe")
public class ServletSubscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSubscribe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath()+"/Accueil");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		formSubscribe sub = new formSubscribe();
		try {
			String repSub = sub.Subscribe(request);
			if(repSub.equals("OK")) {
				HttpSession session = request.getSession();
				session.setAttribute("Admin", "Userabc12345");
				response.sendRedirect(request.getContextPath()+"/Accueil");
			}else if(repSub.equals("ERREUR")) {
				response.sendRedirect(request.getContextPath()+"/Accueil?erreur=true");
			}else if(repSub.equals("VIDE")) {
				response.sendRedirect(request.getContextPath()+"/Accueil");
			}else if(repSub.equals("MDP")) {
				response.sendRedirect(request.getContextPath()+"/Accueil?mdp=true");
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("erreur de hashage");
		}
	}

}
