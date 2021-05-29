
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="headlayout.jsp" %>

 <div class="container-fluid border shadow-sm ">
        <div class="row m-2">
            <a href="${contextRoot}/product/create" class="btn btn-warning m-3 border shadow">Create Listing</a>
            <a href="${contextRoot}/product/listproducts" class="btn btn-warning m-3 border shadow">View Listing</a>
        </div>
    </div>

    <div class="container">
        <div class="row shadow border m-3 p-3">
            <div class="col-md-8">
                <form action="addproduct" method="post" class="form-group" enctype="multipart/form-data">
                    <div>
                        <label>Enter Title</label>
                        <input type="text" name="productTitle" class="form-control mb-2" placeholder="Enter Product Title">
                    </div>
                    
                    <div>
                        <label>Enter Product Description</label>
                        <textarea class="form-control  mb-2"  name="productDesc" cols="60" rows="10"></textarea>
                    </div>
                    <div>
                        <label>Available Quantity</label>
                        <input type="text" class="form-control mb-2" name="productQty" placeholder="Enter Available Quanity">
                    </div>
                    
                    <div>
                        <label>Unit Price</label>
                        <input type="text" class="form-control mb-2" name="productListingPrice" placeholder="Enter Unit Price">
                    </div>
                    <div class="form-group">
                        <label>Product Stock Status</label>
                        <select class="form-control" name="productStatus">
                            <option value="Choose" selected>Choose...</option>
                            <option value="IS">In Stock</option>
                            <option value="OFS">Out of Stock</option>        
                        </select>
                    </div>
                    

                    <c:if test = "${!empty category }">
                    	 <label>Product Category</label>
                    	<div class="form-group">	
                    		  <select class="form-control" name="productCategory">
                    		<option value="Choose..." default>Choose</option>
                    			<c:forEach items="${category }" var="category">
                    				<option value="${category.categoryName}">${category.categoryName }</option>
                    			</c:forEach>
                    		</select>
                    	</div>
                     </c:if>
                     
                     
					<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#addcategory">
					  Add Category
					</button>
                    	
                  <div>
                 	 <label>Upload Product Image</label>
                  	<input type="file" class="form-control" name="productImage">
                  </div>
 
                    <div class="form-group">
                        <input type="submit" value="Create" class="btn btn-warning rounded border border-dark shadow ">
                    </div>
                </form>
                
               
            </div>
        </div>
        
        <%@ include file="addcategory.jsp" %>	
    </div>
    
    <%@ include file="footlayout.jsp" %>