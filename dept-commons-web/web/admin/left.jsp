<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
	
		d = new dTree('d');
		d.add('01',-1,'仓库管理系统');
		d.add('0101','01','供应商管理','','','mainFrame');
		d.add('010101','0101','添加进货单','${pageContext.request.contextPath}/admin/supplier/needlist.jsp','','mainFrame');
		d.add('010102','0101','货单明细','${pageContext.request.contextPath}/SupplierServlet?method=findorder&state=all','','mainFrame');
		
		d.add('0102','01','仓库管理','','','mainFrame');
		d.add('010201','0102','库存查询','${pageContext.request.contextPath}/DepotServlet?method=selectDepot&depot=all','','mainFrame');
		d.add('010202','0102','客户物流单','${pageContext.request.contextPath}/OrderServlet?method=watchorder&clazz=all','','mainFrame');
		document.write(d);
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
