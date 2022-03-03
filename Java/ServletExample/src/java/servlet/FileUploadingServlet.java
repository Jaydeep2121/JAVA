/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * @author Jaydeep Chauhan
 */
@WebServlet(name="FileUploadingServlet",urlPatterns={"/FileUploadingServlet"})
@MultipartConfig (
        fileSizeThreshold = 1024*1024*1,//1 mb
        maxFileSize = 1024*1024*10,     //10 mb
        maxRequestSize = 1024*1024*100, //100 mb
        location = "D:\\myfiles"
)
public class FileUploadingServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          Part filepart = request.getPart("upload");
          String filename = filepart.getSubmittedFileName();
          System.out.println(filename);
          for(Part part:request.getParts()){
              part.write(filename);
          }
          response.getWriter().print(filename + "File Uploaded Successfully...!");
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
