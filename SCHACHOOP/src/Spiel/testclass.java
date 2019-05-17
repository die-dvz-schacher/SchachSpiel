package Spiel;

import java.io.IOException;

public class testclass {

	public static void main(String[] args) throws IOException {
		Schachspiel spiel = new Schachspiel();
		for(int i = 0; i < 3; i++) {
			spiel.Spielzug();
		}
		spiel.getLogger().getWriter().close();

	}

}
