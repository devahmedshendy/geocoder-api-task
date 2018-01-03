package task.geocoder.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.code.geocoder.model.GeocoderResult;

@Component
public class DefaultMapPointResponseFactory implements MapPointResponseFactory {
	
	private MapPointResponse mapPointResponse;
	private MapPointResult mapPointResult;
	
	@Autowired
	public DefaultMapPointResponseFactory(MapPointResponse response,
			MapPointResult result) {
		this.mapPointResponse = response;
		this.mapPointResult = result;
	}

	
	@Override
	public MapPointResponse createWithEmptyResult(String status) {
		this.mapPointResponse.setStatus(status);
		this.mapPointResponse.setResult(null);
		
		return mapPointResponse;
	}
	
	@Override
	public MapPointResponse createWithFullResult(String status, GeocoderResult result) {
		
		this.mapPointResult.setFormattedAddress(result.getFormattedAddress());
		this.mapPointResult.setLocation(result.getGeometry().getLocation());
		
		this.mapPointResponse.setStatus(status.toString());
		this.mapPointResponse.setResult(this.mapPointResult);
		
		return mapPointResponse;
	}

}
