<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>分配用户</title>

<script src="${path }/js/jquery-1.9.1.min.js"></script>
<script src="${path }/ckeditor_4.4.3/ckeditor.js"></script>
<script src="${path }/ckeditor_4.4.3/adapters/jquery.js"></script>


</head>

<body>

	<div style="border: 1px solid red;">
	
		<form action="${path }/sys/user/sysUser!addUser.action" method="post">
			用户真实姓名:<input type="text" name="name" /> <br/>
			登录名:<input type="text" name="loginName" /><br/>
			密码:<input type="password" name="password" /><br/>
			性别:<input type="radio" name="gender" value="1" />男
			<input type="radio" name="gender" value="2" />女<br/>
			手机号:<input type="text" name="phoneNumber" /><br/>
			邮箱:<input type="text" name="email" /><br/>
			描述:<input type="text" name="description" /><br/>

			<input type="submit" value="分配" />				
			
		</form>
		
	</div>
	
	
</body>
</html>
