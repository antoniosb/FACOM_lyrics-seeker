<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Insert title here</title>
</head>
<body>
	<form id='form' action="Controller" method="GET">
		Input an integer: <input id="value" type="text" name="value"> <br> <input
			type="radio" name="method" value="square" checked> Square <br>
		<input type="radio" name="method" value="factorial"> Factorial<br>
		<input type="submit" value="Calculate">
	</form>
<script type="text/javascript" src="./javascript/script.js"></script>	
</body>
</html>