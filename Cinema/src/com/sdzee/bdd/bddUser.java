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
	        System.out.println( "Driver charg� !" );
		}catch(ClassNotFoundException e) {
			System.out.println("Erreur de chargement du driver");
		}
	}
	
	public int testConnect(String email, String mdp) {
		ChargDriver();
		//Connection � la Base de donn�e
		String User= "root";
		String password="prot$ge3";
		String url="jdbc:mariadb://localhost:3306/cinema";
		Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    int Admin = 2; // --> si renvoie alors il y a une erreur
	    try {
	        System.out.println( "Connexion � la base de donn�es..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion r�ussie !" );
	        /* Cr�ation de l'objet g�rant les requ�tes */
	        statement = connexion.createStatement();
	        System.out.println( "Objet requ�te cr�� !" );
	        /* Cr�ation de l'objet g�rant les requ�tes */
	        resultat = statement.executeQuery("SELECT * FROM users WHERE Email = '"+email+"' AND Mdp = '"+mdp+"'");
	        while(resultat.next()) {
	        Admin = resultat.getInt("Admin"); // --> si 0 ou 1 alors utilisateurs connect� (Admin ou User)
	        System.out.println("Requete effectu�e "+Admin);
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
		//Connection � la Base de donn�e
		String User= "root";
		String password="prot$ge3";
		String url="jdbc:mariadb://localhost:3306/cinema";
		Connection connexion = null;
	    PreparedStatement statement = null;
	    ResultSet resultat = null;
	    try {
	        System.out.println( "Connexion � la base de donn�es..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion r�ussie !" );
	        
	        /* Cr�ation de l'objet g�rant les requ�tes */
	        String query="INSERT INTO users (Email,Mdp) VALUES (?,?)";
	        statement = connexion.prepareStatement(query);
	        statement.setString(1, email);
	        statement.setString(2, mdp);
	        resultat = statement.executeQuery();
	        System.out.println("Requete effectu�e");
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

	        //convertir le tableau de bits en une format hexad�cimal - m�thode 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return sb.toString();
	}
}
