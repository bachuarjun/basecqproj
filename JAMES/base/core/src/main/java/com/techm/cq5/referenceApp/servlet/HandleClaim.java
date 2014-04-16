package com.techm.cq5.referenceApp.servlet;

import java.io.IOException;
import java.rmi.ServerException;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.jcr.api.SlingRepository;
import org.json.simple.JSONObject;
import java.util.UUID;
 
@SlingServlet(paths="/bin/mySearchServlet", methods = "POST", metatype=true)
public class HandleClaim extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
     private static final long serialVersionUID = 2598426539166789515L;
      
     @Reference
     private SlingRepository repository;
      
     public void bindRepository(SlingRepository repository) {
            this.repository = repository; 
            }
           
     @Override
     protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
       
      try
      {
         //Get the submitted form data that is sent from the
              //CQ web page  
          String id = UUID.randomUUID().toString();
          String firstName = request.getParameter("firstName");
          String lastName = request.getParameter("lastName");
          String address = request.getParameter("address");
          String cat = request.getParameter("cat");
          String state = request.getParameter("state");
          String details = request.getParameter("details");
          String date = request.getParameter("date"); 
          String city = request.getParameter("city"); 
       
          //Encode the submitted form data to JSON
          JSONObject obj=new JSONObject();
          obj.put("id",id);
          obj.put("firstname",firstName);
          obj.put("lastname",lastName);
          obj.put("address",address);
          obj.put("cat",cat);
          obj.put("state",state);
          obj.put("details",details);
          obj.put("date",date);
          obj.put("city",city);
           
             //Get the JSON formatted data    
          String jsonData = obj.toJSONString();
           
             //Return the JSON formatted data
         response.getWriter().write(jsonData);
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
    }
}