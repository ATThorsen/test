<%-- 
    Document   : CheckOut
    Created on : Oct 4, 2019, 3:19:35 PM
    Author     : casper
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>
        <%
            //ArrayList<String> books = new ArrayList<>();
            String[]choices = request.getParameterValues("book");
            //books.addAll(session.getAttribute("book"));
        %>
        <h1>Checkout</h1>
        <h3>You have selected</h3>

        <%            for (int i = 0; i < choices.length; i++) {
                out.println(choices[i].toString());%>
                <br>
                <%
            }
        %>

        <form action="FrontController">
            <input type="text" name="firstName" placeholder="FirstName"/>
            <input type="text" name="lastName" placeholder="LastName"/>
            <input type="text" name="email" placeholder="Email"/>
            <input type="hidden" name="orderInfo" value="<%=choices%>"
            <input type="hidden" name="bookID" value="<%=session.getAttribute("bookID")%>"/>
            <input type="submit" value="Order" />
            <input type="hidden" name="cmd" value="processOrder"/>


        </form>  










    </body>
</html>
