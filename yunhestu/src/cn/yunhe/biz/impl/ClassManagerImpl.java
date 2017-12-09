package cn.yunhe.biz.impl;

import cn.yunhe.biz.ClassManager;
import cn.yunhe.dao.ClassDao;
import cn.yunhe.dao.impl.ClassDaoimpl;

public class ClassManagerImpl implements ClassManager{
	private ClassDao classDao = new ClassDaoimpl();
	@Override
	public String selectClassName(int classId) {
		String class_name =classDao.selectClassNameById(classId);
		return class_name;
	}

}
