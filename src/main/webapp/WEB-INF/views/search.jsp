<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="headlayout.jsp" %>

<div class=" container ">
        <div class=" row ">
        	
        <div class="table-responsive bg-light shadow mb-4 rounded border">
		        <table class=" table table-hover text-center">
		        	<thead class="m-2 p-4 text-light bg-info border rounded ">
		        		<tr>
		        			<td>S.No</td>
		       
		        			<td>Product</td>
		        			<td>Price</td>
		        			<td>Actions</td>
		        		<tr>
		        	</thead>
		        	<tbody>
		        	<c:forEach items="${search}" var="product" varStatus="count" >
		        		<tr>
		        			<td>${count.count}</td>
		        			<td class="w-50">
		        					<img class="img-thumbnail mt-2" src="${pageContext.request.contextPath}/resources/img/pageimg/${product.productCode }.jpg" />
		        				<div class="text-left">
		       						<a>${product.productTitle }</a>
		       						<p class="text-justify">${product.productDesc } can’t establish a connection to the server at localhost:8080.can’t establish a connection to the server at localhost:8080can’t establish a connection to the server at localhost:8080</p>
		       					</div>
		        			
		        			<td>${product.productListingPrice}</td>
		        			<td>
		                        <a class="btn btn-sm btn-danger text-light" href="${contextRoot}/cart/add?id=${product.productId}"><i class=" mr-2 fa fa-cart"></i>Add to Cart</a>
		        			</td>
		
		        		</tr>
		        	</c:forEach>
		        	</tbody>
		        	 </table>
		       </div>
     
        </div>

    </div>
        
<%@ include file="footlayout.jsp" %>