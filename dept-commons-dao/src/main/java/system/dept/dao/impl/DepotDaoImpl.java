package system.dept.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import system.dept.commons.dao.TxQueryRunner;
import system.dept.dao.DepotDao;
import system.dept.entiy.inventory.Inventory;

import java.sql.SQLException;
import java.util.List;

public class DepotDaoImpl implements DepotDao{

	private QueryRunner qr = new TxQueryRunner();

	public List<Inventory> findByDepotName(String depot) throws SQLException {
		String sql = "select b.bname , b.press , b.clazz , d.bnum  , d.address"
				+ " from t_book b , t_depot d"
				+ " where b.bid = d.bid and d.address=?" ;
		return qr.query(sql, new BeanListHandler<Inventory>(Inventory.class) , depot);
	}

	public List<Inventory> findAllDepot() throws SQLException {
		String sql = "select b.bname , b.press , b.clazz , d.bnum  , d.address"
				+ " from t_book b , t_depot d"
				+ " where b.bid = d.bid" ;
		return qr.query(sql, new BeanListHandler<Inventory>(Inventory.class));
	}

	public List<Inventory> findDepotName() throws SQLException {
		String sql = "select distinct d.address"
				+ " from t_depot d" ;
		return qr.query(sql, new BeanListHandler<Inventory>(Inventory.class));
	}

	public List<Inventory> findBookByALL(String bname, String press,
			String clazz) throws SQLException {
		String sql = "select b.bname , b.press , b.clazz , d.bnum  , d.address"
				+ " from t_book b , t_depot d"
				+ " where b.bid = d.bid and b.bname like ? and b.press like ? and b.clazz like ?" ;
		return qr.query(sql, new BeanListHandler<Inventory>(Inventory.class) , bname , press , clazz);
	}
	
}
