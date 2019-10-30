package com.sdzee.bdd;
import java.util.*;
import com.sdzee.beans.*;
import javax.servlet.http.*;
import java.sql.*;

public class bddFilms {
	//Connection à la Base de donnée
	private String User;
	private String password;
	private String url;
	
	
	public bddFilms() {
		User = "root";
		password = "prot$ge3";
		url="jdbc:mariadb://localhost:3306/cinema";
	}
	
	private void ChargDriver() {
		//Chargement du driver mariaDB
		try {
			System.out.println( "Chargement du driver..." );
	        Class.forName("org.mariadb.jdbc.Driver");
		}catch(ClassNotFoundException e) {}
	}
	
	public List<Film> RecupFilms(){
		List<Film> messages = new ArrayList<Film>();
		ChargDriver();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT * FROM films;" );
	        
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            Film test = new Film();
	            test.setId(resultat.getInt("id"));
	            test.setActif(resultat.getInt("actif"));
	            test.setAnnee(resultat.getInt("annee"));
	            test.setGenre(resultat.getString( "genre" ));
	            test.setNomFilm( resultat.getString( "titre" ));
	            test.setNomRealisateur(resultat.getString( "realisateur" ));
	            test.setResume(resultat.getString( "resume" ));
	            test.setLien(resultat.getString("lien"));
	            /* Formatage des données pour affichage dans la JSP finale. */
	            messages.add(test);
	        }
	    } catch ( SQLException e ) {
	    } finally {
	        if ( resultat != null ) {
	            try {
	                resultat.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	        if ( statement != null ) {
	            try {
	                statement.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	        if ( connexion != null ) {
	            try {
	                connexion.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	    }
	
	    return messages;
	    
	}
	
	public Film RecupFilm(int id) {
		Film test = new Film();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		ChargDriver();
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT * FROM films WHERE id = '"+id+"';" );
	   /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	        test.setId(resultat.getInt("id"));
	        test.setActif(resultat.getInt("actif"));
	        test.setAnnee(resultat.getInt("annee"));
	        test.setGenre(resultat.getString( "genre" ));
	        test.setNomFilm( resultat.getString( "titre" ));
	        test.setNomRealisateur(resultat.getString( "realisateur" ));
	        test.setResume(resultat.getString( "resume" ));
	        test.setLien(resultat.getString("lien"));
	       }
	} catch ( SQLException e ) {
	} finally {
	    if ( resultat != null ) {
	        try {
	            resultat.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException ignore ) {}
	    	}	
		}
	    return test;
	}
	
	public Film RecupFilm(String nom) {
		Film test = new Film();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		ChargDriver();
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT * FROM films WHERE titre = '"+nom+"';" );
	   /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	        test.setId(resultat.getInt("id"));
	        test.setActif(resultat.getInt("actif"));
	        test.setAnnee(resultat.getInt("annee"));
	        test.setGenre(resultat.getString( "genre" ));
	        test.setNomFilm( resultat.getString( "titre" ));
	        test.setNomRealisateur(resultat.getString( "realisateur" ));
	        test.setResume(resultat.getString( "resume" ));
	        test.setLien(resultat.getString("lien"));
	       }
	} catch ( SQLException e ) {
	} finally {
	    if ( resultat != null ) {
	        try {
	            resultat.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException ignore ) {
	        }
	    }
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException ignore ) {}
	    	}	
		}
	    return test;
	}
	
	public boolean UpdateFilm(HttpServletRequest request) {
		Film f = new Film();
		f.setNomFilm(request.getParameter("titre"));
		f.setGenre(request.getParameter("genre"));
		f.setResume(request.getParameter("resume")); 
		f.setAnnee(Integer.valueOf(request.getParameter("annee")));
		f.setNomRealisateur(request.getParameter("rea"));
		f.setLien(request.getParameter("lien"));
		System.out.println(request.getParameter("lien"));
		ChargDriver();
		Connection connexion = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        String query="UPDATE films SET titre = ?,resume=?,genre=?,realisateur=?,annee=?,lien=? WHERE id='"+request.getParameter("id")+"'";
	        preparedStatement = connexion.prepareStatement(query);
	        preparedStatement.setString(1,f.getNomFilm());
	        preparedStatement.setString(2, f.getResume());
	        preparedStatement.setString(3, f.getGenre());
	        preparedStatement.setString(4, f.getNomRealisateur());
	        preparedStatement.setInt(5, f.getAnnee());
	        preparedStatement.setString(6, f.getLien());
	        resultat = preparedStatement.executeQuery();
	    } catch ( SQLException e ) {
	        return false;
	    } finally {
	        if ( resultat != null ) {
	            try {
	                resultat.close();
	            } catch ( SQLException ignore ) {
	            	return false;
	            }
        }
        if ( preparedStatement != null ) {
            try {
            	preparedStatement.close();
            } catch ( SQLException ignore ) {
            	return false;
            }
        }
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException ignore ) {return false;}
        	}	
    	}
	    return true;
	}
	
	public void UpdateActif(Film f) {
		ChargDriver();
		Connection connexion = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        String query="UPDATE films SET actif=? WHERE id='"+f.getId()+"'";
	        preparedStatement = connexion.prepareStatement(query);
	        preparedStatement.setInt(1,f.isActif());
	        resultat = preparedStatement.executeQuery();
	    } catch ( SQLException e ) {
	    } finally {
	        if ( resultat != null ) {
	            try {
	                resultat.close();
	            } catch ( SQLException ignore ) {
	            }
        }
        if ( preparedStatement != null ) {
            try {
            	preparedStatement.close();
            } catch ( SQLException ignore ) {
            }
        }
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException ignore ) {}
        	}	
    	}
	}
	
	public boolean CheckNbSalle(int nbFixe) {
		ChargDriver();
		Connection connexion = null;
		ResultSet resultat = null;
		Statement statement = null;
		int nb=-1;
	    try {
	    	System.out.println( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion réussie !" );
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        System.out.println( "Objet requête créé !" );
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery("SELECT count(salle) AS countSalle FROM films;");
	        while(resultat.next()) {
	        	 nb = Integer.valueOf(resultat.getString("countSalle"));
	        }
	        /* Récupération des données du résultat de la requête de lecture */
	       
	    } catch ( SQLException e ) {
	    	return false;
	    } finally {
	    	if ( resultat != null ) {
	    		try {
	    			resultat.close();
	    		} catch ( SQLException ignore ) {
	    			return false;
	    		}
    	}
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException ignore ) {
	        	return false;
	        }
	    }
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException ignore ) {return false;}
	    	}	
		}
	    if((nb>=0)&&(nb< nbFixe)) {
	    	return true;
        }else {
        	return false;
        }
	}
	
	public boolean AddFilm(Film f) {
		ChargDriver();
		Connection connexion = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
	    try {
	    	System.out.println( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection(url,User,password);
	        System.out.println( "Connexion réussie !" );
	        
	        /* Création de l'objet gérant les requêtes */
	        String query="INSERT INTO films(titre,resume,genre,realisateur,annee,actif,lien) VALUE(?,?,?,?,?,?,?)";
	        preparedStatement = connexion.prepareStatement(query);
	        System.out.println( "Objet requête créé !" );
	        preparedStatement.setString(1,f.getNomFilm());
	        preparedStatement.setString(2, f.getResume());
	        preparedStatement.setString(3, f.getGenre());
	        preparedStatement.setString(4, f.getNomRealisateur());
	        preparedStatement.setInt(5, f.getAnnee());
	        preparedStatement.setInt(6, f.isActif());
	        preparedStatement.setString(7, f.getLien());
	        resultat = preparedStatement.executeQuery();
	        System.out.println("film ajouté");
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
}


