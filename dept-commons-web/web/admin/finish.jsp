<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	type="text/css" rel="stylesheet" />
<style type="text/css">
<!--

body {
	background-color: #FFFFFF;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

body,td,th {
	color: #000000;
}

div{
	width: 100px;
	margin: auto;
}
-->
</style>
<style type="text/css">
BODY {
	SCROLLBAR-FACE-COLOR: #cccccc;
	SCROLLBAR-HIGHLIGHT-COLOR: #ffffFF;
	SCROLLBAR-SHADOW-COLOR: #ffffff;
	SCROLLBAR-3DLIGHT-COLOR: #cccccc;
	SCROLLBAR-ARROW-COLOR: #ffffff;
	SCROLLBAR-TRACK-COLOR: #ffffFF;
	SCROLLBAR-DARKSHADOW-COLOR: #cccccc;
}

h1 {
	text-align: center;
	color: gray;
	font-family: "楷体";
	font-size: 30px;
}
</style>
</head>

<body>
	<form name="Form1" method="post" action="name.aspx" id="Form1">
		<table width="100%" border="0" height="88" border="1"
			background="${pageContext.request.contextPath}/images/back1.JPG">
		</table>
	</form>
	<br />
	<br />
	<h1>${msg}</h1>
	<div>
		<a
			href="${pageContext.request.contextPath}/${index}"><input
			type="button" value="返回列表"></a>
	</div>
</body>
</html>