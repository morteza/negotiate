/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package models;

import play.*;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends Model {

	public String fullname;

	@Required
	public String email;
	
	@Required
	@Password
	public String password;
	
	public String toString() {
		return "" + email;
	}
	
}
