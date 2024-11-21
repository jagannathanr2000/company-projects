package lambdas;

public class Hotel {
	
	private long hotelId;
	private String name;
	private String address;
	private HotelType hotelType;
	private double pricePerStay;
	private FoodType foodType;
	private float rating;
	
	Hotel() {}

	public Hotel(long hotelId, String name, String address, HotelType hotelType, double pricePerStay, FoodType foodType,
			float rating) {
		super();
		
		this.hotelId = hotelId;
		this.name = name;
		this.address = address;
		this.hotelType = hotelType;
		this.pricePerStay = pricePerStay;
		this.foodType = foodType;
		this.rating = rating;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public HotelType getHotelType() {
		return hotelType;
	}

	public void setHotelType(HotelType hotelType) {
		this.hotelType = hotelType;
	}

	public double getPricePerStay() {
		return pricePerStay;
	}

	public void setPricePerStay(double pricePerStay) {
		this.pricePerStay = pricePerStay;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
	
	
}
