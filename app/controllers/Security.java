/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package controllers;

import models.User;
import models.UserRole;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        User user = User.find("byUserId", username).first();
        return (user != null);
    }
    
    static boolean check(UserRole profile) {
        User user = User.find("byUserId", connected()).first();
        if (user!=null && user.role.is(profile))
        	return true;
        return false;
    }
}