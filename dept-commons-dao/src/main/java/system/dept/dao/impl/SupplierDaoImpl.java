package system.dept.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import system.dept.commons.bean.CommonUtils;
import system.dept.commons.dao.TxQueryRunner;
import system.dept.dao.SupplierDao;
import system.dept.entiy.supplier.BookItem;
import system.dept.entiy.supplier.Items;
import system.dept.entiy.supplier.OrderDepot;
import system.dept.entiy.supplier.Waybill;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SupplierDaoImpl implements SupplierDao{

	private QueryRunner qr = new TxQueryRunner();

	/**
	 * &#x6dfb;&#x52a0;&#x8d27;&#x7269;&#x8ba2;&#x5355;
	 *
	 * @return
	 * @throws SQLException
	 */
	public boolean addWaybill() throws SQLException {
		return addWaybill();
	}

	/**
	 * &#x6dfb;&#x52a0;&#x8d27;&#x7269;&#x8ba2;&#x5355;
	 *
	 * @param w
	 * @return
	 * @throws SQLException
	 */
	public boolean addWaybill(Waybill w) throws SQLException {
		String sql = "insert into t_waybill values(?,?,?,?,?,?)";
		Object[] param = { w.getWid(), w.getWstate(), w.getWname(),
				w.getAddress(), w.getSdate(), null };
		try {
			qr.update(sql, param);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * 生成货物列表
	 * 
	 * @param items
	 * @return
	 * @throws SQLException
	 */
	public boolean addItems(List<Items> items) throws SQLException {
		String sql = "insert into t_item value(?,?,?,?)";
		for (Iterator<Items> it = items.iterator(); it.hasNext();) {
			Items item = it.next();
			Object[] param = { item.getIid(), item.getBname(), item.getBnum(),
					item.getSid() };
			try {
				qr.update(sql, param);
			} catch (SQLException e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 加载操做书籍列表信息
	 * @return
	 * @throws SQLException
	 */
	public List<BookItem> loadBookInf() throws SQLException {
		String sql = "select bid , bname from t_book";
		return qr.query(sql, new BeanListHandler<BookItem>(BookItem.class));
	}

	/**
	 * 查询所有的订单信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Waybill> findOrderAll() throws SQLException {
		String sql = "select * from t_waybill";
		return qr.query(sql, new BeanListHandler<Waybill>(Waybill.class));
	}

	/**
	 * 查询指定类别的订单信息
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	public List<Waybill> findOrderByClazz(String state) throws SQLException {
		String sql = "select * from t_waybill where wstate=?";
		return qr.query(sql, new BeanListHandler<Waybill>(Waybill.class), state);
	}

	/**
	 * 删除指定的订单
	 * @param waybill
	 * @throws SQLException
	 */
	public void deleteWaybillById(String waybill) throws SQLException {
		String sql = "delete from t_waybill where wid=?";
		String sql1 = "delete from t_item where sid=?";
		Object[] param = { waybill };
		qr.update(sql, param);
		qr.update(sql1, param);
	}

	/**
	 * 修改指定订单的收货状态
	 * @param waybill
	 * @param wstate
	 * @throws SQLException
	 */
	public void modifyWaybill(String waybill , String wstate) throws SQLException {
		String sql = "update t_waybill set wstate= ? where wid=?";
		Object[] param = {wstate , waybill };
		qr.update(sql, param);
	}
	
	/**
	 * 修改指定收货单的完成时间
	 * @param waybill
	 * @param date
	 * @throws SQLException
	 */
	public void modifyWaybillDate(String waybill , Date date) throws SQLException {
		String sql = "update t_waybill set fdate= ? where wid=?";
		Object[] param = {date , waybill };
		qr.update(sql, param);
	}

	/**
	 * 查询指定编号的清单
	 * @param waybill
	 * @return
	 * @throws SQLException 
	 */
	public List<BookItem> checkItemInfo(String waybill) throws SQLException {
		String sql = "select b.bid ,b.bname , i.bnum "
				+ "from t_book b , t_item i"
				+ " where i.sid=? and b.bid = i.bname";
		return qr.query(sql, new BeanListHandler<BookItem>(BookItem.class), waybill);
	}

	/**
	 * 查询指定编号的供应单列表
	 * @param waybill
	 * @return
	 * @throws SQLException 
	 */
	public Waybill checkWaybillInfo(String waybill) throws SQLException {
		String sql = "select * from t_waybill where wid=?" ;
		Map<String,Object> map = qr.query(sql, new MapHandler(), waybill);
		Waybill way = CommonUtils.toBean(map, Waybill.class);
		return way ;
	}
	
	/**
	 * 查询仓库的列表信息
	 * @return
	 * @throws SQLException 
	 */
	public List<OrderDepot> findDepotInfo() throws SQLException {
		String sql = "select distinct address from t_depot";
		return qr.query(sql, new BeanListHandler<OrderDepot>(OrderDepot.class));
	}

	@Override
	public void addDepotInfo() throws SQLException {

	}

	/**
	 * 添加仓库信息
	 * @param bnum
	 * @param address
	 * @param bid
	 * @throws SQLException 
	 */
	public void addDepotInfo(String bnum, String address, String bid) throws SQLException {
		String sql = "update t_depot set bnum = bnum + ? where bid = ? and address = ?" ;
		Object[] param = { bnum , bid ,address };
		qr.update(sql, param);
	}
}
