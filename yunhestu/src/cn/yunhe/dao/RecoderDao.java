package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Record;

public interface RecoderDao {

	
	/**
	 * 根据学生id找到学生的打卡记录
	 * @param stu_id
	 * @return
	 */
	List<Record> query(int stu_id);
	
	/**
	 * 学生打卡记录分页查询
	 * @param stu_id
	 * @return
	 */
	List<Record> queryByIdPage(int stu_id,int currentPage,int pageSize);
}
