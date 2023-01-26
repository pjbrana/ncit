/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncit.rentmgmt.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prashanna
 */
public class DBConnection {

    static Connection con = null;
    String driver;
    String url;
    String user;
    String password;

    public DBConnection(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        if (con == null) {
            try {
                Class.forName(driver);
                System.out.println("Driver Loaded Succesfully");
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Connection established.");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }

}
