<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>sys</title>

<script src="${path }/js/jquery-1.9.1.min.js"></script>
<script src="${path }/ckeditor_4.4.3/ckeditor.js"></script>
<script src="${path }/ckeditor_4.4.3/adapters/jquery.js"></script>

<script>
	$(function(){
		$('#editor1').ckeditor();
		var editor = CKEDITOR.instances.editor1;
		editor.setData('');
		
	});
</script>

</head>

<body>

	<form action="" method="post">
		<textarea cols="100" id="editor1" name="editor1" rows="10" >&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;</textarea>
	</form>
	
	
</body>
</html>
