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
<style type="text/css">
a.hrefA {
	text-decoration: underline;
	color: blue;
	font-size: 12px;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
</head>
<body>
<!-- 本页面需要的数据信息 -->
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tbody>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单查询管理</strong>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="left">
				<!-- 状态超链接 -->
				订单入口：
				<a class="hrefA" href="${pageContext.request.contextPath}/OrderServlet?method=watchorder&clazz=all">全部订单</a>
				<a class="hrefA" href="${pageContext.request.contextPath}/OrderServlet?method=watchorder&clazz=nosend">未发货</a>
				<a class="hrefA" href="${pageContext.request.contextPath}/OrderServlet?method=watchorder&clazz=back">退货订单</a>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table id="tablelist" cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
							<td align="center" width="5%">订单编号</td>
							<td align="center" width="5%">订单类别</td>
							<td align="center" width="5%">客户名称</td>
							<td align="center" width="5%">客户地址</td>
							<td align="center" width="5%">订单状态</td>
							<td align="center" width="5%">快递编号</td>
							<td align="center" width="5%">快递公司</td>
							<td align="center" width="5%">状态操作</td>
							<td align="center" width="5%">便捷操作</td>
							<!-- 订单详情 、 删除订单 、 修改状态 -->
						</tr>
						<c:forEach items="${requestScope.orders}" var="j">
							<tr id="list" style="FONT-SIZE: 12pt; HEIGHT: 25px;">
								<td align="center" width="5%">${j.oid }</td>
								<td align="center" width="5%">${j.clazz }</td>
								<td align="center" width="5%">${j.gname }</td>
								<td align="center" width="5%">${j.gaddress }</td>
								<td align="center" width="5%">${j.ostate }</td>
								<td align="center" width="5%">${j.sendid }</td>
								<td align="center" width="5%">${j.comp }</td>
								<!-- 未处理的连接 -->
								<c:if test="${j.ostate == '未发货' }">
									<td align="center" width="5%">
										<a class="hrefA" href="${pageContext.request.contextPath}/OrderServlet?method=transmit&orderid=${j.oid}">发货</a>
									</td>
								</c:if>
								<c:if test="${j.ostate == '已发出' }">
									<td align="center" width="5%">订单完成</td>
								</c:if>
								<c:if test="${j.ostate == '配送中' }">
									<td align="center" width="5%">
										<a class="hrefA" href="${pageContext.request.contextPath}/OrderServlet?method=backorder&orderid=${j.oid}">确认收货</a>
									</td>
								</c:if>
								<c:if test="${j.ostate == '退货完成' }">
									<td align="center" width="5%">订单完成</td>
								</c:if>
								<!-- 未处理的连接 -->
								<!-- 订单详情 、 删除订单  -->
								<td align="center" width="5%">
									<a class="hrefA" href="${pageContext.request.contextPath}/OrderServlet?method=orderlist&orderid=${j.oid}">查看订单</a>
									<a class="hrefA" href="${pageContext.request.contextPath}/OrderServlet?method=deleteorder&orderid=${j.oid}">删除订单</a>
								</td>				
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>