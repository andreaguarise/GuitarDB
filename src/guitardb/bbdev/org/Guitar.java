package guitardb.bbdev.org;

import java.sql.*;
import java.util.*;

public class Guitar extends Instrument {

	String type;
	String model;
	String currentGauge;
	String changeDate;
	String nickName;
	
	public Guitar(){};
	
	public Guitar(String brand, Integer year, String serial, String model) {
		super(brand, year, serial);
		this.model = model;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save() {
		PreparedStatement save = null;
		String sql = "INSERT INTO Guitars SET " ;
		sql += "type=\"" + this.type + "\"";
		sql += ",model=\"" + this.model +"\"";
		sql += ",brand=\"" + this.brand +"\"";
		sql += ",gauge=\"" + this.currentGauge +"\"";
		sql += ",nickName=\"" + this.nickName +"\"";
		sql += ",year=" + this.year;
		System.out.println(sql);
		try {
			save = conn.prepareStatement(sql);
			save.executeUpdate();
		} catch (SQLException sqe){ 
			System.out.println(sql);
			System.out.println(sqe.getMessage());
		}
		
	}
	
	public void load() {
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public static Guitars all() {
		// TODO Auto-generated method stub
		Statement all = null;
		String sql = "SELECT * from Guitars";
		ResultSet rs = null;
		Guitars retBuff = null;
		try {
			all = conn.createStatement();
			rs = all.executeQuery(sql);
		
			retBuff = new Guitars();
			while ( rs.next() )
			{
				Guitar buff = new Guitar(rs.getString("brand"), 
					rs.getInt("year"),
					rs.getString("serial"), 
					rs.getString("model"));
				buff.id = rs.getInt("idGuitars");
				retBuff.add(buff);
			}
		}
		catch (SQLException sqe) {
			System.out.println(sql);
			System.out.println(sqe.getMessage());
		}
		return retBuff;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object find(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
