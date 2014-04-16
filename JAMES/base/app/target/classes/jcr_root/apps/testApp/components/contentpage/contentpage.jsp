<%@page session="false" %><%@page import="com.techm.cq5.referenceApp.core.*"
%>
<%
    Test tmp = new Test();
    out.println("This is my first reference component: "+tmp.returnReferenceString());
%>
<cq:include script="servletpage.jsp"/>