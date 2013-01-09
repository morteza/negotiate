/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package controllers;

import play.libs.Codec;
import models.User;
import models.UserRole;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String mTurkId) {
    	if (username!=null && username.trim().length()>0) {
    		User user = User.find("byUserId", username).first();
    		return (user != null);
    	} else if (mTurkId!=null && mTurkId.trim().length()>0) {
    		// System.out.println("mTurk Id: " + mTurkId);
    		User user = new User();
    		user.userId = "[" + Codec.UUID() + "]";
    		user.mTurkId = mTurkId;
    		user.role = UserRole.REGISTERED;
    		user.create();
    		return true;
    	}
    	return false;
    }
    
    static boolean check(UserRole profile) {
        User user = User.find("byUserId", connected()).first();
        if (user==null) {
        	
        	user = user.find("byMTurkId", connected()).first();
        }
        if (user!=null && user.role.is(profile))
        	return true;

        return false;
    }
}