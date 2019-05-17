package Spiel;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Figuren.
 * 
 * @author Simon

 */
public abstract class Figuren {
	
    //Variablen
    protected Feld feld;
	protected Color color;
	protected String figureID;
	protected Spielfeld spielfeld;
	protected ArrayList<Feld> FelderZumBewegen;

	//Konstruktor
	public Figuren(Feld feld, String figureID, Spielfeld spielfeld) {
	   	this.feld = feld;
		this.figureID = figureID;
	
		this.spielfeld = spielfeld;
		
		if(feld.getY() < 3) {
			this.color = Color.WHITE;
		}
		
		else {
			this.color = Color.BLACK;
		}
		
		FelderZumBewegen = new ArrayList<Feld>();
	}
	
	//Methoden
	public Spielfeld getSpielfeld() {
		return spielfeld;
	}

	public ArrayList<Feld> getFelderZumBewegen() {
		return FelderZumBewegen;
	}

    public Feld getFeld() {
    	return this.feld;
    }
    
    public Color getColor() {
    	return this.color;
    }
    
	public String getFigureID() {
		return figureID;
	}
	
	public void setFeld(Feld feld) {
		this.feld = feld;
	}

	public void printFelderZumBewegen() {
		System.out.println(this.getFigureID()+" kann sich auf die Felder\n");
		
		for(int i = 0; i < FelderZumBewegen.size(); i++) {
			
			if(FelderZumBewegen.get(i).getFigur() != null) {
				System.out.println("["+FelderZumBewegen.get(i).getX()+"/"+FelderZumBewegen.get(i).getY()+"] --> "+FelderZumBewegen.get(i).getFigur().getFigureID());
			}
			
			else {
				System.out.println("["+FelderZumBewegen.get(i).getX()+"/"+FelderZumBewegen.get(i).getY()+"]");
			}
			
		}
		System.out.println("\nbewegen.");
	}
	
	public abstract void setFelderZumBewegen();

}
