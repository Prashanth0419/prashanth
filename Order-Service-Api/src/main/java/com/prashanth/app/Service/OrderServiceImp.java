package com.prashanth.app.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.prashanth.app.exception.OrderNotFoundException;
import com.prashanth.app.model.Order;

@Service
public class OrderServiceImp implements OrderService{
      Map<Integer,Order> orders=new HashMap<>();

	@Override
	public List<Order> getAllOrders() {
		List<Order> orderlist =new ArrayList<>();
		   for(Order i :orders.values()) {
			   orderlist.add(i);
		   }
		return orderlist;
	}

	@Override
	public Order orderById(Integer orderId) {
		
		return orders.get(orderId);
	}

	@Override
	public Order addorder(Order order) {
		orders.put(order.getOrderId(), order);
		return orders.get(order.getOrderId());
	}

	@Override
	public Order updateOrder(Integer orderId, Order order) throws OrderNotFoundException {
			if(null ==orderById(orderId)) {
				throw new OrderNotFoundException("Order details are not found"+orderId);
			}else {
		   orders.put(orderId, order);
			return orders.get(orderId);
		
	}
			}

	@Override
	public Order updateOrderByName(Integer orderId, String Name) {
		Order order=orders.get(orderId);
		order.setName(Name);
		orders.put(orderId, order);
		return orders.get(orderId);
	}

	@Override
	public Order deletingOrder(Integer orderId) {
        return orders.remove(orderId);		
	}
      
}
