<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>审批流转</title>

<script type="text/javascript">
		
	
</script>

</head>

<body>

	<table style="border: 1px solid red;">
		<tr>
			<th>审批人</th>
			<th>审批时间</th>
			<th>是否通过</th>
			<th>审批意见</th>
		</tr>
		<c:forEach items="${approveHistory}" var="list">
			<tr>
				<td style="border:2px solid yellow;">${list.sysUser.name }</td>
				<td style="border:2px solid yellow;">${list.approveTime}</td>
				<td style="border:2px solid yellow;">
					<c:if test="${list.approval==true}">
						通过
					</c:if>
					<c:if test="${list.approval==false}">
						不通过
					</c:if>
				</td>
				<td style="border:2px solid yellow;">${list.comment}</td>
			</tr>
		</c:forEach>
	</table>
		
		
	
	
</body>
</html>
	