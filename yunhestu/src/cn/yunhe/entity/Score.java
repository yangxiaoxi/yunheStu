package cn.yunhe.entity;

import java.math.BigDecimal;

public class Score {
	private String  time;//����
	private String stu_name;//ѧ������
	private String score_contents;//��������
	private double score_values;//����
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getScore_contents() {
		return score_contents;
	}
	public void setScore_contents(String score_contents) {
		this.score_contents = score_contents;
	}

	
	public double getScore_values() {
		return score_values;
	}
	public void setScore_values(double score_values) {
		this.score_values = score_values;
	}
	public void Score(){}
	public Score(String time, String stu_name, String score_contents,
			double score_values) {
		super();
		this.time = time;
		this.stu_name = stu_name;
		this.score_contents = score_contents;
		this.score_values = score_values;
	}
	@Override
	public String toString() {
		return "Score [time=" + time + ", stu_name=" + stu_name
				+ ", score_contents=" + score_contents + ", score_values="
				+ score_values + "]";
	}
	
	
    
	

}
