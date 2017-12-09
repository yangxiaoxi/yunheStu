package cn.yunhe.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yunhe.dao.ScoreDao;
import cn.yunhe.dao.StudentDao;
import cn.yunhe.entity.Score;
import cn.yunhe.entity.Student;
import cn.yunhe.util.JDBCutil;

public class StudentDaoImpl implements StudentDao {
    private ScoreDao scoreDao = new ScoreDaoimpl();
	@Override
	public List<Student> query(int class_id) {
		String sql = "select t1.*,t1.class_id,class_name from tb_student t1 "
				+ "inner join tb_class t2 on t1.class_id = t2.class_id where t1.class_id = ? ";
	   Object[] objs = {class_id};
	   List<Student> lists = new ArrayList<Student>();
	   try {
		  JDBCutil.connection();
		  ResultSet rs =  JDBCutil.query(sql, objs);
		 
		 
		  while(rs.next()){
			  double jlScore = 100;
			  double jsScore = 100;
			  double zyScore = 100;
			 Student stu = new Student();
			 stu.setClass_id(rs.getInt("class_id"));
			 stu.setStu_id(rs.getInt("stu_id"));
			 stu.setStu_no(rs.getString("stu_no"));
			 stu.setStu_name(rs.getString("stu_name"));
			 List<Score> jlScoreList = scoreDao.queryBysIDandStype(rs.getInt("stu_id"),1);
			 for (Score score : jlScoreList) {
				 jlScore = jlScore+score.getScore_values();
			}
			 List<Score> jsScoreList = scoreDao.queryBysIDandStype(rs.getInt("stu_id"),2);
			 for (Score score : jsScoreList) {
				 jsScore = jsScore+score.getScore_values();
			}
			 List<Score> zyScoreList = scoreDao.queryBysIDandStype(rs.getInt("stu_id"),3);
			 for (Score score : zyScoreList) {
				 zyScore = zyScore+score.getScore_values();
			}
			 stu.setStu_score_jl(jlScore);
			 stu.setStu_score_js(jsScore);
			 stu.setStu_score_zy(zyScore);
			 stu.setStu_sum(jlScore*0.2+jsScore*0.4+zyScore*0.4);
			 lists.add(stu);
		  }
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			JDBCutil.closeSource();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return lists;
	}
	

	@Override
	public Student querystuBystuid(int stu_id) {

		String sql ="select stu_img,stu_no,stu_name,stu_sex,stu_profession from tb_student "
				+ "where stu_id = ?" ;
//		String sql ="select stu_no,t1.stu_name,stu_sex,stu_profession,t2.date,start_time,end_time ,statusfrom tb_student t1"
//				+ "inner join tb_record t2 on t1.stu_id = t2.stu_id"
//				+ "where t1.stu_id = ?" ;
//      List<Student> lists = new ArrayList<Student>();
	   Object[] objs = {stu_id};
	   Student stu = new Student();
	   try {
		  JDBCutil.connection();
		  ResultSet rs =  JDBCutil.query(sql, objs);  
		  while(rs.next()){
			  //String imgSrc = String.valueOf(stu_id);
			 stu.setImgs(rs.getString("stu_img"));
			 stu.setStu_no(rs.getString("stu_no"));
			 stu.setStu_name(rs.getString("stu_name"));
			 stu.setStu_sex(rs.getString("stu_sex"));
			 stu.setStu_profession(rs.getString("stu_profession"));
	 
		  }
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			JDBCutil.closeSource();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return stu;
   }
	  
}
