<%-- 
    Document   : SearchResults
    Created on : Oct 4, 2019, 12:40:57 PM
    Author     : casper
--%>

<%@page import="javax.lang.model.element.Element"%>
<%@page import="javax.lang.model.util.Elements"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.Book" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search results</title>
    </head>
    <body>

        <% String input = (String) session.getAttribute("input");
            String type = (String) session.getAttribute("type");%>
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
                ArrayList<HashMap<String, Object>> books = new database.SQLMapper().selectSearch(input, type);
                for (int i = 0; i < books.size(); i++) {%>
                
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
