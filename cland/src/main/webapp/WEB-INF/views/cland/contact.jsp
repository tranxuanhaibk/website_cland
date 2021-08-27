<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/templates/tags/taglib.jsp" %>
<div class="clearfix main_content floatleft">
	<div class="clearfix content">
		<div class="contact_us">
			<h1>Liên hệ với chúng tôi</h1>
			<p>
			TRUNG TÂM ĐÀO TẠO TƯ VẤN BĐS HAIBRA<br />
			Trụ sở: 47 Nguyễn Lương Bằng, Liên Chiểu, Đà Nẵng<br />
			Web: <a href="https://www.facebook.com/haihong0810/" title="">www.haibra.edu.vn</a>
			</p>
			<c:if test="${not empty msg}">
				<div class="alert alert-success">
					<strong>${msg}</strong>
				</div>
			</c:if>
			<form action="${pageContext.request.contextPath}/contact" method="post">
				<p><input type="text" name="fullname" class="wpcf7-text" placeholder="Họ tên *"/></p>
				<form:errors path="contact.fullname" cssStyle="color:red"></form:errors>
				
				<p><input type="text" name="phone" class="wpcf7-text" placeholder="Số điện thoại *"/></p>
				<form:errors path="contact.fullname" cssStyle="color:red"></form:errors>
				
				<p><input type="text" name="email" class="wpcf7-email" placeholder="Email *"/></p>
				<form:errors path="contact.email" cssStyle="color:red"></form:errors>
				
				<p><input type="text" name="subject" class="wpcf7-text" placeholder="Chủ đề *"/></p>
				<form:errors path="contact.subject" cssStyle="color:red"></form:errors>
				
				<p><textarea class="wpcf7-textarea" name="content" placeholder="Nội dung *"></textarea></p>
				<form:errors path="contact.content" cssStyle="color:red"></form:errors>
				<p><input type="Submit" class="wpcf7-submit" value="Gửi liên hệ"/></p>
			</form>
		</div>
	</div>
</div>