package com.controllers;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.JobDao;
import com.dao.UserDao;
import com.model.BlogPost;
import com.model.Email;
import com.model.Error;
import com.model.Job;
import com.model.PROJ2_USER;


@RestController
public class JobController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
private JobDao jobDao;
	
	@Autowired
	private Email email;
	
	@Autowired
	private UserDao userDao;
	
    @RequestMapping(value="/postJob",method=RequestMethod.POST)
	public ResponseEntity<?> postJob(@RequestBody Job job,HttpSession session){// we r using httpsession object for authentication
		PROJ2_USER user=(PROJ2_USER)session.getAttribute("user");
		// this method returns a object user
		
		if(user==null){// user is null when user tries to execute this method without login 
			System.out.println("hello");
			Error error=new Error(1,"Unauthorized user.. login using valid credentials");
			System.out.println("hello1");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);//401
			// it returns response object with data{it contains an error object} and status401
			// in frontend we can get error msg by response.data.message
		}
		else{
			System.out.println("hello2");
			logger.debug(user.getUsername());//NullPointerException is user is null
			System.out.println(" Role of User " + user.getRole());
	                job.setPostedOn(new Date());
	    			System.out.println("hello3");
	    			job.setCreatedBy(user);

					jobDao.postJob(job);
					System.out.println("hello4");
			    	try {
			       		email.send(user, "hello "+user.getUsername()+", You posted a job", "Welcome to Yashashree's website - Webminar! You posted a job "+job.getJobTitle()+" Thank you.");
			       	} catch (MessagingException e) {
			         	  System.out.println("jobController exception in edit job");

			       		e.printStackTrace();
			       	}
				return new ResponseEntity<Void>(HttpStatus.OK);
			
	}
	// backend will return response object =[data + status code]
		// for success ==> [void,200] {and from jobcontroller.js return to home.html}
		// for failure ==> [error,401] {and from jobcontroller.js return to login.html} -- for unauthorized 
		//            else [void,500] {and from jobcontroller.js return to same postJob.html}--for server side error/other exceptions
}
    @RequestMapping(value="/getAllJobs",method=RequestMethod.GET)
    public ResponseEntity<?> getAllJobs(HttpSession session){
    	PROJ2_USER user=(PROJ2_USER)session.getAttribute("user");
    	if(user==null){
    		System.out.println("USER is null");
    		Error error=new Error(1,"Unauthorized user.. login using valid credentials");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);//401
    	}
    	System.out.println("USER OBJECT " + user.getRole());
    	List<Job> jobs=jobDao.getAllJobs();
    	return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);    	
    	//response 
    }
    
    
    
  //http://localhost:8080/appname/job/1   , PUT  -> DispatcherServlet ->
    // handler -> find a method in controller which handle the request
    @RequestMapping(value="/job/{id}",method=RequestMethod.PUT)
    public ResponseEntity<?> updateJob(
    		@PathVariable int id,@RequestBody Job job,HttpSession session) {
   		PROJ2_USER user=(PROJ2_USER)session.getAttribute("user");
    	//person -> from client
    	//updatedPerson -> from database 
   	 Job updatedJob=jobDao.updateJob(id,job);
    	if(job==null)
    		return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);

    	try {
   		email.send(user, "hello "+user.getUsername()+", You edit a job", "Welcome to Yashashree's website - Webminar! The job "+job.getJobTitle()+" you posted is edited successfully.");
   	} catch (MessagingException e) {
     	  System.out.println("jobController exception in edit job");

   		e.printStackTrace();
   	}
    	return new ResponseEntity<Job>(updatedJob,HttpStatus.OK);
    	
    }

    @RequestMapping(value="/job/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteJob(@PathVariable("id") int id,HttpSession session) {
   		PROJ2_USER user=(PROJ2_USER)session.getAttribute("user");
    	System.out.println("Delete function at blog controller1");
    	Job job = jobDao.getJob(id);
    			if(job==null)
    			{
    				System.out.println("Delete function at blog controller2");
    				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    			}
    			System.out.println("Delete function at blog controller3");
    			jobDao.deleteJob(id);
    			try {
   				email.send(user, "hello "+user.getUsername()+", the job you posted is deleted", "Welcome to Yashashree's website - Webminar! The job "+job.getJobTitle()+" you posted is deleted successfully.");
   			} catch (MessagingException e) {
   			  	  System.out.println("blogController exception in delete blog");
   				e.printStackTrace();
   			}

    			return new ResponseEntity<Void>(HttpStatus.OK);
    		}

}