<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="home" /></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<c:url value="/template/web/css/styles.css" />">
</head>
<body>

	<!--header-->
	<%@ include file="/common/web/header.jsp"%>
	<!--header-->

	<!-- main -->
	<dec:body />
	<!-- main -->

	<!--footer-->
	<%@ include file="/common/web/footer.jsp"%>
	<!--footer-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value="template/js/scripts.js" />"></script>
</body>
</html>