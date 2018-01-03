package task.geocoder.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Component
@JsonInclude(Include.NON_NULL)
public class MapPointResponse implements Serializable {
	
	private String status;
	private MapPointResult result;
	
	@JsonProperty(value = "error_message")
	private String errorMessage;
	
}