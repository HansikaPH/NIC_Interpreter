<%-- 
    Document   : results
    Created on : Sep 12, 2013, 10:34:19 AM
    Author     : Hansika
--%>

<%@page import="com.mycompany.mavenprojectnic.NIC_Interpreter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
<h1>NIC interpretation resutls</h1>

<h3>Result of NIC Interpretation is</h3>
<%
	String IDNumber = request.getParameter("IDNumber");
	
	NIC_Interpreter calculator = new NIC_Interpreter(IDNumber);
	
	try {
		BmiProp bmiProp = bmiCalculator.createBmiProp(height, weight);
		float bmi = bmiCalculator.calculate(bmiProp);
		out.println(bmi);
	} catch (InvalidBmiPropException ex) {
		out.println(ex.getMessage());
	}	
%>
</head>
<body>

</body>
</html>