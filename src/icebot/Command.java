package icebot;

import net.dv8tion.jda.core.events.message.*;

public class Command {
	
	void help(MessageReceivedEvent e){
		e.getChannel().sendMessage("Michael's Discord Bot\n\n"
				+ "Bot Commands:\n"
				+ "-help - Displays help\n"
				+ "-ping - Ping the bot\n"
				+ "-pingcount - Check number of pings in the current session\n"
				+ "\n"
				+ "Paragon Bot Commands:\n"
				+ "-deck [HERO] [AUTHOR] [optional DECK NAME]- Searches for a deck.\n"
				+ "-adddeck [HERO] [AUTHOR] [URL] [optional DECK NAME]- Adds a deck to the decklist."
				).complete();
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
		if(args.length == 4) deckName += args[3];
		System.out.println("[Deck] " + args.length + " arguments.");
		deckName = deckName.toLowerCase();
		args[0].toLowerCase();
		
		System.out.print("[Deck] Add Deck method initialized.");
		String deck = "";
		deck += deckName + ":" + args[2];
		
		String s = DeckWriter.addDeck(deck);
		System.out.println("[Deck] Deck Proccessed.");
		
		if(s.equals("VLD")){
			if(args.length != 4) e.getChannel().sendMessage(args[1] + "'s " + args[0].substring(0, 1).toUpperCase() + args[0].substring(1) + " deck added.").complete();
			else e.getChannel().sendMessage(args[1] + "'s " + args[0].substring(0, 1).toUpperCase() + args[0].substring(1) + " deck added.").complete();
		}
		else if(s.equals("FNF")){
			e.getChannel().sendMessage("Decklist not found.").complete();
		}
		else if(s.equals("IOE")){
			e.getChannel().sendMessage("IO Exception! Contact Michael/Harry.").complete();
		}
		System.out.println("[Deck] Message sent.");
		
	}
	
	void getdeck(MessageReceivedEvent e, String[] args){
		String deckName = args[0] + args[1];
		if(args.length == 3) deckName = deckName + args[2];
		System.out.println("[Deck] " + args.length + " arguments.");
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
		System.out.println("[Deck] Deck found.");
		
		if(args.length != 3){
			e.getChannel().sendMessage(args[1] + "'s " + args[0].substring(0, 1).toUpperCase() + args[0].substring(1) + " deck:\n" + out).complete();
		}
		else{ //TODO: test this
			e.getChannel().sendMessage(args[1] + "'s " + args[2] + " " + args[0].substring(0, 1).toUpperCase() + args[0].substring(1) + " deck:\n" + out).complete();
		}
		System.out.println("[Deck] Deck sent.");
	}
}
