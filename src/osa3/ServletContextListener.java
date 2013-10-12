package osa3;

import javax.servlet.ServletContextEvent;

//import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListener
 *
 */
public class ServletContextListener implements javax.servlet.ServletContextListener {

    public ServletContextListener() {
    }

    public void contextInitialized(ServletContextEvent arg0) {
        // SIIA LÄHEB MINU ASI
    	dao.SetupDao dao = new dao.SetupDao();
    	dao.createSchema();
    	dao.createDefaultValues();
    	System.out.println("ServletContextListener initialized");
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    	System.out.println("ServletContextListener destroyed");
    }
	
}
