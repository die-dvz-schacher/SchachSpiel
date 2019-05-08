package Spiel;

import java.awt.Color;


/**
 * Das Spielfeld, auf dem das Spiel sp‰ter statt findet.
 * 
 * 
 * @author Simon Soltow
 */
public class Spielfeld {
    //Variablen
	
    /**
     * Eine Liste der einzelnen Felder
     */
    private Feld[] felder = new Feld[65];
    /**
     * Eine Liste, welche die weiﬂen Figuren enth‰lt
     */
    private Figuren[] figurenWeiﬂ = new Figuren[16];
    /**
     * Eine Liste, welche die schwarzen Figuren enth‰lt.
     */
    private Figuren[] figurenSchwarz = new Figuren[16];


    //Konstruktor
    /**
     * 
     */
    public Spielfeld() {
    	
    	//Initialisierung Felder
        felder[0] = new Feld(0,0);
        
        int count = 1;
        for(int i = 1; i <= 8; i++) {
        	for(int j = 1; j <= 8; j++) {
        		felder[count] = new Feld(j,i);
        		System.out.println("Das Feld "+count+" wurde an x = "+j+"/ y = "+i+" generiert.");
        		
        		if(felder[count].getFieldColor() == Color.WHITE) {
        			System.out.println("Es hat die Farbe Weiﬂ.\n");
        		}
        		else {
        			System.out.println("Es hat die Farbe Schwarz.\n");
        		}
        		count++;        		
        	}
        }
        
        //Initialisierung Figuren Weiﬂ
        
        figurenWeiﬂ[0] = new Turm(this.getFeld(1, 1), "WeiﬂTurm1");
        figurenWeiﬂ[1] = new Springer(this.getFeld(2, 1), "WeiﬂSpringer1");
        figurenWeiﬂ[2] = new L‰ufer(this.getFeld(3, 1), "WeiﬂL‰ufer1");
        figurenWeiﬂ[3] = new Kˆnigin(this.getFeld(4, 1), "WeiﬂKˆnigin");
        figurenWeiﬂ[4] = new Kˆnig(this.getFeld(5, 1), "WeiﬂKˆnig");
        figurenWeiﬂ[5] = new L‰ufer(this.getFeld(6, 1), "WeiﬂL‰ufer2");
        figurenWeiﬂ[6] = new Springer(this.getFeld(7, 1), "WeiﬂSpringer2");
        figurenWeiﬂ[7] = new Turm(this.getFeld(8, 1), "WeiﬂTurm2");
        
        for(int i = 0; i < 8; i++) {
        	figurenWeiﬂ[i].getFeld().setFigur(figurenWeiﬂ[i]);
        }
        
        
        for(int i = 8; i < 16; i++) {
        	figurenWeiﬂ[i] = new Bauer(this.getFeld(i - 7, 2), "WeiﬂBauer"+(i-7));
        	figurenWeiﬂ[i].getFeld().setFigur(figurenWeiﬂ[i]);
        }
        
        //Initialisierung Figuren Schwarz
        
        figurenSchwarz[0] = new Turm(this.getFeld(8, 8), "SchwarzTurm1");
        figurenSchwarz[1] = new Springer(this.getFeld(7, 8), "SchwarzSpringer1");
        figurenSchwarz[2] = new L‰ufer(this.getFeld(6, 8), "SchwarzL‰ufer1");
        figurenSchwarz[3] = new Kˆnigin(this.getFeld(5, 8), "SchwarzKˆnigin");
        figurenSchwarz[4] = new Kˆnig(this.getFeld(4, 8), "SchwarzKˆnig");
        figurenSchwarz[5] = new L‰ufer(this.getFeld(3, 8), "SchwarzL‰ufer2");
        figurenSchwarz[6] = new Springer(this.getFeld(2, 8), "SchwarzSpringer2");
        figurenSchwarz[7] = new Turm(this.getFeld(1, 8), "SchwarzTurm2");
        
        for(int i = 0; i < 8; i++) {
        	figurenSchwarz[i].getFeld().setFigur(figurenWeiﬂ[i]);
        }
        
        for(int i = 15; i > 7; i--) {
        	figurenSchwarz[23-i] = new Bauer(this.getFeld(i-7, 7), "SchwarzBauer"+(16-i));
        	figurenSchwarz[23-i].getFeld().setFigur(figurenSchwarz[i-7]);
        }
    }
    
    //Methoden
    
    /**
	 * @return the felder
	 */
	Feld[] getFelder() {
		return felder;
	}

	/**
	 * @return the figurenWeiﬂ
	 */
	Figuren[] getFigurenWeiﬂ() {
		return figurenWeiﬂ;
	}

	/**
	 * @return the figurenSchwarz
	 */
	Figuren[] getFigurenSchwarz() {
		return figurenSchwarz;
	}

	/**
     * Gibt ein Feld aus der Liste felder zur¸ck.
     * 
     * @param x
     * Der X-Wert
     * 
     * @param y
     * Der Y-Wert
     * 
     * @return
     * Ein Feld, wenn Input korrekt ist.
     * Null, wenn ung¸ltige Parameter eingegeben werden.
     */
    public Feld getFeld(int x, int y) {
    	for(int i = 0; i < felder.length; i++) {
    		if(felder[i].getX() == x && felder[i].getY() == y) {
    			return felder[i];
    		}
    	}
    	System.out.println("Feld mit Parametern [x: "+x+" | y: "+y+"] nicht gefunden.");
    	return null;
    }
    
    /**
     * Gibt alle Figuren einer Farbe mit zugehˆriger Position aus.
     * 
     * @param white
     * True wenn die weiﬂen Figuren ausgegeben werden sollen, False wenn die schwarzen Ausgegeben werden sollen.
     */
    public void printFeldFiguren(boolean white) {
    	if(white) {
    		for(int i = 0; i < this.figurenWeiﬂ.length; i++) {
    			System.out.println(this.figurenWeiﬂ[i].getFigureID()+"	-->	["+this.figurenWeiﬂ[i].getFeld().getX()+"/"+this.figurenWeiﬂ[i].getFeld().getY()+"].");
    		}
    	}
    	else {
    		for(int i = 0; i < this.figurenSchwarz.length; i++) {
    			System.out.println(this.figurenSchwarz[i].getFigureID()+"	-->	["+this.figurenSchwarz[i].getFeld().getX()+"/"+this.figurenSchwarz[i].getFeld().getY()+"].");
    		}
    	}
    }
    
}
