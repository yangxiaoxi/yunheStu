package cn.yunhe.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.yunhe.dao.ScoreDao;
import cn.yunhe.entity.Score;
import cn.yunhe.util.JDBCutil;

public class ScoreDaoimpl implements ScoreDao{

	/* (non-Javadoc)
	 * @see cn.yunhe.dao.ScoreDao#query(int, int)
	 */
	@Override
	public List<Score> query(int score_type,int class_id) {
	
		String sql =  "select  t1.time,stu_name,score_contents,score_value from  tb_score t1 "
				+ "inner join tb_student t2 on t1.stu_id = t2.stu_id  where score_type =? and month(t1.time)=month(sysdate()) and t1.class_id =? "; 
		List<Score> lists = new ArrayList<Score>();
		Object[]  objs = {score_type,class_id};
		try {
			JDBCutil.connection();
			ResultSet rs =  JDBCutil.query(sql, objs);
			while(rs.next()){
				String time = rs.getString("time");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				Date date = sdf.parse(time);
				String afterTime = sdf.format(date);
				Score score = new Score(afterTime,rs.getString("stu_name"), rs.getString("score_contents"),rs.getDouble("score_value"));
				lists.add(score);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCutil.closeSource();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lists;
	}

	@Override
	public List<Score> queryBysIDandStype(int stu_id,int score_type) {
		
		String sql =  "select  t1.time,stu_name,score_contents,score_value from  tb_score t1 "
				+ "inner join tb_student t2 on t1.stu_id = t2.stu_id  where score_type =?  and t1.stu_id =? "; 
		List<Score> lists = new ArrayList<Score>();
		Object[]  objs = {score_type,stu_id};
		try {
			JDBCutil.connection();
			ResultSet rs =  JDBCutil.query(sql, objs);
			while(rs.next()){
				String time = rs.getString("time");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				Date date = sdf.parse(time);
				String afterTime = sdf.format(date);
				Score score = new Score(afterTime,rs.getString("stu_name"), rs.getString("score_contents"), rs.getDouble("score_value"));	
				lists.add(score);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCutil.closeSource();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lists;
	}

	@Override
	public List<Score> queryByStuid(int stu_id) {
		String sql =  "select  t1.time,stu_name,score_contents,score_value from  tb_score t1 "
				+ "inner join tb_student t2 on t1.stu_id = t2.stu_id  where t1.stu_id = ? "; 
		List<Score> lists = new ArrayList<Score>();
		Object[]  objs = {stu_id};
		try {
			JDBCutil.connection();
			ResultSet rs =  JDBCutil.query(sql, objs);
			while(rs.next()){
				String time = rs.getString("time");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				Date date = sdf.parse(time);
				String afterTime = sdf.format(date);
				Score score = new Score(afterTime,rs.getString("stu_name"), rs.getString("score_contents"),rs.getDouble("score_value"));
				lists.add(score);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCutil.closeSource();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lists;
	}

}
