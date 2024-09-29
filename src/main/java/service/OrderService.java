package service;

import java.util.List;

import entity.Order;

public interface OrderService {
	
	List<Order> getOrders();

	Order getOrder(long id);

	void createOrder(Order order);

	void deleteOrder(long id);

	void updateOrder(Order order);
	
}
