package com.bank;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String adminName = (String) session.getAttribute("adminName");
        String adminEmail = (String) session.getAttribute("adminEmail");
        if(adminName == null){
            response.sendRedirect("login.html");
            return;
        }

        String message = (String) session.getAttribute("message");
        if(message != null){
            out.println("<h3 style='color:green; text-align:center;'>" + message + "</h3>");
            session.removeAttribute("message");
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Admin Dashboard | SBI Bank</title>");
        out.println("<link rel='stylesheet' href='" + request.getContextPath() + "/style.css'>");
        out.println("</head>");
        out.println("<body>");

        // Admin Header
        out.println("<header>");
        out.println("<div class='bank-name'>SBI Bank</div>");
        out.println("<div class='actions'>");
        out.println("<div class='profile'><img src='https://cdn-icons-png.flaticon.com/512/3135/3135715.png'> " + adminName + "<span>" + adminEmail + "</span></div>");
        out.println("<button onclick=\"location.href='LogoutServlet'\">Logout</button>");
        out.println("</div></header>");

        // Dashboard buttons
        out.println("<div class='container'>");
        out.println("<h2>Welcome, " + session.getAttribute("adminName") + "!</h2>");
        out.println("<div class='button-group'>");
        out.println("<button onclick=\"location.href='create_account.html'\">Create Account</button>");
        out.println("<button onclick=\"location.href='deposit.html'\">Deposit</button>");
        out.println("<button onclick=\"location.href='withdraw.html'\">Withdraw</button>");
        out.println("<button onclick=\"location.href='transaction.html'\">Transactions</button>");
        out.println("</div></div>");

        out.println("</body>");
        out.println("</html>");
    }
}
