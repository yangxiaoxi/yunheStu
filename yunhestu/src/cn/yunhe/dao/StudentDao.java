package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Student;

public interface StudentDao {

	/**
	 * ���ݰ༶���Ʋ�ѯѧ��
	 * @param class_id 
	 * @return
	 */
	List<Student> query(int class_id);
	
	
	/**
	 * ����ѧ��id�ҳ�ѧ��
	 * @param stu_id  ѧ��id
	 * @return
	 */
	Student querystuBystuid(int stu_id);
}
