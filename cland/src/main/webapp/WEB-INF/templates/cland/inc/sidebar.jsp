<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/tags/taglib.jsp" %>
<div class="clearfix sidebar_container floatright">
	<div class="clearfix sidebar">
		<div class="clearfix single_sidebar category_items">
			<h2>Danh mục bất động sản</h2>
			<ul>
			<c:if test="${not empty categories}">
			<c:forEach items="${categories}" var="cat">
				<c:set var="count" value="${landService.countItemsByCat(cat.cid)}"></c:set>
				<li class="cat-item"><a href="${pageContext.request.contextPath}/cat/${cat.cid}">${cat.cname}</a>(${count})</li>
			</c:forEach>
			</c:if>
			</ul>
		</div>

		<div class="clearfix single_sidebar">
			<div class="popular_post">
				<div class="sidebar_title"><h2>Xem nhiều</h2></div>
				<ul>
					<c:forEach items="${landHot}" var="landHot">
						<li><a href="${pageContext.request.contextPath}/single/${landHot.lid}">${landHot.lname}</a></li>
					</c:forEach>
				</ul>
			</div>
			</div>
		<div class="clearfix single_sidebar">
			<iframe width="300" height="315" src="https://www.youtube.com/embed/Bmd4nuUnMH8" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</div>
		<!-- <div class="clearfix single_sidebar">
			<h3>Lọc theo diện tích</h3>
		</div> -->
	</div>
</div>