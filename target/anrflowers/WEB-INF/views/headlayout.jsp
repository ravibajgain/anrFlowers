<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/logo/pagelogo.jpeg">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/css/bootstrap/js/bootstrap.min.js" ></script>
     <script src="${pageContext.request.contextPath}/resources/js/popper.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
     <style>
        html {
   
        font-size: 15px;
        letter-spacing: -.01em;
        }
            
        body {
        
        margin: 0;
		font-family: Nunito,sans-serif;
		font-size: .9rem;
		font-weight: 400;
		line-height: 1.5;
		color: #6c757d;
		text-align: left;
        }
    </style>
    
    <title>Home Page</title>
</head>

<body>
    <nav class=" navbar navbar-expand-md navbar-light bg-light border shadow-sm ">
        <img  width="40px" height="33px"  class="m-2  shadow-sm" src="${pageContext.request.contextPath}/resources/img/logo/pagelogo.jpeg">
        <a class="navbar-brand p-2 bg-light shadow-sm" href="${contextRoot}/home">A &amp; R FLOWERS</a>

        <div class="m-auto">
            <form class="form-inline" action="search" method="GT">
             
	  				<div class="input-group">
	    				<div class="input-group-prepend">
	    					<span class="input-group-text bg-dark"><i class="fa fa-search text-light"></i></span>
	 			 		</div>
	 			 		<input style="width: 400px;"  class="form-control mr-sm-2" type="text" placeholder="What would you like to search today ?" name="query" > 
	 			 	</div>
	         
	            <button class="btn btn-sm btn-dark shadow text-light mr-2" type="submit">Search</button>
	       </form>
        </div>
        <ul class="navbar-nav ml-auto">
        	
        	<li class="nav-item">
        	<c:choose>    
	            <c:when test="${currentLoggedInUser.userName !=null && currentLoggedInUser.role == 'VENDOR' }">
	                <a class="btn btn-sm btn-info shadow text-light mr-2" href="${contextRoot}/product/home">Dashboard</a>
	             </c:when>
	             <c:otherwise>
	             	
	             </c:otherwise>
	   		</c:choose>
	   		</li>
	   		<li class="nav-item">
	   		<c:choose>    
	            <c:when test="${currentLoggedInUser.userName !=null && currentLoggedInUser.role == 'ADMIN' }">
	                <a class="btn btn-sm btn-info shadow text-light mr-2" href="${contextRoot}/account/admin/manage">Admin Dashboard</a>
	             </c:when>
	             <c:otherwise>
	             	
	             </c:otherwise>
	   		</c:choose>
	                
	            </li>
       
            <li class="nav-item">
        	<c:choose>    
	            <c:when test="${pageContext.request.userPrincipal.name !=null }">
	                <a class="btn btn-sm btn-info shadow text-light mr-2" href="${contextRoot}/account/?u=${currentLoggedInUser.userName}">${currentLoggedInUser.userName}</a>
	             </c:when>
	             <c:otherwise>
	             	<a class="btn btn-sm btn-dark shadow text-light mr-2" href="${contextRoot}/auth/login">Login</a>
	             </c:otherwise>
	   		</c:choose>
	                
	            </li>
	
	            <li class="nav-item">
	         <c:choose> 
	            <c:when test="${pageContext.request.userPrincipal.name !=null }">
	                <a class="btn btn-sm btn-danger shadow text-light mr-2" href="${contextRoot}/logout">Logout</a>
	             </c:when>
	             <c:otherwise>
	             	
	             </c:otherwise>
            </c:choose>
            </li>

        </ul>
    </nav>
    
    