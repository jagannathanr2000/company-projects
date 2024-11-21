package com.cognizant.racegarden;

import java.time.LocalDate;

public class Registration {

	private int cusid;
	private int roomid;
	private LocalDate checkindate;
	private LocalDate checkoutdate;
	private int duration;
	private double totalprice;
	
	public Registration() {}
	public Registration(int cusid, int roomid, LocalDate checkindate, LocalDate checkoutdate, int duration,
			double totalprice) {
		super();
		this.cusid = cusid;
		this.roomid = roomid;
		this.checkindate = checkindate;
		this.checkoutdate = checkoutdate;
		this.duration = duration;
		this.totalprice = totalprice;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public LocalDate getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(LocalDate checkindate) {
		this.checkindate = checkindate;
	}
	public LocalDate getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(LocalDate checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "Registration [cusid=" + cusid + ", roomid=" + roomid + ", checkindate=" + checkindate
				+ ", checkoutdate=" + checkoutdate + ", duration=" + duration + ", totalprice=" + totalprice + "]";
	}
	
	
	
	
}
