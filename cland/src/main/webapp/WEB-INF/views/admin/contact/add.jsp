<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file = "/WEB-INF/templates/tags/taglib.jsp" %>
  <div class="col-md-10">
  <form action="${pageContext.request.contextPath }/admin/contact/add" method="post" id="contactform">
		<div class="row">
			<div class="col-md-12 panel-info">
 			<div class="content-box-header panel-heading">
				<div class="panel-title ">Thêm nội dung liên hệ</div>
 			</div>
 			<div class="content-box-large box-with-header">
  			<div>
				<div class="row">
					<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên người gửi</label>
								<input type="text" name ="fullname" class="form-control" placeholder="Nhập tên người gửi">
							</div>
							<div class="form-group">
							   <label>Email</label>
							   <input type="text"  name ="email" class="form-control" placeholder="Nhập email">
							</div>
							<div class="form-group">
							   <label>Chủ đề</label>
							   <input type="text"  name ="subject" class="form-control" placeholder="Nhập chủ đề">
							</div>
							<div class="form-group">
							   <label>Nội dung</label>
							   <input type="text" name ="content" class="form-control" placeholder="Nhập nội dung">
							</div>
							<div class="form-group">
							<input type="submit" value="Thêm" class="btn btn-success" />
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