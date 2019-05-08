package Spiel;

import java.awt.Color;

/**
 * Diese Klasse beschreibt die Felder des Schachfeldes
 * 
 * @author Simon Soltow 
 * @version Version: 26.04.2019
 */
public class Feld {

    //Variablen
    private int x;
    private int y;
    private Color fieldColor;
    private Figuren figur;
    
    public Feld(int x, int y) {
    	
        this.x = x;
        this.y = y;
        this.figur = null;
        
        if(x % 2 == 0) {
        	if(y % 2 == 0) {
        		this.fieldColor = Color.BLACK;
        	}
        	else {
        		this.fieldColor = Color.WHITE;
        	}
        }
        
        else {
        	if(y % 2 == 0) {
        		this.fieldColor = Color.WHITE;
        	}
        	else {
        		this.fieldColor = Color.BLACK;
        	}
        }
    }

    /**
	 * @return the x
	 */
	int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the fieldColor
	 */
	Color getFieldColor() {
		return fieldColor;
	}

	/**
	 * @param fieldColor the fieldColor to set
	 */
	void setFieldColor(Color fieldColor) {
		this.fieldColor = fieldColor;
	}

	/**
	 * @return the figur
	 */
	Figuren getFigur() {
		return figur;
	}

	/**
	 * @param figur the figur to set
	 */
	void setFigur(Figuren figur) {
		this.figur = figur;
	}

	//Konstruktor
    
}
