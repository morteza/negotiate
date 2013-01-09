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
import models.StoryItem;

import controllers.CRUD.For;

@For(StoryItem.class)
public class StoryItems extends CRUD {

}