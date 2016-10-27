package guitardb.bbdev.org;

import java.sql.*;
import java.util.*;

public class Guitar extends Instrument {

	String type = "";
	String model = "";
	String currentGauge = "";
	String changeDate = "";
	String nickName ="";
	
	static String[] types = {"Electric","Acoustic","Hollow","SemiHollow"};
	
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
		sql += ",serial=\"" + this.serial +"\"";
		if (!this.changeDate.isEmpty()) sql += ",changeDate=\"" + this.changeDate +"\"";
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
		PreparedStatement save = null;
		String sql = "UPDATE Guitars SET " ;
		sql += "type=\"" + this.type + "\"";
		sql += ",model=\"" + this.model +"\"";
		sql += ",brand=\"" + this.brand +"\"";
		sql += ",gauge=\"" + this.currentGauge +"\"";
		sql += ",nickName=\"" + this.nickName +"\"";
		sql += ",serial=\"" + this.serial +"\"";
		if (!this.changeDate.isEmpty()) sql += ",changeDate=\"" + this.changeDate +"\"";
		sql += ",year=" + this.year;
		sql += ",pricePaid=" + this.pricePaid;
		sql += " WHERE idGuitars=" + this.id;
		System.out.println(sql);
		try {
			save = conn.prepareStatement(sql);
			save.executeUpdate();
		} catch (SQLException sqe){ 
			System.out.println(sql);
			System.out.println(sqe.getMessage());
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		PreparedStatement destroy = null;
		String sql = "DELETE FROM Guitars where idGuitars=" + this.id;
		System.out.println(sql);
		try {
			destroy = conn.prepareStatement(sql);
			destroy.executeUpdate();
		} catch (SQLException sqe){ 
			System.out.println(sql);
			System.out.println(sqe.getMessage());
		}
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
				buff.type = rs.getString("type");
				buff.changeDate = rs.getString("changeDate");
				buff.currentGauge = rs.getString("gauge");
				buff.nickName = rs.getString("nickName");
				buff.pricePaid = rs.getInt("pricePaid");
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

	public static Guitars find(String key, String value) {
		// TODO Auto-generated method stub
		Statement all = null;
		String sql = "SELECT * from Guitars WHERE " + key + " LIKE \"%" + value + "%\"";
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
				buff.changeDate = rs.getString("changeDate");
				buff.currentGauge = rs.getString("gauge");
				buff.nickName = rs.getString("nickName");
				buff.pricePaid = rs.getInt("pricePaid");
				retBuff.add(buff);
			}
		}
		catch (SQLException sqe) {
			System.out.println(sql);
			System.out.println(sqe.getMessage());
		}
		return retBuff;
	}
	
	
}
