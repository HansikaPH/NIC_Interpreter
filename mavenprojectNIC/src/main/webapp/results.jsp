<%-- 
    Document   : results
    Created on : Sep 12, 2013, 10:34:19 AM
    Author     : Hansika
--%>

<%@page import="com.mycompany.mavenprojectnic.NIC_Interpreter"%>
<%@page import="com.mycompany.mavenprojectnic.NICprop"%>
<%@page import="com.mycompany.mavenprojectnic.exception.InvalidNicInterpreterException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<h1>NIC interpretation resutls</h1>

<h3>Results of the Nic interpretation </h3>
<%
	String IDNumber = request.getParameter("IDnumber");
	
	NIC_Interpreter calculator = new NIC_Interpreter();
	
	try {
                NICprop prop = calculator.createNICprop(IDNumber);
		calculator.checkValidity( prop );
		calculator.calculateYear();
                calculator.calculateMonth();
                calculator.calculateDay();
                calculator.findVoter();
                
		out.println( calculator.output());
	} catch (InvalidNicInterpreterException ex) {
		out.println(ex.getMessage());
	}	
%>
</head>
<body>

</body>
</html>