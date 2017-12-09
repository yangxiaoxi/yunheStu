<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>

<meta charset="utf-8">

 
<title>${ requestScope.class_name  }积分制网站</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 初始化Student对象数组并排序-->

<!-- stylesheet css -->
<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="imgs/templatemo-blue.css">

<style type="text/css">
	a:link, 
	a:visited { 
	color:#000000; 
	text-decoration:underline; 
	} 
	a:hover, 
	a:active { 
	color:#000000; 
	text-decoration:none; 
	}
</style>
</head>

<body data-spy="scroll" data-target=".navbar-collapse">

	<!-- preloader section -->
	<div style="display: none;" class="preloader">
		<div class="sk-spinner sk-spinner-wordpress">
			<span class="sk-inner-circle"></span>
		</div>
	</div>

	<!-- header section -->
	<header>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<img src="imgs/yunhelogo.png" class="img-responsive img-circle tm-border" alt="templatemo easy profile">
				
				<h1 class="tm-title bold shadow">欢迎使用</h1>
				<h1 class="white bold shadow">${requestScope.class_name  }积分制网站</h1>
			</div>
		</div>
	</div>
	</header>

	<!-- about and skills section -->
	<section class="container">
	<div class="row">
		<div id="divTable" style="background-color: white; width: 100%">
			<table class="table table-striped table-hover table-bordered">
				<thead>
				<tr id="theTableTitle">
					<th>名次</th>
					<th>学号</th>
					<th>姓名</th>
					<th>纪律考核分</th>
					<th>技术考核分</th>
					<th>职业能力考核分</th>
					<th>综合分</th>
				</tr>
				</thead>
				
				<tbody>
				
				 
				<c:forEach items="${ requestScope.liststu}" var="stu" varStatus="status">
				
				  <tr>
					<td>${status.index+1 }</td>
					<td><a href="stuinfo.jsp?stu_id=${stu.getStu_id() }&class_id=${stu.getClass_id()}"  target="_blank">${stu.getStu_no() }</a></td>
					<td><a href="stuinfo.jsp?stu_id=${stu.getStu_id() }&class_id=${stu.getClass_id()}"  target="_blank">${stu.getStu_name() }</a></td>
					<td>${ requestScope.df.format(stu.getStu_score_jl()) }</td>
					<td>${requestScope.df.format(stu.getStu_score_js())  }</td>
					<td>${requestScope.df.format(stu.getStu_score_zy()) }</td>
					<td>${requestScope.df.format(stu.getStu_sum()) }</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
		<!-- 本月技术考核分情况 -->
		<div class="col-md-8 col-sm-12">
			<div class="education">
				<h2 class="white">本月技术考核分情况</h2>
				<div>
					<ul>
					<c:forEach items="${requestScope.scoreList }" var="score">
					  <li>${score.getTime()  }：${score.getStu_name()  }“${score.getScore_contents()  }”${score.getScore_values()  }分</li>
					
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<!-- 技术考核分说明 -->
		<div class="col-md-4 col-sm-12">
			<div class="languages">
				<h2>技术考核分说明</h2>
				<ul>
					<li>上课期间提问，回答正确加技术分 1~3 分，回答错误减技术分1~3分</li>
					<li>老师布置的课后作业、预习，不按时提交或抄袭作业代码，减技术分3分</li>
					<li>老师布置的课后作业、预习未完成，减技术分1~2分</li>
					<li>平时阶段考试，前三名分别加5、4、3分，后三名分别减5、4、3分</li>
				</ul>
			</div>
		</div>
		
		<!-- 本月纪律考核分情况 -->
		<div class="col-md-8 col-sm-12">
			<div class="education">
				<h2 class="white">本月纪律考核分情况</h2>
				<div>
					<ul>	
					 <c:forEach items="${ requestScope.list2}" var="score">
					 
					     <li>${score.getTime()  }：${score.getStu_name() }“${score.getScore_contents()  }”${score.getScore_values()  }分</li>
					 </c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<!-- 纪律考核分说明 -->
		<div class="col-md-4 col-sm-12">
			<div class="languages">
				<h2>纪律考核分说明</h2>
				<ul>
					<li>请假需写请假条，每学时0.5分；未写请假条者计为旷课;</li>
					<li>旷课每学时扣2分;</li>
					<li>迟到、早退每学时扣0.5分;</li>
					<li>上课期间每响铃一次或接打电话一次扣0.5分;</li>
					<li>上课期间做与学习无关的一切行为，一次扣1分;</li>
					<li>每月全勤，加3分;</li>
				</ul>
			</div>
		</div>

		<!-- 本月职业能力考核分情况 -->
		<div class="col-md-8 col-sm-12">
			<div class="education">
				<h2 class="white">本月职业能力考核分情况</h2>
				<div>
					<ul>
						 <c:forEach items="${requestScope.list3}" var="score">
					 
					     <li>${score.getTime()  }：${score.getStu_name() }“${score.getScore_contents()  }”${score.getScore_values()  }分</li>
					 </c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<!-- 职业能力考核分说明 -->
		<div class="col-md-4 col-sm-12">
			<div class="languages">
				<h2>职业能力考核分说明</h2>
				<ul>
					<li>每日一讲，凡是被老师打回重来的，扣除职业能力分2分</li>
					<li>平时观察发现超出"准职业人"范围，扣除职业能力分2分;</li>
					<li>小组讨论时，凡发现不合群者，扣除职业能力分2分;</li>
					<li>日报周报不按时提交者，扣除职业能力分2分;</li>
				</ul>
			</div>
		</div>
	</div>
	</section>

	<!-- contact and experience -->
	<section class="container">
	<div class="row">
		<div class="col-md-4 col-sm-12">
			<div class="contact">
				<h3>联系我们</h3>
				<p>
					<i class="fa fa-map-marker"></i> yock
				</p>
				<p>
					<i class="fa fa-phone"></i> 18975523553
				</p>
				<p>
					<i class="fa fa-envelope"></i> dengyukun@iyunhe.com
				</p>
				<p>
					<i class="fa fa-globe"></i> <a href="http://www.iyunhe.com"  target="_blank">www.iyunhe.com</a>
				</p>
			</div>
		</div>
		<!-- 综合分说明 -->
		<div class="col-md-8 col-sm-12">
			<div class="experience">
				<h3 class="white">综合分说明/班委加分项</h3>
				<div class="experience-content">
					<ul>
					<li>综合评分=纪律分*20%+技术分*40%+职业能力分*40%</li>
					<li>全部培训结束后的综合评分排名后10%作为延迟结业考察对象</li>
					<li>全部培训结束后的综合评分上，班委拥有加分权，未尽责而被撤换的班委不加分</li>
					<li>班长/副班长，加3分；</li>
					<li>学习委员，加3分；</li>
					<li>组织委员/纪律委员/劳动委员，加2分；</li>
					<li>组长，加2分</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- footer section -->
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<p>
					copyright © 2013-2016 河南云和数据信息技术有限公司深圳分公司 <a href="index.jsp?class_id=3" target="_blank">首页</a>
					- Collect from <a href="http://www.iyunhe.com/" title="云和数据" target="_blank">云和数据</a>
				</p>
				<ul class="social-icons">
					<li><a href="#" class="fa fa-facebook"></a></li>
					<li><a href="#" class="fa fa-google-plus"></a></li>
					<li><a href="#" class="fa fa-twitter"></a></li>
					<li><a href="#" class="fa fa-dribbble"></a></li>
					<li><a href="#" class="fa fa-github"></a></li>
					<li><a href="#" class="fa fa-behance"></a></li>
				</ul>
			</div>
		</div>
	</div>
	</footer>

	<!-- javascript js -->
	<script src="js/jquery-1.8.2.min.js"></script>
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
	
	
	

<!--  <div style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 100%; width: 100%; z-index: -999999; position: fixed;" class="backstretch">
<img src="imgs/4.jpg" style="position:fixed ; margin: 0px; padding: 0px; border: medium none; width: 100%; height: 1000px;  z-index: -999999; left: 0px; top: -127.167px;">
</div> -->

</body>
</html>