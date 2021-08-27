<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-10">
		<div class="row">
  		<div class="col-md-12 panel-warning">
  			<div class="content-box-header panel-heading">
 					<div class="panel-title ">Quản trị viên</div>
  			</div>
  			<div class="content-box-large box-with-header">
	  			<div class="row">
		            <div class="col-md-4 col-sm-4 col-xs-4">
		                <div class="panel panel-back noti-box">
		                    <span class="icon-box bg-color-green set-icon">
		                    <span class="glyphicon glyphicon-th-list"></span>
		                </span>
		                    <div class="text-box">
		                        <p class="main-text"><a class="fs-14" href="${pageContext.request.contextPath}/admin/cat/index" title="">Quản lý danh mục</a></p>
		                        <p class="text-muted">Có ${numberOfCat} danh mục</p>
		                    </div>
		                </div>
		            </div>
		            <div class="col-md-4 col-sm-4 col-xs-4">
		                <div class="panel panel-back noti-box">
		                    <span class="icon-box bg-color-blue set-icon">
		                    <span class="glyphicon glyphicon-book"></span>
		                </span>
		                    <div class="text-box">
		                        <p class="main-text"><a class="fs-14" href="${pageContext.request.contextPath}/admin/land/index" title="">Quản lý tin tức</a></p>
		                        <p class="text-muted">Có ${numberOfLand} tin tức</p>
		                    </div>
		                </div>
		            </div>
		            <div class="col-md-4 col-sm-4 col-xs-4">
		                <div class="panel panel-back noti-box">
		                    <span class="icon-box bg-color-brown set-icon">
		                    <span class="glyphicon glyphicon-user"></span>
		                </span>
		                    <div class="text-box">
		                        <p class="main-text"><a class="fs-14" href="${pageContext.request.contextPath}/admin/user/index" title="">Quản lý người dùng</a></p>
		                        <p class="text-muted">Có ${numberOfUser} người dùng</p>
		                    </div>
		                </div>
		            </div>
		        </div>
			</div>
  		</div>
  	</div>	

  	<div class="row">
  		<div class="col-md-6">
  			<div class="content-box-large">
  				<div class="panel-heading">
					<div class="panel-title">Chào mừng đến với trang quản trị</div>
					<div class="panel-options">
						<a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
						<a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
					</div>
				</div>
  				<div class="panel-body">
  					Chào mừng đến trang quản lý thông tin. Đây là nơi Quản trị viên và người dùng có thể thêm thông tin, 
  					sửa đổi thông tin, liên hệ khách hàng. Với phương châm đặt lợi ích khách hàng lên hàng đầu.
		  			<br /><br />
		  			Cập nhật nhanh các tin tức về bất động sản <br />
		  			Hỗ trợ khách hàng 24/24
					<br /><br />
  				</div>
  			</div>
  		</div>

  		<div class="col-md-6">
  			<div class="row">
  				<div class="col-md-12">
  					<div class="content-box-header">
	  					<div class="panel-title">Hướng dẫn sử dụng</div>
		  			</div>
		  			<div class="content-box-large box-with-header">
			  			Trang gồm các mục : Danh mục, Tin tức, Liên hệ, Người dùng<br />
			  			Mọi thắc mắc xin liên hệ: 0865787769 - Trần Xuân Hải
						<br /><br />
					</div>
  				</div>
  			</div>
  			<div class="row">
  				<div class="col-md-12">
  					<div class="content-box-header">
	  					<div class="panel-title">Nội quy</div>
		  			</div>
		  			<div class="content-box-large box-with-header">
		  			<ul>
		  				<li>Tài khoản người dùng được quyền thêm sửa xóa tin tức</li>
		  				<li>Tài khoản người dùng được quyền xem liên lạc</li>
		  				<li>Tài khoản người dùng không được quyền sửa, xóa danh mục</li>
		  				<li>Tài khoản người dùng không được vào quản lý tài khoản</li>
		  			</ul>
					</div>
  				</div>
  			</div>
  		</div>
  	</div>
  	
  </div><!-- /.col-md-10 -->