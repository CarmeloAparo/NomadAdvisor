import com.mongodb.client.MongoCursor;

import java.util.List;

public class NomadHandler {

    public static boolean addReview(Review newReview){
        return MongoDBHandle.createReview(newReview);
    }

    public static List<Review> getReviews(Hotel hotel){
        return MongoDBHandle.selectReviews(hotel.getHotelName(), hotel.getCityName(), hotel.getCountryName());
    }

    public static List<Hotel> getHotels(City city){
    	return MongoDBHandle.selectHotels(city.getCityName(), city.getCountryName());
	}
	
	public static String updatePreferences(Customer customer, List<String> preferences) {
		customer.setPreferences(preferences);
		String result;
		if(MongoDBHandle.updatePreferences(customer)) {
			result = "Success!!!";
		}
		else {
			result = "Update operation failed";
		}
		return result;
	}
}
