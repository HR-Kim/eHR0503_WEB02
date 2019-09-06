<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_mng</title>
</head>
<body>
	<h3>user_mng</h3>
	<hr/>
	<form action="get_selectone.do" method="get">
		이름:<input type="text"  name="name" size="15" /><br/>
		성별:<input type="text"  name="sex" size="15" /><br/>
		전화:<input type="text"  name="tel" size="15" /><br/>
		나이:<input type="text"  name="age" size="15" /><br/>
		휴대:<input type="text"  name="cell_phone" size="15" /><br/>
		<input type="submit"    name="전송"  />
	</form>

	<c:if test="${vo.name !='' }">
		이름:${vo.name}<br/>
		성별:${vo.sex}<br/>
		전화:${vo.tel}<br/>
		나이:${vo.age}<br/>
		휴대:${vo.cell_phone}<br/>
	</c:if>


</body>
</html>