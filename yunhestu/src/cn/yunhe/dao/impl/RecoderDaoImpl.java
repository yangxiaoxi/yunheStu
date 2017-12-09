package cn.yunhe.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yunhe.dao.RecoderDao;
import cn.yunhe.entity.Record;
import cn.yunhe.util.JDBCutil;

public class RecoderDaoImpl implements RecoderDao{

	@Override
	public List<Record> query(int stu_id) {

		
		String sql = "select t1.stu_name,date,start_time,end_time,status from tb_record t1 "
				+ "inner join tb_student t2 on t1.stu_id = t2.stu_id where t2.stu_id =? "
				+ "order by date desc";
	    Object[] objs = {stu_id};
	   
	   List<Record> lists = new ArrayList<Record>();
	   try {
		  JDBCutil.connection();
		  ResultSet rs =  JDBCutil.query(sql, objs);
		  while(rs.next()){
			 
			Record record = new Record();
			record.setDate(rs.getString("date"));
			record.setStart_time(rs.getString("start_time"));
			record.setEnd_time(rs.getString("end_time"));
			record.setStu_name(rs.getString("stu_name"));
			int status = rs.getInt("status");
			record.setStatus(status);
			lists.add(record);
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
		return lists;
	}

	@Override
	public List<Record> queryByIdPage(int stu_id, int currentPage, int pageSize) {
		String sql = "select * from tb_record where stu_id = ? limit ?,? ";
		List<Record> lists = new ArrayList<Record>();
		try {
			JDBCutil.connection();
	        Object[] objs ={stu_id,(currentPage-1)*pageSize,pageSize};
			ResultSet rs = JDBCutil.query(sql,objs);	
			while (rs.next()) {
				 Record record = new Record();
				 record.setDate(rs.getString("date"));
				 String end_time = rs.getString("end_time")==null?"":rs.getString("end_time");
				 record.setEnd_time(end_time);
				 record.setRecord_id(rs.getInt("record_id"));
				 String start_time = rs.getString("start_time")==null?"":rs.getString("start_time");
				 record.setStart_time(start_time);
				 int status = rs.getInt("status");
				 record.setStatus(status);
				 record.setStu_id(rs.getInt("stu_id"));
				 record.setStu_name(rs.getString("stu_name"));
				lists.add(record);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCutil.closeSource();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}

}
