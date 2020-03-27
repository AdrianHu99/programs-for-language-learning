<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
<link rel="stylesheet" type="text/css" href="CSS/select.css">
</head>
<style>



</style>


<body>

<h3>Login Successful!</h3>

<%
//User user = (User) session.getAttribute("user");
User user = (User) request.getAttribute("user");

%>



<%-- 
// we can still use JSTL to do that!
<jsp:useBean id="user" class="Entity.User" scope="request">

</jsp:useBean>

Hello <jsp:getProperty property="userName" name="user"/>

 --%>
 
 <form action="Behave" method="post">
 <div class="container" >
	
	<h2>Hello <%=user.getUserName() %>! Please choose the operation you want to do:</h2>
	
  <ul action="Behave" method="post">
  <li>
    <input type="radio" id="A-option" name="choice" value = "Add">
    <label for="A-option">Add</label>
    
    <div class="check"></div>
  </li>
  
  <li>
    <input type="radio" id="R-option" name="choice" value= "Retrieve">
    <label for="R-option">Retrieve</label>
    
    <div class="check"><div class="inside"></div></div>
  </li>
  
  <li>
    <input type="radio" id="E-option" name="choice" value = "Edit">
    <label for="E-option">Update</label>
    
    <div class="check"><div class="inside"></div></div>
  </li>
  
  <li>
    <input type="radio" id="D-option" name="choice" value = "Delete">
    <label for="D-option">Delete</label>
    
    <div class="check"><div class="inside"></div></div>
    
  </li>
  </ul>

    <input type="submit" id="S-option" name="submit" value = "Submit">
    
    <div class="check"><div class="inside"></div></div>
</div>
</form>
<%-- 

<div class="container">
	<h2>Hello <%=user.getUserName() %>! Please choose the operation you want to do:</h2>
	
	<form action="Behave" method="post">
		<input type="radio" id="choiceA" name="choice" value = "Add"/>
		<label for="choiceA">Add</label> 
		<input type="radio" id="choiceB" name="choice" value= "Retrieve"/>
		<label for="choiceB">Retrieve</label> 
		<input type="radio" id="choiceC" name="choice" value = "Edit"/>
		<label for="choiceC">Edit</label> 
		<input type="radio" id="choiceD" name="choice" value = "Delete"/>
		<label for="choiceD">Delete</label> 
		<input type="submit" name = "submit" value = "Submit" />
	</form>
	
</div> --%>


</body>
</html>