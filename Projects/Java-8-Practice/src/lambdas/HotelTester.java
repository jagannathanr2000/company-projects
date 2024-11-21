package lambdas;

public class HotelTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelService hotelService = new HotelService();
		
		
//		hotelService.displayAllHotels();
//		hotelService.getHotelWithFiveStars();
//		hotelService.getHotelWithThreeeStars();
		
		HotelFiltering filter = (hotels) -> {
			System.out.println("------FIVE STAR HOTELS-----");
			for(Hotel hotel : hotels) {
				if(hotel.getHotelType().equals(HotelType.FIVE_STAR)) {
					hotelService.printHotel(hotel);
				}
			}
		};
		hotelService.getHotelWithFiveStars(filter);
		
		filter = (hotels) -> {
			System.out.println("------THREE STAR HOTELS-----");
			for(Hotel hotel : hotels) {
				if(hotel.getHotelType().equals(HotelType.THREE_STAR)) {
					hotelService.printHotel(hotel);
				}
			}
		};
		
		hotelService.getHotelWithThreeStars(filter);
		
	}

}
