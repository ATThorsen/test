<%-- 
    Document   : FrontPage
    Created on : Oct 2, 2019, 10:55:05 AM
    Author     : casper
--%>

<%@page import="logic.Book"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="database.SQLMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        
        <h2>Search</h2>
        <form action="FrontController">
            <select name="type" size="2">
                <option>title</option>
                <option>author</option>
            </select>
            <input type="text" name="input" value=""/>
            <input type="hidden" name="cmd" value="search">
        
        </form>
        <form action="FrontController">
        <table>
            <tr style="background-color:#b3aea1">
                <th>Title</th>
                <th>Author</th>
                <th>Stock</th>
                <th>Price</th>
                <th>ID</th>
                <th>Checkout</th>
            </tr>
            <%
                ArrayList<HashMap<String, Object>> books = new database.SQLMapper().selectAll("title");
                for (int i = 0; i < books.size(); i++)
                {   %>
                   
                <%Book book = new Book((int)books.get(i).get("id"), (String)books.get(i).get("title"), (String)books.get(i).get("author"), (double)books.get(i).get("price"), (int)books.get(i).get("stock")); %>
            <tr style="background-color:#c9c8c5">
                <td><%=book.getTitle()%></td>
                <td><%=book.getAuthor()%></td>
                <td><%=book.getQty()%></td>
                <td><%=book.getPrice()%></td>
                <td><%=book.getId()%></td>
                <td><input type="checkbox" name="book" value="<%=book%>" /></td>
                <input type="hidden" name="id" value="<%=book.getId()%>"/>

            </tr>
            <%
                }
            %>
            
        </table>
        <input type="submit" value="Checkout" />
        <input type="hidden" name="cmd" value="gocheckout"/>
            
        </form>        
        

    </body>
</html>
