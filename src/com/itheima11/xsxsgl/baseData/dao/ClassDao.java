package com.itheima11.xsxsgl.baseData.dao;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.domain.basedata.Class;

public interface ClassDao extends BaseDao<Class>{

	String checkSetIsNot(String bjbh);

	boolean checkUnionKey(String bjbh, String jsbh);
	//检修是否有班级编号与班级编号一样的联合主键
	boolean checkUnionKeyCC(String bjbh, String kcbh);

	Class getClassByName(String bjbh);
}
