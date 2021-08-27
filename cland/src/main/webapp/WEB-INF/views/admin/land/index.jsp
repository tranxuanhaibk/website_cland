<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/tags/taglib.jsp" %>
<div class="col-md-10">
		<div class="content-box-large">
			<div class="row">
				<div class="panel-heading">
					<div class="panel-title ">Quản lý tin tức</div>
 			</div>
	</div>
	<hr>	
	<div class="row">
		<div class="col-md-8">
			<a href="${pageContext.request.contextPath}/admin/land/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>
		</div>
             	<!-- <div class="col-md-4">
              	 <div class="input-group form">
                    <input type="text" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                      <button class="btn btn-primary" type="button">Search</button>
                    </span>
               	 </div>
               	</div> -->
	</div>
	<c:if test="${not empty msg}">
		<div class="alert alert-success">
			<strong>${msg}</strong>
		</div>
	</c:if>
	<div class="row">
			<div class="panel-body">
				<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên</th>
					<th>Danh mục</th>
					<th>Lượt đọc</th>
					<th>Hình ảnh</th>
					<th>Trạng thái hoạt động</th>
					<th>Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty landList}">
				<c:forEach items="${landList}" var="land">
					<tr class="odd gradeX">
						<td>${land.lid}</td>
						<td>${land.lname}</td>
						<td>${land.category.cname}</td>
						<td class="center">${land.countViews}</td>
						<td class="center text-center">
							<c:choose>
								<c:when test="${not empty land.picture}">
								<img src="${pageContext.request.contextPath}/resources/uploads/${land.picture}" width ="300" height="200"/>
								</c:when>
								<c:otherwise>
									<p>Không có hình ảnh</p>
								</c:otherwise>
							</c:choose>
						</td>
						<c:set value="${land.status}" var="status"/>
						<c:if test="${status eq 1}"><td><a href="" title="" class="btn btn-primary status_active" id="${land.lid}">Có</a></td></c:if>
						<c:if test="${status eq 0}"><td><a href="" title="" class="btn btn-primary status_active" id="${land.lid}">Không</a></td></c:if>
						<td class="center text-center">
							<a href="${pageContext.request.contextPath}/admin/land/edit/${land.lid}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
	                        <a href="${pageContext.request.contextPath}/admin/land/del/${land.lid}" title="" class="btn btn-danger" onclick="return confirm('Xóa tin tức. Are you sure?')"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
						</td>
					</tr>
				</c:forEach>
				</c:if>
			</tbody>
		</table>
		<!-- Pagination -->
		<nav class="text-center" aria-label="...">
		   <ul class="pagination">
		   	<c:if test="${currentPage != 1}">
		   		<li class=""><a href="${pageContext.request.contextPath}/admin/land/index/${currentPage - 1}" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
		   	</c:if>
			   <c:forEach begin="1" end="${totalPage}" var="i">
			   	<li class="<c:if test="${i eq currentPage}">active</c:if>"><a href="${pageContext.request.contextPath}/admin/land/index/${i}">${i}<span class="sr-only">(current)</span></a></li>
			   </c:forEach>
			<c:if test="${currentPage != totalPage}">
		   		<li><a href="${pageContext.request.contextPath}/admin/land/index/${currentPage + 1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>
		   	</c:if>
		   </ul>
		</nav>
		<!-- /.pagination -->
			</div>
			</div><!-- /.row -->
		</div><!-- /.content-box-large -->
 </div>
 <script>
		$(document).ready(function () {
	        $('.status_active').click(function () {
	        	var id = $(this).attr('id');
	        	/* alert(id); */
	        	
	            $.ajax({
					url: '<%=request.getContextPath()%>/admin/land/status',
					type: 'POST',
					cache: false,
					data: {
						aid: id
					},
					success: function(data){
						$(".status_active").text(text);
					},
					error: function (){
						alert('Có lỗi xảy ra');
					}
				});
	        });
	 	});  
	</script>
<script>