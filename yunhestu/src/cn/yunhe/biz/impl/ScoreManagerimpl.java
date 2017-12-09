package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.ScoreManager;
import cn.yunhe.dao.ScoreDao;
import cn.yunhe.dao.impl.ScoreDaoimpl;
import cn.yunhe.entity.Record;
import cn.yunhe.entity.Score;

public class ScoreManagerimpl implements ScoreManager{

	ScoreDao jsscore = new ScoreDaoimpl();

		@Override
		public List<Score> query(int score_type,int class_id) {
		    List<Score>lists = jsscore.query(score_type,class_id);
			return lists;
		}

		@Override
		public List<Score> queryByStuid(int stu_id) {
			return jsscore.queryByStuid(stu_id);
		}

		 
	 
}
