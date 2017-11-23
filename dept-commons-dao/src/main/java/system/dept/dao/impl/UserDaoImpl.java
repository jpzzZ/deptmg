package system.dept.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import system.dept.commons.dao.TxQueryRunner;
import system.dept.dao.UserDao;
import system.dept.entiy.user.User;

import java.sql.SQLException;

/**
 * User的登陆操作
 */
public class UserDaoImpl implements UserDao {
	
	private QueryRunner qr = new TxQueryRunner();

	public User checkUserInfo(String uname , String pwd) throws SQLException{
		String sql = "select * from t_user where uname like ? and pwd like ?";
		return qr.query(sql, new BeanHandler<User>(User.class), uname, pwd);
	}
}
