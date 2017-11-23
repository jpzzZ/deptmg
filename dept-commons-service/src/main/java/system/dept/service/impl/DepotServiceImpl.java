package system.dept.service.impl;

import system.dept.dao.DepotDao;
import system.dept.dao.impl.DepotDaoImpl;
import system.dept.entiy.inventory.Inventory;
import system.dept.service.DepotService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepotServiceImpl implements DepotService{

	private DepotDao dao = new DepotDaoImpl();

	/**
	 * 查询根据仓库信息查询库存的入口
	 * 
	 * @param depot
	 * @return
	 */
	public List<Inventory> findDepotInfo(String depot) {
		if (depot.equals("all")) {
			try {
				List<Inventory> list = dao.findAllDepot();
				return this.dealSelectDepot(list);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		} else {
			// 查询有具体名称的仓库
			try {
				return dao.findByDepotName(depot);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * 处理查询完成的数据
	 * @param list
	 * @return
	 */
	public List<Inventory> dealSelectDepot(List<Inventory> list){
		List<Inventory> result = new ArrayList<>();
		boolean flag = true;
		for (Iterator<Inventory> it = list.iterator(); it.hasNext();) {
			Inventory book = it.next();
			flag = true;
			for (Iterator<Inventory> next = result.iterator(); next
					.hasNext();) {
				Inventory temp = next.next();
				if (temp.getBname().equals(book.getBname())) {
					if(temp.getBnum() == 0 && book.getBnum() != 0){
						temp.setAddress(book.getAddress());
					} else if(book.getBnum() != 0){
						temp.setAddress(temp.getAddress() + " ," + book.getAddress());
					} 
					temp.setBnum(temp.getBnum() + book.getBnum());
					flag = false;
				}
			}
			if (flag) {
				result.add(book);
			}
		}
		return result ;
	} 

	/**
	 * 查询所有的仓库名称
	 * @return
	 */
	public List<Inventory> findDepotName() {
		try {
			return dao.findDepotName();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据具体的信息查找书籍
	 * @param bname
	 * @param press
	 * @param clazz
	 * @return
	 */
	public List<Inventory> findBookByALL(String bname, String press,
			String clazz) {
		try {
			List<Inventory> list =  dao.findBookByALL( "%" + bname + "%", "%" + press + "%", "%" + clazz + "%") ;
			return this.dealSelectDepot(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
