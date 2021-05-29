<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="headlayout.jsp" %>

<div class=" container ">
        <div class=" row ">
        	<div class=" mt-2 nav-item ml-auto">
				<a class=" btn btn-sm btn-info mb-2 " href="${contextRoot }/cart/view">
					<i class=" fa fa-shopping-cart fa-lg text-light m-2 "></i>
					<span class=" badge badge-danger " >${carts.size() }</span>
				</a>
		<div class=" btn  btn-info mb-2">
			<strong>Total</strong>
                        <span class=" badge badge-danger" >${currentLoggedInUser.cart.grandTotal }</span>
		</div>
	<c:if test="${!empty carts }">	                       
		<a class=" nav-link btn btn-sm btn-success mr-2 mb-2 text-right" href="${contextRoot}/orders/create?cid=1">
			<i class=" fa fa-credit-card fa-lg text-light m-2"></i>
				<strong>Checkout</strong>
		</a>
	</c:if>
	</div>
        <div class="table-responsive bg-light shadow mb-4 rounded border">
		        <table class=" table table-hover text-center">
		        	<thead class="m-2 p-4 text-light bg-info border rounded ">
		        		<tr>
		        			<td>S.No</td>
		       
		        			<td>Product</td>
		        			<td>Price</td>
		        			<td>Quantity</td>
		        			<td>Total</td>
		        			<td>Actions</td>
		        		<tr>
		        	</thead>
		        	<tbody>
		        	<c:forEach items="${carts}" var="cart" varStatus="count" >
		        		<tr>
		        			<td>${count.count}</td>
		        			<td class="w-50">
		        					<img  style="float: left"width="200px" height ="100px" class="img-thumbnail mt-2" src="${pageContext.request.contextPath}/resources/img/pageimg/${cart.cartProduct.productCode }.jpg" />
		        				<div class="text-left">
		       						<a>${cart.cartProduct.productTitle }</a>
		       						<p class="text-justify">${cart.cartProduct.productDesc }</p>
		       					</div>
		        			</td>
		        			<td>${cart.cartPrice }</td>
		        			<td>
		        			<form method="get" action="edit">
			        			<div class="form-inline">
			        				<input name="cartListId" value="${cart.cartListId}" hidden>
			        				<select name="cartQty" class="form-control">
			        					<option value="1"${cart.cartProductQty=='1' ? 'selected':''}>1</option>
			        					<option value="2"${cart.cartProductQty=='2' ? 'selected':''}>2</option>
			        					<option value="3"${cart.cartProductQty=='3' ? 'selected':''}>3</option>
			        					<option value="4"${cart.cartProductQty=='4' ? 'selected':''}>4</option>
			        					<option value="5"${cart.cartProductQty=='5' ? 'selected':''}>5</option>
			        					<option value="6"${cart.cartProductQty=='6' ? 'selected':''}>6</option>
			        					<option value="7"${cart.cartProductQty=='7' ? 'selected':''}>7</option>
			        					<option value="8"${cart.cartProductQty=='8' ? 'selected':''}>8</option>
			        					<option value="9"${cart.cartProductQty=='9' ? 'selected':''}>9</option>
			        					<option value="10"${cart.cartProductQty=='10' ? 'selected':''}>10</option>
			        				</select> 
			        				<button class="btn btn-sm btn-primary text-light ml-2"><i class="fa mr-2 fa-edit"></i>Change</button>
			        			</div>
		        				</form>
		        			
		        			</td>
		        			<td>$ ${cart.cartTotal }</td>
		        			<td>
		        
		                        <a class="btn btn-sm btn-danger text-light" href="${contextRoot}/cart/delete?id=${cart.cartListId}"><i class="fa mr-2 fa-trash"></i>Delete</a>
		        			</td>
		
		        		</tr>
		        	</c:forEach>
		        	</tbody>
		        	 </table>
		       </div>
		       <small class="text-danger m-auto">***Note: For orders more than 10 please contact our customer service. Phone +61-123-456-7890***</small>
		       
        </div>

    </div>
        
<%@ include file="footlayout.jsp" %>