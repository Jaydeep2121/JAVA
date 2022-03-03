<%-- 
    Document   : JSPProcessig
    Created on : Dec 2, 2021, 11:31:59 AM
    Author     : Jaydeep Chauhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <center>
            <table border='2' cellspacing='8' cellpadding='5'>
                <tr>
                    <th>Name</th><th>Gender</th><th>Hobby</th><th>Email</th><th>City</th><th>Save</th>
                </tr>
                <% if(request.getParameter("submit")!=null){
                    String name = request.getParameter("name");
                    String gen = request.getParameter("gen");
                    String eml = request.getParameter("email");
                    String pwd = request.getParameter("pass");
                    String city = request.getParameter("city");
                    String[] myhobbies = request.getParameterValues("chk"); 
                    String allhb = "";
                    for (String myhobby : myhobbies){
                        allhb += myhobby + ",";
                    }
                %>
                <tr>
                    <td><%= name %></td>
                    <td><%= gen %></td>
                    <td><%= allhb %></td>
                    <td><%= eml %></td>
                    <td><%= city %></td>
                    <td><form action='JSPProcessig.jsp' method='post'><input type='submit' name='button' value='save'/></form></td>
                <tr>
                <%       
                        String arr = name+"$"+gen+"$"+allhb+"$"+eml+"$"+pwd+"$"+city;
                        HttpSession s = request.getSession();
                        s.setAttribute("sessionusr", arr);
                    }
                    if(request.getParameter("button")!=null){
                        response.sendRedirect("JSPInsert.jsp");
                    }
                %>
            </table>
        </center>
    </body>
</html>
