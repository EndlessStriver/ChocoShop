package dao;

import java.util.List;

import entity.Order;

public interface OrderDao {
	
	List<Order> getOrders();

	Order getOrder(long id);

	void createOrder(Order order);

	void deleteOrder(long id);

	void updateOrder(Order order);
	
}
