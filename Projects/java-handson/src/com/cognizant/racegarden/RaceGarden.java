package com.cognizant.racegarden;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RaceGarden {

	private static RaceGardenService service = new RaceGardenService();;
	

	
	public static void main(String[] args) throws SQLException, GlobalException {
		
		try {
			service.loadTables();
			service.loadRooms();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RaceGardenService service = new RaceGardenService();
		int option;
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("1.Register\n2.Book\n3.Check Status\n4.Email"+
					"\n5.All Bookings\n6.All Customers\n7.Quit\n");
			
			System.out.println("Choose the option");
			option = sc.nextInt();
			switch(option) {
			
			case 1: {
				System.out.println("Do you want to proceed with the option?Y/N");
				String choice = sc.next();
				
				if(choice.toLowerCase().equals("y")) {
					System.out.println("Give the details one by one: 1.ID 2.First Name 3.Last Name 4.Age 5.Company Name 6.Email 7.Contact Number");
					
					int id = sc.nextInt();
					
					String firstName = sc.next();
					String lastName = sc.next();
					
					int age = sc.nextInt();
					String companyName = sc.next();
					
					String email = sc.next();
					try {
						if(!Validation.validateEmail(email)) {
							throw new GlobalException("Invalid Email Format!!");
						}
					}catch(GlobalException e) {
						System.out.println(e.getMessage());
						System.out.println("Please enter valid email: ");
						email = sc.next();
					}
					
					long phno = sc.nextLong();
					
					Customer c = new Customer(id,firstName,lastName,age,companyName,email,phno);
					
					boolean added = service.addCustomer(c);
				
					if(added) {
						System.out.println("Customer added successfully!");
					} else {
						System.out.println("Unable to add customer");
					}
					
					break;
				} else {
					break;
				}
				
			}
			case 2: {
				System.out.println("Do you want to proceed with the option?Y/N");
				String choice = sc.next();
				
				if(choice.toLowerCase().equals("y")) {
					System.out.println("Customer Id: ");
					int cusid = sc.nextInt();
					System.out.println("Type of Room (AC/NON-AC): ");
					String type = sc.next();
					System.out.println("Do you want wifi? Y/N ");
					boolean wifi = sc.next().equals("Y");
					System.out.println("Do you need TV? Y/N");
					boolean tv = sc.next().equals("Y");
					System.out.println("Do you need laundry? Y/N");
					boolean laundry = sc.next().equals("Y");
					System.out.println("Capacity: ");
					int capacity = sc.nextInt();
					
					try {
						if(capacity <= 0) {
							throw new GlobalException("Invalid Capacity!!");
						}
					}catch(GlobalException  e) {
						System.out.println(e.getMessage());
						System.out.println("Please re-enter valid capacity: ");
					}
					
					System.out.println("Duration of stay: ");
					int duration = sc.nextInt();
					
					Booking b = new GuestBooking();
					
					List<Room> rooms = b.getAppointments(cusid,type,wifi,tv,laundry,capacity,duration);
					
					if(rooms.isEmpty()) {
						System.out.println("Sorry rooms not-available. Please try with some other room types");
						break;
					}
					for(Room r : rooms) {
						System.out.println(r);
					}
					
					System.out.println("Enter the room id to book: ");
					int roomid = sc.nextInt();
					System.out.println("Enter checkin date: (yyyy-mm-dd)");
					LocalDate checkindate = LocalDate.parse(sc.next());
					
					LocalDate now = LocalDate.now();
					if(!checkindate.isAfter(now)) {
						
						throw new GlobalException("Please enter valid date atleast 1 day ahead of current date");
						
						
					}
					Registration reg = new Registration();
					
					reg.setCheckindate(checkindate);
					
					LocalDate checkoutdate = checkindate.plusDays(duration);
					reg.setCheckoutdate(checkoutdate);
					reg.setCusid(cusid);
					
					reg.setDuration(duration);
					reg.setRoomid(roomid);
					
					for(Room r : rooms) {
						if(r.getRoom_id() == roomid) {
							System.out.println("Price "+capacity*r.getPrice());
							reg.setTotalprice(capacity*r.getPrice());
						}
					}
					boolean booked = b.bookRoom(reg);
					if(booked) {
							System.out.println("Room Booked!!\n--Your Invoice--");
							System.out.println("Customer ID: "+reg.getCusid());
							System.out.println("Room ID: "+reg.getRoomid());
							System.out.println("Chekindate: "+reg.getCheckindate());
							System.out.println("Total Cost For Stay: Rs."+reg.getTotalprice());
					} else {
						System.out.println("Unable to book room");
					}
					break;
				}else {
					break;
				}
				
			}
			case 3: {
				
				System.out.println("Do you want to proceed with the option?Y/N");
				String choice = sc.next();
				
				if(choice.toLowerCase().equals("y")) {
					Booking b = new GuestBooking();
					List<String> status = b.getStatus();
					if(status.isEmpty()) {
						System.out.println("No Bookings");
						break;
					}
					for(String s : status) {
						System.out.println(s);
					}
					break;
				}else {
					break;
				}
			}
			case 4: {
				System.out.println("Do you want to proceed with the option?Y/N");
				String choice = sc.next();
				
				if(choice.toLowerCase().equals("y")) {
					
					System.out.println("Customer Id: ");
					int id = sc.nextInt();
					System.out.println("New Email: ");
					String email = sc.next();
					
					if(!Validation.validateEmail(email)) {
						
						System.out.println("Invalid Email Format! Please enter valid email");
						break;
					}
					boolean updated = service.changeEmail(id, email);
					if(updated) {
						System.out.println("Email updated successfully!");
					} else {
						System.out.println("Unable to update email/Invalid customer id");
					}
					break;
				}else {
					break;
				}
			}
			case 5: {
				System.out.println("Do you want to proceed with the option?Y/N");
				String choice = sc.next();
				
				if(choice.toLowerCase().equals("y")) {
					
					System.out.println("BOOKING FROM: ");
					LocalDate from = LocalDate.parse(sc.next());
					System.out.println("BOOKING UPTO:");
					LocalDate to = LocalDate.parse(sc.next());
					
					Booking b = new GuestBooking();
					List<Registration> regs = b.getAllBookings(from, to);
					
					for(Registration r : regs) {
						System.out.println(r);
					}
					break;
				}else {
					break;
				}
			}
			case 6: {
				System.out.println("Do you want to proceed with the option?Y/N");
				String choice = sc.next();
				
				if(choice.toLowerCase().equals("y")) {
					List<Customer> cList = service.getAllCustomers();
					
					for(Customer c : cList) {
						
						System.out.println(c);
					}
					break;
				}else {
					break;
				}
			}
				
				default: 
				{
					System.out.println("Do you want to quit?Y/N");
					String choice = sc.next();
					
					if(choice.toLowerCase().equals("y")) {
						System.out.println("Thankyou for using our app!");
						System.exit(0);
						break;
					}else {
						break;
					}
					
				}
			}
		}while(true);
		
		
		
	}
}
