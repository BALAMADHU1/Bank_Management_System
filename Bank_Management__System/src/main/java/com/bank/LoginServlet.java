package com.bank;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple hardcoded admin credentials
        if("admin".equals(username) && "admin".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminName", "Admin");  // store admin name in session
            response.sendRedirect("dashboard.jsp"); // use JSP for dynamic admin name
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3 style='color:red;text-align:center;'>Invalid username or password!</h3>");
            out.println("<a href='login.html'>Go Back</a>");
        }
    }
}
