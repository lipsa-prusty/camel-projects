package com.camelspring2;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

	
	@Override
	public void configure() throws Exception{
		from("file:C:/Users/835027/Source?noop=true")
		.process(new FileProcessor())
		.to("file:C:/Users/835027/Destination?fileName=emp.json");
	}
}
