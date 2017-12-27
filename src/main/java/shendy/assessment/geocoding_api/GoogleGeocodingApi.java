package shendy.assessment.geocoding_api;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

@Component
public class GoogleGeocodingApi implements IGeocodingApi {
	
	@Value("${google.geocoding-api.key}")
	private String key;

	@Override
	public GeocodingResult[] getResultFor(String address) throws ApiException, InterruptedException, IOException {
		GeoApiContext apiContext = new GeoApiContext.Builder()
				.apiKey(key).build();
		
		return GeocodingApi.geocode(apiContext, address).await();
	}
}
