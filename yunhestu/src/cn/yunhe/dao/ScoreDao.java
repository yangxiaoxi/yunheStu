package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Score;

public interface ScoreDao {
	/**
	 * ���ݷ������ͺͰ༶id���ҷ���
	 * @param score_type  ��������
	 * @param class_id     �༶id
	 * @return
	 */
	List<Score> query(int score_type,int class_id);
	 
	/**
	 * ����ѧ��id�ͷ������Ͳ���ѧ������
	 * @param stu_id   ѧ��id
	 * @param score_type  ��������
	 * @return
	 */
	List<Score> queryBysIDandStype(int stu_id,int score_type);
	/**
	 * ����ѧ��id�ҷ���
	 * @param stu_id  ѧ��id
	 * @return
	 */
	List<Score> queryByStuid(int stu_id);
}
