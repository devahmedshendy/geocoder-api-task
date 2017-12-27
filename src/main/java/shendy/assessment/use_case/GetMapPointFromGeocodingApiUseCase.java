package shendy.assessment.use_case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.google.maps.model.GeocodingResult;

import shendy.assessment.geocoding_api.IGeocodingApi;
import shendy.assessment.model.MapPointResponse;
import shendy.assessment.model.MapPointResponseFactory;

@Component
public class GetMapPointFromGeocodingApiUseCase {
	
	private IGeocodingApi geocodingApi;
	private MapPointResponseFactory mapPointResponseFactory;
	
	@Autowired 
	public GetMapPointFromGeocodingApiUseCase( @Qualifier("googleGeocodingApi") IGeocodingApi geocodingApi,
			MapPointResponseFactory mapPointResponseFactory) {
		
		this.geocodingApi = geocodingApi;
		this.mapPointResponseFactory = mapPointResponseFactory;
	}
	
	
	
	public MapPointResponse from(String address) throws Exception {
		
		GeocodingResult[] result = geocodingApi.getResultFor(address);
		MapPointResponse response = mapPointResponseFactory.createForSuccessGeocodingResult(result);
		
		return response;
	}
	
}
