package icebot;

import javax.security.auth.login.*;

import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Bot {
	
	public static JDA jda;
	
	public static String BOT_TOKEN = "";
	public static final String GAME = "Paragon | -help";
	
	public static void main(String[] args){
		System.out.println("Welcome!"); //harry added this
		
		BOT_TOKEN = args[0];
		try{ //initialization
		jda = new JDABuilder(AccountType.BOT).addEventListener(new BotListener()).setToken(BOT_TOKEN).buildAsync();
		}
		catch(LoginException | IllegalArgumentException e){
			e.printStackTrace();
		}
		jda.getPresence().setGame(Game.of(GameType.WATCHING, GAME));
		System.out.println("[JDA] Game updated.");
	}
}
