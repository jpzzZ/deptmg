package system.book.dept.controller;

import system.dept.commons.web.BaseServlet;
import system.dept.entiy.inventory.Inventory;
import system.dept.service.DepotService;
import system.dept.service.impl.DepotServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepotServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DepotService service = new DepotServiceImpl();
	
	public String selectDepot(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//可能加入的参数类类型   分页参数
		String depot = request.getParameter("depot");
		//根据仓库名车查找具体仓库存储的数量信息
		List<Inventory> depots = service.findDepotInfo(depot);
		request.setAttribute("depots", depots);
		this.getDepotName(request); // 获取仓库名信息
		return "f:/admin/depot/depotlist.jsp" ;
	}
	
	public String findByDim(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bname = request.getParameter("bname").trim();
		String press = request.getParameter("press").trim();
		String clazz = request.getParameter("clazz").trim();
		//处理数据信息
		bname = (bname == null?"":bname);
		press = (press == null?"":press);
		clazz = (clazz == null?"":clazz);
		
		List<Inventory> depots = service.findBookByALL(bname , press ,clazz);
		request.setAttribute("depots", depots);
		this.getDepotName(request); // 获取仓库名信息
		return "f:/admin/depot/depotlist.jsp" ;
	}
	
	private void getDepotName(HttpServletRequest request){
		List<Inventory> depotName = service.findDepotName();
		request.setAttribute("depotName", depotName);
	}

}
