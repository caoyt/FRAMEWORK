<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>模版管理</title>

<script type="text/javascript">
	
	function downloadF(id){
		window.location.href="appTemplate!downloadHandler.action?id="+id;
	}

	function del(id){
		window.location.href="appTemplate!delTemplate.action?appTemplateId="+id;
	}

</script>

</head>

<body>

<table>
	<c:forEach items="${appTemplateList}" var="list">
		<tr>
			<td><a href="${path }/workflow/handler/workflow!addUI.action?templateId=${list.id}">${list.name }</a></td>
			<td>
				<a href="javascript:;" onclick="del('${list.id }');">删除</a>
				<a href="javascript:;" onclick="downloadF('${list.id}');">下载</a>
				
			</td>
		</tr>
	</c:forEach>
</table>



	
	
	
</body>
</html>
