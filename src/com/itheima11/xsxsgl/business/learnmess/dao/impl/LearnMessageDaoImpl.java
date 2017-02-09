package com.itheima11.xsxsgl.business.learnmess.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.impl.BaseDaoImpl;
import com.itheima11.xsxsgl.business.learnmess.dao.LearnMessageDao;
import com.itheima11.xsxsgl.domain.basedata.LearnMessage;

@Repository("learnMessageDao")
public class LearnMessageDaoImpl extends BaseDaoImpl<LearnMessage> implements LearnMessageDao{

	public LearnMessage seekLearnMessByXueHaoKcbh(String xuehao, String kcbh) {
		// TODO Auto-generated method stub
		List<LearnMessage> list = this.hibernateTemplate.find("from LearnMessage where xuehao=? and kcbh=?",xuehao,kcbh);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	public List<LearnMessage> getStuLearnMessByXuehao(String xuehao) {
		return this.hibernateTemplate.find("from LearnMessage where xuehao=?", xuehao);
	}

}
