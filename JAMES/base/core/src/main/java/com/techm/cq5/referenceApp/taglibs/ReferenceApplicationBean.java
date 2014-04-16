package com.techm.cq5.referenceApp.taglibs;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;


public class ReferenceApplicationBean {
	String name;	
	String purpose;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	public ReferenceApplicationBean() {
		// TODO Auto-generated constructor stub
		setName("Default Name");
		setPurpose("Default Purpose");
	}
	
	public ReferenceApplicationBean(Session session) throws PathNotFoundException, RepositoryException{
		Node node = session.getNode("/apps/testApp/components/contentpage"); 		
		System.out.println("Node name is : "+node);
		setName(node.getProperty("name").getString());
		setPurpose(node.getProperty("description").getString());
		
		System.out.println("++++++++++++++++++++++++++++++++++"+node.getProperty("name").getString());
		System.out.println("++++++++++++++++++++++++++++++++++"+node.getProperty("description").getString());
	}
	
}
