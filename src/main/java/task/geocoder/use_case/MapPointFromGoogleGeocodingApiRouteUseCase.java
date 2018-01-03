package task.geocoder.use_case;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

import task.geocoder.model.DefaultFailureResponseFactory;
import task.geocoder.model.MapPointResponse;

@Component
public class MapPointFromGoogleGeocodingApiRouteUseCase extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		rest("/geocoder").get()
			.produces("application/json")
			.param()
				.name("address")
				.type(RestParamType.query)
				.dataType("string").endParam()
			.route()
				.doTry()
					.toD("geocoder:address:${header.address}")
						.convertBodyTo(MapPointResponse.class)
					
				.doCatch(IllegalArgumentException.class)
					.bean(DefaultFailureResponseFactory.class, "responseForIllegalArgumentException")
				.end()
		.endRest();
	}
}
