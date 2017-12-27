package shendy.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.maps.errors.ApiException;

import shendy.assessment.exception.InvalidAddressValueException;
import shendy.assessment.model.MapPointResponse;
import shendy.assessment.model.MapPointResponseFactory;

@ControllerAdvice
public class MapPointControllerAdvice {
	
	@Autowired
	private MapPointResponseFactory mapPointResponseFactory;
	
	
	
	@ExceptionHandler(InvalidAddressValueException.class)
	public @ResponseBody MapPointResponse handleInvalidAddressValue() {
		MapPointResponse response = mapPointResponseFactory.createForInvalidAddressValue();
		
		return response;
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public @ResponseBody MapPointResponse handleMissingRequestParameter() {
		MapPointResponse response = mapPointResponseFactory.createForMissingRequestParameter();
		
		return response;
	}
	
	@ExceptionHandler(value = { ApiException.class })
	public @ResponseBody MapPointResponse handleApiException(Exception e) {
		MapPointResponse response = mapPointResponseFactory.createForApiException(e.getMessage());
		
		return response;
	}
}
