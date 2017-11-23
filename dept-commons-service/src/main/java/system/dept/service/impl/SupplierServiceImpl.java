package system.dept.service.impl;

import system.dept.commons.bean.CommonUtils;
import system.dept.dao.SupplierDao;
import system.dept.dao.impl.SupplierDaoImpl;
import system.dept.entiy.supplier.BookItem;
import system.dept.entiy.supplier.Items;
import system.dept.entiy.supplier.OrderDepot;
import system.dept.entiy.supplier.Waybill;
import system.dept.service.SupplierService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {

	private SupplierDao dao = new SupplierDaoImpl();

	/**
	 * 添加书籍订单
	 * @param book
	 * @param num
	 * @param wname 
	 * @return
	 */
	public boolean addBookList(String[] book, String[] num, String wname) {
		// 生成订单列表
		Waybill w = this.getWaybill(wname);
		// 生成货物列表
		List<Items> items = this.getItemList(book, num, w.getWid());
		// 传入执行sql语句
		try {
			return dao.addWaybill(w) && dao.addItems(items);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}

	/**
	 * 生成货物单
	 * @param book
	 * @param num
	 * @param sid
	 * @return
	 */
	public List<Items> getItemList(String[] book, String[] num, String sid) {
		List<Items> list = new ArrayList<>();
		for (int i = 0; i < num.length; i++) {
			list.add(new Items(CommonUtils.uuid(), book[i], num[i], sid));
		}
		return list;
	}

	/**
	 * 生成采购单
	 * @return
	 */
	public Waybill getWaybill(String wname) {
		return new Waybill(CommonUtils.uuid(), "采购中", wname , "集散中心",
				new Date(), null);
	}

	/**
	 * 加载书籍名称列表
	 * @return
	 */
	public List<BookItem> loadBookInf() {
		try {
			return dao.loadBookInf();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据条件查询（state）订单信息
	 * @param state
	 * @return
	 */
	public List<Waybill> findOrderList(String state) {
		try{
			if("all".equals(state)){
				//查询所有的订单信息
				return dao.findOrderAll();
			}else {
				//查询指定的类别的订单信息
				return dao.findOrderByClazz(state);
			}
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据指定的订单id删除订单
	 * @param waybill
	 * @return
	 */
	public boolean deleteWaybillById(String waybill) {
		try {
			dao.deleteWaybillById(waybill);
			return true ;
		} catch (SQLException e) {
			return false ;
		}
	}

	/**
	 * 修改收货状态
	 * @param waybill
	 * @return
	 */
	public boolean modifyWaybill(String waybill  , String wstate) {
		try {
			dao.modifyWaybill(waybill , wstate );
			return true ;
		} catch (SQLException e) {
			return false ;
		}
	}

	/**
	 * 查找指定的订单信息
	 * @param waybill
	 * @return
	 */
	public Waybill checkWaybillInfo(String waybill) {
		try {
			return dao.checkWaybillInfo(waybill);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查找指定订单第清单列表
	 * @param waybill
	 * @return
	 */
	public List<BookItem> checkItemInfo(String waybill) {
		try {
			return dao.checkItemInfo(waybill);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查找仓库列表
	 * @return
	 */
	public List<OrderDepot> findDepotInfo() {
		try {
			return dao.findDepotInfo();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 为具体的数据库完成添加操作
	 * @param bookid
	 * @param depotName
	 * @param depotSize
	 * @param waybillID 
	 */
	public void addDepotInfo(String[] bookid, String[] depotName,
			List<String[]> depotSize, String waybillID) {
		/**
		 * 修改仓库的信息只需要根据书籍的编号和仓库信息修改指定的数量信息
		 * bookid 桉顺序的书籍编号
		 * depotName 按顺序的仓库信息
		 * depotSize: 中按顺序的仓库中的数量信息
		 */
		for (int i = 0; i < depotName.length; i++) {
			//i 表示当前仓库的名称
			String depotNameOne = depotName[i];//当前仓库
			String[] depotSizeOne = depotSize.get(i);//当前仓库存储的书籍数量
			for (int j = 0; j < bookid.length; j++) {
				//用书籍编号遍历
				try {
					dao.addDepotInfo(depotSizeOne[j] , depotName[i] , bookid[j]);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		//根据waybillID修改订单的状态
		this.modifyWaybill(waybillID, "已入库");
		//根据waybillID修改订单的完成日期
		try {
			dao.modifyWaybillDate(waybillID, new Date());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
