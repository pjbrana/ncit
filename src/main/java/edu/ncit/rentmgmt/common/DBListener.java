/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncit.rentmgmt.common;

import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Prashanna
 */
public class DBListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String driver = sc.getInitParameter("driver");
        String url = sc.getInitParameter("url");
        String user = sc.getInitParameter("user");
        String pass = sc.getInitParameter("password");
        
        DBConnection dbConnection = new DBConnection(driver, url, user, pass);
        Connection con = dbConnection.getConnection();
        sc.setAttribute("con", con);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
