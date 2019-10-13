<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">


	<div class="row">
		<c:if test="${not empty message}">


			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${message}

				</div>
			</div>

		</c:if>


		<div class="col-md-offset-2 col-md-8">


			<div class="panel panel-primary">

				<div class="panel-heading">


					<h4>Product Management</h4>



				</div>

				<div class="panel-body"></div>
				<!-- Form Elements -->


				<sf:form class="form-horizontal" modelAttribute="product"
					action="${contextRoot}/manage/products" method="POST"
					enctype="multipart/form-data">


					<div class="form-group">

						<label class="control-label col-md-4" for="name">Enter
							Product Name: </label>
						<div class="col-md-8">
							<sf:input type="text" path="name" id="name"
								placeholder="Product Name" class="form-control" />
							<sf:errors path="name" element="em" class="help-block" />

						</div>
					</div>


					<div class="form-group">

						<label class="control-label col-md-4" for="brand">Enter
							Brand Name: </label>
						<div class="col-md-8">
							<sf:input type="text" path="brand" id="brand"
								placeholder="Brand Name" class="form-control" />
							<sf:errors path="brand" element="em" class="help-block" />

						</div>
					</div>

					<div class="form-group">

						<label class="control-label col-md-4" for="productDescription">
							Product Description: </label>
						<div class="col-md-8">
							<sf:textarea path="description" id="description" rows="4"
								placeholder="Write a description" class="form-control"></sf:textarea>
							<sf:errors path="description" element="em" class="help-block" />
						</div>
					</div>


					<div class="form-group">

						<label class="control-label col-md-4" for="unitPrice">Product
							Price: </label>
						<div class="col-md-8">
							<sf:input type="number" path="unitPrice" id="unitPrice"
								placeholder="Unit Price in &#8377" class="form-control" />
							<sf:errors path="unitPrice" element="em" class="help-block" />
						</div>
					</div>

					<div class="form-group">

						<label class="control-label col-md-4" for="quantity">Quantity
							Available: </label>
						<div class="col-md-8">
							<sf:input type="number" path="quantity" id="quantity"
								placeholder="Quantity Avaiable" class="form-control" />
						</div>
					</div>

					<div class="form-group">

						<label class="control-label col-md-4" for="file">Select an
							Image: </label>
						<div class="col-md-8">
							<sf:input type="file" path="file" id="file" class="form-control" />
						</div>
					</div>


					<div class="form-group">

						<label class="control-label col-md-4" for="categoryId">Select
							Category: </label>
						<div class="col-md-8">
							<sf:select class="form-control" path="categoryId" id="categoryId"
								items="${categories}" itemLabel="name" itemValue="id" />
							<c:if test="${product.id==0}">
								<div class=text-right>
									<button type="button" data-toggle="modal"
										data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add
										Category</button>
								</div>
							</c:if>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" name="sumbit" id="submit" value="Submit"
								class="btn btn-primary" />
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="active" />
							<sf:hidden path="purchase" />
							<sf:hidden path="views" />
						</div>
					</div>

				</sf:form>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<hr />
			<h1>Available Products</h1>
			<hr />
		</div>



		<div class="col-md-offset-2 col-md-11">


			<table id="adminProductsTable"
				class="table table-condensed table-bordered">

				<thead>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>
						<th>Edit</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>
						<th>Edit</th>
					</tr>
				</tfoot>


			</table>


		</div>


	</div>

	<!-- Modal -->
<!-- Modal -->
<div class="modal" id="myCategoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterTitle">Add New Category</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <sf:form class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
        
        <div class="form-group">

						<label class="control-label col-md-4" for="name">Enter
							Category Name: </label>
						<div class="col-md-8">
							<sf:input type="text" path="name" id="name"
								placeholder="Category Name" class="form-control" />
							<sf:errors path="name" element="em" class="help-block" />

						</div>
					</div> 
        
        	<div class="form-group">

						<label class="control-label col-md-4" for="description">
							Category Description: </label>
						<div class="col-md-8">
							<sf:textarea path="description" id="description" rows="4"
								placeholder="Write a description for your Category" class="form-control"></sf:textarea>
							<sf:errors path="description" element="em" class="help-block" />
						</div>
					</div> 
        
        
        <div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" value="Add Category"
								class="btn btn-primary" />
								</div>
								</div> 
        
        
        </sf:form>
      </div>
    
    </div>
  </div>
</div>
</div>
