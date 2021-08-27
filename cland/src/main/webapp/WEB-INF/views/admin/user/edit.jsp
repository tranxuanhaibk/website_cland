<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file = "/WEB-INF/templates/tags/taglib.jsp" %>
  <div class="col-md-10">
  <c:if test="${user ne null}">
  <c:set value="${user.id}" var="id"/>
  <c:set value="${user.userName}" var="userName"/>
  <c:set value="${user.fullName}" var="fullName"/>
  <c:set value="${user.passWord}" var="passWord"/>
  <c:set value="${user.authorization}" var="authorization"/>
  </c:if>
  <form action="${pageContext.request.contextPath }/admin/user/edit/${id}" method="post" id="contactform">
		<div class="row">
			<div class="col-md-12 panel-info">
 			<div class="content-box-header panel-heading">
					<div class="panel-title ">Sửa người dùng</div>
 			</div>
 			<div class="content-box-large box-with-header">
  			<div>
				<div class="row">
					<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên đăng nhập</label>
								<form:errors path="user.userName" cssStyle="background-color:yellow;"></form:errors>
								<input type="text" name ="userName" value="${userName}" class="form-control" placeholder="Nhập tên đăng nhập" >
							</div>
							<div class="form-group">
							   <label>Họ Tên</label>
							   <form:errors path="user.fullName" cssStyle="background-color:yellow;"></form:errors>
							   <input type="text" name ="fullName" value="${fullName}" class="form-control" placeholder="Nhập họ tên">
							</div>
							<div class="form-group">
							   <label>Mật Khẩu</label>
							   <form:errors path="user.passWord" cssStyle="background-color:yellow;"></form:errors>
							   <input type="password" name ="passWord" value="" class="form-control" placeholder="Nhập mật khẩu">
							</div>
							<div class="form-group">
							   <label>Phân quyền</label>
							   <form:errors path="user.authorization" cssStyle="background-color:yellow;"></form:errors>
							   <input type="text" name ="authorization" value="${authorization}" class="form-control" placeholder="Nhập mật khẩu">
							</div>
							<div class="form-group">
							<input type="submit" value="Sửa" class="btn btn-success" />
							<input type="reset" value="Nhập lại" class="btn btn-default" />
							</div>
					</div>
				</div>
				<hr>
			</div>
		</div>
 		</div>
		</div><!-- /.row col-size -->
		</form>
  </div><!-- /.col-md-10 -->