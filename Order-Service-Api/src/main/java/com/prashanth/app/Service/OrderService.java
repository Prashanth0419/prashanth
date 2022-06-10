package com.prashanth.app.Service;

import java.util.List;

import com.prashanth.app.exception.OrderNotFoundException;
import com.prashanth.app.model.Order;

public interface OrderService {

    public List<Order> getAllOrders();
    
    public Order orderById(Integer orderId);
    
    public Order addorder(Order order);
    
   public Order updateOrder(Integer orderId,Order order) throws OrderNotFoundException;

    public Order updateOrderByName(Integer orderId,String Name);
    
    public Order deletingOrder(Integer orderId);
    
    
}
