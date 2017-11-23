package system.dept.service;

import system.dept.entiy.order.Order;
import system.dept.entiy.order.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
	
	/**
	 * 根据状态查询具体的订单信息
	 * @param clazz
	 * @return
	 */
	List<Order> findOrderInfo(String clazz);

	/**
	 * 删除指定订单的信息
	 * @param orderid
	 * @return 
	 */
	boolean deletOrderById(String orderid);

	/**
	 * 根据订单号查找相关的订单信息
	 * @param orderid
	 * @return
	 */
	Order checkOrderInfo(String orderid);

	/**
	 * 根据订单号查找相关的订单列表信息
	 * @param orderid
	 * @return
	 */
	List<OrderItem> checkItemInfo(String orderid);

	/**
	 * 退货处理的service
	 * @param orderid
	 * @return
	 */
	boolean backOrderDeal(String orderid);

	/**
	 * 发货处理的service
	 * @param orderid
	 * @return
	 */
	boolean sendOrderDeal(String orderid, String comp);


	/**
	 * 修改收货状态
	 * @param orderid
	 * @return
	 */
	boolean modifyOrderState(String orderid, String ostate);
}
