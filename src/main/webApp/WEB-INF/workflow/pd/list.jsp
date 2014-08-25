<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>审批流程管理</title>

<script type="text/javascript">
	function delPdImage(key){
		window.location.href = "processDefinition!deleteByKey.action?key="+encodeURI(encodeURI(key));  
	}


	function lookPdImage(pd_id){
		var url = "processDefinition!downloadProcessImage.action?processDefinitionId="+encodeURI(encodeURI(pd_id))+"&date="+new Date();
		window.open(url);
	}		
	
</script>

</head>

<body>

	<table style="border: 1px solid red;">
		<tr>
			<th>流程名称</th>
			<th>最新版本</th>
			<th>说明</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${listPd}" var="pd">
			<tr>
				<td style="border:2px solid yellow;">${pd.name }</td>
				<td style="border:2px solid yellow;">${pd.version }</td>
				<td style="border:2px solid yellow;">${pd.description }</td>
				<td style="border:2px solid yellow;">
					<a href="javascript:;" onclick="delPdImage('${pd.key}');">删除</a>||
					<a href="javascript:;" onclick="lookPdImage('${pd.id}');">查看流程图</a>
				</td>
			</tr>
		</c:forEach>
	</table>
		
		
	
	
</body>
</html>
