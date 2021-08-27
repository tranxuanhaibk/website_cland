<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/templates/tags/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<title>HaiBra | Bất động sản</title>
		<link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/cland/images/icon.png" />
		<link rel="stylesheet" href="<spring:url value="/resources/cland/css/main.css"/>"/>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!--Oswald Font -->
		<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css' />
		<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/cland/css/tooltipster.css"/>" />
		<!-- home slider-->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous"/>
		<link href="<spring:url value="/resources/cland/css/pgwslider.css"/>" rel="stylesheet"/>
		<!-- Font Awesome -->
		<link rel="stylesheet" href="<spring:url value="/resources/cland/css/font-awesome.min.css"/>"/>
		<link href="<spring:url value="/resources/cland/css/style.css"/>" rel="stylesheet" media="screen" />	
		<link href="<spring:url value="/resources/cland/css/responsive.css"/>" rel="stylesheet" media="screen" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
	</head>
	<body>
		<!-- header -->
		<tiles:insertAttribute name="header"/>
		<!-- header -->
		<section id="content_area">
			<div class="clearfix wrapper main_content_area">
				<tiles:insertAttribute name="content"/>
				<tiles:insertAttribute name="sidebar"/>
			</div>
		</section>
		<!-- FOOTER -->
		<tiles:insertAttribute name="footer"/>
      <div class="contact-content">
        <div class="phone-number">
          <div class="phone-number-wrap">
            <div class="phone-number-ring-circle"></div>
            <div class="phone-number-ring-circle-fill"></div>
            <div class="phone-number-icon-circle">
              <a href="tel:+00 151515"><i class="phone-icon fas fa-phone"></i></a>
            </div>
            <div class="messgae-icon-circle">
              <a href="https://chat-room-public.herokuapp.com/index.html" target="_blank"><i class="message-icon fas fa-comments"></i></a>
            </div>
          </div>
        </div>
      </div>
		<!-- FOOTER -->
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.0.min.js"></script>	
		<script type="text/javascript" src="resources/cland/js/jquery.tooltipster.min.js"></script>		
		<script type="text/javascript">
			$(document).ready(function() {
				$('.tooltip').tooltipster();
			});
		</script>
		 <script type="text/javascript" src="resources/cland/js/selectnav.min.js"></script>
		<script type="text/javascript">
			selectnav('nav', {
			  label: '-Navigation-',
			  nested: true,
			  indent: '-'
			});
		</script>		
		<script src="resources/cland/js/pgwslider.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.pgwSlider').pgwSlider({
					
					intervalDuration: 5000
				
				});
			});
		</script>
		<script type="text/javascript" src="resources/cland/js/placeholder_support_IE.js"></script>
	</body>
</html>
