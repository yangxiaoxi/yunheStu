package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Student;

public interface StudentDao {

	/**
	 * 根据班级名称查询学生
	 * @param class_id 
	 * @return
	 */
	List<Student> query(int class_id);
	
	
	/**
	 * 根据学生id找出学生
	 * @param stu_id  学生id
	 * @return
	 */
	Student querystuBystuid(int stu_id);
}
