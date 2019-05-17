package Spiel;

/**
 * @author simon
 *
 */
public class Turm extends Figuren {

	/**
	 * @param feld
	 */
	public Turm(Feld feld, String figureID, Spielfeld spielfeld) {
		super(feld, figureID, spielfeld);
	}

	@Override
	public void setFelderZumBewegen() {
		
		this.FelderZumBewegen.removeAll(FelderZumBewegen);
		boolean breaker = false;
		int move = 1;
		Feld currentFeld = this.getFeld();
		
		//x
		for(int i = 0; i < 2; i++) {
			while(!breaker) {
				if((currentFeld.getX() == 8 && move == 1) || (currentFeld.getX() == 1 && move == -1)) {
					break;
				}
				currentFeld = this.spielfeld.getFeld(currentFeld.getX()+move, currentFeld.getY());
				if(currentFeld.getFigur() != null) {
					breaker = true;
					if(currentFeld.getFigur().getColor() != this.color) {
						this.FelderZumBewegen.add(currentFeld);
						System.out.println("]"+currentFeld.getX()+"/"+currentFeld.getY()+"[");
					}
					else {
						break;
					}
				}
				else {
					this.FelderZumBewegen.add(currentFeld);
					System.out.println("]"+currentFeld.getX()+"/"+currentFeld.getY()+"[");
				}
			}
			breaker = false;
			move = move*(-1);
			currentFeld = this.getFeld();
		}
		
		//y
		for(int i = 0; i < 2; i++) {
			while(!breaker) {
				if((currentFeld.getY() == 8 && move == 1) || (currentFeld.getY() == 1 && move == -1)) {
					break;
				}
				currentFeld = this.spielfeld.getFeld(currentFeld.getX(), currentFeld.getY()+move);
				if(currentFeld.getFigur() != null) {
					breaker = true;
					if(currentFeld.getFigur().getColor() != this.color) {
						this.FelderZumBewegen.add(currentFeld);
					}
				}
				else {
					this.FelderZumBewegen.add(currentFeld);
				}
			}
			breaker = false;
			move = move*(-1);
			currentFeld = this.getFeld();
		}
		
	}
	
	

}
