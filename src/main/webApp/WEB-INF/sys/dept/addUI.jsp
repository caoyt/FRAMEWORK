<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>添加部门</title>



</head>

<body>

	<div style="border: 1px solid red;">
	
		<form action="${path }/sys/dept/sysDept!addDept.action" method="post">
			上级部门:<select name="parent_id">
				<option value="1">海淀区</option>
				<option value="2">朝阳区</option>
			</select> <br/>
			部门名称:<input type="text" name="name" /><br/>
			代码:<input type="text" name="code" /><br/>
			部门描述:<input type="text" name="description" /><br/>
			

			<input type="submit" value="保存" />				
			
		</form>
		
	</div>
	
	
</body>
</html>
