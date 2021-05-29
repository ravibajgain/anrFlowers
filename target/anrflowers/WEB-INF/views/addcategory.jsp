

<div class="modal fade" id="addcategory" tabindex="-1" role="dialog" aria-labelledby="productmodal" aria-hidden="true">
  <div class="modal-dialog" role="document">
   	 <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Add Product Description</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="${contextRoot }/product/addcategory" method="post">
        	<div class="form-group">
        		<label>Category Name</label>
        		<input type="text" class="form-control"	name="categoryName" placeholder="Add a new Category">
        	</div>
        	<div class="form-group">
        		<label>Category Description</label>
        		<textarea class="form-control" name="categoryDesc"></textarea>
        	</div>
        	
	      <div class="modal-footer">
	        <input type="submit" value="Add Category" class="btn btn-info btn-sm">
	      </div>
        </form>
     </div>
     </div>
 </div>
</div>
