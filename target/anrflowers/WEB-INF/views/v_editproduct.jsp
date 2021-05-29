
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="headlayout.jsp" %>

 <div class="container-fluid border shadow-sm ">
        <div class="row m-2">
            <a href="addproduct" class="btn btn-warning m-3 border shadow">Create Listing</a>
            <a href="listproducts" class="btn btn-warning m-3 border shadow">View Listing</a>
        </div>
    </div>
    
    <div class="container">
        <div class="row shadow border m-3 p-3">
            <div class="col-md-8">
             <c:if test="${!empty product}">
             	<form action="updateproduct" method="post" class="form-group" enctype="multipart/form-data">
             	
             		<div class="form-group">
		           	 	<input class="form-control" type="text" value="${product.productId}" name="productId" hidden>
		        	</div>
		        	
		        	<div class="form-group">
		           	 	<input class="form-control" type="text" value="${product.productCode}" name="productCode" hidden>
		        	</div>
		        	
                    <div>
                        <label>Enter Title</label>
                        <input type="text" name="productTitle" class="form-control mb-2" value = "${product.productTitle}"   placeholder="Enter Product Title">
                    </div>
                    
                    <div>
                        <label>Enter Product Description</label>
                        <textarea class="form-control  mb-2"  name="productDesc" cols="60" rows="10">${product.productDesc}</textarea>
                    </div>
                    <div>
                        <label>Available Quantity</label>
                        <input type="text" class="form-control mb-2" name="productQty"  value="${product.productQty}" placeholder="Enter Available Quanity">
                    </div>
                    
                    <div>
                        <label>Unit Price</label>
                        <input type="text" class="form-control mb-2" name="productListingPrice" value="${product.productListingPrice}" placeholder="Enter Unit Price">
                    </div>
                    <div class="form-group">
                       <label>Product Stock Status</label>
                        <select class="form-control" name="productStatus" value = "${product.productStatus}">
                            <option value="Choose" selected>Choose...</option>
                            <option value="IS" ${product.productStatus=='IS' ? 'selected':''}>In Stock</option>
                            <option value="OFS" ${product.productStatus=='OOFS' ? 'selected':''}>Out of Stock</option>        
                                
                        </select>
                    </div>
                    
                     <div class="fomr-group">
                        <label>Product Category</label>
                        <select class="form-control" name="productCategory" value = "${product.productCategory}">
                            <option value="Choose" selected>Choose...</option>
                            <option value="Birthday" ${product.productCategory=='Birthday' ? 'selected':''}>Birthday</option>
                            <option value="Love" ${product.productCategory=='Love' ? 'selected':''} >Love</option>
                            <option value="Occassion" ${product.productCategory=='Occassion' ? 'selected':''}>Occassion</option>
                            <option value="Flowers" ${product.productCategory=='Flowers' ? 'selected':''}>Flowers</option>
                            <option value="Gifts" ${product.productCategory=='Gifts' ? 'selected':''}>Gifts</option>
                            <option value="Other" ${product.productCategory=='Other' ? 'selected':''}>Other</option>
                        </select>
                    </div>

                  <div>
                 	 <label>Upload Product Image</label>
                  	<input type="file" class="form-control" name="productImage">
                  </div>
 
                    <div class="form-group">
                        <input type="submit" value="Edit" class="btn btn-warning rounded border border-dark shadow ">
                    </div>
                </form>
                
        </c:if>
                
               
            </div>
        </div>
    </div>

    <%@ include file="footlayout.jsp" %>
    