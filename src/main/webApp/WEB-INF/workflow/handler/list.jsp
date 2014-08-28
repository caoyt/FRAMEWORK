<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>个人申请列表</title>

<script type="text/javascript">

function approveHistory(applicationId){
	window.location.href = "workflow!approveHistory.action?applicationId="+applicationId;
}
	
</script>

</head>

<body>

	<table style="border: 1px solid red;">
		<tr>
			<th>名称</th>
			<th>审核信息</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${applicationList}" var="list">
			<tr>
				<td style="border:2px solid yellow;">${list.title }</td>
				<td style="border:2px solid yellow;">
					意见：
					<c:forEach items="${list.approveInfo}" var="info">
						${info.comment }||
					</c:forEach>
				</td>
				<td style="border:2px solid yellow;">${list.status }</td>
				<td style="border:2px solid yellow;">
					<a href="javascript:;" onclick="approveHistory('${list.id}');">查看流转记录</a>
				</td>
			</tr>
		</c:forEach>
	</table>
		
		
	
	
</body>
</html>
	