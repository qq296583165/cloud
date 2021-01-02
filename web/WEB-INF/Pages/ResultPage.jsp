<%@page import="Service.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>学生学习系统</title>
<link href="ToolPage/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="ToolPage/style.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Study Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--Google Fonts-->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!-- <script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
	</script> -->
<!-- //end-smoth-scrolling -->
<script src="js/menu_jquery.js"></script>
<!--script-->
<script src="js/modernizr.custom.97074.js"></script>
<script src="js/jquery.chocolat.js"></script>
<link rel="stylesheet" href="ToolPage/chocolat.css" type="text/css"
	media="screen" charset="utf-8">
<!--light-box-files -->
<!-- <script type="text/javascript" charset="utf-8">
		$(function() {
			$('.gallery a').Chocolat();
		});
		</script> -->
<script type="text/javascript" src="js/jquery.hoverdir.js"></script>

</head>
<body>
	<!--header start here-->
	<div class="header1">
		<div class="container">
			<div class="header-main">
				<!---->
				<div class="header-logo">
					<div class="logo">
						<a href="index.html"><img src="images/lo1.png" alt=""></a>
					</div>
					<div class="top-nav">
						<span class="icon"><img src="images/menu.png" alt="">
						</span>
						<ul>
							<li><a
								href="ShowCourseServlet ">我的课程</a>
							</li>
							<li><a href="UserInfoPrintServlet">个人中心</a>
							</li>
							<li><a href="LoginPage.jsp">登陆</a></li>
							<li><input type="text" name="keywords"></li>
							<li><input type="submit" value="搜索"
								style="background-color: transparent; text-decoration: none; color: white;"></li>
						</ul>
						<!--script-->
						<script>
							$("span.icon").click(function(){
								$(".top-nav ul").slideToggle(500, function(){
								});
							});
					</script>
					</div>
					<div class="clearfix"></div>
				</div>
				<!---->
				<div class="top-menu">
					<ul>
							<li><a
							href="HeadPage.jsp"><img src="images/lo1.png" alt="首页"></a>
							</li>
							<li><a
								href="ShowCourseServlet">我的课程</a>
							</li>
							<li><a href="UserInfoPrintServlet">个人中心</a>
							</li>
						<form action="SearchServlet" method="get" style="display:inline-block;">
							<li><input type="text" name="keywords"></li>
							<li><input type="submit" value="搜索" style="background-color:transparent; text-decoration:none;color:white;"></li>
						</form>
						
							<% 
							String cla =(String) session.getAttribute("cla");
							%>
							<c:if test='${ flag.equals("1")}' >
								<c:if test='<%=cla.equals("2") %>'>
									<li><a href="TeacherManagement.jsp" >教师管理</a></li>
								</c:if>
							<li><a href="LogoutServlet" type="submit" >退出登录</a></li>
							<li><a href="UserInfoPrintServlet">
							欢迎<c:if test='<%=cla.equals("0") %>'>学生</c:if><c:if test='<%=cla.equals("1") %>'>老师</c:if><c:if test='<%=cla.equals("2") %>'>管理员</c:if>${name}!
							</a></li>
							</c:if>
							<c:if test='${ flag.equals("0")}' >
							<li><a href="LoginPage.jsp">登录</a></li>
							</c:if>
						</form>
					</ul>
				</div>
				<!--script-->
			</div>
		</div>
	</div>
	<!--header end here-->
	<!--gallery-starts-->
	<div class="gallery">
		<div class="container">
			<div class="gallery-top heading">
				<h2>课程</h2>
			</div>
			<form action="SearchServlet" method= "get">
			<section>
				<ul id="da-thumbs" class="da-thumbs">
				<c:forEach items="${CourseList}"  var= "course" >
				<li>
					<a href="" rel="title" class="b-link-stripe b-animate-go  thickbox" onclick="ahref('${course.id}')" > 
						<img src="images/g1.jpg" alt="" class="img-responsive">
							<div>
								<h5>${course.id },${course.name}</h5>
								<span>${course.tecName} </span>
								<!--  ${status.count} -->
							</div>
					</a>
					</li>
					<script>
					function ahref(id){
						$.get("CourseInfoPrintServlet",{"id":id},function(){
						window.location.href="JumpServlet?jump=Pages/CourseInfo.jsp";	
						});
					}		
					</script>
				</c:forEach>
					<div class="clearfix">${message}</div>
				</ul>
			</section>
			</form>
			<script type="text/javascript">
			$(function() {
				$(' #da-thumbs > li ').each( function() { $(this).hoverdir(); } );
			});
		</script>
		</div>
	</div>
	<!--gallery-end-->
	<!--copyright start here-->
	<div class="copyright">
		<div class="container">
			<div class="copyright-main">
				<p style="color: black;">
					学生学习系统期待您的加入| <a href="HeadPage.jsp" target="_blank"
						style="color: black;">CourseSupSystem</a>
				</p>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--copyright end here-->
</body>
</html>