/**
 * @author Arman Radmanesh <radmanesh@gmail.com>
 * @since Oct 9, 2012
 * @version 0.1.0-prototype
 */

package models;

public enum UserRole {
	UNKNOWN(null),
		ANONYMOUS(UNKNOWN),
		REGISTERED(UNKNOWN),
			SUBSCRIBER(REGISTERED),
			AGENT(REGISTERED),
				PUBLISHER(AGENT),
			ADMINISTRATOR(REGISTERED),
				SUPERUSER(ADMINISTRATOR);
	
	private UserRole parent = null;
	private UserRole(UserRole parent) {
		this.parent = parent;
	}

	public boolean is(String strRole) {
	    if (strRole==null)
	        return false;
	    
	    return is(valueOf(strRole.toUpperCase()));
	}
	
	public boolean is(UserRole other) {
	    if (other==null) {
	        return false;
	    }
	   
	    for (UserRole r=this; r!=null; r=r.parent) {
	        if (other == r)
	        	return true;
	    }

	    return false;
	}
	
}
