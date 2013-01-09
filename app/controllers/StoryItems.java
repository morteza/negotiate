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
import models.UserRole;

import controllers.CRUD.For;

@Check(UserRole.ADMINISTRATOR)
@With(Secure.class)
@For(StoryItem.class)
public class StoryItems extends CRUD {

}