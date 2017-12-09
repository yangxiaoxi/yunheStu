package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.Record;
import cn.yunhe.entity.Score;

public interface ScoreManager {

	List<Score> query(int score_type,int class_id);
	List<Score> queryByStuid(int stu_id);
}
