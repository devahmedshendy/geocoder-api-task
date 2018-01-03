package task.geocoder.converter;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.code.geocoder.model.GeocodeResponse;
import task.geocoder.model.MapPointResponseFactory;
import task.geocoder.model.MapPointResponse;

@Component
public class MapPointCamelTypeConverters implements TypeConverters {
	
	private MapPointResponseFactory responseFactory;
	
	@Autowired
	private MapPointCamelTypeConverters(MapPointResponseFactory factory) {
		this.responseFactory = factory;
	}
	
	private MapPointCamelTypeConverters() { 
		
	}
	
	
	
	@Converter
	public MapPointResponse convertToMapPointModel(GeocodeResponse response) {
		String responseStatus = response.getStatus().value(); 
		
		return response.getResults().size() > 0 ? 
				this.responseFactory.createWithFullResult(responseStatus, response.getResults().get(0))
				:
				this.responseFactory.createWithEmptyResult(responseStatus);
	}
	
}
