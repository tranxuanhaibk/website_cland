<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file = "/WEB-INF/templates/tags/taglib.jsp" %>
  <div class="col-md-10">
  <form action="${pageContext.request.contextPath }/admin/land/add" method="post" id="contactform" enctype="multipart/form-data">
		<div class="row">
			<div class="col-md-12 panel-info">
 			<div class="content-box-header panel-heading">
					<div class="panel-title ">Thêm danh mục</div>
 			</div>
 			<div class="content-box-large box-with-header">
  			<div>
				<div class="row mb-10"></div>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">Tên truyện</label>
							<input type="text" class="form-control" placeholder="Nhập tên truyện" name = "lname">
						</div>
						<div class="form-group">
							<label>Danh mục</label>
							<select class="form-control" name = "cid">
							  <option value="">Chọn thể loại</option>
									<c:forEach items="${categories}" var="cat">
										<option value="${cat.cid}">${cat.cname}</option>
									</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Thêm hình ảnh</label>
							<input type="file" class="btn btn-default" id="exampleInputFile1">
							<p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
						</div>
						<div class="form-group">
						   <label>Mô tả</label>
						   <textarea class="form-control" rows="3"></textarea>
						</div>
					</div>
					<div class="col-sm-6"></div>

					<div class="col-sm-12">
						<div class="form-group">
						   <label>Chi tiết</label>
						   <textarea class="form-control" rows="7"></textarea>
						</div>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-12">
						<input type="submit" value="Thêm" class="btn btn-success" />
						<input type="reset" value="Nhập lại" class="btn btn-default" />
					</div>
				</div>
			</div>
		</div>
 		</div>
		</div><!-- /.row col-size -->
		</form>
  </div><!-- /.col-md-10 -->