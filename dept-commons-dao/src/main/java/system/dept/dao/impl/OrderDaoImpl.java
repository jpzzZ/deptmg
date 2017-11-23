package system.dept.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import system.dept.commons.bean.CommonUtils;
import system.dept.commons.dao.TxQueryRunner;
import system.dept.dao.OrderDao;
import system.dept.entiy.order.Order;
import system.dept.entiy.order.OrderItem;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {
	
	private QueryRunner qr = new TxQueryRunner() ;

	/**
	 * 查询所有的订单信息
	 * @return
	 * @throws SQLException 
	 */
	public List<Order> findOrderAll() throws SQLException {
		String sql = "select * from t_order ORDER BY ostate desc" ;
		return qr.query(sql, new BeanListHandler<Order>(Order.class));
	}

	/**
	 * 根据订单的状态查询信息
	 * @param clazz
	 * @return
	 * @throws SQLException 
	 */
	public List<Order> findOrderByState(String clazz) throws SQLException {
		String sql = "select * from t_order where clazz = ? ORDER BY ostate desc" ;
		return qr.query(sql, new BeanListHandler<Order>(Order.class) , clazz);
	}
	
	
	/**
	 * 删除指定的订单
	 * @param waybill
	 * @throws SQLException
	 */
	public void deleteOrderById(String waybill) throws SQLException {
		String sql = "delete from t_order where oid=?";
		String sql1 = "delete from t_item where sid=?";
		Object[] param = { waybill };
		qr.update(sql, param);
		qr.update(sql1, param);
	}

	/**
	 * 查询指定订单的详情信息
	 * @param orderid 
	 * @return
	 * @throws SQLException 
	 */
	public List<OrderItem> checkItem(String orderid) throws SQLException {
		String sql = "select b.bid ,b.bname , i.bnum "
				+ "from t_book b , t_item i"
				+ " where i.sid=? and b.bid = i.bname";
		return qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), orderid);
	}

	/**
	 * 查询指定订单的订单详情
	 * @param orderid
	 * @return
	 * @throws SQLException 
	 */
	public Order checkOrder(String orderid) throws SQLException {
		String sql = "select * from t_order where oid=?" ;
		Map<String,Object> map = qr.query(sql, new MapHandler(), orderid);
		Order order = CommonUtils.toBean(map, Order.class);
		return order ;
	}

	/**
	 * 修改订单的收货状态
	 * @param orderid
	 * @param ostate
	 * @throws SQLException 
	 */
	public void modifyOrderState(String orderid, String ostate) throws SQLException {
		String sql = "update t_order set ostate= ? where oid=?";
		Object[] param = {ostate , orderid };
		qr.update(sql, param);
	}

	/**
	 * 完成发货处理
	 * @param orderid
	 * @param uuid
	 * @param comp
	 * @throws SQLException 
	 */
	public void sendOrderComp(String orderid, String uuid, String comp) throws SQLException {
		String sql = "update t_order set sendid= ? where oid=?";
		String sql1 = "update t_order set comp= ? where oid=?";
		Object[] param = {uuid , orderid };
		Object[] param1 = {comp , orderid };
		qr.update(sql, param);
		qr.update(sql1, param1);
	}
}
