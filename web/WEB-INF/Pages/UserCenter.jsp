<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>学生学习系统</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="ToolPage/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Study Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--Google Fonts-->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- //end-smoth-scrolling -->
<script src="js/menu_jquery.js"></script>
</head>
<body>
	<!--header start here-->
	<div class="header">
		<div class="container">
			<div class="header-main">
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
							$("span.icon").click(function() {
								$(".top-nav ul").slideToggle(500, function() {
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
								href="ShowCourseServlet ">我的课程</a>
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
				<div class="bann-bottom">
					<h1>个人中心</h1>
						<div class="bann-main">
							<div class="col-md-4 bann-grid">
							<c:if test='<%=session.getAttribute("userInfo")!=null%>'>
								<div>
									<label style="color: white; font-size: 22px;">姓名:</label> 
									<input class="in"
										type="text" name="name"
										style="text-align: center;  font-size: 22px; background-color: transparent; border: none; border-bottom: 1px solid white; line-height: 1em; margin-bottom: 20px; color:white;"    
										disabled="disabled";  value="${userInfo.name }"  onfocus="this.value=''">
								</div>
								<div>
									<label style="color: white; font-size: 22px;">账号:</label>
									 <input 
										type="text" name="id"
										style=" text-align: center; font-size: 22px; background-color: transparent; border: none; border-bottom: 1px solid white; line-height: 1em; margin-bottom: 20px; color:white;"
										disabled="disabled" value="${userInfo.id }"  onfocus="this.value=''">
								</div>
								<div>
									<label style="color: white; font-size: 22px;">密码:</label> 
									<input class="in"
										type="text" name="pass"
										style="text-align: center; font-size: 22px; background-color: transparent; border: none; border-bottom: 1px solid white; line-height: 1em; margin-bottom: 20px; color:white;"
										disabled="disabled" value="${userInfo.pass }"  onfocus="this.value=''">
								</div>
								<div>
									<label style="color: white; font-size: 22px;">电话:</label> 
									<input class="in"
										type="text" name="tel"
										style="text-align: center; font-size: 22px; background-color: transparent; border: none; border-bottom: 1px solid white; line-height: 1em; margin-bottom: 20px; color:white;"
										disabled="disabled" value="${userInfo.tel}"  onfocus="this.value=''">
								</div>
								<div>
									<label style="color: white; font-size: 22px;">性别:</label>
									 <input class="in"
										type="text" name="sex"
										style="text-align: center; font-size: 22px; background-color: transparent; border: none; border-bottom: 1px solid white; line-height: 1em; margin-bottom: 20px; color:white;"
										disabled="disabled" value="${userInfo.sex}"  onfocus="this.value=''">
								</div>
								<button type="button"  style="background-color: #ff4f81; border: none; border-radius: 5px; font-size: 22px; color: white; margin: 10px;" onclick="changeType()" >修改
							</button>
								<input type="button" value="保存修改" style="background-color: #ff4f81; border: none; border-radius: 5px; font-size: 22px; color: white; margin: 10px;" onclick="submitInput()">
								<script>
								function submitInput(){
									var name =$('input[name="name"]').val();
									var pass =$('input[name="pass"]').val();
									var tel =$('input[name="tel"]').val();
									var sex =$('input[name="sex"]').val();
									$(".in").attr('disabled','disabled'); 
									$.post("UpdateServlet",{"name":name,"pass":pass,"tel":tel,"sex":sex}); 
								}
								</script>
								</c:if>
									<div class="clearfix" style=" color:#ff4f81 ; font-size: 22px; ">${message }</div>
							</div>
							<div>
								<!-- <a href="" style="text-decoration: none; color: white;font-size: 22px; font-weight: bold; border:1px  rgb(252,52,111);  background-color: rgb(252,52,111); border-radius: 5px;">修改信息</a> -->
						<script>
						function changeType(){
							$(".in").removeAttr("disabled"); 
							/* Document.getElementById("#"+"in").removeAttr("disabled") */
						}
						</script>	
							</div>				
						</div>
				</div>
			</div>
		</div>
		<div class="copyright">
			<div class="container">
				<div class="copyright-main">
					<p>
						学生学习系统期待您的加入|<a href="HeadPage.jsp" target="_blank">CourseSupSystem</a>
					</p>
				
				</div>
			</div>
		</div>
	</div>

</body>
</html>