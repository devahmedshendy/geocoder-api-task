package task.geocoder.model;

import java.util.Map;

public interface FailureResponseFactory {

	Map<String, String> responseForIllegalArgumentException(Exception e);
	
}
