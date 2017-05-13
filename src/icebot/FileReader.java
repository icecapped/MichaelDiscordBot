package icebot;
import java.util.Scanner;
import java.io.*;
public class FileReader {
 
	 
	
	static String getDeck(String deckName){
		File f = new File("/Users/Icecap/icebot/MichaelDiscordBot/decks.txt");
		
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				String s = sc.nextLine();
				if(s.contains(deckName)){
					sc.close();
					return s.substring(deckName.length() + 1);
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("[FileReader] Deck text file not found.");
			return "FNF"; //file not found exception
		}
		return "DNF";//deck not found
	}
}
