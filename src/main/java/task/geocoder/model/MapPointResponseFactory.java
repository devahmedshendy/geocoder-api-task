package task.geocoder.model;

import com.google.code.geocoder.model.GeocoderResult;

public interface MapPointResponseFactory {
	MapPointResponse createWithEmptyResult(String status);

	MapPointResponse createWithFullResult(String status, GeocoderResult result);
}
