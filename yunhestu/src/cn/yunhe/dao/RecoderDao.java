package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Record;

public interface RecoderDao {

	
	/**
	 * ����ѧ��id�ҵ�ѧ���Ĵ򿨼�¼
	 * @param stu_id
	 * @return
	 */
	List<Record> query(int stu_id);
	
	/**
	 * ѧ���򿨼�¼��ҳ��ѯ
	 * @param stu_id
	 * @return
	 */
	List<Record> queryByIdPage(int stu_id,int currentPage,int pageSize);
}
