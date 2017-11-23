package system.dept.dao;


import system.dept.entiy.inventory.Inventory;

import java.sql.SQLException;
import java.util.List;

public interface DepotDao {

	/**
	 * 根据仓库的名称查询具体的书籍信息
	 * @param depot
	 * @return
	 * @throws SQLException
	 */
	List<Inventory> findByDepotName(String depot) throws SQLException ;
	/**
	 * 查询所有的残酷列表信息
	 * @return
	 * @throws SQLException 
	 */
	List<Inventory> findAllDepot() throws SQLException ;

	List<Inventory> findDepotName() throws SQLException ;

	/**
	 * 根据要求的信息查询书籍
	 * @param bname
	 * @param press
	 * @param clazz
	 * @return
	 * @throws SQLException 
	 */
	List<Inventory> findBookByALL(String bname, String press,
								  String clazz) throws SQLException ;
	
}
