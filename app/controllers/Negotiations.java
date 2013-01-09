package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import controllers.CRUD.For;

import models.*;

@For(Negotiation.class)
public class Negotiations extends CRUD {

	@Before
	public static void authenticate() {
		
	}
	
    public static void index(User user) {
        Negotiation.get().join(user);
        room(user);
    }
    
    public static void room(User user) {
        List events = Negotiation.get().archive();
        render(user, events);
    }
    
    public static void say(User user, String message) {
        Negotiation.get().say(user, message);
        room(user);
    }
    
    public static void leave(User user) {
        Negotiation.get().leave(user);
        Application.index();
    }
    
}

