package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.StudentManager;
import cn.yunhe.dao.StudentDao;
import cn.yunhe.dao.impl.StudentDaoImpl;
import cn.yunhe.entity.Student;

public class StudentManagerImpl implements StudentManager{
  private StudentDao  stuDao= new  StudentDaoImpl();
	@Override
	public List<Student> query(int class_id) {
		return stuDao.query(class_id);
	}
	@Override
	public Student querystuBystuid(int stu_id) {
		 
		return stuDao.querystuBystuid(stu_id);
	}

}
