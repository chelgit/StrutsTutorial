package my.model;

import com.opensymphony.xwork2.ActionSupport;

public class Booking  extends ActionSupport{

	int id;
    String name;
    String nric;
    String dob;
    int appointmentid;

	public Booking() {
		super();	
	}
	
	public Booking(int id, String name, String nric, String dob, int appointmentid) {
		super();
		this.id = id;
		this.name = name;
		this.nric = nric;
		this.dob = dob;
		this.appointmentid = appointmentid; 
	} 
	   
	public int getAppointmentid() {
		return appointmentid;
	}
	
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getNric() {
		return nric;
	}
	public void setNric(String nric) {
		this.nric = nric;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Booking [appointmentid=" + appointmentid + ", name=" + name + ", nric=" + nric + ", dob=" + dob + "]";
	} 
 
	
}
