<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.adrian.login.dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>

<h3>Login Successful!</h3>

<%
//User user = (User) session.getAttribute("user");
User user = (User) request.getAttribute("user");

%>

Hello <%=user.getUserName() %>!

<%-- 
// we can still use JSTL to do that!
<jsp:useBean id="user" class="org.adrian.login.dto.User" scope="request">

</jsp:useBean>

Hello <jsp:getProperty property="userName" name="user"/>

 --%>


</body>
</html>