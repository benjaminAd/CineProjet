package com.sdzee.bdd;
import java.util.*;
import com.sdzee.beans.*;
import javax.servlet.http.*;
import java.sql.*;

public class bddActeurs {
	String User;
	String password;
	String url;
	public bddActeurs(){
		User= "root";
		password="prot$ge3";
		url="jdbc:mariadb://localhost:3306/cinema";
	}
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
	
	public List<Acteurs> recupActeurs(){
		List<Acteurs> listeActeur = new ArrayList<Acteurs>();
		ChargDriver();
		Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    try {
	        System.out.println( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion réussie !" );
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        System.out.println( "Objet requête créé !" );
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT * FROM acteurs;" );
	   /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	        	Acteurs act = new Acteurs();
	        	act.setId(resultat.getInt("id"));
	        	act.setNom(resultat.getString("Nom"));
	        	act.setPrenom(resultat.getString("Prenom"));
	        	act.setNationalite(resultat.getString("Nationalite"));
	        	act.setAge(resultat.getInt("Age"));
	        	act.setSexe(resultat.getString("Sexe"));
	        	listeActeur.add(act);
	        	System.out.println("acteur ajouté");
	       }
	} catch ( SQLException e ) {
	    System.out.println("Erreur lors de la connexion");
	} finally {
	    System.out.println( "Fermeture de l'objet ResultSet." );
	    if ( resultat != null ) {
	        try {
	            resultat.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    System.out.println( "Fermeture de l'objet Statement." );
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    System.out.println( "Fermeture de l'objet Connection." );
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException ignore ) {}
	    	}	
		}
	    return listeActeur;
	}
	
	public List<Acteurs> RecupIdAct(int id){
		List<Integer> listeId = new ArrayList<Integer>();
		List<Acteurs> listeActeur = new ArrayList<Acteurs>();
		ChargDriver();
		Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    try {
	        System.out.println( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion réussie !" );
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        System.out.println( "Objet requête créé !" );
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT IdActeur FROM acttofilm WHERE IdFilm = '"+id+"';" );
	   /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	        	listeId.add(resultat.getInt("IdActeur"));
	        	System.out.println("Id");
	       }
	} catch ( SQLException e ) {
	    System.out.println("Erreur lors de la connexion");
	} finally {
	    System.out.println( "Fermeture de l'objet ResultSet." );
	    if ( resultat != null ) {
	        try {
	            resultat.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    System.out.println( "Fermeture de l'objet Statement." );
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    System.out.println( "Fermeture de l'objet Connection." );
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException ignore ) {}
	    	}	
		}
	    for(int i = 0; i < listeId.size();i++) {
	    	listeActeur.add(recupAct((int)listeId.get(i)));
	    }
	    return listeActeur;
	}
	
	public Acteurs recupAct(int id) {
		Acteurs act = new Acteurs();
		ChargDriver();
		Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    try {
	        System.out.println( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion réussie !" );
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        System.out.println( "Objet requête créé !" );
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT * FROM acteurs WHERE id = '"+id+"';" );
	   /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	        	act.setId(resultat.getInt("id"));
	        	act.setAge(resultat.getInt("Age"));
	        	act.setNationalite(resultat.getString("Nationalite"));
	        	act.setNom(resultat.getString("Nom"));
	        	act.setPrenom(resultat.getString("Prenom"));
	        	act.setSexe(resultat.getString("Sexe"));
	        	System.out.println("Acteurs");
	       }
	} catch ( SQLException e ) {
	    System.out.println("Erreur lors de la connexion");
	} finally {
	    System.out.println( "Fermeture de l'objet ResultSet." );
	    if ( resultat != null ) {
	        try {
	            resultat.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    System.out.println( "Fermeture de l'objet Statement." );
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    System.out.println( "Fermeture de l'objet Connection." );
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException ignore ) {}
	    	}	
		}
	    return act;
	}
	public boolean AddActeur(Acteurs a){
       ChargDriver();
       Connection connexion = null;
       ResultSet resultat = null;
       PreparedStatement preparedStatement = null;
        try {
            System.out.println( "Connexion à la base de données..." );
            connexion = DriverManager.getConnection( url, User, password );
            System.out.println( "Connexion réussie !" );

            String SQL_ADD = "INSERT INTO acteurs(Nom,Prenom,Nationalite,Age,Sexe) VALUE(?,?,?,?,?)";
            	preparedStatement = connexion.prepareStatement(SQL_ADD);
                preparedStatement.setString(1, a.getNom());
                preparedStatement.setString(2, a.getPrenom());
                preparedStatement.setString(3, a.getNationalite());
                preparedStatement.setInt(4, a.getAge());
                preparedStatement.setString(5, a.getSexe());
                resultat = preparedStatement.executeQuery();

        } catch ( SQLException e ) {
            System.out.println( "Erreur lors de la connexion : <br/>");
            return false;
        }finally {
    	    System.out.println( "Fermeture de l'objet ResultSet." );
    	    if ( resultat != null ) {
    	        try {
    	            resultat.close();
    	        } catch ( SQLException ignore ) {
    	        	return false;
    	        }
    	    }
    	    System.out.println( "Fermeture de l'objet Statement." );
    	    if ( preparedStatement != null ) {
    	        try {
    	        	preparedStatement.close();
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

	public int recupIdFromNom(String nom, String prenom) {
		ChargDriver();
		Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    int id = -1;
	    try {
	        System.out.println( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion réussie !" );
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        System.out.println( "Objet requête créé !" );
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT id FROM acteurs WHERE Nom = '"+nom+"' AND Prenom='"+prenom+"';" );
	   /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	        	id = resultat.getInt("id");
	        }
	} catch ( SQLException e ) {
	    System.out.println("Erreur lors de la connexion");
	} finally {
	    System.out.println( "Fermeture de l'objet ResultSet." );
	    if ( resultat != null ) {
	        try {
	            resultat.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    System.out.println( "Fermeture de l'objet Statement." );
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    System.out.println( "Fermeture de l'objet Connection." );
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException ignore ) {}
	    	}	
		}
	    return id;
	}
	
	public void insertidAidF(int idF, int idA) {
		 ChargDriver();
	       Connection connexion = null;
	       ResultSet resultat = null;
	       PreparedStatement preparedStatement = null;
	        try {
	            System.out.println( "Connexion à la base de données..." );
	            connexion = DriverManager.getConnection( url, User, password );
	            System.out.println( "Connexion réussie !" );
	            	preparedStatement = connexion.prepareStatement("INSERT INTO acttofilm(IdFilm,IdActeur) VALUE(?,?)");
	                preparedStatement.setInt(1, idF);
	                preparedStatement.setInt(2, idA);
	                resultat = preparedStatement.executeQuery();
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur lors de la connexion : <br/>");
	        }finally {
	    	    System.out.println( "Fermeture de l'objet ResultSet." );
	    	    if ( resultat != null ) {
	    	        try {
	    	            resultat.close();
	    	        } catch ( SQLException ignore ) {
	    	        }
	    	    }
	    	    System.out.println( "Fermeture de l'objet Statement." );
	    	    if ( preparedStatement != null ) {
	    	        try {
	    	        	preparedStatement.close();
	    	        } catch ( SQLException ignore ) {
	    	        }
	    	    }
	    	    System.out.println( "Fermeture de l'objet Connection." );
	    	    if ( connexion != null ) {
	    	        try {
	    	            connexion.close();
	    	        } catch ( SQLException ignore ) {}
	    	    	}	
	    		}
	}
	
	public void insertidFidA(int idF, int idA) {
		 ChargDriver();
	       Connection connexion = null;
	       ResultSet resultat = null;
	       PreparedStatement preparedStatement = null;
	        try {
	            System.out.println( "Connexion à la base de données..." );
	            connexion = DriverManager.getConnection( url, User, password );
	            System.out.println( "Connexion réussie !" );
	            	preparedStatement = connexion.prepareStatement("INSERT INTO acttofilm(IdFilm,IdActeur) VALUE(?,?)");
	                preparedStatement.setInt(1, idF);
	                preparedStatement.setInt(2, idA);
	                resultat = preparedStatement.executeQuery();
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur lors de la connexion : <br/>");
	        }finally {
	    	    System.out.println( "Fermeture de l'objet ResultSet." );
	    	    if ( resultat != null ) {
	    	        try {
	    	            resultat.close();
	    	        } catch ( SQLException ignore ) {
	    	        }
	    	    }
	    	    System.out.println( "Fermeture de l'objet Statement." );
	    	    if ( preparedStatement != null ) {
	    	        try {
	    	        	preparedStatement.close();
	    	        } catch ( SQLException ignore ) {
	    	        }
	    	    }
	    	    System.out.println( "Fermeture de l'objet Connection." );
	    	    if ( connexion != null ) {
	    	        try {
	    	            connexion.close();
	    	        } catch ( SQLException ignore ) {}
	    	    	}	
	    		}
	}
}
