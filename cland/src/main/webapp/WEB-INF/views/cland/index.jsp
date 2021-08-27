<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/tags/taglib.jsp"%>
<div class="clearfix main_content floatleft">
	<div class="clearfix slider">
		<ul class="pgwSlider">
			<li><img src="${pageContext.request.contextPath}/resources/cland/images/thumbs/burjkhalifa.jpg" alt="Dubai"
				data-description="Sheikh Mohammed bin Rashid Blvd - Downtown Dubai - Dubai"
				data-large-src="${pageContext.request.contextPath}/resources/cland/images/slides/burjkhalifa.jpg" /></li>
			<li><img
				src="${pageContext.request.contextPath}/resources/cland/images/thumbs/dlandmark81.jpg" alt="TP.Hồ Chí Minh"
				data-large-src="${pageContext.request.contextPath}/resources/cland/images/slides/dlandmark81.jpg"
				data-description="208 Nguyễn Hữu Cảnh, phường 22, quận Bình Thạnh, TP Hồ Chí Minh" /></li>
			<li><img
				src="${pageContext.request.contextPath}/resources/cland/images/thumbs/landmark.jpg" alt="TP.Hồ Chí Minh"
				data-large-src="${pageContext.request.contextPath}/resources/cland/images/slides/landmark.jpg"
				data-description="208 Nguyễn Hữu Cảnh, phường 22, quận Bình Thạnh, TP Hồ Chí Minh">
			</li>
		</ul>
	</div>
	<div class="clearfix content">
		<div class="content_title">
			<h2>Bài viết mới</h2>
		</div>
		<div class="clearfix single_content">
			<c:choose>
				<c:when test="${not empty listSearch}">
				<h2>Kết quả tìm kiếm cho: <strong style="color:red">${search}</strong></h2>
					<c:forEach items="${listSearch}" var="land">
						<div class="clearfix post_detail">
							<h2>
								<a href="${pageContext.request.contextPath}/single/${land.lid}">${land.lname}</a>
							</h2>
							<fmt:formatDate value="${land.dateCreate}" pattern="MM" var="landMonth"/>
							<fmt:formatDate value="${land.dateCreate}" pattern="dd" var="landDay"/>
							<div class="clearfix post_date floatleft">
							<div class="date">
								<p>${landDay}</p>
								<p>${landMonth}</p>
							</div>
							</div>
							<div class="clearfix post-meta">
								<p>
									<span><i class="fa fa-clock-o"></i> Địa chỉ : ${land.address}</span> 
									<span><i class="fa fa-folder"></i> Diện tích : ${land.area} m²</span>
									<span><i class="fa fa-folder"></i> Lượt xem : ${land.countViews}</span>
								</p>
							</div>
							<div class="clearfix post_excerpt">
								<img
									src="${pageContext.request.contextPath}/resources/uploads/${land.picture}"
									alt="${land.picture}" />
								<p>${land.description}</p>
							</div>
							<a href="${pageContext.request.contextPath}/single/${land.lid}">Đọc thêm</a>
						</div>
						
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:if test="${not empty landList}">
						<c:forEach items="${landList}" var="land">
								<fmt:formatDate value="${land.dateCreate}" pattern="MM" var="landMonth"/>
								<fmt:formatDate value="${land.dateCreate}" pattern="dd" var="landDay"/>
								<div class="clearfix post_date floatleft">
								<div class="date">
									<h3>Ngày ${landDay}</h3>
									<p>Tháng ${landMonth}</p>
								</div>
								</div>
							<div class="clearfix post_detail">
								<h2>
									<a href="${pageContext.request.contextPath}/single/${land.lid}">${land.lname}</a>
								</h2>
								<div class="clearfix post-meta">
									<p>
										<span><i class="fa fa-clock-o"></i> Địa chỉ :
											${land.address}</span> <span><i class="fa fa-folder"></i>
											Diện tích : ${land.area} m²</span> <span><i
											class="fa fa-folder"></i> Lượt xem : ${land.countViews}</span>
									</p>
								</div>
								<div class="clearfix post_excerpt">
									<img
										src="${pageContext.request.contextPath}/resources/uploads/${land.picture}"
										alt="${land.picture}" />
									<p>${land.description}</p>
								</div>
								<a href="${pageContext.request.contextPath}/single/${land.lid}">Đọc thêm</a>
							</div>
						</c:forEach>
					</c:if>
					<div class="pagination">
						<nav>
							<ul>
								<c:if test="${currentPage != 1}">
						   			<li class=""><a href="${pageContext.request.contextPath}/index/${currentPage - 1}" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						   		</c:if>
								<c:forEach begin="1" end="${totalPage}" var="i">
									<li class="<c:if test="${i eq currentPage}">active</c:if>"><a href="${pageContext.request.contextPath}/index/${i}">${i}</a></li>
								</c:forEach>
								<c:if test="${currentPage != totalPage}">
						   			<li><a href="${pageContext.request.contextPath}/index/${currentPage + 1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>
						   		</c:if>
							</ul>
						</nav>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- PAGI TEMPALTE DIV -->
</div>