<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	application.setAttribute("path", path);
%>
<script type="text/javascript">location.replace('sys/sysUser!index.action')</script>

