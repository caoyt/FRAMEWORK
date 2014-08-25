<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>添加流程定义</title>


</head>

<body>

	<div style="border: 1px solid red;">
	
		<form action="${path }/workflow/pd/processDefinition!deploy.action" method="post" enctype="multipart/form-data">
			
			<input type="file" name="upload"/>
			
			<input type="submit" value="上传" />				
			
		</form>
		
	</div>
	
	
</body>
</html>
