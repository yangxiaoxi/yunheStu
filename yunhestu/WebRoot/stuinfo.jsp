<%@page import="cn.yunhe.entity.Score"%>
<%@page import="cn.yunhe.biz.impl.ScoreManagerimpl"%>
<%@page import="cn.yunhe.biz.ScoreManager"%>
<%@page import="cn.yunhe.biz.impl.RecordManagerImpl"%>
<%@page import="cn.yunhe.biz.RecordManager"%>
<%@page import="cn.yunhe.entity.Record"%>
<%@page import="cn.yunhe.dao.impl.RecoderDaoImpl"%>
<%@page import="cn.yunhe.dao.RecoderDao"%>
<%@page import="cn.yunhe.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="cn.yunhe.biz.impl.StudentManagerImpl"%>
<%@page import="cn.yunhe.biz.StudentManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>学员信息</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">

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

<%
     StudentManager stuManager = new StudentManagerImpl();
    ScoreManager scoreManerg = new ScoreManagerimpl();
     RecordManager recoder = new RecordManagerImpl();
     String stuidStr = request.getParameter("stu_id");
     int stu_id   = Integer.parseInt(stuidStr);//接收到学生id
     pageContext.setAttribute("stu_id", stu_id);
     System.out.println(stu_id);
     Student stu = stuManager.querystuBystuid(stu_id);
     pageContext.setAttribute("stu", stu);
     List<Record> listRecoder=  recoder.query(stu_id);
     pageContext.setAttribute("listRecoder", listRecoder);
     List<Score> listScore  = scoreManerg.queryByStuid(stu_id);
     pageContext.setAttribute("listScore", listScore);
 	String host = request.getServerName();//主机名
	pageContext.setAttribute("host", host);
	int port = request.getServerPort();//端口号
	pageContext.setAttribute("port", port);
     
%>
	<!-- header section -->
	<header>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<img src="imgs/yunhelogo.png" class="img-responsive img-circle tm-border" alt="templatemo easy profile" />
				<h1 class="tm-title bold shadow">欢迎使用</h1>
				<h1 class="white bold shadow">${stu.getStu_name() }积分制网站</h1> 
			</div>
		</div>
	</div>
	</header>
	
	<!-- contact and experience -->
	<section class="container">
	<div class="row">
		<div class="col-md-4 col-sm-12">
			<div class="contact">
			<c:set var="imgsSrc" value="http://${host }:${port }/yunheStuManager/stuimgs/${stu.getImgs() }"/>
				<p>
				<img src="${imgsSrc }" width="210px" height="250px" />
				</p>
				<p>
					<i class="fa fa-map-marker"></i> 学号：${stu.getStu_no() }
				</p>
				<p>
					<i class="fa fa-phone"></i> 姓名：${stu.getStu_name()  }
				</p>
				<p>
					<i class="fa fa-envelope"></i> 性别：${stu.getStu_sex()  }
				</p>
				<p>
					<i class="fa fa-globe"></i> 专业：${stu.getStu_profession()  }
				</p>
				
				
			</div>
		</div>
		
		<div class="col-md-8 col-sm-12">
			<div class="experience">
				<h3 class="white">历史考核分情况</h3>
				<div class="experience-content">
					<ul>
									 
						<c:forEach items="${ listScore}" var="score" >
						    <li>${score.getTime() }:${score.getStu_name()  }“${score.getScore_contents()  }”${score.getScore_values()  }分</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>	
		
	</section>
	
	<section class="container">
		<div id="divTable" style="background-color: white; width: 100%">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th><strong>日期</strong></th>
						<th><strong>姓名</strong></th>
						<th><strong>上班打卡时间</strong></th>
						<th><strong>下班打卡时间</strong></th>
						<th><strong>状态</strong></th>
					</tr>
				</thead>
				<tbody>
				 
					 <c:forEach items="${ listRecoder}" var="record">
					 
					       <c:set var="statusStr" value=""/>
			               <c:set var="color" value=""/>
			                <c:set var="start_time" value="${record.getStart_time() }"/>
			                <c:set var="end_time" value="${ record.getEnd_time()}"/>
			               
			                <c:if test="${ pageScope.record.getStatus()==0}">
					           <c:set var="statusStr" value="待处理"/>
					           <c:set var="color" value="color='black'"/>
					       </c:if>
					       <c:if test="${ pageScope.record.getStatus()==-1}">
					           <c:set var="statusStr" value="异常"/>
					           <c:set var="color" value="color='red'"/>
					       </c:if>
					       <c:if test="${pageScope.record.getStatus()==1}">
					           <c:set var="statusStr" value="正常"/>
					           <c:set var="color" value= "color='#00FF00'"/>
					       </c:if>
					       
					       <c:if test="${start_time eq 'null'}">
					           <c:set var="start_time" value=""/>
					       </c:if>
					       <c:if test="${end_time eq 'null'}">
					           <c:set var="end_time" value=""/>
					       </c:if>
					       
					       <tr>
						<td>${record.getDate()  }</td>
						<td>${record.getStu_name() }</td>
						<td>${start_time }</td>
						<td>${end_time }</td>
						<td>
					     <font ${color  }>${statusStr }</font>
					</td>
					</tr>
					 </c:forEach>
				</tbody>	
			</table>
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

</body>
</html>