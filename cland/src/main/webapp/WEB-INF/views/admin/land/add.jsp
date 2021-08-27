<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/tags/taglib.jsp" %>  
 <div class="col-md-10">
		<form action="${pageContext.request.contextPath }/admin/land/add" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-12 panel-info">
  			<div class="content-box-header panel-heading">
 					<div class="panel-title ">Thêm tin tức</div>
  			</div>
  			<div class="content-box-large box-with-header">
	  			<div>
					<div class="row mb-10"></div>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên tin</label>
								<form:errors path="land.lname" cssStyle="color:red"></form:errors>
								<input type="text" name="lname" class="form-control" placeholder="Nhập tên tin">
							</div>
							
							<div class="form-group">
								<label>Danh mục tin</label>
								<select name="cid" class="form-control">
									<c:if test="${not empty catList}">
										<c:forEach var="cat" items="${catList}">
								   			<option value="${cat.cid }">${cat.cname}</option>
								   		</c:forEach>
								   	</c:if>
								</select>
							</div>

							<div class="form-group">
								<label>Thêm hình ảnh</label>
								<input type="file" class="btn btn-default" name="hinhanh" id="exampleInputFile1">
								<p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
							</div>
							
							<div class="form-group">
							   <label>Diện tích</label>
							   <form:errors path="land.area" cssStyle="color:red"></form:errors>
							   <textarea class="form-control" name="area" rows="1"></textarea>
							</div>
							
							<div class="form-group">
							   <label>Địa chỉ</label>
							   <form:errors path="land.address" cssStyle="color:red"></form:errors>
							   <textarea class="form-control" name="address" rows="3" id="txtautocomplete"></textarea>
							</div>
							<label id="lblResult"></label>
    						<!-- <div id="lat"></div> -->
    						
    						<div class="form-group">
								<label for="name">Kinh độ</label>
								<form:errors path="land.longitude" cssStyle="color:red"></form:errors>
								<input type="text" name="longitude" class="form-control" id="long">
							</div>
							<div class="form-group">
								<label for="name">Vĩ độ</label>
								<form:errors path="land.latitude" cssStyle="color:red"></form:errors>
								<input type="text" name="latitude" class="form-control" id="lat">
							</div>
						</div>
						<div class="col-sm-6"></div>

						<div class="col-sm-12">
							<div class="form-group">
							   <label>Mô tả</label>
							   <form:errors path="land.description" cssStyle="color:red"></form:errors>
							   <textarea class="form-control" name="description" rows="7"></textarea>
							</div>
						</div>
					</div>

					<hr>

					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Thêm" class="btn btn-success mapInput" />
							<input type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
					</div>
				</div>
			</div>
  		</div>
		</div>
		<c:if test="${not empty msg}">
			<p style="color: red; font-weight: bold">${msg}</p>
		</c:if>
		</form>
		<!-- /.row col-size -->
 </div><!-- /.col-md-10 -->
<script type="text/javascript">
        google.maps.event.addDomListener(window, 'load', intilize);
        
        function intilize() {
            var autocomplete = new google.maps.places.Autocomplete(document.getElementById('txtautocomplete'));

            google.maps.event.addListener(autocomplete, 'place_changed', function () {
                var place = autocomplete.getPlace();
                var location = "<b>Address:</b>" + place.formatted_address + "<br/>";
                var lat = place.geometry.location.lat();
                var longi = place.geometry.location.lng();
                document.getElementById('lblResult').innerHTML = location
                document.getElementById('long').value = longi
                document.getElementById('lat').value = lat
                
            });
        };
        /* AJAX */
       <%--  $(document).ready(function () {
	        $('.mapInput').click(function () {
	        	alert(longi);
	        	var id = $(this).attr('id');        	
	            $.ajax({
					url: '<%=request.getContextPath()%>/admin',
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
	 	});   --%>
</script>	