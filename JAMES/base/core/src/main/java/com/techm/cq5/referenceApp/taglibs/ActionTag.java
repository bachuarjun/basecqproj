package com.techm.cq5.referenceApp.taglibs;

import java.io.IOException;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.scripting.jsp.util.TagUtil;


public class ActionTag extends SimpleTagSupport{
	
	private String beanClass;
    private String id;
	
    public void setBean(String beanClass) {
        this.beanClass = beanClass;
    }

    public void setId(String id) {
        this.id = id;
    }
    
	@Override
	public void doTag() throws JspException, IOException {
		PageContext currentPageContext = (PageContext) getJspContext();
		SlingHttpServletRequest slingRequest = TagUtil.getRequest(currentPageContext);
		Session session = slingRequest.getResourceResolver().adaptTo(Session.class);
		ReferenceApplicationBean referenceApplication = null;
        
        System.out.println("BEAN++++++++++--------------:"+this.beanClass.toString());
		
		try {
			referenceApplication = new ReferenceApplicationBean(session);
		}catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("$$$$$PathNotFound");
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			System.out.println("$$$$$REPO EXCEPTION ");
			e.printStackTrace();
		}
		
		System.out.println("Reference application bean object: "+referenceApplication);
		if(referenceApplication==null){
			referenceApplication=new ReferenceApplicationBean();
		}
		
		currentPageContext.setAttribute(id, referenceApplication);
	}
}
