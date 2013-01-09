/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package controllers;

import play.*;
import play.mvc.*;

import java.io.File;
import java.util.*;

import controllers.CRUD.For;

import models.*;

@Check(UserRole.REGISTERED)
//@For(Negotiation.class)
public class Negotiations extends CRUD {

	@Before
	public static void authenticate() {
        if(Security.isConnected()) {
            	User user = User.find("byUserId",Security.connected()).first();
                renderArgs.put("user", user);
        }
	}
	
    public static void join() {
    	User user = (User) renderArgs.get("user");
        if (Negotiation.get().join(user)!=null)
        	room();
        flash.error("You are already negotiating!");
        flash.keep();
        Application.index();
    }
    
    public static void room() {
    	User user = (User) renderArgs.get("user");
    	
    	Story sample = Story.all().first();
    	
    	List<String> items = new ArrayList<String>();
    	
    	if (sample!=null) {
    		for (StoryItem item: sample.items) {
    			for (int i=0;i<item.count;i++)
    				items.add(""+item.item.id);
    		}
    	    	
    		List events = Negotiation.get().archive();
    		render(user, events, items);
    	}
    	flash.error("No story is available for this negotiaion!");
    	flash.keep();
    	Application.index();
    }
    
    public static void say(String message) {
    	User user = (User) renderArgs.get("user");
        Negotiation.get().say(user, message);
        room();
    }
    
    public static void leave(User user) {
        Negotiation.get().leave(user);
        Application.index();
    }
    
}

