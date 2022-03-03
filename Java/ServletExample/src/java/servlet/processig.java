/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jaydeep Chauhan
 */
public class processig extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            if(request.getParameter("submit")!=null){
                String name = request.getParameter("name");
                String gen = request.getParameter("gen");
                String[] myhobbies = request.getParameterValues("chk");
                String eml = request.getParameter("email");
                String pwd = request.getParameter("pass");
                String city = request.getParameter("city");
                String allhb = "";
                for (String myhobby : myhobbies){
                    allhb += myhobby + ",";
                }
                PrintWriter out = response.getWriter();
                out.println("<html>"
                                + "<body><center><table border='2' cellspacing='8' cellpadding='5'>"
                                    + "<tr>"
                                         + "<th>Name</th><th>Gender</th><th>Hobby</th><th>Email</th><th>City</th><th>Save</th>"
                                    + "</tr>"
                                    + "<tr>"
                                        + "<td>"+ name +"</td>"
                                        + "<td>"+ gen +"</td>"
                                        + "<td>"+ allhb +"</td>"
                                        + "<td>"+ eml +"</td>"
                                        + "<td>"+ city +"</td>"
                                        + "<td><form action='processig' method='post'><input type='submit' name='button' value='save'/></form></td>"
                                    + "<tr></table></center></body>"
                          + "</html>");                    
                    String arr = name+"$"+gen+"$"+allhb+"$"+eml+"$"+pwd+"$"+city;
                    HttpSession s = request.getSession();
                    s.setAttribute("sessionusr", arr);
            }
            if(request.getParameter("button")!=null){
                   response.sendRedirect("insert");
            }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
