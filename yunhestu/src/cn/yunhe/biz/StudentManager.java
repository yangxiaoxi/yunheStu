package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.Student;

public interface StudentManager {
	
	
	
	/**
	 * ��ѯĳ���������ѧ��
	 * @param class_id
	 * @return
	 */
	List<Student> query(int class_id);
	/**
	 * ����ѧ��id��ѧ������
	 * @param stu_id  �ĸ�ѧ��
	 * @return
	 */
	Student querystuBystuid(int stu_id);

}
