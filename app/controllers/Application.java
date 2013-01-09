/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

@Check(UserRole.REGISTERED)
@With(Secure.class)
public class Application extends Controller {

	@Before
	public static void authenticate() throws Throwable {
        if(Security.isConnected()) {
        	User user = User.find("byUserId",Security.connected()).first();
        	if (user==null)
        		user = User.find("byMTurkId", Security.connected()).first();
        	renderArgs.put("user", user);
        }
	}	

    public static void index() {
        render();
    }

    public static void board() {
    	render();
    }
    
    public static void enter(@Required String negotiation) {

    	User user = (User) renderArgs.get("user");
    	
    	validation.valid(user);
    	
    	if(validation.hasErrors()) {
            flash.error("Invalid negotiation. Please choose a negotiation.");
            index();
        }
            	
    	//TODO find negotiation
        // Dispatch to the demonstration        
        if(negotiation.equals("negotiation1")) {
            Negotiations.join();
        }
    }

}