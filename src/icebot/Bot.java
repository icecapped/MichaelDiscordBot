package icebot;

import javax.security.auth.login.*;

import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Bot {

	public static JDA jda;
	
	public static final String BOT_TOKEN = "MzEyNDA2MTYyMzQ5ODgzMzkz.C_amxQ.RslY0c9MfaDHspPC1nfY-CvJkNo";
	 
	public static void main(String[] args){
		System.out.println("Welcome!"); //harry added this
		
		jda.getPresence().setGame(Game.of("Paragon"));
		System.out.println("[JDA] Game updated.");
		try{ //initialization
		jda = new JDABuilder(AccountType.BOT).addEventListener(new BotListener()).setToken(BOT_TOKEN).buildAsync();
		}
		catch(LoginException | IllegalArgumentException | RateLimitedException e){
			e.printStackTrace();
		}
	}
}
