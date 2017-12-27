package shendy.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shendy.assessment.exception.InvalidAddressValueException;
import shendy.assessment.model.MapPointResponse;
import shendy.assessment.use_case.GetMapPointFromGeocodingApiUseCase;

@RestController 
@RequestMapping("/api")
public class MapPointController {
	
	private GetMapPointFromGeocodingApiUseCase getMapPointFromGeocodingApiUseCase;
	
	@Autowired
	public MapPointController(GetMapPointFromGeocodingApiUseCase useCase) {
		this.getMapPointFromGeocodingApiUseCase = useCase;
	}
	
	
	@GetMapping(path = "/json", produces = "application/json")
	public MapPointResponse mapPointJsonResponse(
			@RequestParam(value = "address") String address) throws Exception {
		
		validateAddress(address);
		
		return getMapPointFromGeocodingApiUseCase.from(address);
	}
	
	
	@GetMapping(path = "/xml", produces = "application/xml")
	public MapPointResponse mapPointXmlResponse(
			@RequestParam(value = "address") String address) throws Exception {
		
		validateAddress(address);
		
		return getMapPointFromGeocodingApiUseCase.from(address);
	}
	
	
	public void validateAddress(String address) throws InvalidAddressValueException {
		if (address.isEmpty() || address == null) {
			throw new InvalidAddressValueException();
		}
	}
	
}
