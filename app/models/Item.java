/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

/**
 * Represents item to negotiate
 *
 */
@Entity
public class Item extends Model {
 
	public Blob icon;
	
	@Required
	public String title;
	
	public String toString() {
		return title;
	}
}
