<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="headlayout.jsp" %>


<div class="container">
    <div class=" row justify-content-center ">
			<div class="col-md-5 m-4 shadow border p-4 text-center">
				<div class="d-flex bd-highlight mb-3 p-4">
				 	<div  class="card-body">
						<h1><a  class="nav-link text-danger border-bottom  "href="${contextRoot }/product/create">CREATE LISTING</a></h1>
					
					</div>
				</div>
			</div>
			
			<div class="col-md-5 m-4 shadow border p-4 text-center">
				<div class="d-flex bd-highlight mb-3 p-4">
				 	<div  class="card-body">
						<h1><a  class="nav-link text-danger border-bottom "href="${contextRoot }/product/listproducts">VIEW LISTINGS</a></h1>
					
					</div>
				</div>
			</div>
	</div>
	
	 <div class=" row justify-content-center ">
			<div class="col-md-5 m-4 shadow border p-4 text-center">
				<div class="d-flex bd-highlight mb-3 p-4">
				 	<div  class="card-body">
						<h1><a  class="nav-link text-danger border-bottom "#">REVENUE</a></h1>
					
					</div>
				</div>
				<small class="text-danger">*Page under construction*</small>
			</div>
			
			<div class="col-md-5 m-4 shadow border p-4 text-center">
				<div class="d-flex bd-highlight mb-3 p-4">
				 	<div  class="card-body">
						<h1><a  class="nav-link text-danger border-bottom "href="#">ANALYTICS</a></h1>
					
					</div>
				</div>
				<small class="text-danger">*Page under construction*</small>
			</div>
	</div>
	
</div>
        
<%@ include file="footlayout.jsp" %>