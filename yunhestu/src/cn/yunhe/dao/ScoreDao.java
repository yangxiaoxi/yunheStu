package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Score;

public interface ScoreDao {
	/**
	 * 根据分数类型和班级id查找分数
	 * @param score_type  分数类型
	 * @param class_id     班级id
	 * @return
	 */
	List<Score> query(int score_type,int class_id);
	 
	/**
	 * 根据学生id和分数类型查找学生分数
	 * @param stu_id   学生id
	 * @param score_type  分数类型
	 * @return
	 */
	List<Score> queryBysIDandStype(int stu_id,int score_type);
	/**
	 * 根据学生id找分数
	 * @param stu_id  学生id
	 * @return
	 */
	List<Score> queryByStuid(int stu_id);
}
