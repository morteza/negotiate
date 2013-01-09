/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.User;

import controllers.CRUD.For;

@For(User.class)
public class Users extends CRUD {

}