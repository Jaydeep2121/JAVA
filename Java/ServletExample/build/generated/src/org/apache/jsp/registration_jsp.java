package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Registration</title>\n");
      out.write("        <style>\n");
      out.write("            input[type=\"submit\"],input[type=\"reset\"]{\n");
      out.write("                border: none;\n");
      out.write("                text-align: center;color: white;\n");
      out.write("                background-color: #008CBA;\n");
      out.write("                padding: 15px 10px;\n");
      out.write("                font-size: 17px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            input[type=\"text\"],input[type=\"password\"],input[type=\"email\"],select{\n");
      out.write("                border-radius: 5px;\n");
      out.write("                padding: 5px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("        <form action=\"JSPProcessig.jsp\" method=\"post\" name=\"register\">\n");
      out.write("            <h1>Student Registration</h1>\n");
      out.write("            <table border=\"2\" cellspacing=\"8\" cellpadding=\"5\" style=\"border-radius: 10px;\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><b>Name</b></td>\n");
      out.write("                    <td> <input type=\"text\" name=\"name\" /> </td>\n");
      out.write("                </tr>   \n");
      out.write("                <tr>\n");
      out.write("                    <td><b>Gender</b></td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"radio\" name=\"gen\" value=\"male\"/>Male\n");
      out.write("                        <input type=\"radio\" name=\"gen\" value=\"female\"/>Female\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><b>Hobby</b></td>\n");
      out.write("                    <td>\n");
      out.write("                        Cricket<input type=\"checkbox\" name=\"chk\" value=\"cricket\"/>\n");
      out.write("                        Running<input type=\"checkbox\" name=\"chk\" value=\"running\"/>\n");
      out.write("                        Driving<input type=\"checkbox\" name=\"chk\" value=\"driving\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><b>Email</b></td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"email\" name=\"email\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><b>Password</b></td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"password\" name=\"pass\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><b>City</b></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"city\">\n");
      out.write("                            <option>Surat</option>\n");
      out.write("                            <option>Mumbai</option>\n");
      out.write("                            <option>Pune</option>\n");
      out.write("                            <option>Banglore</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"submit\" value=\"Submit\" name=\"submit\" />\n");
      out.write("                    <input type=\"reset\" value=\"Clear\" name=\"reset\" />\n");
      out.write("                </td>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
