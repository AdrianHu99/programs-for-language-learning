package org.adrian.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.adrian.messenger.model.Message;
import org.adrian.messenger.model.Profile;

public class DatabaseClass {
	
	//maps that map the IDs to messages and profiles
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	
	//Notice that this setting is not thread safe, we assume that only one person will use this project
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
}
