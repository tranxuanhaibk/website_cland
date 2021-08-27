<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/tags/taglib.jsp" %>
<!-- header -->
<!DOCTYPE html>
<html>
  <head>
    <title>VNE Login</title>
    <link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/admin/images/icon-180x180.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<spring:url value="/resources/admin/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- styles -->
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
    <link href="<spring:url value="/resources/admin/css/style1.css"/>" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
 <!-- BEGIN HEADER -->
  	<tiles:insertAttribute name="header"/>
 <!--END Header -->
	<div class="page-content container">
		<form action="" method="post">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
			        <div class="box">
			            <div class="content-wrap">
			            	<img width="100px" height="100px" class="img-circle" src="${pageContext.request.contextPath}/resources/admin/images/icon-180x180.png">
			                <h6>Đăng nhập</h6>
			                <c:if test="${not empty param['msg']}">
			                <h5 style="color:red">Sai tên đăng nhập Hoặc mật khẩu</h5>
			                <h4 style="color:black">Vui lòng Nhập lại</h4>
			                </c:if>
			                <div class="form-group">
			                	<label class="text-left pull-left" for="username">Tên đăng nhập</label>
			               		<input class="form-control" name="username" type="text" placeholder="Username">
			                </div>
			                
			                <div class="form-group">
			                	<label class="text-left pull-left" for="password">Mật khẩu</label>
			                	<input class="form-control" type="password" name="password" placeholder="Password">
			                </div>
			                
			                <div class="action">
			                    <input type="submit" class="btn btn-primary signup btn-block" value="Đăng nhập">
			                </div>                
			            </div>
			        </div>

			        <div class="already">
			            <p>Don't have an account yet?</p>
			            <a href="javascript:void(0)">Sign Up</a>
			        </div>
			    </div>
			</div>
		</div>
		</form>
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<spring:url value="/resources/admin/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="<spring:url value="/resources/admin/js/custom.js"/>"></script>
  </body>
</html>