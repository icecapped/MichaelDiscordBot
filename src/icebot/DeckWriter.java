package icebot;

import java.io.*;

public class DeckWriter {

	static String addDeck(String deck){
		File f = new File("/Users/Icecap/icebot/MichaelDiscordBot/decks.txt");
		
		try {
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bf = new BufferedWriter(fw);
			System.out.println("[Write] Decklist opened.");
			bf.write("\n" + deck);
			bf.flush();
			bf.close();
			System.out.println("[Write] Decklist updated.");
			return "VLD"; // valid
		} catch(FileNotFoundException e){
			System.out.println("[Write] Decklist not found!");
			return "FNF";
		} catch (IOException e) {
			System.out.println("[Write] IOException!");
			return "IOE";
		}
	}
}
