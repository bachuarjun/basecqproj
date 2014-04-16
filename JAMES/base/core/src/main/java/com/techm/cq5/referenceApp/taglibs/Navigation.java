package com.techm.cq5.referenceApp.taglibs;

import java.io.IOException;

import javax.jcr.Session;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.scripting.jsp.util.TagUtil;

public class Navigation extends SimpleTagSupport{

	private String location;
	@Override
	public void doTag() throws JspException, IOException {
		PageContext currentPageContext = (PageContext) getJspContext();
		SlingHttpServletRequest slingRequest = TagUtil.getRequest(currentPageContext);
		Session session = slingRequest.getResourceResolver().adaptTo(Session.class);
		
		currentPageContext.setAttribute("id", "value");
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
