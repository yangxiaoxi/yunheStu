package cn.yunhe.util;

import java.util.Comparator;

import cn.yunhe.entity.Student;

public class StudentSort implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		if(o1.getStu_sum()>o2.getStu_sum()){
			return -1;
		}else if(o1.getStu_sum()<o2.getStu_sum()){
			return 1;
		}else{
			return 0;
		}
	
		
	}

}
