package system.dept.dao;

import system.dept.entiy.order.Order;
import system.dept.entiy.order.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
	
	/**
	 * 查询所有的订单信息
	 * @return
	 * @throws SQLException 
	 */
	List<Order> findOrderAll() throws SQLException;
	/**
	 * 根据订单的状态查询信息
	 * @param clazz
	 * @return
	 * @throws SQLException 
	 */
	List<Order> findOrderByState(String clazz) throws SQLException;
	
	
	/**
	 * 删除指定的订单
	 * @param waybill
	 * @throws SQLException
	 */
	void deleteOrderById(String waybill) throws SQLException;

	/**
	 * 查询指定订单的详情信息
	 * @param orderid 
	 * @return
	 * @throws SQLException 
	 */
	List<OrderItem> checkItem(String orderid) throws SQLException ;

	/**
	 * 查询指定订单的订单详情
	 * @param orderid
	 * @return
	 * @throws SQLException 
	 */
	Order checkOrder(String orderid) throws SQLException ;

	/**
	 * 修改订单的收货状态
	 * @param orderid
	 * @param ostate
	 * @throws SQLException 
	 */
	void modifyOrderState(String orderid, String ostate) throws SQLException;

	/**
	 * 完成发货处理
	 * @param orderid
	 * @param uuid
	 * @param comp
	 * @throws SQLException 
	 */
	void sendOrderComp(String orderid, String uuid, String comp) throws SQLException ;
}
