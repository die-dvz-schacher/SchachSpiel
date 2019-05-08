package Spiel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Beschreibt das Schachspiel.
 * 
 * @author Simon Soltow 
 * 
 */
public class Schachspiel {
	
	//Variablen 
    private Spielfeld spielfeld;
    private String currentPlayer;
    private int currentZug;
    
    //Konstruktur
    public Schachspiel() {
    	
    	spielfeld = new Spielfeld();
    	currentPlayer = "Wei�";
    	currentZug = 1;
    	
    }
    
    //Methoden
    
    private Figuren selectFigur() {
    	//Check, ob der CurrentPlayer richtig ist
    	if(!this.checkCurrentPlayer()) {
    		System.out.println("Fehler beim w�hlen der Figur");
    		return null;
    	}
    	
    	//Abfrage per BufferedReader
    	System.out.println("Spieler "+this.currentPlayer+" bitte zu bewegende Figur selektieren: ");
    	BufferedReader din =  new BufferedReader(new InputStreamReader(System.in));
    	String erg = new String("");
    	try {
    		erg = din.readLine();
    	}
    	catch (IOException e) {
    		System.out.println("Fehler beim W�hlen der Figur");
    		return null;
    	}
    	
    	//Figurenauswahl Wei�
    	if(this.currentPlayer.equals("Wei�")) {
    		for(int i = 0; i < 16; i++) {
   				if(this.spielfeld.getFigurenWei�()[i].getFigureID().equals(""+erg)) {
   					System.out.println("\nAusgew�hlte Figur: ["+spielfeld.getFigurenWei�()[i].getFeld().getX()+"/"+spielfeld.getFigurenWei�()[i].getFeld().getY()+"]");
   					return this.spielfeld.getFigurenWei�()[i];
   					
   				}
   			}
   		}
    	
    	//Figurenauswahl Schwarz
   		else {
   			for(int i = 0; i < 16; i++) {
   				if(this.spielfeld.getFigurenSchwarz()[i].getFigureID().equals(erg)) {
   					System.out.println("\nAusgew�hlte Figur: ["+spielfeld.getFigurenSchwarz()[i].getFeld().getX()+"/"+spielfeld.getFigurenSchwarz()[i].getFeld().getY()+"]");
   					return this.spielfeld.getFigurenSchwarz()[i];
   				}
   			}
   		}
   	
    	//Fehlermeldung
    	System.out.println("Fehler beim W�hlen der Figur.");
    	return null;
   
    }
    
    private boolean checkCurrentPlayer() {
    	if(this.currentPlayer.equals("Wei�") || this.currentPlayer.equals("Schwarz")) {
    		return true;
    	}
    	
    	return false;
    }
    
    private String substringToCheck() {
    	if(this.currentPlayer == "Wei�") {
    		return "Wei�";
    	}
    	else {
    		return "Schwarz";
    	}
    }
    
    public void Spielzug() {
    	if(this.currentPlayer.equals("Wei�")) {
    		//Spielzug f�r Wei�en Spieler
    		spielfeld.printFeldFiguren(true);
    		
    		this.changePlayer();
    	}
    	
    	else {
    		//Spielzug f�r Schwarzen Spieler
    		spielfeld.printFeldFiguren(false);
    		
    		this.changePlayer();
    	}
    	currentZug++;
    }
    
    /**
     * �ndert den momentanen Spieler
     * @return
     * true, wenn Wechsel erfolgreich; false wenn falscher Spieler im Spiel ist
     */
    private boolean changePlayer() {
    	if(this.checkCurrentPlayer()) {
    		if(this.currentPlayer.equals("Wei�")) {
        		this.currentPlayer = "Schwarz";
        		return true;
        	}
    		
        	else {
        		this.currentPlayer = "Wei�";
        		return true;
        	}
    	}
    	
    	else {
    		System.out.println("Fehler beim Spielerwechsel");
    		return false;
    	}    	
    }


}
