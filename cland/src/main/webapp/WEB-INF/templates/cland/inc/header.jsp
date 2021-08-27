<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/templates/tags/taglib.jsp" %>
<section id="header_area">
	<div class="wrapper header">
		<div class="clearfix header_top">
			<div class="clearfix logo floatleft">
				<a href="${pageContext.request.contextPath}/index"><h1><span>HAIBRA</span> | Bất Động Sản</h1></a>
			</div>
			<div class="clearfix search floatright">
				<form action="${pageContext.request.contextPath}/index" method="post">
					<input type="text" name="search" placeholder="Search"/>				
					<button type="submit"><i class="fas fa-search"></i></button>	
				</form>
			</div>
		</div>
		<div class="header_bottom">
			<nav>
				<ul id="nav">
					<li><a href="${pageContext.request.contextPath}/index">Trang chủ</a></li>
					<li id="dropdown"><a href="">Danh mục</a>
						<ul>
						<c:if test="${not empty categories}">
						<c:forEach items="${categories}" var="cat">
							<li><a href="${pageContext.request.contextPath}/cat/${cat.cid}">${cat.cname}</a></li>
						</c:forEach>
						</c:if>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath}/contact">Liên hệ</a></li>
					<%-- <li><a href="${pageContext.request.contextPath}/contact">Liên hệ</a></li> --%>
				</ul>
			</nav>
		</div>
	</div>
</section>