/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cjd.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
/**
 *
 * @author chrisd
 */
@ManagedBean
@SessionScoped
public class CommentsBean {
    private static final long serialVersionUID = 1L;
    String dbUrl = "jdbc:mysql://localhost:3306/portfolio";
    String dbClass = "com.mysql.jdbc.Driver";
    String query = "Select * FROM comments";
    /**
     * Creates a new instance of CustomerBean
     */
    public CommentsBean() {
    }


    public String getName() {
        String name = new String();
        try {
            Class.forName(this.dbClass);
            Connection con = DriverManager.getConnection(dbUrl, "pdbu", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        }
        catch (ClassNotFoundException e)
        {
            return "Class not found" + e.getMessage();
        }
        catch (SQLException e)
        {
            return "sql exception " + e.getMessage();
        }
    }


}
