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
public class Schachspiel implements Cloneable{
	
	//Variablen 
	
    private Spielfeld spielfeld;
    //private Spielfeld spielfeldClone = spielfeld.clone();
    private String currentPlayer;
    private int currentZug;
    private Logger log;
    
    //Konstruktur
    public Schachspiel() throws IOException {
    	
    	spielfeld = new Spielfeld();
    	currentPlayer = "Weiﬂ";
    	currentZug = 1;
    	log = new Logger(this);
    	log.init("test");
    	
    }
    
    public Logger getLogger() {
    	return this.log;
    }
    
    public void Spielzug() {
		
		System.out.println("-----------------------------------------\nZug:		"+this.currentZug+"\n-----------------------------------------");
		
		Figuren selectedFigur;
		Feld selectedFeld;
		
		if(this.currentPlayer.equals("Weiﬂ")) {
			spielfeld.printFeldFiguren(true);
		}
		
		if(this.currentPlayer.equals("Schwarz")) {
			spielfeld.printFeldFiguren(false);
		}	
			
		do {
			selectedFigur = this.selectFigur();
		} while(selectedFigur == null);	
		
		selectedFigur.setFelderZumBewegen();
		
		while(selectedFigur.FelderZumBewegen.isEmpty() || selectedFigur.FelderZumBewegen.size() < 1) {
			System.out.println("\nGew‰hlte Figur kann sich nicht bewegen, bitte eine andere ausw‰hlen!");
			
			do {
				selectedFigur = this.selectFigur();
			} while(selectedFigur == null);
			
			selectedFigur.setFelderZumBewegen();
		}
			
		selectedFigur.printFelderZumBewegen(); 
			
		do {
			selectedFeld = this.selectFeld();
		}	while(!this.isMoveable(selectedFeld, selectedFigur));
		
		System.out.println("\n"+this.getMovementLog(selectedFigur.getFeld(), selectedFeld, selectedFigur));
		log.LogTurn(this.getMovementLog(selectedFigur.getFeld(), selectedFeld, selectedFigur), this.currentPlayer, this.currentZug);
		selectedFigur.getFeld().setFigur(null);
		selectedFigur.setFeld(selectedFeld);
		selectedFeld.setFigur(selectedFigur);
		
		
		this.changePlayer();	
		
		currentZug++;
		System.out.println("-----------------------------------------");
	}

    protected Schachspiel clone() {
    	return this;
    }
    
    private Feld selectFeld() {
    	
    	boolean erfolg = false;
    	
    	//Abfrage X
    	System.out.println("\nBitte das X eingeben: ");
    	BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
    	String ergX = new String("");
    	int x = 0;
    	do {
    		try {
    			ergX = din.readLine();
    		}
    		catch (IOException e) {
    			System.out.println("\nFehler beim W‰hlen von X.");
    			return null;
    		}
    		
    		try {
    			x = Integer.parseInt(ergX);
    			erfolg = true;
    		} 
    		catch (NumberFormatException f) {
    			System.out.println("\nFehler beim W‰hlen von X.");
    			erfolg = false;
    		} 
    			
    	} while (!erfolg);
    	
    	erfolg = false;
    	
    	//Abfrage Y
    	System.out.println("\nBitte das Y eingeben");
    	String ergY = new String("");
    	int y = 0;
    	do {
    		try {
    			ergY = din.readLine();
    		}
    		catch (IOException e) {
    			System.out.println("\nFehler beim W‰hlen von Y.");
    			return null;
    		}
    		
    		try {
    			y = Integer.parseInt(ergY);
    			erfolg = true;
    		} 
    		catch (NumberFormatException f) {
    			System.out.println("\nFehler beim W‰hlen von Y.");
    			erfolg = false;
    		} 
    			
    	} while (!erfolg);
    	
    	//Feld¸bergabe
    	Feld erg;
    	try {
    		erg = this.spielfeld.getFeld(x, y);
    	}
    	
    	catch (NullPointerException n) {
    		System.out.println("\nFehler bei der Auswahl des Feldes.");
    		return null;
    	}
    	
    	System.out.println("\nAusgew‰hltes Feld: ["+x+"/"+y+"]");
    	return erg;
    }
    
    private Figuren selectFigur() {
    	//Check, ob der CurrentPlayer richtig ist
    	if(!this.checkCurrentPlayer()) {
    		System.out.println("\nFehler beim W‰hlen der Figur");
    		return null;
    	}
    	
    	//Abfrage per BufferedReader
    	System.out.println("\nSpieler "+this.currentPlayer+" bitte zu bewegende Figur selektieren: ");
    	BufferedReader din =  new BufferedReader(new InputStreamReader(System.in));
    	String erg = new String("");
    	try {
    		erg = din.readLine();
    	}
    	catch (IOException e) {
    		System.out.println("\nFehler beim W‰hlen der Figur");
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
    	System.out.println("\nFehler beim W‰hlen der Figur.");
    	return null;
   
    }
    
    private boolean checkCurrentPlayer() {
    	if(this.currentPlayer.equals("Weiﬂ") || this.currentPlayer.equals("Schwarz")) {
    		return true;
    	}
    	
    	return false;
    }
    
    private boolean changePlayer() {
    	if(this.checkCurrentPlayer()) {
    		System.out.print("\nZug von "+this.currentPlayer+" beendet, ");
    		if(this.currentPlayer.equals("Weiﬂ")) {
        		this.currentPlayer = "Schwarz";
           		System.out.println(this.currentPlayer+" ist dran.");
        		return true;
        	}
    		
        	else {
        		this.currentPlayer = "Weiﬂ";
           		System.out.println(this.currentPlayer+" ist dran.");
        		return true;
        	}
    		
    	}
    	
    	else {
    		System.out.println("Fehler beim Spielerwechsel");
    		return false;
    	}    	
    }
    
    private boolean isMoveable(Feld feld, Figuren figur) {
    	for(int i = 0; i < figur.FelderZumBewegen.size(); i++) {
    		if(figur.FelderZumBewegen.get(i).equals(feld)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public String getMovementLog(Feld feldAlt, Feld feldNeu, Figuren figur, Figuren geschlagen) {
    	String erg = new String(figur.figureID+":	["+feldAlt.getX()+"/"+feldAlt.getY()+"] ---> ["+feldNeu.getX()+"/"+feldNeu.getY()+"]	RIP:"+geschlagen.getFigureID());
    	return erg;
    }
    
    public String getMovementLog(Feld feldAlt, Feld feldNeu, Figuren figur) {
    	String erg = new String(figur.figureID+":	["+feldAlt.getX()+"/"+feldAlt.getY()+"] ---> ["+feldNeu.getX()+"/"+feldNeu.getY()+"]");
    	return erg;
    }


}
