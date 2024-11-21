package lambdas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class HotelService {
	
	public static List<Hotel> hotels= new ArrayList<>();
	
	static {
		
		//Hotel Stub
		
		for(int i=1;i<=10;i++) {
			Hotel hotel = new Hotel();
			
			hotel.setHotelId(i);
			hotel.setName("Hotel"+i);
			hotel.setAddress("NO:"+i+"abc st,xyz");
			List<HotelType> hotelTypes = new LinkedList<>();
			List<FoodType> foodTypes = new LinkedList<>();
			
			for(HotelType type : HotelType.values()) {
				hotelTypes.add(type);
			}
			for(FoodType type : FoodType.values()) {
				foodTypes.add(type);
			}
			
			Random rand = new Random();
			int index = rand.nextInt(hotelTypes.size());
			hotel.setHotelType(hotelTypes.get(index));
			
			index = rand.nextInt(foodTypes.size());
			hotel.setFoodType(foodTypes.get(index));
			
			hotel.setRating((float)rand.nextInt(5)+1.0f);
			hotel.setPricePerStay((double)i);
			
			hotels.add(hotel);
			
		}
	}
	
	
	public void displayAllHotels() {
		
		for(Hotel hotel : hotels) {
			printHotel(hotel);
		}
	}
	
	
	public void getHotelWithFiveStars(HotelFiltering filter) {
		filter.test(hotels);
	}
	
	public void printHotel(Hotel hotel) {
		
		System.out.println("-------------------------------");
		System.out.println("Hotel Name: "+hotel.getName()
		+"\nHotel Address: "+hotel.getAddress()+
		"\nHotel Type: "+hotel.getHotelType()+"\nFood Type: "
	+hotel.getFoodType()+"\nPrice Per Day: "+hotel.getPricePerStay()+"$"
	+"\nRating: "+hotel.getRating()
		);
		System.out.println("-------------------------------");
	
	}


	public void getHotelWithThreeStars(HotelFiltering filter) {
		// TODO Auto-generated method stub
		filter.test(hotels);
		
	}
	
	
}
