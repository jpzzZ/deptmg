package system.dept.dao;


import system.dept.entiy.user.User;

import java.sql.SQLException;

/**
 * User的登陆操作
 */
public interface UserDao {

	User checkUserInfo(String uname, String pwd) throws SQLException;
}
