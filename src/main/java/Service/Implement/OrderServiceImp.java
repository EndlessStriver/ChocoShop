package Service.Implement;

import java.util.List;

import Dao.OrderDao;
import Entity.Order;
import Service.OrderService;

public class OrderServiceImp implements OrderService{
	
	private OrderDao orderDao;
	
	public OrderServiceImp(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> getOrders() {
		try {
			return orderDao.getOrders();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Order getOrder(long id) {
		try {
			return orderDao.getOrder(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void createOrder(Order order) {
		try {
			orderDao.createOrder(order);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteOrder(long id) {
		try {
			orderDao.deleteOrder(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateOrder(Order order) {
		try {
			orderDao.updateOrder(order);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
