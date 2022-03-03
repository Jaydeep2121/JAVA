/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

//import classfile.DatabaseConnection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Jaydeep Chauhan
 */
public class insert extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String dbdriver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/mca5";
            HttpSession s=request.getSession();
            String user=(String) s.getAttribute("sessionusr");
            String[] names=user.split("[$]");
        try {
                Class.forName(dbdriver);
                Connection cn=DriverManager.getConnection(url,"root","");
//                Connection cn = DatabaseConnection.initializeDatabase();
                PreparedStatement st = cn.prepareStatement("insert into student(name,gender,hobby,email,password,city)values(?,?,?,?,?,?)");
                int k=1;
                for (String sr : names) {
                    st.setString(k, sr);
                    k++;
                }
                int i=st.executeUpdate();
                if(i>0){
                    System.out.print("You are successfully registered...");  
                    response.sendRedirect("registration.html");
                }else{
                    System.out.println("No.....!!");
                }
                st.close();
                cn.close();
            }catch(ClassNotFoundException | SQLException ex) {
                Logger.getLogger(processig.class.getName()).log(Level.SEVERE, null, ex);
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
