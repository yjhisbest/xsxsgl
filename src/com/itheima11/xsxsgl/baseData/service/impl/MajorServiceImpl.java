package com.itheima11.xsxsgl.baseData.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.base.service.BaseServiceImpl;
import com.itheima11.xsxsgl.baseData.dao.MajorDao;
import com.itheima11.xsxsgl.baseData.service.MajorService;
import com.itheima11.xsxsgl.domain.basedata.Major;

@Service("majorService")
public class MajorServiceImpl extends BaseServiceImpl<Major> implements MajorService{
	@Resource(name="majorDao")
	private MajorDao majorDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.majorDao;
	}
	public Major getMajorByZymc(String zymc) {
		// TODO Auto-generated method stub
		return this.majorDao.getMajorByName(zymc);
	}

}
