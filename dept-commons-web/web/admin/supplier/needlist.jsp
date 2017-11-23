<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	//加载数据库书籍的操作
	$(document).ready(function() {
		getBook();
	})
	function getBook(){
		$.get("/DepotMgr/SupplierServlet", {
			method : "loadbook"
		}, function(date) {
			eval("var areas=" + date);
			var pro = $("#book");
			pro.empty();
			for (var i = 0; i < areas.length; i++) {
				pro.append("<option value=" +areas[i].bid +">"
						+ areas[i].bname + "</option>");
			}
		})	
	}
	function add() {
		var tablelist = $("#tablelist");
		var list = $("#list");
		tablelist.html(tablelist.html() + list.html());
	}
</script>
</head>
<body>
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tbody>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>添加进货单</strong>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<form action="${pageContext.request.contextPath}/SupplierServlet"
						method="get">
						<table>
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px;">
								<td align="right" width="5%">供应商信息:</td>
								<td align="left" width="5%">
								<input type="text" name="wname" style="width:120px" /></td>
							</tr>
						</table>
						<table id="tablelist" cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 60%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="5%">请选择书籍名称</td>
								<td align="center" width="5%">请输入书籍数量</td>
							</tr>
							<tr id="list" style="FONT-SIZE: 12pt; HEIGHT: 25px;">
								<td align="center" width="5%">书籍名称 ： <select name="book"
									id="book">
								</select>
								</td>
								<td align="center" width="5%">书籍数量: <input type="text"
									name="num" style="width:30px" /></td>
							</tr>
						</table>
						<input type="hidden" name="method" id="method" value="order" />
						<button onclick="add(); return false;">添加一行</button>
						<input type="submit" name="提交" id="提交" value="提交订单" />
					</form>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>

