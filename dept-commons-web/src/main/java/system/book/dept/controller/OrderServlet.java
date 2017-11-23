package system.book.dept.controller;

import system.dept.commons.web.BaseServlet;
import system.dept.entiy.order.Order;
import system.dept.entiy.order.OrderItem;
import system.dept.service.OrderService;
import system.dept.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {

	private OrderService service = new OrderServiceImpl();

	/**
	 * 查询订单入口
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String watchorder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 订单类型
		/**
		 * all表示全部订单 nosend 表示未发货 back 表示退货订单 返回的数据信息 ， 订单表
		 */
		String clazz = request.getParameter("clazz");
		List<Order> orders = service.findOrderInfo(clazz);
		request.setAttribute("orders", orders);
		return "f:/admin/order/clientorder.jsp";
	}
	
	/*---------------------------华丽的分割线-----------------------------------*/

	public String transmit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		Order order = service.checkOrderInfo(orderid);
		List<OrderItem> bookList = service.checkItemInfo(orderid);
		request.setAttribute("order", order);
		request.setAttribute("item", bookList);
		return "f:/admin/order/sendorder.jsp" ;
	}
	
	/**
	 * 发货订单的servlet
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String modifystate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		String comp = request.getParameter("comp");
		if(service.sendOrderDeal(orderid , comp)){
			request.setAttribute("msg", comp + "发送成功");
		} else {
			request.setAttribute("msg", "发送失败、请从新操作！");
		}
		request.setAttribute("index", "OrderServlet?method=watchorder&clazz=all");
		return "f:/admin/finish.jsp" ;
	}
	/**
	 * 退货接收的servlet
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String backorder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		if(service.backOrderDeal(orderid)){
			request.setAttribute("msg", "入库完成");
		} else {
			request.setAttribute("msg", "入库失败、请从新操作！");
		}
		request.setAttribute("index", "OrderServlet?method=watchorder&clazz=all");
		return "f:/admin/finish.jsp" ;
	}
	/*-----------------------------标准分割线---------------------------------------*/
	
	/**
	 * 删除具体的物流订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteorder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		if(service.deletOrderById(orderid)){
			request.setAttribute("msg", "删除成功");
		} else {
			request.setAttribute("msg", "删除失败请从新操作！");
		}
		request.setAttribute("index", "OrderServlet?method=watchorder&clazz=all");
		return "f:/admin/finish.jsp" ;
		
	}
	
	/**
	 * 订单详情列表
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String orderlist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		if(orderid == null){
			return null ;
		}
		Order order = service.checkOrderInfo(orderid);
		List<OrderItem> bookList = service.checkItemInfo(orderid);
		request.setAttribute("order", order);
		request.setAttribute("item", bookList);
		return "f:/admin/order/orderItem.jsp" ;
	}
}
