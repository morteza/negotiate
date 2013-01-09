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

}