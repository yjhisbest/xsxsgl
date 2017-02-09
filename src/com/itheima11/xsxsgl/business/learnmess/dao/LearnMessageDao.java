package com.itheima11.xsxsgl.business.learnmess.dao;

import java.util.List;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.domain.basedata.LearnMessage;

public interface LearnMessageDao extends BaseDao<LearnMessage>{
	//根据学号和课程编号查看该数据是否经存在
	public LearnMessage seekLearnMessByXueHaoKcbh(String xuehao, String kcbh);

	public List<LearnMessage> getStuLearnMessByXuehao(String xuehao);
}
