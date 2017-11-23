package system.book.dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import system.dept.commons.web.BaseServlet;
import system.dept.entiy.supplier.BookItem;
import system.dept.entiy.supplier.OrderDepot;
import system.dept.entiy.supplier.Waybill;
import system.dept.service.SupplierService;
import system.dept.service.impl.SupplierServiceImpl;

public class SupplierServlet extends BaseServlet {

	private SupplierService service = new SupplierServiceImpl();
	
	/**
	 * 完成收货操作
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String modifyorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String waybill = request.getParameter("waybill");
		if(waybill == null){
			return null ;
		}
		if(service.modifyWaybill(waybill , "已到货")){
			request.setAttribute("msg", "收货成功");
		} else {
			request.setAttribute("msg", "收货失败,请重新操作");
		}
		request.setAttribute("index", "SupplierServlet?method=findorder&state=all");
		return "f:/admin/finish.jsp" ;
	}
	
	/**
	 * 查看订单详情页面的加载和入库页面的基本信息加载页面
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String watchorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request = this.getOrderItem(request);
		if("modify".equals(request.getParameter("type"))){
			//加载入库页面所需要的信息
			request = this.getOrderItem(request);
			List<OrderDepot> depots = service.findDepotInfo();
			request.setAttribute("depots", depots);
			return "f:/admin/supplier/indepot.jsp" ;
		} else if ("watch".equals(request.getParameter("type"))) {
			return "f:/admin/supplier/orderItem.jsp" ;
		}
		return null ;
	}
	/**
	 * 入库操作的servlet
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String indepot(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//货去本此订单的编号
		String waybillID = request.getParameter("waybillID");
		//获取仓库的地址信息
		List<String> depotNameList = new ArrayList<>() ;
		String s = null ;
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()){
			if((s = e.nextElement()).endsWith("仓库")){
				depotNameList.add(s);
			}
		}
		String[] depotName = depotNameList.toArray(new String[0]);
		String[] bookid = request.getParameterValues("bookid");
		List<String[]> depotSize = new ArrayList<>(); 
		
		for (int j = 0; j < depotName.length; j++) {
			String[] depotValue = request.getParameterValues(depotName[j]);
			depotSize.add(depotValue);
		}
		service.addDepotInfo(bookid, depotName , depotSize ,waybillID);
		request.setAttribute("msg", "入库成功");
		request.setAttribute("index", "SupplierServlet?method=findorder&state=all");
		return "f:/admin/finish.jsp" ;
	}
	
	/**
	 * 相关的订单详情的servlet
	 * @param request
	 * @return
	 */
	private HttpServletRequest getOrderItem(HttpServletRequest request){
		String waybill = request.getParameter("waybill");
		if(waybill == null){
			return null ;
		}
		Waybill way = service.checkWaybillInfo(waybill);
		List<BookItem> bookList = service.checkItemInfo(waybill);
		request.setAttribute("way", way);
		request.setAttribute("item", bookList);
		return request;
	}
	
	/**
	 * 删除订单的服务
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String waybill = request.getParameter("waybill");
		if(waybill == null){
			return null ;
		}
		if(service.deleteWaybillById(waybill)){
			request.setAttribute("msg", "删除成功");
		} else {
			request.setAttribute("msg", "删除失败,请重新操作");
		}
		request.setAttribute("index", "SupplierServlet?method=findorder&state=all");
		return "f:/admin/finish.jsp" ;
	}

	
	
	/**
	 * 查找供应商订单的servlet
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String state = request.getParameter("state");
		if(state == null){
			return null ;
		}
		List<Waybill> waybills = service.findOrderList(state);
		request.setAttribute("waybills", waybills);
		return "f:/admin/supplier/orderlist.jsp" ;
	}

	/**
	 * 添加订单的servlet服务
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] book = request.getParameterValues("book");
		String[] num = request.getParameterValues("num");
		String wname = request.getParameter("wname");
		
		if(book == null || num == null || wname == null){
			return null ;
		}

		if("".equals(wname)){
			request.setAttribute("msg", "添加失败，没有加入供应商信息，请从新操作");
			request.setAttribute("index", "admin/supplier/needlist.jsp");
			return "f:/admin/finish.jsp";
		}
		if (service.addBookList(book, num , wname)) {
			request.setAttribute("msg", "添加成功");
		} else {
			request.setAttribute("msg", "添加失败，请从新操作");
		}
		request.setAttribute("index", "admin/supplier/needlist.jsp");
		return "f:/admin/finish.jsp";
	}

	/**
	 * 加载添加订单的图书列表ajax请求
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loadbook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<BookItem> list = service.loadBookInf();
		response.getWriter().write(new Gson().toJson(list));
		return null;
	}

	/**
	 * 分页函数
	 * @param req
	 * @return
	 */
	private int getPc(HttpServletRequest req) {
		int pc = 1;
		String param = req.getParameter("pc");
		if (param != null && !param.trim().isEmpty()) {
			try {
				pc = Integer.parseInt(param);
			} catch (RuntimeException e) {
			}
		}
		return pc;
	}

}
