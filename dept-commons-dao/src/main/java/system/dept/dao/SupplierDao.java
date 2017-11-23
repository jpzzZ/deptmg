package system.dept.dao;

import system.dept.entiy.supplier.BookItem;
import system.dept.entiy.supplier.Items;
import system.dept.entiy.supplier.OrderDepot;
import system.dept.entiy.supplier.Waybill;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface SupplierDao {

	/**
	 * 添加货物订单
	 * @param w
	 * @return
	 * @throws SQLException
	 */
	boolean addWaybill(Waybill w) throws SQLException;

	/**
	 * 生成货物列表
	 *
	 * @param items
	 * @return
	 * @throws SQLException
	 */
	boolean addItems(List<Items> items) throws SQLException ;

	/**
	 * 加载操做书籍列表信息
	 * @return
	 * @throws SQLException
	 */
	List<BookItem> loadBookInf() throws SQLException ;
	/**
	 * 查询所有的订单信息
	 *
	 * @return
	 * @throws SQLException
	 */
	List<Waybill> findOrderAll() throws SQLException;
	/**
	 * 查询指定类别的订单信息
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	List<Waybill> findOrderByClazz(String state) throws SQLException ;

	/**
	 * 删除指定的订单
	 * @param waybill
	 * @throws SQLException
	 */
	void deleteWaybillById(String waybill) throws SQLException ;

	/**
	 * 修改指定订单的收货状态
	 * @param waybill
	 * @param wstate
	 * @throws SQLException
	 */
	void modifyWaybill(String waybill, String wstate) throws SQLException ;

	/**
	 * 修改指定收货单的完成时间
	 * @param waybill
	 * @param date
	 * @throws SQLException
	 */
	void modifyWaybillDate(String waybill, Date date) throws SQLException;

	/**
	 * 查询指定编号的清单
	 * @param waybill
	 * @return
	 * @throws SQLException
	 */
	List<BookItem> checkItemInfo(String waybill) throws SQLException ;
	/**
	 * 查询指定编号的供应单列表
	 * @param waybill
	 * @return
	 * @throws SQLException
	 */
	Waybill checkWaybillInfo(String waybill) throws SQLException;

	/**
	 * 查询仓库的列表信息
	 * @return
	 * @throws SQLException
	 */
	List<OrderDepot> findDepotInfo() throws SQLException ;

	/**
	 * 添加仓库信息
	 * @throws SQLException
	 */
	void addDepotInfo() throws SQLException;

	/**
	 * 添加仓库信息
	 * @param bnum
	 * @param address
	 * @param bid
	 * @throws SQLException
	 */
	void addDepotInfo(String bnum, String address, String bid) throws SQLException ;
}
