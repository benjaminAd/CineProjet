package com.sdzee.forms;



import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import com.sdzee.bdd.bddUser;

public class formSubscribe {
	public String Subscribe(HttpServletRequest request) throws NoSuchAlgorithmException {
		String mail = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		String confMdP = request.getParameter("conf");
		if((!mail.equals("")) && (!mdp.equals("")) && (!confMdP.equals(""))) {
			if(mdp.equals(confMdP)) {
				bddUser User = new bddUser();
			    String HashMdp = User.Sha(mdp);
			    boolean SubUser = User.subscribe(mail,HashMdp);
			    System.out.println(HashMdp);
			    if(SubUser) {
			    	System.out.println("OK");
			       return "OK";
			    }else {
			    	System.out.println("ERREUR");
			       return "ERREUR";
			    }
			}else {
				return "MDP";
			}
		}else {
			return "VIDE";
		}
	}

}
