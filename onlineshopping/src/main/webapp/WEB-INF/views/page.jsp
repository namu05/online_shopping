<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="fonts" value="/resources/fonts" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping-${title}</title>

<script>
	window.menu = '${title}';
</script>
<script>
	window.contextRoot = '${contextRoot}';
</script>


<!-- Bootstrap core CSS -->
 <link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
 <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom styles for this template -->
 <link href="${css}/myapp.css" rel="stylesheet">



</head>

<body>

<div class="wrapper">
	<!-- Navigation -->
	<%@include file="./shared/nav-bar.jsp"%>

	<!-- Page Content -->
	<div class="content">
	<c:if test="${userClickHome == true }">
		<%@include file="home.jsp"%>
	</c:if>



	<c:if test="${userClickAbout == true }">
		<%@include file="about.jsp"%>
	</c:if>

	<c:if test="${userClickContact == true }">
		<%@include file="contact.jsp"%>
	</c:if>

	<c:if
		test="${userClickAllProducts == true || userClickCategoryProducts == true}">
		<%@include file="listProducts.jsp"%>
	</c:if>
	
	<c:if
		test="${userClickManageProducts == true}">
		<%@include file="manageProducts.jsp"%>
	</c:if>

</div>
	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/jquery.dataTables.js"></script>
	<script src="${js}/dataTables.bootstrap.js"></script>  
	<script src="${js}/bootbox.min.js"></script>
	<script src="${js}/myapp.js"></script>
</div>
</body>

</html>
