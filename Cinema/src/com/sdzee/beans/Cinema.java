package com.sdzee.beans;
import java.io.*;
import java.util.List;
public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Film> films;
	private List<Salle> salles;
	private String nomCinema;
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}	
	public String getNomCinema() {
		return nomCinema;
	}
	public void setNomCinema(String nomCinema) {
		this.nomCinema = nomCinema;
	}
	public List<Salle> getSalles() {
		return salles;
	}
	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}
	
}
