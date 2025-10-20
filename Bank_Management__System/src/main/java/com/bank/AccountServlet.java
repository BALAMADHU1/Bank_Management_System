package com.bank;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("adminName") == null) {
            response.sendRedirect("login.html");
            return;
        }

        String action = request.getParameter("action");

        try (Connection conn = Utils.getConnection()) {
            if ("create".equals(action)) {
                String firstName = request.getParameter("first_name");
                String lastName = request.getParameter("last_name");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String aadhar = request.getParameter("aadhar");
                String pincode = request.getParameter("pincode");

                PreparedStatement check = conn.prepareStatement("SELECT * FROM accounts WHERE phone=? OR aadhar=?");
                check.setString(1, phone);
                check.setString(2, aadhar);
                ResultSet rs = check.executeQuery();

                if(rs.next()) {
                    out.println("<h3 class='error'>Account already exists!</h3>");
                } else {
                    long accountNumber = Utils.generateAccountNumber();
                    PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO accounts (account_number, first_name, last_name, address, phone, aadhar, pincode) VALUES (?, ?, ?, ?, ?, ?, ?)"
                    );
                    ps.setLong(1, accountNumber);
                    ps.setString(2, firstName);
                    ps.setString(3, lastName);
                    ps.setString(4, address);
                    ps.setString(5, phone);
                    ps.setString(6, aadhar);
                    ps.setString(7, pincode);
                    ps.executeUpdate();

                    out.println("<h3 class='success'>Account Created Successfully!</h3>");
                    out.println("<p>Account Holder: " + firstName + " " + lastName + "<br>Account Number: " + accountNumber + "</p>");
                    out.println("<form action='dashboard.html'><button class='home-btn'>Home</button></form>");
                }

            } else if ("deposit".equals(action) || "withdraw".equals(action)) {
                long accNo = Long.parseLong(request.getParameter("account_number"));
                double amount = Double.parseDouble(request.getParameter("amount"));
                String type = action.toUpperCase();

                PreparedStatement ps1 = conn.prepareStatement("SELECT first_name, last_name, balance FROM accounts WHERE account_number=?");
                ps1.setLong(1, accNo);
                ResultSet rs = ps1.executeQuery();

                if(rs.next()) {
                    double balance = rs.getDouble("balance");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    double newBalance = balance;

                    if(type.equals("DEPOSIT")) newBalance += amount;
                    else if(type.equals("WITHDRAW")) {
                        if(balance >= amount) newBalance -= amount;
                        else { out.println("<h3 class='error'>Insufficient Balance!</h3>"); return; }
                    }

                    PreparedStatement ps2 = conn.prepareStatement("UPDATE accounts SET balance=? WHERE account_number=?");
                    ps2.setDouble(1, newBalance);
                    ps2.setLong(2, accNo);
                    ps2.executeUpdate();

                    PreparedStatement ps3 = conn.prepareStatement("INSERT INTO transactions(account_number, transaction_type, amount, balance_after) VALUES (?, ?, ?, ?)");
                    ps3.setLong(1, accNo);
                    ps3.setString(2, type);
                    ps3.setDouble(3, amount);
                    ps3.setDouble(4, newBalance);
                    ps3.executeUpdate();

                    out.println("<h3 class='success'>" + type + " Successful!</h3>");
                    out.println("<p>Account Holder: " + firstName + " " + lastName + "<br>Account Number: " + accNo + "<br>" + type + " Amount: " + amount + "<br>Total Balance: " + newBalance + "</p>");
                    out.println("<form action='dashboard.html'><button class='home-btn'>Home</button></form>");
                } else {
                    out.println("<h3 class='error'>Account not found.</h3>");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            out.println("<h3 class='error'>Error: " + e.getMessage() + "</h3>");
        }
    }
}
