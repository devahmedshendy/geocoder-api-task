package task.geocoder.model;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;
import task.geocoder.enums.ErrorStatus;

@Data
@Component
public class DefaultFailureResponseFactory implements FailureResponseFactory {
	
	private Map<String, String> errorResponse = new LinkedHashMap<>();;
	
	public Map<String, String> createErrorResponse(String status, String errorMessage) {
		this.errorResponse.put("status", status);
		this.errorResponse.put("error_message", errorMessage);
		
		return errorResponse;
	}
	
	@Override
	public @ResponseBody Map<String, String> responseForIllegalArgumentException(Exception e) {
		return createErrorResponse(ErrorStatus.INVALID_REQUEST.value(), e.getMessage());
	}
	
}
