package com.itheima11.xsxsgl.business.learnmess.service;

import com.itheima11.xsxsgl.base.service.BaseSerivce;
import com.itheima11.xsxsgl.domain.basedata.LearnMessage;
import com.itheima11.xsxsgl.domain.basedata.Teacher;

public interface LearnMessageService extends BaseSerivce<LearnMessage>{
	//根据学号和课程编号查看该数据是否经存在
	public LearnMessage seekLearnMessByXueHaoKcbh(String xuehao, String kcbh);

	public Teacher getTeacher(String kcbh, String jsmc);

	public String getStudentCJDATA(String xuehao);
}
