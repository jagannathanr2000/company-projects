package com.cognizant.racegarden;

public class Room {

	private int room_id;
	private String room_type;
	private boolean wifi;
	private boolean tv;
	private boolean laundry;
	private double price;
	private int capacity;
	private boolean bookedStatus;
	
	public Room() {	}

	public Room(int room_id, String room_type, boolean wifi, boolean tv, boolean laundry, double price, int capacity,boolean bookedStatus) {
		super();
		this.room_id = room_id;
		this.room_type = room_type;
		this.wifi = wifi;
		this.tv = tv;
		this.laundry = laundry;
		this.price = price;
		this.capacity = capacity;
		this.setBookedStatus(bookedStatus);
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isLaundry() {
		return laundry;
	}

	public void setLaundry(boolean laundry) {
		this.laundry = laundry;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isBookedStatus() {
		return bookedStatus;
	}

	public void setBookedStatus(boolean bookedStatus) {
		this.bookedStatus = bookedStatus;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_type=" + room_type + ", wifi=" + wifi + ", tv=" + tv + ", laundry="
				+ laundry + ", price=" + price + ", capacity=" + capacity + ", bookedStatus=" + bookedStatus + "]";
	}


	
	
	
	
	
	
	
}
