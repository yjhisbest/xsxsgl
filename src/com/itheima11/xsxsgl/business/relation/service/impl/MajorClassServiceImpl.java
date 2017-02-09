package com.itheima11.xsxsgl.business.relation.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.baseData.dao.ClassDao;
import com.itheima11.xsxsgl.baseData.dao.MajorDao;
import com.itheima11.xsxsgl.basebusiness.service.impl.BaseBusinessSeviceImpl;
import com.itheima11.xsxsgl.business.relation.service.MajorClassService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Major;


@Service("majorClassService")
public class MajorClassServiceImpl extends BaseBusinessSeviceImpl<Major, Class> implements MajorClassService{
	@Resource(name="majorDao")
	private MajorDao majorDao;
	@Resource(name="classDao")
	private ClassDao classDao;
	@Override
	public BaseDao<Major> getBaseDao_zhu() {
		return this.majorDao;
	}

	@Override
	public BaseDao<Class> getBaseDao_zi() {
		return this.classDao;
	}
	@Transactional
	public void saveRelation(Long mid, List<Class> classes) {
		Major major = this.majorDao.getEntryBId(mid);
		if(major!=null){
			for(Class clazz : classes){
				if(clazz.getBjbh()!=null && !clazz.getBjbh().equals("")){
					Class initclass = this.classDao.getEntryBId(clazz.getBjbh());
					initclass.setMajor(major);
				}
			}
		}
		
	}
	@Transactional
	public String releaseAllClass(Long mid) {
		Major major = this.majorDao.getEntryBId(mid);
		major.setClasses(null);
		return "deleteOk";
	}
	@Transactional
	public String releaseOneClass(Class clazz) {
		clazz.setMajor(null);
		return "deleteOk";
	}

}
