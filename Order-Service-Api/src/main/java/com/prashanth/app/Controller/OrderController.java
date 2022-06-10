package com.prashanth.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashanth.app.Service.OrderService;
import com.prashanth.app.exception.OrderNotFoundException;
import com.prashanth.app.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	@GetMapping()
	public ResponseEntity<List<Order>> getAllOrder(){
		return new ResponseEntity<>(orderservice.getAllOrders(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Order> addorder(@RequestBody Order order){
		return new ResponseEntity<>(orderservice.addorder(order),HttpStatus.CREATED);
	}
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> orderById(@PathVariable Integer orderId){
		return new ResponseEntity<>(orderservice.orderById(orderId),HttpStatus.OK);
	}
	@PutMapping("/{orderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable Integer OrderId,@RequestBody Order order) throws OrderNotFoundException{
		return new ResponseEntity<>(orderservice.updateOrder(OrderId, order),HttpStatus.ACCEPTED);
	}
	@PatchMapping("/{orderId}")
	public ResponseEntity<Order> updateOrderByName(@PathVariable Integer orderId,@RequestBody String Name){
		return new ResponseEntity<>(orderservice.updateOrderByName(orderId,Name),HttpStatus.OK);
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Order> DeleteOrder(@PathVariable Integer orderId){
	return	new ResponseEntity<>(orderservice.deletingOrder(orderId),HttpStatus.OK);
		}

}
