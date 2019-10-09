<%-- 
    Document   : Confirmation
    Created on : Oct 6, 2019, 9:11:51 PM
    Author     : casper
--%>

<%@page import="database.SQLMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        <h1>Your order has been submitted</h1>
        
        <h3>Order Confirmed</h3>
        
        <%
            
            
           
            
        %>
        <h3>Details:</h3>
        
        <p>First name: <%out.println(session.getAttribute("firstName"));%><br>
        <p>Last name:<%out.println(session.getAttribute("lastName"));%><br>
        <p>Email: <%out.println(session.getAttribute("email"));%><br>
        <p>Selected books:<%out.println(session.getAttribute("bookID"));%>
            
            
           
        
        
        
        
    </body>
</html>
