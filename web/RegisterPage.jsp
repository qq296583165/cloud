<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>学生学习系统</title>
<link rel="shortcut icon" type="image/x-icon"
	href="https://s2.ax1x.com/2019/12/10/QDkQMj.jpg">
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Course Register Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme -->
<!-- css files -->
<link
	href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">
<link href="LoginRegister/style.css" type="text/css" rel="stylesheet"
	media="all">
<!-- //css files -->

<link rel="stylesheet" href="LoginRegister/font-awesome.css">
<!-- Font-Awesome-Icons-CSS -->

</head>
<!-- body starts -->
<body>
	<!-- section -->
	<section class="register">
	<div class="register-full">
		<div class="register-left">
			<div class="register">
				<div class="logo">
					<a href="#"><span class="fa fa-graduation-cap"
						aria-hidden="true"> </span></a>
				</div>
				<h1>欢迎加入</h1>
				<p>一个能让你学得更自由、更容易的好地方</p>
			<!-- 	<form action="" method="get"> -->
					<div class="content3">
						<ul>
							<li><a class="read" href="LoginPage.jsp"> 已有账号，去登陆 </a></li>
						</ul>
					</div>
				<!-- </form> -->
			</div>
		</div>
		<div class="register-right">
			<div class="register-in">
				<h2>
					<span class="fa fa-pencil"></span> register here
				</h2>
				<div class="register-form">
					<form action="Register" method="post">
						<div class="fields-grid">
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="userName" required=""> <label>姓名</label>

							</div>
							<div class="styled-input">
								<input type="text" name="userId" required=""> <label>账号（大于等于六位数字）</label>

							</div>
							<div class="styled-input">
								<input type="password" name="password" required=""> <label>密码(大于等于八位数字)</label>

							</div>
							<div class="styled-input">
								<input type="tel" name="userTel" required=""> <label>手机号</label>

							</div>
							<div class="styled-input agile-styled-input-top">
								<select id="category2" name="sex">
									<option value="男">男</option>
									<option value="女">女</option>
								</select>
							</div>
							<div class="styled-input agile-styled-input-top">
								<select id="category2" name="cla">
									<option value="0">学生</option>
									<option value="1">教师</option>
								</select>
							</div>
							<div class="clear" style="color: #ff4f81">
								<%
							String str = (String)request.getAttribute("message");
							if(str != null)
								out.print(str);
							%>
							</div>
						</div>
						<input type="submit" value="注册">
					</form>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<!-- copyright -->
	<p class="agile-copyright">
		学生学习系统期待您的加入<a href="" target="_blank"> | CourseSupSystem</a>
	</p>
	<!-- //copyright --> </section>
	<!-- //section -->
</body>
<!-- //body ends -->
</html>