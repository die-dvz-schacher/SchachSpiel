/**
 * 
 */
package Spiel;

/**
 * @author simon
 *
 */
public class König extends Figuren {

	/**
	 * @param feld
	 */
	public König(Feld feld, String figureID, Spielfeld spielfeld) {
		super(feld, figureID, spielfeld);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setFelderZumBewegen() {
		
		this.FelderZumBewegen.removeAll(FelderZumBewegen);
		
		int x = 1;
		int y = 0;
		if(checkFeld(x,y)) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+x, this.getFeld().getY()+y));
		}
		
		x = 1;
		y = -1;
		if(checkFeld(x,y)) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+x, this.getFeld().getY()+y));
		}
		
		x = 0;
		y = -1;
		if(checkFeld(x,y)) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+x, this.getFeld().getY()+y));
		}
		
		x = -1;
		y = -1;
		if(checkFeld(x,y)) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+x, this.getFeld().getY()+y));
		}
		
		x = -1;
		y = 0;
		if(checkFeld(x,y)) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+x, this.getFeld().getY()+y));
		}
		
		x = -1;
		y = 1;
		if(checkFeld(x,y)) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+x, this.getFeld().getY()+y));
		}
		
		x = 0;
		y = 1;
		if(checkFeld(x,y)) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+x, this.getFeld().getY()+y));
		}
		
		x = 1;
		y = 1;
		if(checkFeld(x,y)) {
			this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+x, this.getFeld().getY()+y));
		}
		
	}
	
	private boolean checkFeld(int x, int y) {
		if((this.getFeld().getX() == 8 && x == 1) || (this.getFeld().getX() == 0 && x == -1)) {
			return false;
		}
		
		if((this.getFeld().getY() == 8 && y == 1) || (this.getFeld().getY() == 0 && y == -1)) {
			return false;
		}
		
		Figuren aufFeld = this.spielfeld.getFeld(this.getFeld().getX()+x, this.getFeld().getY()+y).getFigur();
		if(aufFeld == null) {
			return true;
		}
		
		else {
			if(aufFeld.getColor() == this.color) {
				return false;
			}
			else {
				return true;
			}
		}
	}
	
}