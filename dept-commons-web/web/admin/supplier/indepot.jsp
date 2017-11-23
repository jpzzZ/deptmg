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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
</head>
<body>
	<!-- 货单展示和仓库的分配问题 -->
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tbody>
			<tr>
				<td class="ta_01" bgColor="#afd1f3"><strong>入库处理：订单编号：${requestScope.way.wid}</strong>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table id="tablelist" cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr style="FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">货物清单</td>
							<td align="center" width="5%"><br /> <%
								 	for (Iterator<BookItem> it = ((List<BookItem>) request
								 			.getAttribute("item")).iterator(); it.hasNext();) {
								 		BookItem bi = it.next();
								 		out.println("<div>" + bi.getBname() + "&nbsp;&nbsp;&nbsp;   X"
								 				+ bi.getBnum() + "<div><br/>");
								 	}
								 %></td>
						</tr>
						<tr style="FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">分配入库</td>
							<td align="center" width="5%" style="FONT-WEIGHT: bold;">
						<form action="${pageContext.request.contextPath}/SupplierServlet" method="post">
								<table>
									<c:forEach items="${requestScope.item}" var="i">
										<tr>
											<div>
												<td>${i.bname}&nbsp;&nbsp;&nbsp;
												<input type="hidden" name="bookid" value="${i.bid}" />
												</td>
												<c:forEach items="${requestScope.depots}" var="j">
													<td>${j.address}<input type="text" name="${j.address}" value="" style="width:30px" /></td>
												</c:forEach>
											</div>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						<tr style="FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="5%" style="FONT-WEIGHT: bold;"
								colspan="2">
								<input type="hidden" name="method" value="indepot" />
								<input type="hidden" name="waybillID" value="${requestScope.way.wid}" />
								<input type="submit" name="分配入库" value="分配入库" />
							</td>
						</tr>
					</table>
					</form>
				</td>
			</tr>

		</tbody>
	</table>
</body>
</html>
