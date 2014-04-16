package com.techm.cq5.referenceApp.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.scripting.jsp.util.TagUtil;


public class CreatePage extends SimpleTagSupport {

	private String pageName;
	private String path;
	
	@Override
	public void doTag() throws JspException, IOException {

		PageContext currentPageContext = (PageContext) getJspContext();
		SlingHttpServletRequest slingRequest = TagUtil.getRequest(currentPageContext);
		ResourceResolver resolver =  slingRequest.getResourceResolver();
	
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
