
<%@ include file="headlayout.jsp" %>
   
  <div class="container-fluid border shadow-sm ">
        <div class="row m-2">
            <a href="${contextRoot }/product/create" class="btn btn-warning m-3 border shadow">Create Listing</a>
            <a href="${contextRoot }/product/listproducts" class="btn btn-warning m-3 border shadow">View Listing</a>
        </div>
    </div>

    <div class="container-fluid mt-2 mb-2">

        <table style="font-size: 15px;" class="table">
            <thead>
                <tr>
                    <th scope="col">SN</th>
                    <th scope="col">Product Title</th>
                    <th scope="col">Product Quantity</th>
                    <th scope="col">Unit Price</th>
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
                        <td>${product.productListingPrice}</td>
                        <td>${product.productStatus}</td>
                        <td>
                            <a class="btn btn-sm btn-primary text-light" href="editproduct?id=${product.productId}"><i class="fa mr-2 fa-edit"></i>Edit Listing</a> |
                            <a class="btn btn-sm btn-danger text-light" href="deleteproduct?id=${product.productId}"><i class="fa mr-2 fa-trash"></i>Delete Listing</a>
                        </td>
                    </tr>

                </tbody>
            </c:forEach>

        </table>
    </div>
     
<%@ include file="footlayout.jsp" %>