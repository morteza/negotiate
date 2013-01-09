/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package controllers;

import play.*;
import play.mvc.*;

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
        Negotiation.get().join(user);
        room();
    }
    
    public static void room() {
    	User user = (User) renderArgs.get("user");
    	List events = Negotiation.get().archive();
        render(user, events);
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

