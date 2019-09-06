<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String context = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File</title>

<script src="<%=context%>/resources/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		console.log("ready");
	});
</script>
</head>
<body>
	<h3>File Upload</h3>
	<hr/>
	<form action="do_save.do" method="post" enctype="multipart/form-data">
		파일1:<input type="file" name="file01" /><br/>
		파일2:<input type="file" name="file02" /><br/>
		작업구분:<input type="text" name="work_div" size="15"><br/>
		<input type="submit" value="전송" />
	
	</form>
	${fileList}
</body>
</html>