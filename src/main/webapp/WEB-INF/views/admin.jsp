<%@ include file="headlayout.jsp" %>
<div class="row">
	<a class="col-md-4 btn btn-info text-light m-4">Products</a>
	<a class="col-md-4 btn btn-info text-light m-4">Users</a>
</div>
<div class="container-fluid mt-2 mb-2">
	<h3>User Dashboard</h3>
        <table style="font-size: 15px;" class="table">
            <thead>
                <tr>
                    <th scope="col">SN</th>
                    <th scope="col">Username</th>
                    <th scope="col">User Role</th>
                    <th scope="col">Email</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>


            <c:forEach items="${users}" var="user" varStatus="count">
                <tbody>
                    <tr>
                        <td scope="row">${count.count}</td>
                        <td>${user.userName}</td>
                        <td>${user.role}</td>
                        <td>${user.email}</td>
                        <td>
                            <a class="btn btn-sm btn-danger text-light" href="${contextRoot }/account/delete?id=${user.userName}"><i class="fa mr-2 fa-trash"></i>Delete User</a>
                        
                        </td>
                    </tr>

                </tbody>
            </c:forEach>

        </table>
    </div>



    <div class="container-fluid mt-2 mb-2">
	<h3>Products Dashboard</h3>
        <table style="font-size: 15px;" class="table">
            <thead>
                <tr>
                    <th scope="col">SN</th>
                    <th scope="col">Product Title</th>
                    <th scope="col">Product Quantity</th>
                    <th scope="col">Product Status</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>


            <c:forEach items="${products}" var="product" varStatus="count">
                <tbody>
                    <tr>
                        <td scope="row">${count.count}</td>
                        <td>${product.productTitle}</td>
                        <td>${product.productQty}</td>
                        <td>${product.productStatus}</td>
                        <td>
                            <a class="btn btn-sm btn-primary text-light" href="${contextRoot }/product/create">Create</a>
                        
                            <a class="btn btn-sm btn-primary text-light" href="${contextRoot }/product/editproduct?id=${product.productId}"><i class="fa mr-2 fa-edit"></i>Edit Listing</a> |
                            
                            <a class="btn btn-sm btn-danger text-light" href="${contextRoot }/product/deleteproduct?id=${product.productId}"><i class="fa mr-2 fa-trash"></i>Delete Listing</a>
                        </td>
                    </tr>

                </tbody>
            </c:forEach>
        </table>
        <div> * IS - In Stock
            ** OFS- Out of Stock 
       </div>
    </div>
    
    
    
     