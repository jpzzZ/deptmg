<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="system.book.depot.supplier.vo.*"%>
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
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tbody>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>供货单详情查询</strong>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="left">
				<!-- 状态超链接 -->
				货单入口：
				<a class="hrefA" href="${pageContext.request.contextPath}/SupplierServlet?method=findorder&state=all">查询所有</a>
				<a class="hrefA" href="${pageContext.request.contextPath}/SupplierServlet?method=findorder&state=采购中">采购中</a>
				<a class="hrefA" href="${pageContext.request.contextPath}/SupplierServlet?method=findorder&state=已到货">已到货</a>
				<a class="hrefA" href="${pageContext.request.contextPath}/SupplierServlet?method=findorder&state=已入库">已入库</a>
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
							<td align="center" width="5%">订单状态</td>
							<td align="center" width="5%">供应商信息</td>
							<td align="center" width="5%">仓库信息</td>
							<td align="center" width="5%">订单创建日期</td>
							<td align="center" width="5%">订单完成日期</td>
							<td align="center" width="5%">选择操作</td>
							<td align="center" width="5%">删除操作</td>
						</tr>
						<c:forEach items="${requestScope.waybills}" var="i">
							<tr id="list" style="FONT-SIZE: 12pt; HEIGHT: 25px;">
								<td align="center" width="5%">${i.wid }</td>
								<td align="center" width="5%"><font color="red">${i.wstate}</font></td>
								<td align="center" width="5%">${i.wname }</td>
								<td align="center" width="5%">${i.address }</td>
								<td align="center" width="5%">${i.sdate }</td>
								<!-- 完成日期的处理 -->
								<c:if test="${i.fdate ==null }">
									<td align="center" width="5%">未完成</td>
								</c:if>
								<c:if test="${i.fdate !=null}">
									<td align="center" width="5%">${i.fdate }</td>
								</c:if>

								<!-- 操作入口 -->
								<c:if test='${i.wstate.equals("采购中") }'>
									<td align="center" width="5%">
									<a class="hrefA" href="${pageContext.request.contextPath}/SupplierServlet?method=modifyorder&waybill=${i.wid}">收货</a>
									</td>
								</c:if>
								<c:if test='${i.wstate.equals("已到货") }'>
									<td align="center" width="5%">
									<a class="hrefA" href="${pageContext.request.contextPath}/SupplierServlet?method=watchorder&type=modify&waybill=${i.wid}">选择入库</a>
									</td>
								</c:if>
								<c:if test='${i.wstate.equals("已入库") }'>
									<td align="center" width="5%">订单完成</td>
								</c:if>
								
								<!-- 删除按钮 -->
								<td align="center" width="5%">
									<a class="hrefA" href="${pageContext.request.contextPath}/SupplierServlet?method=watchorder&type=watch&waybill=${i.wid}">查看订单</a>
									<a class="hrefA" href="${pageContext.request.contextPath}/SupplierServlet?method=deleteorder&waybill=${i.wid}">删除订单</a>
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
