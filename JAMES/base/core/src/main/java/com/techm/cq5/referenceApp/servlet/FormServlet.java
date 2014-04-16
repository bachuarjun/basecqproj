package com.techm.cq5.referenceApp.servlet;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;

@Component(immediate=true, metatype=false, label="Test App Form Servlet", description="Test App Form Servlet")
@Service
@Properties({
	@Property(name="sling.servlet.paths", value="/bin/testApp"),
	@Property(name="sling.servlet.methods", value="GET")
	})
public class FormServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -509363140268385270L;
	
	private static final Logger log = LoggerFactory.getLogger(FormServlet.class);  
    
	/**
     * {@inheritDoc}
     */
    @Override
    protected void doGet(SlingHttpServletRequest request,
            SlingHttpServletResponse response) throws ServletException,
            IOException {
    	
    	log.info("james entered...");
			
    	String username = request.getParameter("Name");
        String password = request.getParameter("Pass");
        response.setContentType("text/html");
        if(username.equals("james") && password.equals("james")) {
            response.getWriter().println("<html><body>Welcome to My Page!!!</body></html>");                
        } 
        else {                
            String message = "OOps!!! Invalid Username/Password";
            response.getWriter().println(message);                 
        }
    }
}