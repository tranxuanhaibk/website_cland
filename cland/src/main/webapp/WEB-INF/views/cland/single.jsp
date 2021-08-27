<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/tags/taglib.jsp" %>
<div class="clearfix main_content floatleft">
	<div class="clearfix content">
	<c:if test="${landDTO ne null}">
		<h1>${landDTO.lname}</h1>
		<div class="clearfix post-meta">
			<p><span><i class="fa fa-clock-o"></i>Địa chỉ : ${landDTO.address}</span> 
			<span><i class="fa fa-folder"></i>Diện tích : ${landDTO.area} m²</span>
			<span><i class="fa fa-folder"></i>Lượt xem : ${landDTO.countViews}</span></p>
			
		</div>
		<div class="vnecontent" >
			<p>${landDTO.description}</p>
			<img src="${pageContext.request.contextPath}/resources/uploads/${landDTO.picture}" alt="" width="600px" height="500px"/>
		</div>
		<div class="content_map">
			<h2 style="text-align: left;">------Vị trí trên bản đồ------</h2>
		</div>
		<div id="map1"></div>
    <script type="text/javascript">
    let map;
    function initMap() {
    	
      var longi = ${landDTO.longitude};
      var lat = ${landDTO.latitude};
    	
      map = new google.maps.Map(document.getElementById("map1"), {
        center: { lat: lat, lng: longi },
        zoom: 15,
        mapTypeId: "roadmap"
      });
    	
    	var icon  = 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png';
      const marker = new google.maps.Marker({
          position: { lat: lat, lng: longi },
          map: map,
          label: "Tại Đây",
          title: "Vi tri can tim",
          draggable: false,
          animation: google.maps.Animation.DROP,
          icon: icon
      });

      const infoWindow = new google.maps.InfoWindow({
        content: "<p>Đã các định được vị trí</p>"
      });
      infoWindow.open(map, marker);
    }
    </script>
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCL-bM9kNshNLWs8HhKU4gLv6-WRrCl-gE&callback=initMap&libraries=&v=weekly"
      defer
    ></script>
	</c:if>
	</div>
		<div class="more_themes">
			<h2>Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i></h2>
			<div class="more_themes_container">
				<c:choose>
					<c:when test="${not empty landRelated}">
						<c:forEach items="${landRelated}" var="related">
							<div class="single_more_themes floatleft">
								<img src="${pageContext.request.contextPath}/resources/uploads/${related.picture}" alt=""/>
								<a href="${pageContext.request.contextPath}/single/${related.lid}"><h2>${related.lname}</h2></a>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p style="background-color:powderblue;">------ Không có tin liên quan !</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
</div>
