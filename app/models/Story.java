/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package models;

import play.*;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

/**
 * Represents story
 * @author morteza
 *
 */
@Entity
public class Story extends Model {
	
	@Required
	public String title;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="story")
    public List<StoryItem> items = new ArrayList<StoryItem>();
	
	@MaxSize(value=1024*1024)
	@Lob
	@Column(columnDefinition="TEXT")
	public String introduction;
	
	public String toString() {
		return title;
	}
}
