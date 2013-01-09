/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package controllers;

import play.*;
import play.mvc.With;

import models.Story;
import models.UserRole;

import controllers.CRUD.For;

import java.util.*;

/**
 * Represents story
 *
 */
@Check(UserRole.ADMINISTRATOR)
@With(Secure.class)
@For(Story.class)
public class Stories extends CRUD {
    
}
