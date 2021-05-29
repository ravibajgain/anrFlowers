<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="headlayout.jsp" %>

        <div class=" container m-4 ">
            <div class=" row m-2 ">
                <div class="col-md-8">
                    <div>
                    <h3 class="border-bottom"><strong>Payment</strong></h3>
                    <c:choose>
                    	<c:when test="${!empty payment }">

	                        <div>
								${payment.paymentCardType },
								${payment.paymentCardNo }
								
	                        </div>
	                        </c:when>
	                        <c:otherwise>
	                        	<a  class="m-3 nav-link btn btn-info col-md-5"href="${contextRoot }/account/?u=${currentLoggedInUser.userName}">Add Payment Method</a>
	                        </c:otherwise>
                        </c:choose>
                    </div>
                    
                    <div class="mt-2">
                     <h3 class="border-bottom"><strong>Shipped To</strong></h3>
                     <c:choose>
                    	<c:when test="${!empty contact }">

                        <div>
								${contact.address1 }
                        </div>
                        <div>
								${contact.address2 }
                        </div>
                        
                         <div>
								${contact.city }, ${contact.state } ${contact.postalCode } 
                        </div>
                        <div>
								${contact.phoneNo }
                        </div>
                        </c:when>
                        <c:otherwise>
                        	<a class="m-3 nav-link btn btn-info col-md-5" href="${contextRoot }/account/?u=${currentLoggedInUser.userName}">Add Delivery Address</a>
                        </c:otherwise>
                       </c:choose>
                    </div>
	
                    <div class="m-2">
                     <h2>Your Ordered Items</h2>
                        <div class="table-responsive bg-light  rounded border">
                            <table class=" table table-hover text-center">
                                <thead class="m-2 border rounded ">
                                    <tr>
                                        <td>S.No</td>

                                        <td>Product</td>
                                        <td>Price</td>
                                        <td>Quantity</td>
                                        <td>Total</td>
                                        <tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orderItems }" var="order">
                                        <tr>
                                            <td>${count.count}</td>
                                            <td class="w-50">
                                                <img  width="250px" height="200px" class="float-left mr-2" src="${pageContext.request.contextPath}/resources/img/pageimg/${order.product.productCode }.jpg" />
                                                <div class="text-left m-2">
                                                    <a> <strong>${order.product.productTitle }</strong></a>

                                                </div>
                                            </td>
                                            <td>${order.productPrice }</td>
                                            <td>${order.productOrderQty }</td>
                                            <td>$ ${order.orderTotal}</td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 text-right border">
                    <div>
                        <h3 class="text-center border-bottom"><strong>Order Summary</strong></h3>
                        <div>
                            Total : ${currentLoggedInUser.cart.grandTotal }
                        </div>

                        <div>
                            Total Items : ${currentLoggedInUser.cart.cartList }
                        </div>
                        <div>
                            Shipping Fees : free
                        </div>
                        <div>
                            Tax : $0
                        </div>
                        <div class="m-2 border-top border-dark">
                        	<strong>Grand Total: ${currentLoggedInUser.cart.grandTotal }</strong>
                        </div>
                         <c:if test="${!empty payment && !empty contact && currentLoggedInUser.cart.grandTotal > 0 }" >
                			<a  class="nav-link btn btn-success"href="${contextRoot }/orders/confirm">Place Order</a>
               			</c:if>
                    </div>
                </div>

             
            </div>
        </div>

<%@ include file="footlayout.jsp" %>