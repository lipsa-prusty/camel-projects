package com.camelspring2;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor{
	
	public void process(Exchange exchange) throws Exception{
		String message = exchange.getIn().getBody(String.class);
		
		StringTokenizer str= new StringTokenizer(message, ",");
		String eid= str.nextToken();
		String ename=str.nextToken();
		String esal=str.nextToken();
		
		String outMessage= "{eid:"+eid+",ename:"+ename+",esal:"+esal+"}";
		exchange.getIn().setBody(outMessage);
	}

}
