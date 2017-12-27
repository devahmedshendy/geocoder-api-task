package shendy.assessment.model;

import org.springframework.stereotype.Component;

import com.google.maps.model.GeocodingResult;

@Component
public class MapPointResponseFactory {
	
	public MapPointResponse createForSuccessGeocodingResult(GeocodingResult[] result) {
		MapPointResponse response = new MapPointResponse();
		response.status = "OK";
		response.formattedAddress = result[0].formattedAddress;
		response.location = result[0].geometry.location;
		
		return response;
	}
	
	public MapPointResponse createForInvalidAddressValue() {
		MapPointResponse response = new MapPointResponse();
		response.status = "INVALID_REQUEST";
		response.errorMessage = "Invalid request. Missing the 'address' value.";
		
		return response;
	}
	
	public MapPointResponse createForMissingRequestParameter() {
		MapPointResponse response = new MapPointResponse();
		response.status = "BAD_REQUEST";
		response.errorMessage = "Bad request. Missing the 'address' parameter.";
		
		return response;
	}
	
	public MapPointResponse createForApiException(String errorMessage) {
		MapPointResponse response = new MapPointResponse();
		response.status = "INVALID_REQUEST";
		response.errorMessage = errorMessage;
		
		return response;
	}
}
