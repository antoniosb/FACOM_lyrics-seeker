<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller" method="GET">
		Input an integer: <input type="text" name="value"> <br> <input
			type="radio" name="method" value="square" checked> Square <br>
		<input type="radio" name="method" value="factorial"> Factorial<br>
		<input type="submit" value="Calculate">
	</form>
</body>
</html>