package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.Student;

public interface StudentManager {
	
	
	
	/**
	 * 查询某个班的所有学生
	 * @param class_id
	 * @return
	 */
	List<Student> query(int class_id);
	/**
	 * 根据学生id找学生姓名
	 * @param stu_id  哪个学生
	 * @return
	 */
	Student querystuBystuid(int stu_id);

}
