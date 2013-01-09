package models;

import java.util.*;

import javax.persistence.Entity;

import play.db.jpa.Model;
import play.libs.*;
import play.libs.F.*;

//@Entity
public class Negotiation /*extends Model*/ {
    
	public User userOne = null;
	public User userTwo = null;
	
    final ArchivedEventStream<Negotiation.Event> events = new ArchivedEventStream<Negotiation.Event>(100);
    
    /**
     * For WebSocket, when a user join the negotiation we return a continuous event stream
     * of ChatEvent
     */
    public EventStream<Negotiation.Event> join(User user) {
    	if(userOne == null) {
    		userOne = user;
            events.publish(new Join(user));
            return events.eventStream();    		
    	} else {
    		if(userTwo==null) {
        		userTwo = user;
                events.publish(new Join(user));
                return events.eventStream();    			
    		}
    	}
    	return null;
    }
    
    /**
     * A user leave the negotiation
     */
    public void leave(User user) {
        events.publish(new Leave(user));
    }
    
    /**
     * A user say something on the negotiation
     */
    public void say(User user, String text) {
        if(text == null || text.trim().equals("")) {
            return;
        }
        events.publish(new Message(user, text));
    }
    
    /**
     * For long polling, as we are sometimes disconnected, we need to pass 
     * the last event seen id, to be sure to not miss any message
     */
    public Promise<List<IndexedEvent<Negotiation.Event>>> nextMessages(long lastReceived) {
        return events.nextEvents(lastReceived);
    }
    
    /**
     * For active refresh, we need to retrieve the whole message archive at
     * each refresh
     */
    public List<Negotiation.Event> archive() {
        return events.archive();
    }
    
    // ~~~~~~~~~ negotiation events

    public static abstract class Event {
        
        final public String type;
        final public Long timestamp;
        
        public Event(String type) {
            this.type = type;
            this.timestamp = System.currentTimeMillis();
        }
        
    }
    
    public static class Join extends Event {
        
        final public User user;
        
        public Join(User user) {
            super("join");
            this.user = user;
        }
        
    }
    
    public static class Leave extends Event {
        
        final public User user;
        
        public Leave(User user) {
            super("leave");
            this.user = user;
        }
        
    }
    
    public static class Message extends Event {
        
        final public User user;
        final public String text;
        
        public Message(User user, String text) {
            super("message");
            this.user = user;
            this.text = text;
        }
        
    }
    
    public static class Proposal extends Event {
        
        final public User user;
        final public String text;
        
        public Proposal(User user, String text) {
            super("proposal");
            this.user = user;
            this.text = text;
        }
        
    }
    
    
    // ~~~~~~~~~ negotiation factory

    static Negotiation instance = null;
    public static Negotiation get() {
        if(instance == null) {
            instance = new Negotiation();
        }
        return instance;
    }
    
}

