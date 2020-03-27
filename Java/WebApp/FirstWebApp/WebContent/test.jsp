<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adrian </title>
</head>
<body>
<h3>
testing jsp!!!!!</h3>


<%
int i = 1;
int j = 2;
int k = i + j;
out.println("the value of k is " + k);


%>

The value of k is:<%=k %>

The value of k is:<%=1+2 %>


<%!

public int add(int a , int b){
	return a+b;
}
%>



<%
k=add(232342,23423);

%>

The value of k is:<%=k %>!!!






<%
for(int l = 0; l < 5; l++){
%>

<br> The value of l is <%=l %>

<%
}%>
</body>
</html>