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

public class Application extends Controller {

	@Before
	public static void authenticate() {
		//TODO add security and put user in renderArgs with 'user' key
	}
	

    public static void index() {
        render();
    }

    public static void board() {
    	render();
    }
    
    public static void enter(@Required String negotiation) {

    	User user = (User) renderArgs.get("user");
    	
    	if(validation.hasErrors()) {
            flash.error("Please choose a nick name and the demonstration type…");
            index();
        }
        
    	//TODO find negotiation
        // Dispatch to the demonstration        
        if(negotiation.equals("negotiation1")) {
            Negotiations.index(user);
        }
    }

}