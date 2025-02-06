/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.listener;

import in.gadgethub.utility.DBUtil;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author pramo
 */
public class DBConnectionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        System.out.println("Application start...");
        ServletContext ctxt=sce.getServletContext();
        String dbUrl=ctxt.getInitParameter("url");
        String username=ctxt.getInitParameter("username");
        String password=ctxt.getInitParameter("password");
        
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Oracle Driver Loaded Sucessfuly");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not found");
            e.printStackTrace();
        }
        System.out.println("listener called");
        DBUtil.openConnection(dbUrl,username,password);
        System.out.println("connection opened");
        
            
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBUtil.closeConnection();
    }
    
    
}
