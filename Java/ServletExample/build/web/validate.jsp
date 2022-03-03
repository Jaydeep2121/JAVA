<%-- 
    Document   : validate
    Created on : Dec 5, 2021, 6:16:33 AM
    Author     : Jaydeep Chauhan
--%>
<%@page import="java.sql.*,classfile.DatabaseConnection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validate Page</title>
    </head>
    <body>
        <%
            try{
                Connection cn = DatabaseConnection.initializeDatabase();
                String uname=request.getParameter("uname");
                String password=request.getParameter("pass");
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery("select * from login where user_name='"+ uname +"' and user_pass='"+ password +"'");
                if(rs.next()){
                    HttpSession s = request.getSession();
                    s.setAttribute("sessionusr", uname);
                    response.sendRedirect("memberarea.jsp");
                }else{
                    System.out.println("user not found");
                    response.sendRedirect("LoginJsp.html");
                }
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        %>
    </body>
</html>
