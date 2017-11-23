package system.dept.service.impl;


import system.dept.commons.bean.CommonUtils;
import system.dept.dao.OrderDao;
import system.dept.dao.impl.OrderDaoImpl;
import system.dept.entiy.order.Order;
import system.dept.entiy.order.OrderItem;
import system.dept.service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService{
	
	private OrderDao dao = new OrderDaoImpl() ;

	/**
	 * 根据状态查询具体的订单信息
	 * @param clazz
	 * @return
	 */
	public List<Order> findOrderInfo(String clazz) {
		if("all".equals(clazz)){
			try {
				return dao.findOrderAll();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else if ("nosend".equals(clazz)){
			clazz = "发货单" ;
		} else { //back退回订单
			clazz = "退货单" ;
		}
		try {
			return dao.findOrderByState(clazz);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除指定订单的信息
	 * @param orderid
	 * @return 
	 */
	public boolean deletOrderById(String orderid) {
		try {
			dao.deleteOrderById(orderid);
			return true ;
		} catch (SQLException e) {
			return false ;
		}
	}

	/**
	 * 根据订单号查找相关的订单信息
	 * @param orderid
	 * @return
	 */
	public Order checkOrderInfo(String orderid) {
		try {
			return dao.checkOrder(orderid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据订单号查找相关的订单列表信息
	 * @param orderid
	 * @return
	 */
	public List<OrderItem> checkItemInfo(String orderid) {
		try {
			return dao.checkItem(orderid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 退货处理的service
	 * @param orderid
	 * @return
	 */
	public boolean backOrderDeal(String orderid) {
		/**
		 * 修改订单状态 1----
		 * 把订单中涉及的书籍信息 1-- 修改
		 */
		return this.modifyOrderState(orderid, "退货完成");
	}

	/**
	 * 发货处理的service
	 * @param orderid
	 * @return
	 */
	public boolean sendOrderDeal(String orderid , String comp) {
		/**
		 * 仓库书籍减少的操作
		 */
		try {
			dao.sendOrderComp(orderid , CommonUtils.uuid() , comp);
			this.modifyOrderState(orderid, "已发货");
			return true ;
		} catch (SQLException e) {
			return false;
		}
	}
	
	
	/**
	 * 修改收货状态
	 * @param ostate
	 * @return
	 */
	public boolean modifyOrderState(String orderid  , String ostate) {
		try {
			dao.modifyOrderState(orderid , ostate );
			return true ;
		} catch (SQLException e) {
			return false ;
		}
	}
}
