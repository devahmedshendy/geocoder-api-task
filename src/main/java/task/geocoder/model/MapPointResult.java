package task.geocoder.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.code.geocoder.model.LatLng;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Component
@JsonInclude(Include.NON_NULL)
public class MapPointResult implements Serializable {
	
	@JsonProperty(value = "formatted_address")
	private String formattedAddress;
	
	@JsonProperty(value = "location")
	private LatLng location;

}
