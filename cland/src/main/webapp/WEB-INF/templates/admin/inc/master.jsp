<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/tags/taglib.jsp" %>
<!-- header -->
<!DOCTYPE html>
<html>
  <head>
    <title>Hệ thống quản trị viên</title>
    <link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/cland/images/icon.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<spring:url value="/resources/admin/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- styles -->
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
    <link href="<spring:url value="/resources/admin/css/style1.css"/>" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
   <script
        src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places&key=AIzaSyCL-bM9kNshNLWs8HhKU4gLv6-WRrCl-gE"></script>
  <!-- heager -->
  <tiles:insertAttribute name="header"/>
<!-- END header -->
    <div class="page-content">
    	<div class="row">
		 <tiles:insertAttribute name="sidebar"/>
		 <tiles:insertAttribute name="content"/>
		</div><!-- /.row -->
    </div><!-- /.page-content -->

    <!-- Footer -->
    <tiles:insertAttribute name="footer"/>
    <!-- END footer -->