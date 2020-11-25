package com.camel.data;

import java.util.List;

public class JdbcHandler  {
  public void display(List list){
	  for(int i=0;i<list.size(); i++){
		  System.out.println( "list.get(i)");
	  }
  }
}
