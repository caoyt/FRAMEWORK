<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>上传模版</title>


</head>

<body>

	<div style="border: 1px solid red;">
	
		<form action="${path }/web/template/appTemplate!uploadHandler.action" method="post" enctype="multipart/form-data">
			
			<select name="processDefinitionKey">
				<c:forEach items="${pdList}" var="pd">
					<option value="${pd.key }">${pd.name }</option>
				</c:forEach>
			</select>
			<br/>
			
			<input type="text" name="name"/><br/>
			
			<input type="file" name="upload"/><br/>
			
			<input type="submit" value="上传" />				
			
		</form>
		
	</div>
	
	
</body>
</html>
