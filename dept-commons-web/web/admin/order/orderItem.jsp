<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="system.book.depot.order.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
</head>

<body>
	<!-- 列出订单详情的页面 -->
	<br>
	<table cellSpacing="1" cellPadding="0" width="80%" align="center"
		bgColor="#f5fafe" border="0">
		<tbody>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>客户订单详情</strong>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table id="tablelist" cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 80%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr style="FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">订单编号</td>
							<td align="center" width="5%">${requestScope.order.oid}</td>
						</tr>
						<tr style="FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">订单类别</td>
							<td align="center" width="5%">${requestScope.order.clazz}</td>
						</tr>
						<tr style=" FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">客户姓名</td>
							<td align="center" width="5%">${requestScope.order.gname}</td>
						</tr>
						<tr style=" FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">客户地址信息</td>
							<td align="center" width="5%">${requestScope.order.gaddress}</td>
						</tr>
						<tr style="FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">订单状态</td>
							<td align="center" width="5%">${requestScope.order.ostate}</td>
						</tr>
						<tr style=" FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">快递单号</td>
							<td align="center" width="5%">${requestScope.order.sendid}</td>
						</tr>
						<tr style=" FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">快递公司</td>
							<td align="center" width="5%">${requestScope.order.comp}</td>
						</tr>
						<tr style="FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">订单详情</td>
							<td align="center" width="5%">
								<%
									for (Iterator<OrderItem> it = ((List<OrderItem>) request
											.getAttribute("item")).iterator(); it.hasNext();) {
										OrderItem bi = it.next();
										out.println("<div>" + bi.getBname() + "   X" + bi.getBnum()
												+ "<div>");
									}
								%>
							</td>
						</tr>
					</table>
					<div>
						<a
							href="${pageContext.request.contextPath}/admin/order/clientorder.jsp"><input
							type="button" value="返回列表"></a>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
