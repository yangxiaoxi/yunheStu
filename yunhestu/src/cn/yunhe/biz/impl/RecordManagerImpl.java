package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.RecordManager;
import cn.yunhe.dao.RecoderDao;
import cn.yunhe.dao.impl.RecoderDaoImpl;
import cn.yunhe.entity.Record;

public class RecordManagerImpl  implements RecordManager{
  private RecoderDao recoder = new RecoderDaoImpl();
	@Override
	public List<Record> query(int stu_id) {
		 
		return recoder.query(stu_id);
	}
	@Override
	public List<Record> queryByIdPage(int stu_id, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return recoder.queryByIdPage(stu_id, currentPage, pageSize);
	}

}
