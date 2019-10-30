package com.sdzee.forms;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.sdzee.bdd.*;

public class formConnect {
	public String Connect(HttpServletRequest request) throws NoSuchAlgorithmException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		if(!(email.equals("")) && !(mdp.equals(""))) {
			System.out.println("email "+email+" mdp: "+mdp);
			bddUser bdd = new bddUser();
			String HashMdp = bdd.Sha(mdp);
			System.out.println(HashMdp);
			int connect = bdd.testConnect(email, HashMdp);
			HttpSession session = request.getSession();
			if(connect == 0) {
				session.setAttribute("Admin", "Adminxyzabc12345");
				return "OK";
			}else if(connect == 1) {
				session.setAttribute("Admin", "Userabc12345");
				return "OK";
			}else {
				System.out.println("Erreur");
				return "ERREUR";
			}
		}else {
			return "VIDE";
		}
	}
}
