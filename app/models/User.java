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

import controllers.CRUD.Hidden;

import java.util.*;

@Entity
public class User extends Model {

	public String fullname;
	public String email;

	@Required
	public String userId;
		
	@Password
	public String password;
	
	@Required
	public UserRole role = UserRole.REGISTERED;
	
	public String toString() {
		return "" + userId;
	}
	
}
