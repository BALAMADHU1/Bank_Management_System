package com.bank;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class TransactionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("adminName") == null) {
            response.sendRedirect("login.html");
            return;
        }

        long accNo = Long.parseLong(request.getParameter("account_number"));

        try (Connection conn = Utils.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT transaction_type, amount, balance_after, transaction_time FROM transactions WHERE account_number=? ORDER BY transaction_time DESC");
            ps.setLong(1, accNo);
            ResultSet rs = ps.executeQuery();

            out.println("<h2>Transaction History for Account: " + accNo + "</h2>");
            out.println("<table>");
            out.println("<tr><th>Time</th><th>Type</th><th>Amount</th><th>Balance After</th></tr>");
            while(rs.next()) {
                out.println("<tr><td>" + rs.getTimestamp("transaction_time") + "</td>");
                out.println("<td>" + rs.getString("transaction_type") + "</td>");
                out.println("<td>" + rs.getDouble("amount") + "</td>");
                out.println("<td>" + rs.getDouble("balance_after") + "</td></tr>");
            }
            out.println("</table>");
            out.println("<form action='dashboard.html'><button class='home-btn'>Home</button></form>");
        } catch(Exception e) {
            e.printStackTrace();
            out.println("<h3 class='error'>Error: " + e.getMessage() + "</h3>");
        }
    }
}
