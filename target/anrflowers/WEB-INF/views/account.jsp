<%@ page language="java" contentType="text/html; charset=UTF-8"
				pageEncoding="UTF-8"%>
    <%@ include file="headlayout.jsp"%>
    <div class="text-right"><a class="nav-link btn btn-sm btn-info" href="${contextRoot }/orders/checkout"><small>Checkout Page</small></a></div>
        <div class=" container-fluid">
            <div class=" row m-4">
                <div class="col-md-6">
                	<h3 class="border-bottom text-center"> Address</h3>
                	<br>
                    <form method="POST" action="updatecontact?u=${currentLoggedInUser.userName }">
                        
                            <div class="form-group">
                                <label>Address Line 1</label>
                                <input type="text" class="form-control" name="address1" value="${contact.address1 }">
                            </div>
                            <div class="form-group ">
                                <label>Address Line 2</label>
                                <input type="text" class="form-control" name="address2" value="${contact.address2 }">
                            </div>

                        <div class="form-row">
                            <div class="form-group m-1 ">
                                <label >City</label>
                                <input type="text" class="form-control" name="city" value="${contact.city }">
                            </div>
                            <div class="form-group m-1">
                                <label>State</label>
                                <input type="text" class="form-control" name="state" value="${contact.state }">
                              </div>
                              <div class="form-group m-1">  
                              	   <label>Zip Code</label>
                                	<input type="text" class="form-control" name="postalCode" value="${contact.postalCode }">
                            </div>
                        
                        </div>

                        <div class="form-row">
                            <div class="form-group ">
                                <label>Contact Number</label>
                                <input type="text" class="form-control" name="phoneNo" value="${contact.phoneNo }">
                            </div>
                            <input type="text" class="form-control" value="${contact.userContactId }" hidden>
                        </div>

                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
				<div class="border-right"></div>	
                <div class="col-md-5">
                <h3 class="border-bottom text-center"> Payment</h3>
                	<br>

                    <form method="POST" action="updatepayment?u=${currentLoggedInUser.userName }">
                        
                            <div class="form-group">
                                <div class="w-50">
                                	<label>Payment Card Type</label>
                                	<input type="text" class="form-control" name="paymentCardType" value="${payment.paymentCardType }">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Credit Card Number</label>
                                <input type="text" class="form-control" name="paymentCardNo" value="${payment.paymentCardNo }">
                            </div>

                        <div class="form-row">
                            <div class="form-group m-1">
                                <label>Expiry Month</label>
                                <input type="text" class="form-control" name="paymentCardExMo" value="${payment.paymentCardExMo }">
                            </div>
                            <div class="form-group m-1">
                                <label>Expiry Year</label>
                                <input type="text" class="form-control" name="paymentCardExYr" value="${payment.paymentCardExYr }">
                                
                            </div>
                            <div class="form-group m-1">
                                    <label>CVC Code</label>
                                    <input type="text" class="form-control" name="paymentCardCvc" value="${payment.paymentCardCvc }">
                             </div>
                        </div>

                        <input type="text" class="form-control" value="${payment.paymentUserId }" hidden>

                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </div>
            <a href="${contextRoot}/account/delete?id=${currentLoggedInUser.userName}" class="text-danger">Delete my Account</a>
        </div>
 <%@ include file="footlayout.jsp"%>