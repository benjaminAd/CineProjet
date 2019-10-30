package com.sdzee.forms;

import javax.servlet.http.HttpServletRequest;

import com.sdzee.bdd.bddFilms;
import com.sdzee.beans.Film;

public class formAddFilm {
	public String AddFilm(HttpServletRequest request) {
		bddFilms bdd = new bddFilms();
		String titre = request.getParameter("titre");
		String genre = request.getParameter("genre");
		String realisateur = request.getParameter("rea");
		String annee = request.getParameter("annee");
		String resume = request.getParameter("resume");
		String act = "0";
		String lien = request.getParameter("lien");
		if((titre.equals("")) || (genre.equals("")) || (resume.equals("")) || 
			(realisateur.equals("")) || (annee.equals(""))
			|| (act.equals("")) || (lien.equals(""))) {
			return "VIDE";
		}
		Film f = new Film();
		f.setNomFilm(titre);
		f.setNomRealisateur(realisateur);
		f.setGenre(genre);
		f.setAnnee(Integer.valueOf(annee));
		f.setResume(resume);
		f.setActif(Integer.valueOf(act));
		f.setLien(lien);
		if(bdd.AddFilm(f)) {
		return "OK";
		}else {
			return "ERREUR";
		}
	}
}
