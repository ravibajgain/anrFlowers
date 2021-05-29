<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="headlayout.jsp" %>
    <div style="font-size: 15px;"class="mb-2 sticky-top border border-bottom bg-light">

        <nav class="d-flex justify-content-around ">
        	<a class="nav-link btn btn-light btn-sm shadow m-2" href="${contextRoot}/category?c=Birthday"> 
        		<strong>Birthday</strong>
        	</a>
        	<a class="nav-link btn btn-light btn-sm shadow m-2" href="${contextRoot}/category?c=Love"> 
        		<strong>Love</strong>
        	</a>
        	<a class="nav-link btn btn-light btn-sm shadow m-2" href="${contextRoot}/category?c=Occassion"> 
        		<strong>Occassion</strong>
        	</a>
        	<a class="nav-link btn btn-light btn-sm shadow m-2" href="${contextRoot}/category?c=Flowers"> 
        		<strong>Flowers</strong>
        	</a>
        	<a class="nav-link btn btn-light btn-sm shadow m-2" href="${contextRoot}/category?c=Gifts"> 
        		<strong>Gifts</strong>
        	</a>
        	<a class="nav-link btn btn-light btn-sm shadow m-2" href="${contextRoot}/category?c=Other"> 
        		<strong>Other</strong>
        	</a>
        	 <a class=" btn btn-sm btn-danger shadow-lg m-2 " href="${contextRoot}/cart/view">
        	 	<i class=" fa fa-shopping-cart fa-lg text-light m-2 "></i>
        	 		<strong>View Cart <span class="badge badge-light">${currentLoggedInUser.cart.cartList }</span></strong>
    		 </a>

        </nav>
    </div>

    <div class="container-fluid">
    	<div class="row m-2">
        	<c:forEach items="${productsByCategory}" var="product" varStatus="count" >
        	<div class="col-md-4">
   
        		<div class="card-body m-2 p-2 border shadow ">
        			<div>
        			
        				<div class=" m-2 rounded">
        				<a href="#"><strong>${product.productTitle }</strong></a>
        						<img class="img-thumbnail mt-2" src="${pageContext.request.contextPath}/resources/img/pageimg/${product.productCode }.jpg" />
        					
        				</div>
        			
        				<div class="text-left">
       						
       						<p class="text-justify m-2">${product.productDesc }</p>
       					</div>
       					
       					<div class="mb-2 mt-2">
       						<strong class="btn btn-sm btn-primary">$ ${product.productListingPrice }</strong>
       						<a class="btn btn-sm btn-success text-light ml-3" href="${contextRoot}/cart/add?id=${product.productId}"><i class=" mr-1  fa fa-shopping-cart"></i>Add to Cart</a>
                 	  	 	<a class="btn btn-sm btn-info text-light ml-3" href="${contextRoot}/cart/viewproduct?id=${product.productId}"><i class=" ml-1"></i>View More</a>
       					</div>
        			</div>
        		</div>
        		</div>
        	</c:forEach>
        	</div>
		</div>
<%@ include file="footlayout.jsp" %>
