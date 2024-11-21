package com.cognizant.racegarden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSchema {

//	private int room_id;
//	private String room_type;
//	private boolean wifi;
//	private boolean tv;
//	private boolean laundry;
//	private double price;
//	private int capacity;
	
	private static final String CUS_QUERY = "CREATE TABLE IF NOT EXISTS customer(id int,fname text,lname text,age int,companyname text,email text,phno bigint);";
	private static final String ROOM_QUERY = "CREATE TABLE IF NOT EXISTS  room(room_id int PRIMARY KEY,room_type text,wifi boolean,tv boolean,laundry boolean,price decimal(6,2),capacity int,bookedstatus boolean)";
	private static final String GET_CUS = "SELECT * FROM CUSTOMER";
	private static final String ROOM_INSERT_QUERY = "INSERT INTO ROOM VALUES(?,?,?,?,?,?,?,?)";
	private static final String CUS_INSERT_QUERY = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?)";
	private static final String REG_CREATE= "CREATE TABLE IF NOT EXISTS Registration(room_id int,cusid int,checkindate date,checkoutdate date,duration int,price decimal(6,2));";
	public static void createSchema() throws SQLException{
		
		Connection con = DbConnection.getConnection();
		
		
		Statement st = con.createStatement();
		
		st.execute(CUS_QUERY);
		st.execute(ROOM_QUERY);
		st.execute(REG_CREATE);
		
		
		st.close();
		
		con.close();
		
		
		
	}
	
	
	public static void loadRoomDetails(List<Room> roomsList) throws SQLException {
		Connection con = DbConnection.getConnection();

		PreparedStatement ps = con.prepareStatement(ROOM_INSERT_QUERY);
		
		for(Room room: roomsList) {
			
			ps.setInt(1,room.getRoom_id());
			ps.setString(2,room.getRoom_type());
			ps.setBoolean(3, room.isWifi());
			ps.setBoolean(4, room.isTv());
			ps.setBoolean(5, room.isLaundry());
			ps.setDouble(6,room.getPrice());
			ps.setInt(7,room.getCapacity());
			ps.setBoolean(8, room.isBookedStatus());
			
			try {
				ps.execute();
			} catch(SQLIntegrityConstraintViolationException e) {
				
			}
			
			
			
		}
		
		ps.close();
	}
	
	
	public static List<Customer>  getAllCustomers() throws SQLException {
		Connection con = DbConnection.getConnection();
		
		Statement st = con.createStatement();

		
		ResultSet rs = st.executeQuery(GET_CUS);
		List<Customer> cusList = new ArrayList<>();
		
		while(rs.next()) {
			Customer c = new Customer();
			
			c.setId(rs.getInt("id"));
			c.setFirstName(rs.getString("fname"));
			c.setLastName(rs.getString("lname"));
			c.setAge(rs.getInt("age"));
			c.setCompanyName(rs.getString("companyname"));
			c.setEmail(rs.getString("email"));
			c.setPhno(rs.getLong("phno"));
			
			cusList.add(c);
		}
		
		
		return cusList;
	}
	
	public static boolean saveCustomer(Customer cus) throws SQLException {
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps = con.prepareStatement(CUS_INSERT_QUERY);
		
		ps.setInt(1, cus.getId());
		ps.setString(2,cus.getFirstName());
		ps.setString(3,cus.getLastName());
		ps.setInt(4,cus.getAge());
		ps.setString(5, cus.getCompanyName());
		ps.setString(6,cus.getEmail());
		ps.setLong(7, cus.getPhno());
		
		int row = ps.executeUpdate();
		
		ps.close();
		con.close();
		if(row == 1) {
			return true;
		} else {
			return false;
		}
		
	
		
	}


	public static boolean updateEmail(int id, String email) throws SQLException {

		Connection con = DbConnection.getConnection();
		
		PreparedStatement stm = con.prepareStatement("UPDATE CUSTOMER SET email=? WHERE id=?;");
		
		stm.setInt(2, id);
		stm.setString(1, email);
		
		int row = stm.executeUpdate();
		
		stm.close();
		con.close();
		
		if(row == 1) {
			return true;
		} else {
			return false;
		}
		
		
		
		
		
	}
	
	
}
