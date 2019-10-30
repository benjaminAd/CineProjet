package com.sdzee.bdd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class bddUser {
	private void ChargDriver() {
		//Chargement du driver mariaDB
		try {
			System.out.println( "Chargement du driver..." );
	        Class.forName("org.mariadb.jdbc.Driver");
	        System.out.println( "Driver chargé !" );
		}catch(ClassNotFoundException e) {
			System.out.println("Erreur de chargement du driver");
		}
	}
	
	public int testConnect(String email, String mdp) {
		ChargDriver();
		//Connection à la Base de donnée
		String User= "root";
		String password="prot$ge3";
		String url="jdbc:mariadb://localhost:3306/cinema";
		Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    int Admin = 2; // --> si renvoie alors il y a une erreur
	    try {
	        System.out.println( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion réussie !" );
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        System.out.println( "Objet requête créé !" );
	        /* Création de l'objet gérant les requêtes */
	        resultat = statement.executeQuery("SELECT * FROM users WHERE Email = '"+email+"' AND Mdp = '"+mdp+"'");
	        while(resultat.next()) {
	        Admin = resultat.getInt("Admin"); // --> si 0 ou 1 alors utilisateurs connecté (Admin ou User)
	        System.out.println("Requete effectuée "+Admin);
	        }
	    } catch ( SQLException e ) {
	        System.out.println("Erreur lors de la connexion");
	        return Admin;
	    } finally {
	        System.out.println( "Fermeture de l'objet ResultSet." );
	        if ( resultat != null ) {
	            try {
	                resultat.close();
	            } catch ( SQLException ignore ) {
	            	return Admin;
	            }
        }
        System.out.println( "Fermeture de l'objet Statement." );
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException ignore ) {
            	return Admin;
            }
        }
        System.out.println( "Fermeture de l'objet Connection." );
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException ignore ) {return Admin;}
        	}	
    	}
	    return Admin;
	}
	
	public boolean subscribe(String email, String mdp) {
		ChargDriver();
		//Connection à la Base de donnée
		String User= "root";
		String password="prot$ge3";
		String url="jdbc:mariadb://localhost:3306/cinema";
		Connection connexion = null;
	    PreparedStatement statement = null;
	    ResultSet resultat = null;
	    try {
	        System.out.println( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion réussie !" );
	        
	        /* Création de l'objet gérant les requêtes */
	        String query="INSERT INTO users (Email,Mdp) VALUES (?,?)";
	        statement = connexion.prepareStatement(query);
	        statement.setString(1, email);
	        statement.setString(2, mdp);
	        resultat = statement.executeQuery();
	        System.out.println("Requete effectuée");
	    } catch ( SQLException e ) {
	        System.out.println("Erreur lors de la connexion");
	        return false;
	    } finally {
	        System.out.println( "Fermeture de l'objet ResultSet." );
	        if ( resultat != null ) {
	            try {
	                resultat.close();
	            } catch ( SQLException ignore ) {
	            	return false;
	            }
        }
        System.out.println( "Fermeture de l'objet Statement." );
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException ignore ) {
            	return false;
            }
        }
        System.out.println( "Fermeture de l'objet Connection." );
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException ignore ) {return false;}
        	}	
    	}
	    return true;
	}
	
	public String Sha(String mdp) throws NoSuchAlgorithmException {
		 MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(mdp.getBytes());

	        byte byteData[] = md.digest();

	        //convertir le tableau de bits en une format hexadécimal - méthode 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return sb.toString();
	}
}
