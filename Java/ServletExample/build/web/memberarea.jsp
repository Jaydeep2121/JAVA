<%-- 
    Document   : memberarea
    Created on : Dec 5, 2021, 6:26:32 AM
    Author     : Jaydeep Chauhan
--%>
<%@page import="java.sql.*,classfile.DatabaseConnection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP MemberArea</title>
    </head>
    <body>
    <center>
        <%
            HttpSession s=request.getSession();
            String user=(String) s.getAttribute("sessionusr");
            if(user==null){
                   session.invalidate();
                   response.sendRedirect("LoginJsp.html");
                   return;
            }
            Connection cn=null;
            Statement st=null;
            ResultSet rs;
            if(request.getParameter("btnup")==null){%>
            <table border='2' cellspacing='8' cellpadding='5'>
            <tr>
                <th>UserName</th><th>Password</th><th colspan="2">Action</th>
            </tr>
            <%
                out.println(user + "<br>LoggedIn Successfully...!<br>");
                try{
                    cn = DatabaseConnection.initializeDatabase();
                    st=cn.createStatement();
                    rs=st.executeQuery("select *from login");
                    while(rs.next()){
                        out.println("<tr><td>"+rs.getString("user_name")+"</td><td>"+rs.getString("user_pass")
                                +"</td><td><form action='memberarea.jsp' method='post'><input type='hidden' name='updid' value='"+rs.getInt("id")+"'><input type='submit' name='btnup' value='Edit'/></form></td>"
                        +"<td><form action='memberarea.jsp' method='post'><input type='hidden' name='id' value='"+rs.getInt("id")+"'><input type='submit' name='btndel' value='Delete'/></form></td></tr>");
                    }
                }catch(ClassNotFoundException ex) {
                    ex.printStackTrace();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }  
        %>
            </table><br>
            <form action='#' method='post'>
                <input type='submit' name='button' value='LogOut'/><br><br>
                <input type='submit' name='first' value='<< First'/>
                <input type='submit' name='last' value='Last >>'/>
                <input type='submit' name='prev' value='< Previous'/>
                <input type='submit' name='next' value='Next >'/>
            </form>  
        <%
            }else{
                cn = DatabaseConnection.initializeDatabase();
                st=cn.createStatement();
                rs=st.executeQuery("select *from login where id='"+request.getParameter("updid")+"'");
                while(rs.next()){
         %>
            <form action="memberarea.jsp" method="POST">
            <center>
            <table border="2"> 
                <tbody>
                <tr>
                    <td>UserName</td>
                    <input type='hidden' name='uid' value="<%= rs.getInt("id")%>">
                    <td><input type="text" value="<%= rs.getString("user_name")%>" name="upd_usr_name" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" value="<%= rs.getString("user_pass")%>" name="upd_usr_pass" /></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Update" name="editsubmit"/>
                        <input type="reset" value="Reset" name="reset" />
                    </td>
                </tr>
                </tbody>
            </table>
        <%    
            }
        }
            if(request.getParameter("button")!=null){
                   session.invalidate();
                   response.sendRedirect("LoginJsp.html");
                   return;
            }
            if(request.getParameter("editsubmit")!=null){
                try {
                     cn = DatabaseConnection.initializeDatabase();
                     PreparedStatement pst = cn.prepareStatement("update login set user_name=?,user_pass=? "
                                             + "where id="+request.getParameter("uid"));
                     pst.setString(1,request.getParameter("upd_usr_name"));
                     pst.setString(2,request.getParameter("upd_usr_pass"));
                     int i=pst.executeUpdate();
                     if(i>0){
                         System.out.print("You are successfully registered...");  
                         response.sendRedirect("memberarea.jsp");
                         return;
                     }else{
                         System.out.println("No.....!!");
                     }
                 }catch(ClassNotFoundException ex) {
                    ex.printStackTrace();
                 }catch(SQLException ex){
                    ex.printStackTrace();
                 }
            }
            if(request.getParameter("btndel")!=null){
                cn = DatabaseConnection.initializeDatabase();
                st=cn.createStatement();
                int i=st.executeUpdate("delete from login where id='"+request.getParameter("id")+"'");
                if(i==1){
                    System.out.println("record deleted...");
                }else{
                    System.out.println("error at delete...");
                }
            }
            int id=0;
            if(request.getParameter("first")!=null){
                try {
                    rs=st.executeQuery("select * from login order by id asc limit 1");
                    rs.next();
                    id=rs.getInt("id");
                    out.print("UserName : "+rs.getString("user_name")+" PassWord : "+rs.getString("user_pass"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }else if(request.getParameter("last")!=null){
                try {
                    rs=st.executeQuery("select * from login order by id desc limit 1");
                    rs.next();
                    id=rs.getInt("id");
                    out.print("UserName : "+rs.getString("user_name")+" PassWord : "+rs.getString("user_pass"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }else if(request.getParameter("prev")!=null){
                try {
                    PreparedStatement pst = cn.prepareStatement("select * from login where id=?");
                    pst.setInt(1, id-1);
                    rs=pst.executeQuery();
                    rs.next();
                    out.print("UserName : "+rs.getString("user_name")+" PassWord : "+rs.getString("user_pass"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }else if(request.getParameter("next")!=null){
                out.print("next");
            }
        %>
    </center>
    </body>
</html>
