package cn.yunhe.entity;

import java.math.BigDecimal;

public class Student {
//名次	学号	姓名	纪律考核分	技术考核分	职业能力考核分	综合分
	private int stu_desc;//学名排名
	private String stu_no;//学号
	private String stu_name;//姓名
	private double stu_score_jl;//纪律
	private double stu_score_js;//技术
	private double stu_score_zy;//职业
	private double stu_sum;//综合分
	private String start_time;//上班打卡时间
	private String end_time;//下班打卡时间
	private String stu_date;//日期；
	private String stu_status;//学生状态
	private int class_id;
	private int stu_id;
	private String stu_sex;
	private String stu_profession;
	private String imgs;
	
	
	
	
	
	
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getStu_profession() {
		return stu_profession;
	}
	public void setStu_profession(String stu_profession) {
		this.stu_profession = stu_profession;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public double getStu_score_jl() {
		return stu_score_jl;
	}
	public void setStu_score_jl(double stu_score_jl) {
		this.stu_score_jl = stu_score_jl;
	}
	public double getStu_score_js() {
		return stu_score_js;
	}
	public void setStu_score_js(double stu_score_js) {
		this.stu_score_js = stu_score_js;
	}
	public double getStu_score_zy() {
		return stu_score_zy;
	}
	public void setStu_score_zy(double stu_score_zy) {
		this.stu_score_zy = stu_score_zy;
	}
	public double getStu_sum() {
		return stu_sum;
	}
	public void setStu_sum(double stu_sum) {
		this.stu_sum = stu_sum;
	}
	public int getStu_desc() {
		return stu_desc;
	}
	public void setStu_desc(int stu_desc) {
		this.stu_desc = stu_desc;
	}
	public String getStu_no() {
		return stu_no;
	}
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
 
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getStu_date() {
		return stu_date;
	}
	public void setStu_date(String stu_date) {
		this.stu_date = stu_date;
	}
 
	public String getStu_status() {
		return stu_status;
	}
	public void setStu_status(String stu_status) {
		this.stu_status = stu_status;
	}
	@Override
	public String toString() {
		return "Student [stu_desc=" + stu_desc + ", stu_no=" + stu_no
				+ ", stu_name=" + stu_name + ", stu_score_jl=" + stu_score_jl
				+ ", stu_score_js=" + stu_score_js + ", stu_score_zy="
				+ stu_score_zy + ", stu_sum=" + stu_sum + ", start_time="
				+ start_time + ", end_time=" + end_time + ", stu_date="
				+ stu_date + ", stu_status=" + stu_status + "]";
	}
	
}
