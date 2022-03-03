<%-- 
    Document   : JSPInsert
    Created on : Dec 2, 2021, 12:12:46 PM
    Author     : Jaydeep Chauhan
--%>
<%@page import="java.sql.*,classfile.DatabaseConnection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP InsertPage</title>
    </head>
    <body>
        <%
            HttpSession s=request.getSession();
            String user=(String) s.getAttribute("sessionusr");
            String[] names=user.split("[$]");
        try {
                Connection cn = DatabaseConnection.initializeDatabase();
                PreparedStatement st = cn.prepareStatement("insert into student(name,gender,hobby,email,password,city)values(?,?,?,?,?,?)");
                int k=1;
                for (String sr : names) {
                    st.setString(k, sr);
                    k++;
                }
                int i=st.executeUpdate();
                if(i>0){
                    System.out.print("You are successfully registered...");  
                    response.sendRedirect("registration.jsp");
                }else{
                    System.out.println("No.....!!");
                }
                st.close();
                cn.close();
            }catch(ClassNotFoundException ex) {
                ex.printStackTrace();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        %>
    </body>
</html>
