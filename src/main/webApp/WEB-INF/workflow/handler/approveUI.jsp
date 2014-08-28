<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>审批处理</title>
<%@include file="/common/publicJs.jsp" %>
<script type="text/javascript">
	function _submit(value){
		$("#approval").val(value);
		$("#approveForm").submit();
	}
</script>

</head>

<body>

	<div style="border: 1px solid red;">
		
		<form id="approveForm" action="${path }/workflow/handler/workflow!approveHandler.action" method="post">
			<input type="hidden" name="applicationId" value="${applicationId }" />	
			<input type="hidden" name="taskId" value="${taskId }" />	
			<input type="hidden" name="approval" id="approval" value="" />	
			
			
			<textarea rows="10" cols="40" name="comment"></textarea>
			<c:if test="${fn:length(outcomes)>1}">
				<select name="outcome">
					<c:forEach items="${outcomes}" var="outcome">
						<option value="${outcome }">${outcome }</option>
					</c:forEach>
				</select>
			</c:if>
			
			<a href="javascript:;" onclick="_submit('true');">同意</a>
			<a href="javascript:;" onclick="_submit('false');">不同意</a>
			
		</form>
		
	</div>
	
	
</body>
</html>
