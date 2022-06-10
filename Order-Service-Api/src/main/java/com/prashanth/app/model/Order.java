package com.prashanth.app.model;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	
	  private Integer orderId;
	  
	  
	  private String name;
       
	  
      private String descripion;
      
	  
      private Double ammount;
       
	  
      private Date dateoforder;

}
