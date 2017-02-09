package com.itheima11.xsxsgl.business.learnmess.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.base.service.BaseServiceImpl;
import com.itheima11.xsxsgl.baseData.dao.TeacherDao;
import com.itheima11.xsxsgl.business.learnmess.dao.LearnMessageDao;
import com.itheima11.xsxsgl.business.learnmess.service.LearnMessageService;
import com.itheima11.xsxsgl.domain.basedata.LearnMessage;
import com.itheima11.xsxsgl.domain.basedata.Teacher;

@Service("learnMessageService")
public class LearnMessageServiceImpl extends BaseServiceImpl<LearnMessage> implements LearnMessageService{
	@Resource(name="learnMessageDao")
	private LearnMessageDao learnMessageDao;
	@Resource(name="teacherDao")
	private TeacherDao teacherDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.learnMessageDao;
	}
	public LearnMessage seekLearnMessByXueHaoKcbh(String xuehao, String kcbh) {
		// TODO Auto-generated method stub
		return this.learnMessageDao.seekLearnMessByXueHaoKcbh(xuehao, kcbh);
	}
	public Teacher getTeacher(String kcbh, String jsmc) {
		return this.teacherDao.getTeacherByKJ(kcbh,jsmc);
	}
	public String getStudentCJDATA(String xuehao) {
		int a=0,b=0,c=0,d=0,e=0;
		List<LearnMessage> learnMessages = this.learnMessageDao.getStuLearnMessByXuehao(xuehao);
		for(LearnMessage learnMessage : learnMessages){
			if(learnMessage.getCj()>=90){
				a++;
			}else if(learnMessage.getCj()>=80 && learnMessage.getCj()<90){
				b++;
			}else if(learnMessage.getCj()>=70 && learnMessage.getCj()<80){
				c++;
			}else if(learnMessage.getCj()>=60 && learnMessage.getCj()<70){
				d++;
			}else{
				e++;
			}
		}
		String str = "[{name : '0~60',value : "+e+",color:'#a5c2d5'},"
				 +"{name : '60~70',value : "+d+",color:'#cbab4f'},"
				 +"{name : '70~80',value : "+c+",color:'#76a871'},"
				 +"{name : '80~90',value : "+b+",color:'#9f7961'},"
				 +"{name : '90~100',value : "+a+",color:'#a56f8f'}]";
		return str;
	}

}
