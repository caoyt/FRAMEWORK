<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>工作流</title>


<script>
	
</script>

</head>

<body>

	<a href="${path }/workflow/pd/processDefinition!addUI.action" target="_blank;">部署流程定义</a>
	<br/><br/><br/>
	<a href="${path }/workflow/pd/processDefinition!list.action" target="_blank;">管理流程定义</a>
	<br/><br/><br/>
	<a href="${path }/web/template/appTemplate!addUI.action" target="_blank;">上传模版</a>
	<br/><br/><br/>
	<a href="${path }/web/template/appTemplate!list.action" target="_blank;">模版管理</a>
	<br/><br/><br/>
	<a href="${path }/web/template/appTemplate!list.action" target="_blank;">发起申请</a>
	<br/><br/><br/>
	<a href="${path }/workflow/handler/workflow!myApplicationList.action" target="_blank;">申请列表</a>
	
	
</body>
</html>
