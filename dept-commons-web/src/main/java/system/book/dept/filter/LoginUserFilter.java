package system.book.dept.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(value="/")
public class LoginUserFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Object admin = req.getSession().getAttribute("admin");
		if(admin == null) {
			request.setAttribute("msg", "请登录后在访问");
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	public void destroy() {
	}

}
