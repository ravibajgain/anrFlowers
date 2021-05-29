<%@ include file="headlayout.jsp" %>
    
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 align-items-center ">
                    <div class="card">
                        <div class="card-header text-center text-light bg-primary">
                            USER LOGIN
                        </div>

                        <div class="card-body">
                            <form action="login" method="post" class="form-group">
                                <div class="form-group">
                                    <label>USERNAME </label>
                                    <input type="text" name = "username" class="m-2 form-control">
                                    
                           <c:choose>
                           		<c:when test="${ !empty invalidLogin }">
                          		
	                          		<div class="alert alert-danger alert-dismissible fade show" role="alert">
										  ${invalidLogin}
										  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
										    <span aria-hidden="true">&times;</span>
										  </button>
									</div>
                          		</c:when>
                        	</c:choose>
                                </div>
                                <div class="form-group">
                                    <label class="">PASSWORD</label>
                                    <input type="password" name="password" class="m-2 form-control">
                                </div>
                                <div class="form-group m-2">
                                	<button class="btn btn-sm btn-dark text-light mt-2 mb-0">LOGIN</button>
                            	</div>
                            </form>
           
                        </div>
                    </div>
                </div>

                <div class="border-left border-danger col-md-6 align-items-center text-center mt-2">
                    <div class="card shadow-sm">
                        <div class="card-header text-center text-light bg-primary">
                            NOT A MEMBER ?
                        </div>

                        <div class="card-body">
							<h5>Members can enjoy</h5>
								<ul style="list-style:none" class="text-left">
									<li> Free Delivery </li>
									<li> Save 5% with every purchase over $200 </li>
									<li> Stay updated with latest offerings </li>
									<li> And much more ..... </li>
									
								</ul>
                            <a href="register" class="btn btn-sm btn-dark text-light mt-2 mb-0">
                               REGISTER TODAY
                            </a>

                        </div>
                    </div>
                    
                     <div class="card mt-2 shadow-sm">
                        <div class="card-header text-center text-light bg-info">
                            NOT A SELLER ?
                        </div>

                        <div class="card-body ">
							<h5>Seller can enjoy</h5>
								<ul style="list-style:none" class="text-left">
									<li> Increased Revenue</li>
									<li> Get 5% with every 1000 products sold </li>
									<li> Stay updated with latest offerings </li>
									<li> And much more ..... </li>
									
								</ul>
                            <a href="vendor_register" class="btn btn-sm btn-info text-light mt-2 mb-0">
                               START SELLING 
                            </a>

                        </div>
                    </div>
                </div>
                
                
            </div>
        </div>
        <a  class="nav-link"href="${contextRoot}/auth/admin_register"><small>Admin Signup ?</small> </a>
    </div>    
</body>
</html>