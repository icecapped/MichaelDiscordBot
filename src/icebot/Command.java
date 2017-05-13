package icebot;

import net.dv8tion.jda.core.events.message.*;

public class Command {
	
	void help(MessageReceivedEvent e){
		//TODO: PUT HELP INTO A TEXT FILE
		e.getChannel().sendMessage("Michael's Discord Bot\n\nCommands:\n-help - Display help\n-ping - Ping the bot\n-pingcount - Check number of pings in the current session\n-deck [HERO] [AUTHOR]").complete();
	}
	
	void ping(MessageReceivedEvent e){
		System.out.println("[Ping] Ping Received."); 
		e.getChannel().sendMessage(e.getAuthor().getAsMention() + " GET PINGED").complete();
		System.out.println("[Ping] Message Sent, Ping count updated.");
	}
	
	void pingcount(MessageReceivedEvent e, int pingcount){
		System.out.println("[Ping] Pingcount Recieved.");
		e.getChannel().sendMessage("Pings: " + pingcount).complete();
		System.out.println("[Ping] Message Sent.");
	}
	
	void adddeck(MessageReceivedEvent e, String[] args){
		String deckName = args[0] + args[1];
		deckName.toLowerCase();
		args[0].toLowerCase();
		
		System.out.print("[Deck] Add Deck method initialized.");
		String deck = "";
		deck += deckName + ":" + args[2];
		
		DeckWriter.addDeck(deck);
		System.out.println("[Deck] Deck Added.");
		
		e.getChannel().sendMessage(args[1] + "'s " + args[0].substring(0, 1).toUpperCase() + args[0].substring(1) + " deck added.");
		System.out.println("[Deck] Message sent.");
		//TODO: write to file
	}
	
	void getdeck(MessageReceivedEvent e, String[] args){
		String deckName = args[0] + args[1];
		args[0].toLowerCase();
		deckName = deckName.toLowerCase();
		
		System.out.println("[Deck] Get Deck method initialized.");
		
		String out = "";
		
		out = FileReader.getDeck(deckName);
		
		if(out.equals("DNF")){
			System.out.println("[Deck] Deck not found or improper syntax.");
			e.getChannel().sendMessage("Deck not found or improper syntax.\nCommand usage: -deck [HERO] [AUTHOR]").complete();
			return;
		}
		if(out.equals("FNF")){
			System.out.println("[Deck] ERROR: Text file not found!");
			e.getChannel().sendMessage("Deck list not found.").complete();
			return;
		}
		
		/*
		switch(deckName){
		default: e.getChannel().sendMessage("Deck not found or improper syntax.\nCommand usage: -deck [HERO] [AUTHOR]").complete();
		System.out.println("[Deck] Deck not found/improper syntax");
		return;
		//TODO: PUT DECKS INTO A TXT FILE
		case "gideonzharry":
			out = "https://www.epicgames.com/paragon/deckbuilder/en-US/decks/zharry/74545183-b421-4359-a616-f11426ebf086";
			break;
			
		case "gideonicecappuccino":
			out = "https://www.epicgames.com/paragon/deckbuilder/en-US/decks/Icecappuccino/937dd0de-5bf6-4a87-b001-4b2cf8f0bb06";
			break;
		
		case "revenanticecappuccino":
			out = "https://www.epicgames.com/paragon/deckbuilder/en-US/decks/Icecappuccino/4cc2653f-40c3-4713-bb84-88219924ffc7";
			break;
			
		case "sevarogicecappuccino":
			out = "https://www.epicgames.com/paragon/deckbuilder/en-US/decks/Icecappuccino/0c2be498-a267-4c07-983e-bbe515ff933f";
			break;
			
		case "riktorepy22135":
			out = "https://www.epicgames.com/paragon/deckbuilder/en-US/decks/Epy22135/99659ab2-6b1d-4160-ad48-66580e215a05";
			break;
			
		case "yinepy22135":
			out = "https://www.epicgames.com/paragon/deckbuilder/en-US/decks/Epy22135/b858bd20-8b65-4585-b68a-a3c65a2e3821";
			break;
			
		}
		
		*/
		System.out.println("[Deck] Deck found.");
		e.getChannel().sendMessage(args[1] + "'s " + args[0].substring(0, 1).toUpperCase() + args[0].substring(1) + " deck:\n" + out).complete();
		System.out.println("[Deck] Deck sent.");
	}
}
