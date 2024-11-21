package com.cognizant.racegarden;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GuestBooking extends Booking{

	@Override
	public boolean bookRoom(Registration reg) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DbConnection.getConnection();
		
		String query = "INSERT INTO REGISTRATION VALUES(?,?,?,?,?,?);";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setInt(1, reg.getRoomid());
		ps.setInt(2, reg.getCusid());
		ps.setDate(3, Date.valueOf(reg.getCheckindate()));
		ps.setDate(4, Date.valueOf(reg.getCheckoutdate()));
		ps.setInt(5, reg.getDuration());
		ps.setDouble(6, reg.getTotalprice());

		
		int row = ps.executeUpdate();
		
		PreparedStatement stm = con.prepareStatement("update room set bookedstatus=? where room_id=?;");
		stm.setBoolean(1, true);
		stm.setInt(2, reg.getRoomid());
		
		int row1 = stm.executeUpdate();
		ps.close();
		stm.close();
		
		if(row == 1 && row1 == 1) {
			return true;
		} else {
			return false;
		}
		
		
		
	}

	@Override
	public List<Room> getAppointments(int cusid, String type, boolean wifi, boolean tv, boolean laundry, int capacity,
			int duration) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = DbConnection.getConnection();
		String query = "SELECT * FROM ROOM WHERE room_type=? AND wifi=? AND TV=? AND laundry=? AND capacity >= ? AND bookedstatus=?;";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, type);
		ps.setBoolean(2,wifi );
		ps.setBoolean(3,tv );
		ps.setBoolean(4,laundry );
		ps.setInt(5, capacity);
		ps.setBoolean(6, false);
		
		ResultSet rs = ps.executeQuery();
		List<Room> rooms = new ArrayList<>();
		while(rs.next()) {
			Room r = new Room();
			
			r.setRoom_id(rs.getInt("room_id"));
			r.setRoom_type(rs.getString("room_type"));
			r.setWifi(rs.getBoolean("wifi"));
			r.setTv(rs.getBoolean("tv"));
			r.setLaundry(rs.getBoolean("laundry"));
			
			r.setCapacity(rs.getInt("capacity"));
			r.setBookedStatus(rs.getBoolean("bookedstatus"));
			r.setPrice(rs.getDouble("price"));
			rooms.add(r);
			
		}
		
		return rooms;
		
	}

	@Override
	public List<String> getStatus() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DbConnection.getConnection();
		String query = "SELECT * FROM room r inner join registration reg using(room_id);";
		PreparedStatement ps = con.prepareStatement(query);
		List<String> status = new ArrayList<>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			boolean wifi = rs.getBoolean("wifi");
			boolean tv = rs.getBoolean("tv");
			boolean laundry = rs.getBoolean("laundry");
			String bookedstatus = rs.getBoolean("bookedstatus") ? "NOT-VACCANT": "VACCANT";
			String aminities = ""+ (wifi ? "WIFI" : "")+(tv ? " TV ":"")+(laundry ? " LAUNDRY " : "");
			
			String msg = rs.getString("room_id")+" ("+rs.getString("room_type")+")"+"( "+aminities+" )"+" "+bookedstatus;
		
			status.add(msg);
		}
		return status;
	}

	@Override
	public List<Registration> getAllBookings(LocalDate from, LocalDate to) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = DbConnection.getConnection();
		String query = "SELECT * FROM REGISTRATION WHERE checkindate BETWEEN ? AND ?;";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setDate(1,Date.valueOf(from));
		ps.setDate(2,Date.valueOf(to));
		
		ResultSet rs = ps.executeQuery();
		List<Registration> regs = new ArrayList<>();
		while(rs.next()) {
			
			Registration r = new Registration();
			r.setRoomid(rs.getInt("room_id"));
			r.setCusid(rs.getInt("cusid"));
			r.setCheckindate(LocalDate.parse(rs.getDate("checkindate").toString()));
			r.setCheckoutdate(LocalDate.parse(rs.getDate("checkoutdate").toString()));
			r.setDuration(rs.getInt("duration"));
			r.setTotalprice(rs.getDouble("price"));
			
			regs.add(r);
		}
		return regs;
	}

}
