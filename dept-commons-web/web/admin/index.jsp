<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>物流库存管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/login.css">
</head>
<body>
	<section class="container">
	<div class="login">
		<h1>用户登录</h1>
		<form method="post"
			action="${pageContext.request.contextPath }/UserServlet"
			target="_parent" name='theForm' onsubmit="return validate()">
			<p>
				<font color="red">${msg}</font>
			</p>
			<p>
				<input type="text" name="uname" value="" placeholder="用户名">
			</p>
			<p>
				<input type="password" name="pwd" value="" placeholder="密码">
			</p>
			<input type="hidden" value="login" name="method"/>
			<p class="submit">
				<input type="submit" name="commit" value="登录">
			</p>
		</form>
	</div>
	<div class="login-help">
		<p>后台物流仓库管理系统</p>
	</div>
	</section>
	<div style="text-align:center;"></div>
</body>
<script language="JavaScript">
<!--
	document.forms['theForm'].elements['uname'].focus();
	/**
	 * 检查表单输入的内容
	 */
	function validate() {
		var validator = new Validator('theForm');
		validator.required('uname', user_name_empty);
		if (document.forms['theForm'].elements['captcha']) {
			validator.required('captcha', captcha_empty);
		}
		return validator.passed();
	}
//-->
</script>
</html>