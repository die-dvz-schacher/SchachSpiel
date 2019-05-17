package Spiel;

public class Springer extends Figuren {

	public Springer(Feld feld, String figureID, Spielfeld spielfeld) {
		super(feld, figureID, spielfeld);
	}
	
	
	public void setFelderZumBewegen() {
		/*
		 * Muster:
		 * 1.	Überprüfen, ob mögliche Felder sich auf dem Schachbrett befindet, wenn nein wird das Feld nicht übergeben.
		 * 1.	Überprüfen, ob sich eine Figur auf den Koordinaten befindet
		 * 1.a	Wenn ja + diese Figur die gleiche Farbe hat, wird das Feld nicht übergeben
		 * 1.b	Wenn ja + diese Figur die andere Farbe hat, wird das Feld übergeben.
		 * 1.c	Wenn nein, wird das Feld übergeben.
		 */
		
		//Liste leeren
		this.FelderZumBewegen.removeAll(FelderZumBewegen);

		if(this.getFeld().getX()+2 <= 8) {
			if(this.getFeld().getY()+1 <= 8) {
				//[x+2/y+1]
				if(this.spielfeld.getFeld(this.getFeld().getX()+2, this.getFeld().getY()+1).getFigur() != null) {
					if(this.spielfeld.getFeld(this.getFeld().getX()+2, this.getFeld().getY()+1).getFigur().getColor() != this.getColor()) {
						this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+2,this.getFeld().getY()+1));
					}
				}
				else {
					this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+2,this.getFeld().getY()+1));
				}
			}
			
			if(this.getFeld().getY()-1 > 0) {
				//[x+2/y-1]
				if(this.spielfeld.getFeld(this.getFeld().getX()+2, this.getFeld().getY()-1).getFigur() != null) {
					if(this.spielfeld.getFeld(this.getFeld().getX()+2, this.getFeld().getY()-1).getFigur().getColor() != this.getColor()) {
						this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+2,this.getFeld().getY()-1));
					}
				}
				else {
					this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+2,this.getFeld().getY()-1));
				}
			}
		}
		
		if(this.getFeld().getX()-2 > 0) {
			if(this.getFeld().getY()+1 <= 8) {
				//[x-2/y+1]
				if(this.spielfeld.getFeld(this.getFeld().getX()-2, this.getFeld().getY()+1).getFigur() != null) {
					if(this.spielfeld.getFeld(this.getFeld().getX()-2, this.getFeld().getY()+1).getFigur().getColor() != this.getColor()) {
						this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()-2,this.getFeld().getY()+1));
					}
				}
				else {
					this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()-2,this.getFeld().getY()+1));
				}
			}
			
			if(this.getFeld().getY()-1 > 0) {
				//[x-2/y-1]
				if(this.spielfeld.getFeld(this.getFeld().getX()-2, this.getFeld().getY()-1).getFigur() != null) {
					if(this.spielfeld.getFeld(this.getFeld().getX()-2, this.getFeld().getY()-1).getFigur().getColor() != this.getColor()) {
						this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()-2,this.getFeld().getY()-1));
					}
				}
				else {
					this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()-2,this.getFeld().getY()-1));
				}
			}
		}
		
		if(this.getFeld().getY()+2 <= 8) {
			if(this.getFeld().getX()+1 <= 8) {
				//[x+1/y+2]
				if(this.spielfeld.getFeld(this.getFeld().getX()+1, this.getFeld().getY()+2).getFigur() != null) {
					if(this.spielfeld.getFeld(this.getFeld().getX()+1, this.getFeld().getY()+2).getFigur().getColor() != this.getColor()) {
						this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+1,this.getFeld().getY()+2));
					}
				}
				else {
					this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+1,this.getFeld().getY()+2));
				}
			}
			
			if(this.getFeld().getX()-1 > 0) {
				//[x-1/y+2]
				if(this.spielfeld.getFeld(this.getFeld().getX()-1, this.getFeld().getY()+2).getFigur() != null) {
					if(this.spielfeld.getFeld(this.getFeld().getX()-1, this.getFeld().getY()+2).getFigur().getColor() != this.getColor()) {
						this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()-1,this.getFeld().getY()+2));
					}
				}
				else {
					this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()-1,this.getFeld().getY()+2));
				}
			}
		}
		
		if(this.getFeld().getY()-2 > 0) {
			//[x+1/y-2]
			if(this.getFeld().getX()+1 <= 8) {
				if(this.spielfeld.getFeld(this.getFeld().getX()+1, this.getFeld().getY()-2).getFigur() != null) {
					if(this.spielfeld.getFeld(this.getFeld().getX()+1, this.getFeld().getY()-2).getFigur().getColor() != this.getColor()) {
						this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+1,this.getFeld().getY()-2));
					}
				}
				else {
					this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()+1,this.getFeld().getY()-2));
				}
			}
			
			if(this.getFeld().getX()-1 > 0) {
				//[x-1/y-2]
				if(this.spielfeld.getFeld(this.getFeld().getX()-1, this.getFeld().getY()-2).getFigur() != null) {
					if(this.spielfeld.getFeld(this.getFeld().getX()-1, this.getFeld().getY()-2).getFigur().getColor() != this.getColor()) {
						this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()-1,this.getFeld().getY()-2));
					}
				}
				else {
					this.FelderZumBewegen.add(this.spielfeld.getFeld(this.getFeld().getX()-1,this.getFeld().getY()-2));
				}
			}
		}
	}

}
