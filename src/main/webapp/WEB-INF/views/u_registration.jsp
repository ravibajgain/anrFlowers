<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="headlayout.jsp" %>

<div class="container">
    <div class="row justify-content-center m-4">
        <div class="col-md-6 align-items-center">
            <div class="card shadow border">
                <div class="card-header bg-danger text-center text-light">
                    SIGN UP
                </div>
			
                <div class="card-body">
                    <form action="register" method="post" class="form-group">
                        <div class="form-group">
                            <label>Username </label>
                            <input type="text" name="userName" class="m-2 form-control">
                          <c:choose>
                          
                           <c:when test="${ !empty errors.username }">
                          		
                          		<div class="alert alert-danger alert-dismissible fade show" role="alert">
									  ${errors.username}
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
									    <span aria-hidden="true">&times;</span>
									  </button>
									</div>
                          	</c:when>
                        </c:choose>
                        
                        <c:choose>
                          
                           <c:when test="${ !empty errors.taken }">
                          		
                          		<div class="alert alert-danger alert-dismissible fade show" role="alert">
									  ${errors.taken}
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
									    <span aria-hidden="true">&times;</span>
									  </button>
									</div>
                          	</c:when>
                        </c:choose>
                        </div>
                        
                        <div class="form-group">
                            <label>Password </label>
                            <input type="password" name="userPassword" class="m-2 form-control">
                             <c:choose>
                          
                           <c:when test="${ !empty errors.emptyPass }">
                          		
                          		<div class="alert alert-danger alert-dismissible fade show" role="alert">
									  ${errors.emptyPass}
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
									    <span aria-hidden="true">&times;</span>
									  </button>
									</div>
                          	</c:when>
                        </c:choose>
                           
                        </div>


                        <div class="form-group">
                            <label>Confirm Password</label>
                            <input type="password" name="passwordConf" class="m-2 form-control">
                        <c:choose>
                          
                           <c:when test="${ !empty errors.password }">
                          		
                          		<div class="alert alert-danger alert-dismissible fade show" role="alert">
									  ${errors.password}
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
									    <span aria-hidden="true">&times;</span>
									  </button>
									</div>
                          	</c:when>
                        </c:choose>	
                        
                        </div>
                        
                        <div class="form-group">
                            <label>First Name</label>
                            <input type="text" name="firstName" class="m-2 form-control">
                        </div>
                        
                        <div class="form-group">
                            <label>Last Name</label>
                            <input type="text" name="lastName" class="m-2 form-control">
                        </div>
                        
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" name="email" class="m-2 form-control">
                        </div>
                        
                        <button class="btn btn-sm btn-dark text-light m-auto" type="submit">Register</button>
                     </form>
                </div>
            </div>
        </div>
    </div>
</div>

    
    
    <%@ include file="footlayout.jsp" %>
    
    
    