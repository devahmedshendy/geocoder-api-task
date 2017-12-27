package shendy.assessment.geocoding_api;

import com.google.maps.model.GeocodingResult;

public interface IGeocodingApi {
	GeocodingResult[] getResultFor(String address) throws Exception;
}
