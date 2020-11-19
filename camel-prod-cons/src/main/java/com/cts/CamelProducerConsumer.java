package com.cts;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelProducerConsumer {
	public static void main(String[] args) {
		CamelContext camel = new DefaultCamelContext();
		try {
			camel.addRoutes(new RouteBuilder() {

				@Override
				public void configure() throws Exception {
					from("direct:start").to("seda:end");
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			camel.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProducerTemplate producer = camel.createProducerTemplate();
		producer.sendBody("direct:start", "hello");
		ConsumerTemplate consumer = camel.createConsumerTemplate();
		String message = consumer.receiveBody("seda:end", String.class);
		System.out.println(message);
	}

}
