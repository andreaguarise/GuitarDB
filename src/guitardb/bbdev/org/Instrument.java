package guitardb.bbdev.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Instrument implements Record {
	Integer id;
	String brand;
	Integer pricePaid;
	Integer year;
	String serial;
	
	public static Connection conn = null;
	
	
	public static void dbconnect() {
		try {	
			conn =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/Guitars?useSSL=false&" +
	                                   "user=root&password=ccSl1nky");
		} catch (SQLException ex) {
	    // handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public static void dbclose() {
		try { 
			conn.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public Instrument(String brand, Integer year, String serial) {
		this.brand = brand;
		this.serial = serial;
		this.year = year;
	}
	
	

	
	
}
