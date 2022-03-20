package my.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import my.model.*;

public class BookingsDB {

    private static Connection connection;
    
    public void connect() throws ClassNotFoundException, SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/mybookingappoint";
        String dbUser = "root";
        String dbPassword = "root1234";
 
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        
        System.out.println("#done connect()");
        
    }
    
    
    public List<Booking> getAll() throws SQLException, ClassNotFoundException {
    	 
		String sql = "SELECT * FROM BOOKINGS WHERE DATE(CREATED_DATE)  = '" + LocalDate.now() + "'" +
				            " ORDER BY APPOINTMENTID";
		 
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		Booking booking = null;
		ArrayList<Booking> list = new ArrayList<Booking>();
		
		while (result.next()) {
			booking = new Booking();
			
			booking.setId(result.getInt("id"));
			booking.setName(result.getString("name"));
			booking.setNric(result.getString("nric"));
			booking.setDob(result.getDate("dob").toString()); 
			booking.setAppointmentid(result.getInt("appointmentid")); 
			 
			list.add(booking);
		}
		
		connection.close();
		
		return list;
    }
    
    public int getmax() throws SQLException, ClassNotFoundException {
   	    
    	int max = 0;
		String sql = "SELECT MAX(APPOINTMENTID) FROM BOOKINGS WHERE DATE(CREATED_DATE)  = '" + LocalDate.now() + "'";
		 
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql); 
	   
		if (result.next()) {
		    max = result.getInt(1);
		} 
		 
		return max;
    }
    
 
    public int save(Booking booking) throws SQLException, ClassNotFoundException {
    	
    	int appointmentid = getmax(); 
    	appointmentid = appointmentid + 1;
		if (appointmentid == 0)
		{
			appointmentid = 1; 
		} 
		 
	    System.out.println(booking.getDob());
		 
        String sql = "INSERT INTO BOOKINGS (NAME, NRIC, DOB, APPOINTMENTID) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, booking.getName());
        statement.setString(2, booking.getNric());
        statement.setString(3, booking.getDob());
        statement.setInt(4, appointmentid);
        
        int result = statement.executeUpdate();
        
        connection.close();
        
        return result;
    }

}
