/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfile;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Jaydeep Chauhan
 */
public class ServletListenerDemo implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String url = ctx.getInitParameter("DBURL");
    	String u = ctx.getInitParameter("DBUSER");
    	String p = ctx.getInitParameter("DBPWD");
        System.out.println(url+"\n"+u+"\n"+p);
        try {
            DatabaseConnection dbc=(DatabaseConnection) DatabaseConnection.initializeDatabase();
            ctx.setAttribute("Connection", dbc);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServletListenerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("DatabaseConnection Established for App.........");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        try {
            DatabaseConnection dbc = (DatabaseConnection) ctx.getAttribute("Connection");
            dbc.closeConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletListenerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Database connection closed for Application........");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
