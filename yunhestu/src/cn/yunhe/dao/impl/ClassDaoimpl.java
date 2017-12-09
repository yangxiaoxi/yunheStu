package cn.yunhe.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.yunhe.dao.ClassDao;
import cn.yunhe.util.JDBCutil;

public class ClassDaoimpl implements ClassDao{

	@Override
	public String selectClassNameById(int classId) {
		
		String className = null;
		String sql ="select class_name from tb_class where class_id =?";
		try {
			JDBCutil.connection();
		  ResultSet rs = JDBCutil.query(sql, new Object[]{classId});
		  if(rs.next()){
			 className = rs.getString("class_name");
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
		return className;
	}

}
