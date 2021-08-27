<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/tags/taglib.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/admin/cat"/>
<div class="col-md-10">
<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý danh mục</div>
		</div>
	</div>
	<hr>	
	<div class="row">
		<div class="col-md-8">
			<a href="${contextPath}/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

		</div>
         <!-- 	<div class="col-md-4">
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
					<th>Số lượng tin</th>
					<th width="300">Chức năng</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${not empty categoryList}">
				<c:forEach items="${categoryList}" var="cat">
				<c:set var="urlEdit" value="${contextPath}/edit/${cat.cid}"/>
				<c:set var="urlDel" value="${contextPath}/del/${cat.cid}"/>
				<c:set var="count" value="${landService.countItemsByCat(cat.cid)}"></c:set>
				<tr class="odd gradeX">
					<td>${cat.cid}</td>
					<td>${cat.cname}</td>
					<td>${count}</td>
					<td class="center text-center">
						<a href="${urlEdit}" title="Sửa" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
                        <a href="${urlDel}" title="Xoá" class="btn btn-danger" onclick="return confirm('Xóa danh mục sẽ xóa những tin thuộc danh mục. Are you sure?')" ><span class="glyphicon glyphicon-trash"></span> Xóa</a>
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
		      <li class="disabled"><a href="${pageContext.request.contextPath}/admin/cat/index/${currentPage - 1}" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
		   </c:if>   
		      <c:forEach begin="1" end="${totalPage}" var="i">
		      	<li class="<c:if test="${i eq currentPage}">active</c:if>"><a href="${pageContext.request.contextPath}/admin/cat/index/${i}">${i}<span class="sr-only">(current)</span></a></li>
		      </c:forEach>
		      <c:if test="${currentPage != totalPage}">
		      <li><a href="${pageContext.request.contextPath}/admin/cat/index/${currentPage + 1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>
		   </c:if>
		   </ul>
		</nav>
		<!-- /.pagination -->
			</div>
			</div><!-- /.row -->
		</div><!-- /.content-box-large -->
 </div>