<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="system.book.depot.inventory.vo.*"%>
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
<!-- 仓库表信息 -->
<!-- 书籍表信息 -->
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tbody>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>库存查询管理</strong>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center">
				仓库地址：
				<a class="hrefA" href="${pageContext.request.contextPath}/DepotServlet?method=selectDepot&depot=all">查询所有</a>
				<c:forEach items="${requestScope.depotName}" var="i">
					<a class="hrefA" href="${pageContext.request.contextPath}/DepotServlet?method=selectDepot&depot=${i.address}">${i.address}</a>
				</c:forEach>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table id="tablelist" cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
							<td align="center" width="5%">书籍名称</td>
							<td align="center" width="5%">书籍类别</td>
							<td align="center" width="5%">书籍出版社</td>
							<td align="center" width="5%">书籍数量</td>
							<td align="center" width="5%">仓库分布</td>
						</tr>
						<c:forEach items="${requestScope.depots}" var="j">
							<tr id="list" style="FONT-SIZE: 12pt; HEIGHT: 25px;">
								<td align="center" width="5%">${j.bname }</td>
								<td align="center" width="5%">${j.clazz }</td>
								<td align="center" width="5%">${j.press }</td>
								<td align="center" width="5%">${j.bnum }</td>
								<td align="center" width="5%">${j.address }</td>						
							</tr>
						</c:forEach>
					</table>
					模糊搜索入口：
					<a class="hrefA" href="${pageContext.request.contextPath}/admin/depot/select.jsp">点击进入</a>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
