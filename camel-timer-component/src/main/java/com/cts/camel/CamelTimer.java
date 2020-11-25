package com.cts.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class CamelTimer {

	
	public static void main(String[] args) throws Exception{
		MyBean myBean =new MyBean();
		SimpleRegistry registry=new SimpleRegistry();
		//registry.bind("bean1", MyBean.class, myBean);
		registry.put("bean1", new MyBean());
		
		
		
		CamelContext camel=new DefaultCamelContext(registry);
	camel.addRoutes(new RouteBuilder(){
		@Override
		public void configure() throws Exception{
			//configure routes
			
			from("timer:myTimer?period=1000")
			.setBody(simple("hello from camel at ${header.firedTime}"))
			.to("stream:out")
			.to("bean:bean1?method=sayHello");
			//.bean(new MyBean(), "sayHello");
		}
	});
	camel.start();
	Thread.sleep(5000);
	camel.stop();
	//it will keep on running
	//while(true)
	//camel.start();
			}
}
