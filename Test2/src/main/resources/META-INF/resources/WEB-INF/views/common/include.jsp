<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" 
%><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" 
%><%@ taglib uri="http://www.springframework.org/tags" prefix="spring" 
%><%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" 
%><%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"  
%><%  
response.setHeader("Cache-Control", "no-store");  
response.setHeader("Pragma", "no-cache");  
response.setDateHeader("Expires", 0);  
if (request.getProtocol().equals("HTTP/1.1"))
	response.setHeader("Cache-Control", "no-cache");
%><% pageContext.setAttribute("newLineChar", "\n"); %>