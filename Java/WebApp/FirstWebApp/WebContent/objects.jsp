<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String userName = request.getParameter("name");

if(userName != null){
	session.setAttribute("sessionUserName", userName);
	//application.setAttribute("applicationUserName",userName);
	pageContext.setAttribute("pageContextUserName", userName);
	pageContext.setAttribute("applicationUserName", userName, pageContext.APPLICATION_SCOPE);
	

}
%>

<br> 
the user name in the request is <%=userName %>
<br>
User name in the session object is <%=session.getAttribute("sessionUserName") %>
<br> 
User name in the context object is <%=application.getAttribute("applicationUserName") %>
<br> 
User name in the page context object is <%=pageContext.getAttribute("pageContextUserName") %>



</body>
</html>