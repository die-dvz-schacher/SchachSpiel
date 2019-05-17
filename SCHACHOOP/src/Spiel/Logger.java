package Spiel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
	
	private Date date;
	private File f;
	private FileWriter writer;


	public Logger(Schachspiel spiel) throws IOException {
		date = new Date();
		f = new File("C:\\Users\\simon\\Documents\\Schachlog\\"+date.toString().replace(':', '-')+".txt");
		writer = new FileWriter(f);
	}
	
	public FileWriter getWriter() {
		return this.writer;
	}
	
	void init(String kommentar) {
		try {
			writer.write("Spiel: "+date.toString()+"\r\n"+kommentar+"\r\n");
		}
		
		catch (IOException e) {
			System.out.println("<><><><><><><><><>\nIO-Fehler\n<><><><><><><><><>");
		}
	}
	
	void LogTurn(String log, String spieler, int zug) {
		try {
			writer.write(spieler+" {"+zug+"}: "+log+"\r\n");
		}
		
		catch (IOException e) {
			System.out.println("<><><><><><><><><>\nIO-Fehler\n<><><><><><><><><>");
		}
	}

}
