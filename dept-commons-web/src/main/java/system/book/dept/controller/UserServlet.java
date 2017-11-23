package system.book.dept.controller;

import system.dept.commons.bean.CommonUtils;
import system.dept.commons.web.BaseServlet;
import system.dept.entiy.user.User;
import system.dept.service.UserService;
import system.dept.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




/**
 *	管理员信息处理的Servlet
 */
public class UserServlet extends BaseServlet {
	
	private UserService service = new UserServiceImpl() ;
	
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到Admin
		 */
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		User admin = service.login(form);
		if(admin == null) {
			request.setAttribute("msg", "用户名或密码错误！");
			return "r:/admin/index.jsp";
		}
		request.getSession().setAttribute("admin", admin);
		return "r:/admin/home.jsp";
	}

}
