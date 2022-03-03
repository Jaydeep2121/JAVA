<%-- 
    Document   : RetrieveJsp
    Created on : Nov 30, 2021, 11:39:08 AM
    Author     : Jaydeep Chauhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String dburl=(String)application.getAttribute("dburl");
            System.out.println("DBurl is :"+dburl);
        %>
    </body>
</html>
