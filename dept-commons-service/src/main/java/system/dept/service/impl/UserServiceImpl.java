package system.dept.service.impl;


import system.dept.dao.UserDao;
import system.dept.dao.impl.UserDaoImpl;
import system.dept.entiy.user.User;
import system.dept.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{

	private UserDao dao = new UserDaoImpl();

	public User login(User form) {
		try {
			return dao.checkUserInfo(form.getUname() , form.getPwd());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null ;
	}
}
