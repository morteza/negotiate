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
 * Represents a key and its value
 *
 */
@Entity
public class StoryItem extends Model {
 
	@ManyToOne(cascade=CascadeType.ALL)
	public Story story;
	
	@OneToOne
	public Item key;
	
	@Required
	public Integer count;
	
	public String toString() {
		return key.toString() + " (" + count + ")";
	}
}
