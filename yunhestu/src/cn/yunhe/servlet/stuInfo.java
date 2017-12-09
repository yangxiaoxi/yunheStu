package cn.yunhe.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.biz.ClassManager;
import cn.yunhe.biz.ScoreManager;
import cn.yunhe.biz.StudentManager;
import cn.yunhe.biz.impl.ClassManagerImpl;
import cn.yunhe.biz.impl.ScoreManagerimpl;
import cn.yunhe.biz.impl.StudentManagerImpl;
import cn.yunhe.entity.Score;
import cn.yunhe.entity.Student;
import cn.yunhe.util.StudentSort;


//@WebServlet("/stuInfo")
public class stuInfo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
	  	    ClassManager classManager = new ClassManagerImpl();
		    String class_name = classManager.selectClassName(3);//查询id为3的班级名称
		    request.setAttribute("class_name", class_name);
		    StudentManager stuManager = new StudentManagerImpl();
			   List <Student> liststu = stuManager.query(3);
			   request.setAttribute("liststu", liststu);
			   Collections.sort(liststu, new StudentSort());
			   DecimalFormat    df   = new DecimalFormat("######0.0");  
			   request.setAttribute("df", df);
			   ScoreManager scoremanager = new ScoreManagerimpl();
			   List<Score> scoreList = scoremanager.query(2,3);
			   request.setAttribute("scoreList", scoreList);
			   List<Score> list2 = scoremanager.query(1,3);
			   request.setAttribute("list2", list2);
			   List<Score> list3 = scoremanager.query(3,3);
			   request.setAttribute("list3", list3);
			  request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
			  
	}
	

}
