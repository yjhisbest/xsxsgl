package com.itheima11.xsxsgl.domain.basedata;

import java.io.Serializable;

public class LearnMessage implements Serializable{//学生学习信息
	private Long lid;
	private String xuehao;//学号
	private String xsmz;//学生名字
	private String kcbh;//课程编号
	private String kcmc;//课程名称
	private float pscj;//平时成绩
	private float kscj;//考试成绩
	private float cj;//成绩
	private String jsmc;//教师名称
	private String jsbh;//教师编号
	
	public Long getLid() {
		return lid;
	}
	public void setLid(Long lid) {
		this.lid = lid;
	}
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	public String getXsmz() {
		return xsmz;
	}
	public void setXsmz(String xsmz) {
		this.xsmz = xsmz;
	}
	public String getKcbh() {
		return kcbh;
	}
	public void setKcbh(String kcbh) {
		this.kcbh = kcbh;
	}
	public String getKcmc() {
		return kcmc;
	}
	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}
	public float getPscj() {
		return pscj;
	}
	public void setPscj(float pscj) {
		this.pscj = pscj;
	}
	public float getKscj() {
		return kscj;
	}
	public void setKscj(float kscj) {
		this.kscj = kscj;
	}
	public float getCj() {
		return cj;
	}
	public void setCj(float cj) {
		this.cj = cj;
	}
	public String getJsmc() {
		return jsmc;
	}
	public void setJsmc(String jsmc) {
		this.jsmc = jsmc;
	}
	public String getJsbh() {
		return jsbh;
	}
	public void setJsbh(String jsbh) {
		this.jsbh = jsbh;
	}
}
