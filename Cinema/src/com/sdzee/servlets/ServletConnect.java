package com.sdzee.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.forms.*;

/**
 * Servlet implementation class ServletConnect
 */
@WebServlet("/Connect")
public class ServletConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("deconnect") != null) {
			if(request.getParameter("deconnect").equals("true")) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect(request.getContextPath()+"/Accueil");
			}
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		formConnect co = new formConnect();
		String validConnect;
		try {
			validConnect = co.Connect(request);
			if(validConnect.equals("OK")) {
			HttpSession session = request.getSession();
			if(session.getAttribute("Admin").equals("Adminxyzabc12345") || session.getAttribute("Admin").equals("Userabc12345")) {
				response.sendRedirect(request.getContextPath()+"/Accueil");
			}else {
				response.sendRedirect(request.getContextPath()+"/Accueil?erreur=true");
			}
			}else if(validConnect.equals("ERREUR")) {
				response.sendRedirect(request.getContextPath()+"/Accueil?erreur=true");
			}else if(validConnect.equals("VIDE")) {
				response.sendRedirect(request.getContextPath()+"/Accueil");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
