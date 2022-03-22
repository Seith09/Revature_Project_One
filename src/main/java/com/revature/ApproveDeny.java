package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ApproveDeny {

    public static void approveButton(String empId) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "]eT*LA;a6m3lqTs-");
        Statement stmApprove = con.createStatement();
        stmApprove.execute("update rei_request set approved = true where emp_id = "+ empId);
    }

    public static void denyButton(String empId) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "]eT*LA;a6m3lqTs-");
        Statement stmApprove = con.createStatement();
        stmApprove.execute("delete from rei_request where emp_id = "+ empId + ";");
    }
}
