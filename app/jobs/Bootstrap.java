/**
 * @author Morteza Ansarinia <ansarinia@me.com>
 * @date Jan 9, 2013
 * 
 */

package jobs;

import java.util.Date;

import models.User;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Crypto;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() {
    	System.out.println("Starting Negotiate...");
    	
    	//User.deleteAll();
    	
		if(User.count() == 0) {
			Fixtures.loadModels("data.yml");
    	}

    }
}