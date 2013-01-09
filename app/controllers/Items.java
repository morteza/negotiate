/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.Item;

import controllers.CRUD.For;

@For(Item.class)
public class Items extends CRUD {

	/**
	 * Renders binary image of the selected item's icon
	 * @param id
	 */
	public static void icon(Long id) {
		Item item = Item.findById(id);
		notFoundIfNull(item);
		
		renderBinary(item.icon.getFile());
	}
}