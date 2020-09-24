package com.sreejesh.demo.route;

import com.sreejesh.model.Cat;
import com.sreejesh.model.Dog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="camel-demo-route")
@Data
@EqualsAndHashCode(callSuper=true)

public class TypeConverterDemoRoute extends RouteBuilder {


	
	@Override
	public void configure() {

		// @formatter:off



		from("timer://myTimer?period=10s&repeatCount=1")
		.routeId("InputFolderToTestSedaRoute")
		.setBody(()-> new Cat("Tom","black",3))
		.log("Body:${body}")
//		.convertBodyTo(String.class)
		.convertBodyTo(Dog.class)
//		.convertBodyTo(String.class)
		.to("file://{{outputFolder}}?fileName=myOutputFile.txt")
		;

		
		
		// @formatter:on

	}



}
