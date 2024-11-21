package com.cognizant.racegarden;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaceGardenService {
	
	
	
	
	public static List<Room> roomsList = new ArrayList<>();
	
	static {
		
		roomsList.add(new Room(100,"AC",true,true,true,700.00,2,false));
		roomsList.add(new Room(101,"AC",true,true,false,650.00,2,false));
		roomsList.add(new Room(102,"NON-AC",true,true,true,500.00,3,false));
		roomsList.add(new Room(103,"NON-AC",true,true,true,400.00,1,false));
		roomsList.add(new Room(104,"AC",false,false,false,300.00,1,false));
		roomsList.add(new Room(105,"NON-AC",false,true,true,200.00,1,false));
	}

	public boolean addCustomer(Customer c) throws SQLException {
		return DatabaseSchema.saveCustomer(c);
		
	}
	
	public List<Customer> getAllCustomers() throws SQLException {
		List<Customer> cusList = DatabaseSchema.getAllCustomers();
		return cusList;
	}
	
	public void loadTables() throws SQLException {
		DatabaseSchema.createSchema();
	}
	
	public void loadRooms() throws SQLException {
		DatabaseSchema.loadRoomDetails(roomsList);
	}
	
	public boolean changeEmail(int id,String email) throws SQLException {
		return DatabaseSchema.updateEmail(id,email);
	}
 
}
