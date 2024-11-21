package com.cognizant.racegarden;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public abstract class Booking {
	public abstract List<Room> getAppointments(int cusid,String type,boolean wifi,boolean tv,boolean laundry,int capacity,int duration) throws SQLException;
	public abstract boolean bookRoom(Registration reg) throws SQLException;
	public abstract List<String> getStatus() throws SQLException;
	public abstract List<Registration> getAllBookings(LocalDate from,LocalDate to) throws SQLException;
}
