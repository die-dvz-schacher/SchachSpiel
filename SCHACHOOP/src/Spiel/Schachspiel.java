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
    	currentPlayer = "Weiﬂ";
    	currentZug = 1;
    	
    }
    
    //Methoden
    
    private Figuren selectFigur() {
    	//Check, ob der CurrentPlayer richtig ist
    	if(!this.checkCurrentPlayer()) {
    		System.out.println("Fehler beim w‰hlen der Figur");
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
    		System.out.println("Fehler beim W‰hlen der Figur");
    		return null;
    	}
    	
    	//Figurenauswahl Weiﬂ
    	if(this.currentPlayer.equals("Weiﬂ")) {
    		for(int i = 0; i < 16; i++) {
   				if(this.spielfeld.getFigurenWeiﬂ()[i].getFigureID().equals(""+erg)) {
   					System.out.println("\nAusgew‰hlte Figur: ["+spielfeld.getFigurenWeiﬂ()[i].getFeld().getX()+"/"+spielfeld.getFigurenWeiﬂ()[i].getFeld().getY()+"]");
   					return this.spielfeld.getFigurenWeiﬂ()[i];
   					
   				}
   			}
   		}
    	
    	//Figurenauswahl Schwarz
   		else {
   			for(int i = 0; i < 16; i++) {
   				if(this.spielfeld.getFigurenSchwarz()[i].getFigureID().equals(erg)) {
   					System.out.println("\nAusgew‰hlte Figur: ["+spielfeld.getFigurenSchwarz()[i].getFeld().getX()+"/"+spielfeld.getFigurenSchwarz()[i].getFeld().getY()+"]");
   					return this.spielfeld.getFigurenSchwarz()[i];
   				}
   			}
   		}
   	
    	//Fehlermeldung
    	System.out.println("Fehler beim W‰hlen der Figur.");
    	return null;
   
    }
    
    private boolean checkCurrentPlayer() {
    	if(this.currentPlayer.equals("Weiﬂ") || this.currentPlayer.equals("Schwarz")) {
    		return true;
    	}
    	
    	return false;
    }
    
    private String substringToCheck() {
    	if(this.currentPlayer == "Weiﬂ") {
    		return "Weiﬂ";
    	}
    	else {
    		return "Schwarz";
    	}
    }
    
    public void Spielzug() {
    	if(this.currentPlayer.equals("Weiﬂ")) {
    		//Spielzug f¸r Weiﬂen Spieler
    		spielfeld.printFeldFiguren(true);
    		
    		this.changePlayer();
    	}
    	
    	else {
    		//Spielzug f¸r Schwarzen Spieler
    		spielfeld.printFeldFiguren(false);
    		
    		this.changePlayer();
    	}
    	currentZug++;
    }
    
    /**
     * ƒndert den momentanen Spieler
     * @return
     * true, wenn Wechsel erfolgreich; false wenn falscher Spieler im Spiel ist
     */
    private boolean changePlayer() {
    	if(this.checkCurrentPlayer()) {
    		if(this.currentPlayer.equals("Weiﬂ")) {
        		this.currentPlayer = "Schwarz";
        		return true;
        	}
    		
        	else {
        		this.currentPlayer = "Weiﬂ";
        		return true;
        	}
    	}
    	
    	else {
    		System.out.println("Fehler beim Spielerwechsel");
    		return false;
    	}    	
    }


}
