package shendy.assessment.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.maps.model.LatLng;

@JsonInclude(value = Include.NON_NULL)
@JacksonXmlRootElement(localName = "map-point-response")
@Component
public class MapPointResponse {

	public String status;
	
	@JsonProperty(value = "formatted_address")
	@JacksonXmlElementWrapper(localName = "formatted_address")
	public String formattedAddress;
	
	public LatLng location;
	
	@JsonProperty(value = "error_message")
	@JacksonXmlElementWrapper(localName = "error_message")
	public String errorMessage;

}
