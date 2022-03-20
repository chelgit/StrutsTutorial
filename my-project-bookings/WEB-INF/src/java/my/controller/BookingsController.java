package my.controller;


import java.sql.SQLException;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;
 
import my.db.BookingsDB;
import my.model.Booking;


@Results({
    @Result(name="success", type="redirectAction", params = {"actionName" , "bookings"}) 
}) 
public class BookingsController extends ValidationAwareSupport implements ModelDriven<Object>, Validateable	{ 

	private static final Logger log = LogManager.getLogger(BookingsController.class);
    private Collection<Booking> list;
    BookingsDB bookingsDB = new BookingsDB();
    Booking model = new Booking();
        
    // rest service for listing all bookings
	// GET /bookings 
    public HttpHeaders index() {
    	
        try {
        	bookingsDB.connect();
			list = bookingsDB.getAll();  
			
		} catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		} 
        
        return new DefaultHttpHeaders("index")
            .disableCaching();
    }
    
    // 	rest service to prompt for our view page for the creation of new bookings.
    // GET /bookings/new
    public String editNew() {
        model = new Booking();
        return "editNew";
    }
    
    // rest service for creating a booking
    // POST /bookings
    public HttpHeaders create() {
        log.debug("Creates an new booking {}", model);
        
        try {
        	bookingsDB.connect();
			bookingsDB.save(model);
			 
		} catch (ClassNotFoundException | SQLException e) {  
			  e.printStackTrace();    
		}
        addActionMessage("New booking appointment created successfully");
        
        return new DefaultHttpHeaders("success")
            .setLocationId(model.getId());
    }
    
    // needed these implemented methods from the parent class
	@Override
	public void validate() {
		  System.out.println("hellp");
        if (model.getName() == null || model.getName().length() ==0) {
            addFieldError("name", "The name field is empty");
            
        }
        
        if (model.getNric() == null || model.getNric().length() ==0) {
            addFieldError("nric", "The NRIC field is empty");
        }
        
        if (model.getDob() == null || model.getDob().length() ==0) {
            addFieldError("dob", "The Birth Date field is empty");
        }
	}

	@Override
	public Object getModel() {
		return (list != null ? list : model);		
	}
    
}
