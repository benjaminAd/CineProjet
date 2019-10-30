package com.sdzee.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sdzee.beans.Film;
import com.sdzee.beans.Salle;

public class bddSalle {
	private String User;
	private String password;
	private String url;
	
	
	public bddSalle() {
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
	
	public int nbSalle() {
		ChargDriver();
		int nb= -1;
		//Connection à la Base de donnée
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery("SELECT count(Id) AS countSalle FROM salle;");
	        /* Récupération des données du résultat de la requête de lecture */
	        while(resultat.next()) {
	        	nb = Integer.valueOf(resultat.getString("countSalle"));
	        }
	    } catch ( SQLException e ) {
	    	return -1;
	    } finally {
	    	if ( resultat != null ) {
	    		try {
	    			resultat.close();
	    		} catch ( SQLException ignore ) {
	    			return -1;
	    		}
    	}
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException ignore ) {
	        	return -1;
	        }
	    }
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException ignore ) {return -1;}
	    	}	
		}
	    return nb;
	}
	
	public List<Salle> RecupSalle(){
		List<Salle> messages = new ArrayList<Salle>();
		bddFilms bdd = new bddFilms();
		ChargDriver();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT * FROM salle;" );
	        
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            Salle test = new Salle();
	            test.setId(resultat.getInt("Id"));
	            test.setNbPlaces(resultat.getInt("places"));
	            test.setNom(resultat.getString("nom"));
	            test.setFilm(bdd.RecupFilm(resultat.getInt("IdFilm")));
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
	
	public Salle recupSalle(int Id) {
		ChargDriver();
		bddFilms bdd = new bddFilms();
        Salle test = new Salle();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery( "SELECT * FROM salle WHERE Id='"+Id+"';" );
	        
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            test.setId(resultat.getInt("Id"));
	            test.setNbPlaces(resultat.getInt("places"));
	            test.setNom(resultat.getString("nom"));
	            test.setFilm(bdd.RecupFilm(resultat.getInt("IdFilm")));
	            /* Formatage des données pour affichage dans la JSP finale. */
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
	    return test;
	}
	public boolean UpdateSalle(HttpServletRequest request) {
		bddFilms bdd = new bddFilms();
		Salle salle = new Salle();
		salle.setFilm(bdd.RecupFilm(request.getParameter("film")));
		salle.setNbPlaces(Integer.valueOf(request.getParameter("places")));
		salle.setNom(request.getParameter("nom"));
		ChargDriver();
		Connection connexion = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        String query="UPDATE salle SET nom = ?,places=?,IdFilm=? WHERE id='"+request.getParameter("formid")+"'";
	        preparedStatement = connexion.prepareStatement(query);
	        preparedStatement.setString(1, salle.getNom());
	        preparedStatement.setInt(2, salle.getNbPlaces());
	        preparedStatement.setInt(3, salle.getFilm().getId());
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
	
	public boolean ExistSalle(String nom) {
		ChargDriver();
		int nb = -1;
		//Connection à la Base de donnée
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	    try {
	        connexion = DriverManager.getConnection(url,User,password);
	        
	        /* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery("SELECT count(Id) AS countId FROM salle WHERE nom='"+nom+"';");
	        /* Récupération des données du résultat de la requête de lecture */
	        while(resultat.next()) {
	        	nb = Integer.valueOf(resultat.getString("countId"));
	        }
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
	    if(nb == 0) {
	    	return true;
	    }else {
	    	return false;
	    }
	}
	
	public boolean AddSalle(Salle salle) {
			ChargDriver();
			Connection connexion = null;
	        ResultSet resultat = null;
	        PreparedStatement preparedStatement = null;
	        try {
	        	System.out.println( "Connexion à la base de données..." );
	            connexion = DriverManager.getConnection( url, User, password );
	            System.out.println( "Connexion réussie !" );
	             preparedStatement = connexion.prepareStatement("INSERT INTO salle(nom,places,IdFilm) VALUE(?,?,?)");
	                preparedStatement.setString(1, salle.getNom());
	                preparedStatement.setInt(2, salle.getNbPlaces());
	                preparedStatement.setInt(3, salle.getFilm().getId());
	                resultat = preparedStatement.executeQuery();
	        } catch ( SQLException e ) {
	        	System.out.println( "Erreur lors de la connexion :");
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
	
	public void RemoveSalle(int id) {
		   Connection connexion = null;
           ResultSet resultat = null;
           PreparedStatement preparedStatement = null;
           try {
           	System.out.println( "Connexion à la base de données..." );
               connexion = DriverManager.getConnection( url, User, password );
               System.out.println( "Connexion réussie !" );
               preparedStatement = connexion.prepareStatement("DELETE FROM salle WHERE id='"+id+"';");
               resultat = preparedStatement.executeQuery();
               
           } catch ( SQLException e ) {
           	System.out.println( "Erreur lors de la connexion :");
           } finally {
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
