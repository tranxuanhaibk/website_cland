<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file = "/WEB-INF/templates/tags/taglib.jsp" %>
  <div class="col-md-10">
  <c:if test="${contact ne null}">
  <c:set value="${contact.cid}" var="cid"/>
  <c:set value="${contact.fullname}" var="fullname"/>
  <c:set value="${contact.phone}" var="phone"/>
  <c:set value="${contact.email}" var="email"/>
  <c:set value="${contact.subject}" var="subject"/>
  <c:set value="${contact.content}" var="content"/>
  </c:if>
  <form action="${pageContext.request.contextPath }/admin/contact/edit/${cid}" method="post" id="contactform">
		<div class="row">
			<div class="col-md-12 panel-info">
 			<div class="content-box-header panel-heading">
					<div class="panel-title ">Sửa nội dung liên hệ</div>
 			</div>
 			<div class="content-box-large box-with-header">
  			<div>
				<div class="row">
					<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên người gửi</label>
								<form:errors path="contact.fullname" cssStyle="background-color:yellow;"></form:errors>
								<input type="text" name ="fullname" value="${fullname}" class="form-control" placeholder="Nhập tên người gửi" >
							</div>
							<div class="form-group">
								<label for="name">Tên người gửi</label>
								<form:errors path="contact.phone" cssStyle="background-color:yellow;"></form:errors>
								<input type="text" name ="phone" value="${phone}" class="form-control" placeholder="Nhập số điện thoại" >
							</div>
							<div class="form-group">
							   <label>Email</label>
							   <form:errors path="contact.email" cssStyle="background-color:yellow;"></form:errors>
							   <input type="text" name ="email" value="${email}" class="form-control" placeholder="Nhập Email">
							</div>
							<div class="form-group">
							   <label>Chủ đề</label>
							   <form:errors path="contact.subject" cssStyle="background-color:yellow;"></form:errors>
							   <input type="text" name ="subject" value="${subject}" class="form-control" placeholder="Nhập chủ đề">
							</div>
							<div class="form-group">
							   <label>Nội dung</label>
							   <form:errors path="contact.content" cssStyle="background-color:yellow;"></form:errors>
							   <textarea  name ="content" class="form-control" placeholder="Nhập nội dung">${content}</textarea>
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