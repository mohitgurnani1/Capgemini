<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>

		<%-- <%=??%> --%>
		
		<jsp:useBean id="message"    class="java.lang.String"                   scope= "page" />
 		
		${message}
			${requestScope.message}
			${sessionScope.message}
			
			
				
		<!-- EL can have either attributes or implicit objects -->
		
		

</h1>





</body>
</html>