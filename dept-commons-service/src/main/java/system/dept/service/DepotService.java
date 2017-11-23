package system.dept.service;

import system.dept.entiy.inventory.Inventory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface DepotService {


	/**
	 * 查询根据仓库信息查询库存的入口
	 * 
	 * @param depot
	 * @return
	 */
	public List<Inventory> findDepotInfo(String depot);

	/**
	 * 处理查询完成的数据
	 * @param list
	 * @return
	 */
	List<Inventory> dealSelectDepot(List<Inventory> list);

	/**
	 * 查询所有的仓库名称
	 * @return
	 */
	List<Inventory> findDepotName();

	/**
	 * 根据具体的信息查找书籍
	 * @param bname
	 * @param press
	 * @param clazz
	 * @return
	 */
	List<Inventory> findBookByALL(String bname, String press,
								  String clazz);
}
