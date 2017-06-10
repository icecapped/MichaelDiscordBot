package icebot;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.*;
import net.dv8tion.jda.core.hooks.*;

public class BotListener extends ListenerAdapter{
	
	private int pingcount = 0;
	QueueContainer queue = new QueueContainer(); // defaults to 5
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e){
		Command command = new Command();
		String in = e.getMessage().getContent(); //text
		Message m = e.getMessage(); //message object
		
		if(!(in.charAt(0) == '-' || in.charAt(0) == '<')){ //Checking if it's a command
			return; 
		}
		in = in.substring(1, in.length());
		
		String[] args = new String[11];
		String cmd;
		
		if(in.contains(" ")){
			cmd = in.substring(0, in.indexOf(" "));
			in = in.substring(in.indexOf(" ") + 1);
			args = in.split("\\s+");
		}
		else{
			cmd = in;
		}
		cmd = cmd.toLowerCase();
		switch(cmd){
		default: e.getChannel().sendMessage("Invalid Command \"" + cmd + "\".").complete();
		System.out.println("[Command] Invalid Command: \"" + cmd + "\".");
		return;
		case "help":
			command.help(e);
			break;
		case "ping":
			command.ping(e);
			pingcount++;
			break;
		
		case "pingcount":
			command.pingcount(e, pingcount);
			break;
			
		case "deck":
			command.getdeck(e, args);
			break;
		
		case "add":
			command.adddeck(e, args);
			break;
		case "remove":
			command.removeDeck(e, args);
			break;
		case "j":
		case "join":
			command.queue(e, queue);
			break;
		case "party":
			command.callPlayers(e, queue);
			break;
		case "queue":
			command.listQueue(e, queue);
			break;
		case "leave":
			command.leaveQueue(e, queue);
			break;
		}
	}
	
}
