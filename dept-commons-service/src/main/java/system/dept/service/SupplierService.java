package system.dept.service;

import system.dept.commons.bean.CommonUtils;
import system.dept.entiy.supplier.BookItem;
import system.dept.entiy.supplier.Items;
import system.dept.entiy.supplier.OrderDepot;
import system.dept.entiy.supplier.Waybill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface SupplierService {


	/**
	 * 添加书籍订单
	 * @param book
	 * @param num
	 * @param wname 
	 * @return
	 */
	boolean addBookList(String[] book, String[] num, String wname);

	/**
	 * 生成货物单
	 * @param book
	 * @param num
	 * @param sid
	 * @return
	 */
	List<Items> getItemList(String[] book, String[] num, String sid);

	/**
	 * 生成采购单
	 * @return
	 */
	Waybill getWaybill(String wname);

	/**
	 * 加载书籍名称列表
	 * @return
	 */
	List<BookItem> loadBookInf();

	/**
	 * 根据条件查询（state）订单信息
	 * @param state
	 * @return
	 */
	List<Waybill> findOrderList(String state);

	/**
	 * 根据指定的订单id删除订单
	 * @param waybill
	 * @return
	 */
	boolean deleteWaybillById(String waybill);

	/**
	 * 修改收货状态
	 * @param waybill
	 * @return
	 */
	boolean modifyWaybill(String waybill, String wstate);

	/**
	 * 查找指定的订单信息
	 * @param waybill
	 * @return
	 */
	Waybill checkWaybillInfo(String waybill);

	/**
	 * 查找指定订单第清单列表
	 * @param waybill
	 * @return
	 */
	List<BookItem> checkItemInfo(String waybill);

	/**
	 * 查找仓库列表
	 * @return
	 */

	List<OrderDepot> findDepotInfo();

	/**
	 * 为具体的数据库完成添加操作
	 * @param bookid
	 * @param depotName
	 * @param depotSize
	 * @param waybillID 
	 */
	void addDepotInfo(String[] bookid, String[] depotName,
					  List<String[]> depotSize, String waybillID);
}
