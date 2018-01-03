package task.geocoder.config;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import task.geocoder.converter.MapPointCamelTypeConverters;

@Configuration
public class CustomCamelConfig implements CamelContextConfiguration {
	
	@Autowired
	private MapPointCamelTypeConverters mapPointCamelTypeConverters;

	@Override
	public void afterApplicationStart(CamelContext context) {
		
	}

	@Override
	public void beforeApplicationStart(CamelContext context) {
		context.getTypeConverterRegistry().addTypeConverters(mapPointCamelTypeConverters);
	}
}
