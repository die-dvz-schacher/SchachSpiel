package Spiel;

import java.awt.Color;

/**
 * @author Simon Soltow
 *
 */
public class Bauer extends Figuren {

	public Bauer(Feld feld, String figureID, Spielfeld spielfeld) {
		super(feld, figureID, spielfeld);
	}
	
	private boolean checkZweiSchritte() {
		if(this.getColor() == Color.BLACK) {
			if(this.getFeld().getY() == 7) {
				return true;
			}
		}
		
		if(this.getColor() == Color.WHITE) {
			if(this.getFeld().getY() == 2) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkGegnerLinks() {
		if(this.getFeld().getX() == 1) {
			return false;
		}
		
		Feld toCheck = null;
		if(this.getColor() == Color.BLACK) {
			toCheck = this.spielfeld.getFeld(this.getFeld().getX()-1, this.getFeld().getY()-1);
		}
		
		if(this.getColor() == Color.WHITE) {
			toCheck = this.spielfeld.getFeld(this.getFeld().getX()-1, this.getFeld().getY()+1);
		}
		
		if(toCheck.getFigur() != null) {
			if(toCheck.getFigur().getColor() != this.getColor()) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkGegnerRechts() {
		
		if(this.getFeld().getX() == 8) {
			return false;
		}
		
		Feld toCheck = null;
		if(this.getColor() == Color.BLACK) {
			toCheck = this.spielfeld.getFeld(this.getFeld().getX()+1, this.getFeld().getY()-1);
		}
		
		if(this.getColor() == Color.WHITE) {
			toCheck = this.spielfeld.getFeld(this.getFeld().getX()+1, this.getFeld().getY()+1);
		}
		
		if(toCheck.getFigur() != null) {
			if(toCheck.getFigur().getColor() != this.getColor()) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void setFelderZumBewegen() {
		this.FelderZumBewegen.removeAll(FelderZumBewegen);
		int move = 0;

		if(this.getColor() == Color.BLACK) {
			move--;
		}
		
		if(this.getColor() == Color.WHITE) {
			move++;
		}
		
		if(this.checkZweiSchritte()) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX(), this.getFeld().getY()+move*2));
		}
		
		if(this.checkGegnerLinks()) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()-1, this.getFeld().getY()+move));
		}
		
		if(this.checkGegnerRechts()) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+1, this.getFeld().getY()+move));
		}
		
		this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX(), this.getFeld().getY()+move));
	}

}
