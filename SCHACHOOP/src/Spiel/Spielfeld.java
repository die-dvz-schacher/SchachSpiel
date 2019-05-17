package Spiel;

import java.awt.Color;

public class Spielfeld {
    //Variablen
    private Feld[] felder = new Feld[65];
    private Figuren[] figurenWei� = new Figuren[16];
    private Figuren[] figurenSchwarz = new Figuren[16];
    



    //Konstruktor
    public Spielfeld() {
    	
    	//Initialisierung Felder
        felder[0] = new Feld(0,0);
        
        int count = 1;
        for(int i = 1; i <= 8; i++) {
        	for(int j = 1; j <= 8; j++) {
        		felder[count] = new Feld(j,i);
        		System.out.println("Das Feld "+count+" wurde an x = "+j+"/ y = "+i+" generiert.");
        		
        		if(felder[count].getFieldColor() == Color.WHITE) {
        			System.out.println("Es hat die Farbe Wei�.\n");
        		}
        		else {
        			System.out.println("Es hat die Farbe Schwarz.\n");
        		}
        		count++;        		
        	}
        }
        
        //Initialisierung Figuren Wei�
        
        figurenWei�[0] = new Turm(this.getFeld(1, 1), "Wei�Turm1", this);
        figurenWei�[1] = new Springer(this.getFeld(2, 1), "Wei�Springer1", this);
        figurenWei�[2] = new L�ufer(this.getFeld(3, 1), "Wei�L�ufer1", this);
        figurenWei�[3] = new K�nigin(this.getFeld(4, 1), "Wei�K�nigin", this);
        figurenWei�[4] = new K�nig(this.getFeld(5, 1), "Wei�K�nig", this);
        figurenWei�[5] = new L�ufer(this.getFeld(6, 1), "Wei�L�ufer2", this);
        figurenWei�[6] = new Springer(this.getFeld(7, 1), "Wei�Springer2", this);
        figurenWei�[7] = new Turm(this.getFeld(8, 1), "Wei�Turm2", this);
        
        for(int i = 0; i < 8; i++) {
        	figurenWei�[i].getFeld().setFigur(figurenWei�[i]);
        }
        
        
        for(int i = 8; i < 16; i++) {
        	figurenWei�[i] = new Bauer(this.getFeld(i - 7, 2), "Wei�Bauer"+(i-7), this);
        	figurenWei�[i].getFeld().setFigur(figurenWei�[i]);
        }
        
        //Initialisierung Figuren Schwarz
        
        figurenSchwarz[0] = new Turm(this.getFeld(8, 8), "SchwarzTurm1", this);
        figurenSchwarz[1] = new Springer(this.getFeld(7, 8), "SchwarzSpringer1", this);
        figurenSchwarz[2] = new L�ufer(this.getFeld(6, 8), "SchwarzL�ufer1", this);
        figurenSchwarz[3] = new K�nigin(this.getFeld(5, 8), "SchwarzK�nigin", this);
        figurenSchwarz[4] = new K�nig(this.getFeld(4, 8), "SchwarzK�nig", this);
        figurenSchwarz[5] = new L�ufer(this.getFeld(3, 8), "SchwarzL�ufer2", this);
        figurenSchwarz[6] = new Springer(this.getFeld(2, 8), "SchwarzSpringer2", this);
        figurenSchwarz[7] = new Turm(this.getFeld(1, 8), "SchwarzTurm2", this);
        
        for(int i = 0; i < 8; i++) {
        	figurenSchwarz[i].getFeld().setFigur(figurenSchwarz[i]);
        }
        
        for(int i = 15; i > 7; i--) {
        	figurenSchwarz[23-i] = new Bauer(this.getFeld(i-7, 7), "SchwarzBauer"+(16-i), this);
        	figurenSchwarz[23-i].getFeld().setFigur(figurenSchwarz[i-7]);
        }
    }
    
    //Methoden
    
	public Feld[] getFelder() {
		return felder;
	}

	public Figuren[] getFigurenWei�() {
		return figurenWei�;
	}

	public Figuren[] getFigurenSchwarz() {
		return figurenSchwarz;
	}

    public Feld getFeld(int x, int y) {
    	for(int i = 0; i < felder.length; i++) {
    		if(felder[i].getX() == x && felder[i].getY() == y) {
    			return felder[i];
    		}
    	}
    	System.out.println("Feld mit Parametern [x: "+x+" | y: "+y+"] nicht gefunden.");
    	return null;
    }
    
    public void printFeldFiguren(boolean white) {
    	if(white) {
    		for(int i = 0; i < this.figurenWei�.length; i++) {
    			System.out.println(this.figurenWei�[i].getFigureID()+"	-->	["+this.figurenWei�[i].getFeld().getX()+"/"+this.figurenWei�[i].getFeld().getY()+"].");
    		}
    	}
    	else {
    		for(int i = 0; i < this.figurenSchwarz.length; i++) {
    			System.out.println(this.figurenSchwarz[i].getFigureID()+"	-->	["+this.figurenSchwarz[i].getFeld().getX()+"/"+this.figurenSchwarz[i].getFeld().getY()+"].");
    		}
    	}
    }
    
    
    
}
