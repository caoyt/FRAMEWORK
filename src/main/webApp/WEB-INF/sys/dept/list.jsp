<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>部门列表</title>

<script src="${path }/js/jquery-1.9.1.min.js"></script>
<script src="${path }/ckeditor_4.4.3/ckeditor.js"></script>
<script src="${path }/ckeditor_4.4.3/adapters/jquery.js"></script>


</head>

<body>

	<div style="border: 1px solid red;">
	
		<table>
			<tr>
				<th>名称</th>
				<th>代码</th>
			</tr>
			

			<c:forEach var="dept" items="${deptList}">
				<tr>
					<td>${dept.name }</td>
					<td>${dept.code }</td>
				</tr>
			</c:forEach>
			
		</table>
		
	</div>
	
	
</body>
</html>
