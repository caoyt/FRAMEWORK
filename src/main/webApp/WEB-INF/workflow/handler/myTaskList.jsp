<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@include file="/common/publicJs.jsp" %>


<title>个人任务列表</title>

<script type="text/javascript">

	//审批处理UI	
	function approveUI(applicationId, taskId){
		window.location.href = "workflow!approveUI.action?applicationId="+applicationId+"&taskId="+taskId;		
	}

	function approveHistory(applicationId){
		window.location.href = "workflow!approveHistory.action?applicationId="+applicationId;
	}

</script>

</head>

<body>

	<table style="border: 1px solid red;">
		<tr>
			<th>标题</th>
			<th>申请人</th>
			<th>申请日期</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${taskView}" var="list">
			<tr>
				<td style="border:2px solid yellow;">${list.application.title }</td>
				<td style="border:2px solid yellow;">${list.application.sysUser.name }</td>
				<td style="border:2px solid yellow;"><fmt:formatDate value="${list.application.applyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td style="border:2px solid yellow;">
					<a href="javascript:;" onclick="approveUI('${list.application.id}','${list.task.id }');">审批处理</a>
						||
					<a href="javascript:;" onclick="approveHistory('${list.application.id}');">查看流转记录</a>
				</td>
			</tr>
		</c:forEach>
	</table>
		
		
	
	
</body>
</html>
	