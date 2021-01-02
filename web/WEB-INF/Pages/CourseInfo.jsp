<%@page import="Service.UserIInformation"%>
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
								<form action="SearchServlet" method="get" style="display: inline-block;">
							<li><input type="text" name="keywords"></li>
							<li><input type="submit" value="搜索" style="background-color:transparent; text-decoration:none;color:white;"></li>
								</li>
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
					</ul>
				</div>
				<!--script-->
				<form action="">
					<div class="bann-bottom">
					<c:if test="${CourseInfo!=null}">
					<h1>${CourseInfo.name}</h1>
						<div class="bann-main">
							<div class="col-md-4 bann-grid">
						
								<div>
									<label style="color: white; font-size: 22px;">课程名：</label> 
									<input class="in"
										type="text" 
										style="text-align: center; font-size: 22px; background-color: transparent; border: none; border-bottom: 1px solid white; line-height: 1em; margin-bottom: 20px; color:white;"    
										disabled="disabled";  value="${CourseInfo.name }"  onfocus="this.value=''">
								</div>
								<div>
									<label style="color: white; font-size: 22px;">课程号：</label>
									 <input 
										type="text" 
										style=" text-align: center; font-size: 22px; background-color: transparent; border: none; border-bottom: 1px solid white; line-height: 1em; margin-bottom: 20px; color:white;"
										disabled="disabled" value="${CourseInfo.id }"  onfocus="this.value=''">
								</div>
								<div>
									<label style="color: white; font-size: 22px;">教师名：</label>
									 <input 
										type="text" 
										style="text-align: center; font-size: 22px; background-color: transparent; border: none; border-bottom: 1px solid white; line-height: 1em; margin-bottom: 20px; color:white;"
										disabled="disabled" value="${CourseInfo.tecName }"  onfocus="this.value=''">
								</div>
								<c:if test="${CourseInfo.grade>0}">
								<div>
									<label style="color: white; font-size: 22px;">课程成绩：
									 <input 
										type="text" 
										style="font-size: 22px; background-color: transparent; border: none; border-bottom: 1px solid white; line-height: 1em; margin-bottom: 20px; color:white; text-align: center;"
										disabled="disabled" value="${CourseInfo.grade}"  onfocus="this.value=' ' ">
										分
										</label>
								</div>
								</c:if>
								<c:if test='${CourseInfo.grade<0&&cla.equals("0")}'>
								<div class = "clearfix"  style=" color:#ff4f81 ; font-size: 22px;">
								暂无成绩！
								</div>
								</c:if>
								
							<%-- 	<c:if test="${CourseInfo.source.isEmpty()}"> --%>
								<label style="color: white; font-size: 22px;">课程资料：</label>
								<br>
								<c:forEach items="${CourseInfo.source }"  var="source"> 
								<a href="" style="text-decoration: none; font-size: 22px; color: white; ">${source}</a>
								<br>
								</c:forEach>
								<%-- </c:if> --%>
								<c:if test="${CourseInfo.source.isEmpty()}">
								<div class="clearfix" style=" color:white ; font-size: 22px; ">教师暂未上传课程资料!</div>
								</c:if>
								<div class="clearfix" style=" color:#ff4f81 ; font-size: 22px; ">${message }</div>
							</div>
							<div>
							</div>				
						</div>
						</c:if>
				</div>
				</form>
			
			</div>
		</div>
		
	</div>
	<div>


		<c:if test='${ !cla.equals("0") &&  !students.isEmpty()}'>
	<h4 style="width:100%; font-size:33px; text-align: center; margin-top:20px; margin-bottom: -30px;">学员名单</h4>
								<table style=" font-size: 22px; text-align: center; margin: 50px;" cellspacing="20" width="90%" rules="rows" border="1">
								<tbody>
								<tr>
								    <th> </th>
									<th>学号</th>
									<th>姓名</th>
								</tr>
								<c:forEach items="${students}" var="student" varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td><a href="" onclick="ahref(${student.id})" style="text-decoration: none; color:black;"> ${student.id}</a></td>
									<td><a href="" onclick="ahref(${student.id})" style="text-decoration: none; color:black;" >${student.name}</a></td>
								</tr>
								<script>
								function ahref(id){
									var cid = "${CourseInfo.id}";
									var cname="${CourseInfo.name}"
									$.get("studentInfo",{"id":id,"courseId":cid,"cname":cname },function(data){
										window.location.href="JumpServlet?jump=Pages/StuInfoPage.jsp"
									});
								}
								</script>
								</c:forEach>
								</tbody>
								</table>
								<!-- 加入学生 -->
						<a href="JumpServlet?jump=Pages/AddStudentPage.jsp"  > 
							<img style =" height:100px;  margin-left:50px;"  src="https://s2.ax1x.com/2019/12/17/QoDkOU.png"  >
							<span>添加学生</span>
						</a>

		<a href="JumpServlet?jump=Pages/DeleteStudentPage.jsp"  >
			<img style =" height:100px;  margin-left:1050px;"  src="images/-.png"  >
			<span>删除学生</span>
		</a>
		</c:if>
	<div class="copyright">
			<div class="container">
				<div class="copyright-main" >
					<p style="color:black;">
						学生学习系统期待您的加入|<a href="HeadPage.jsp" target="_blank" style="color:black;">CourseSupSystem</a>
					</p>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	
								

</body>
</html>