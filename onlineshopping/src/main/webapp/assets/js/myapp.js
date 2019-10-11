$(function() {

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'View Products':
		$('#listProducts').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#home').addClass('active');
		break;

	
}
	var $table = $('#productListTable');
	if ($table.length) {
		

		var jsonUrl = '';
		if (window.categoryId == " ") {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else

		{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}

		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [

			{
				data : 'name'
			}, 
			{
				data : 'brand'
			},
			{
				data : 'unitPrice'
			},
			{
				data : 'quantity'
			},
			{ data : 'id',
			  mRender:function(data,type,row)
			 { var str='';
			 str += '<a href="'	+ window.contextRoot+ '/show/'+ data+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
			 str += '<a href="'+ window.contextRoot	+ '/cart/add/'	+ data	+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			  return str;
			  }
			 }
			]
			

		});
		}
});