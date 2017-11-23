<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>模糊搜索</title>
<style type="text/css">
body {
	background-color: #eee ;
}
table {
	color: #404040;
	font-size: 10pt;
}
</style>
</head>

<body>
	<br/><br/><br/><br/><br/><br/>
	<form action="<c:url value='/DepotServlet'/>" method="post">
		<input type="hidden" name="method" value="findByDim" />
		<table align="center">
			<tr>
				<td>书名：</td>
				<td><input type="text" name="bname" /></td>
			</tr>
			<tr>
				<td>出版社：</td>
				<td><input type="text" name="press" /></td>
			</tr>
			<tr>
				<td>书籍类别：</td>
				<td><input type="text" name="clazz" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="搜　　索" /> 
				&nbsp;&nbsp;
				<input type="reset" value="重新填写" /></td>
			</tr>
		</table>
		<div style="height: 80px" align="center" >
			<font color="blue" >支持精确搜索以及模糊搜索</font>
		</div>
	</form>
</body>
</html>
