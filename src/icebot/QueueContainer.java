package icebot;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.*;

public class QueueContainer {

	public String[] id;
	public User[] user;
	
	QueueContainer(){
		id = new String[5];
		user = new User[5];
	}
	QueueContainer(int i){
		id = new String[i];
		user = new User[i];
	}
	
}
