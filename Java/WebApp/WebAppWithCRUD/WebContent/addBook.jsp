<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create a new book</title>
<link rel="stylesheet" type="text/css" href="CSS/AddBook.css">
</head>



<body>
Please input the information of the book you want to add:
<hr>
<form action="addBook" method="post">


	<br>Name: <input type="text" name="Name" />
	<br>Author: <input type="text" name="Author" />
	<br>Pages: <input type="text" name="Pages" />
	<br>
	<div class="selectholder">State: 
	<select name="State" id="State" >
		<option value="0">State of the book</option>
		<option value="Unbooked">Unbooked</option>
      	<option value="Booked">Booked</option>
    </select>
    </div>
<!-- 	<input type="radio" name="State" value="UnBooked">Unbooked</input>
	<input type="radio" name="State" value="Booked">Booked</input> -->
	<br>Pub_Date<input type="text" name="Pub_Date" pattern="MM-dd-yyyy" />
	<input type="submit" />

</form>


</body>
</html>


