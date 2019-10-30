package com.sdzee.beans;
import java.io.*;

public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
	private String NomFilm, NomRealisateur, Resume,Genre,Lien;
	private int Actif;
	private int Annee,id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomFilm() {
		return NomFilm;
	}
	public void setNomFilm(String nomFilm) {
		this.NomFilm = nomFilm;
	}
	public String getNomRealisateur() {
		return NomRealisateur;
	}
	public void setNomRealisateur(String nomRealisateur) {
		this.NomRealisateur = nomRealisateur;
	}
	public String getResume() {
		return Resume;
	}
	public void setResume(String resume) {
		this.Resume = resume;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		this.Genre = genre;
	}
	public String getLien() {
		return Lien;
	}
	public void setLien(String lien) {
		Lien = lien;
	}
	public int isActif() {
		return Actif;
	}
	public void setActif(int actif) {
		this.Actif = actif;
	}
	public int getAnnee() {
		return Annee;
	}
	public void setAnnee(int annee) {
		this.Annee = annee;
	}
	

}
