package com.itheima11.xsxsgl.business.relation.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.baseData.dao.CollegeDao;
import com.itheima11.xsxsgl.baseData.dao.MajorDao;
import com.itheima11.xsxsgl.basebusiness.service.impl.BaseBusinessSeviceImpl;
import com.itheima11.xsxsgl.business.relation.service.CollegeMajorService;
import com.itheima11.xsxsgl.domain.basedata.College;
import com.itheima11.xsxsgl.domain.basedata.Major;

@Service("collegeMajorService")
public class CollegeMajorServiceImpl extends BaseBusinessSeviceImpl<College, Major> implements CollegeMajorService{
	@Resource(name="collegeDao")
	private CollegeDao collegeDao;
	@Resource(name="majorDao")
	private MajorDao majorDao;
	@Override
	public BaseDao<College> getBaseDao_zhu() {
		// TODO Auto-generated method stub
		return this.collegeDao;
	}

	@Override
	public BaseDao<Major> getBaseDao_zi() {
		// TODO Auto-generated method stub
		return this.majorDao;
	}

	public Collection<College> getColleges() {
		// TODO Auto-generated method stub
		return this.collegeDao.findEntry();
	}

	public Major getMajorByName(String zymc) {
		// TODO Auto-generated method stub
		return this.majorDao.getMajorByName(zymc);
	}

	@Transactional
	public void saveRelation(Long id, List<Major> majors) {
		College college = this.collegeDao.getEntryBId(id);
		if(college!=null){
			//Set<Major> allmajors = college.getMajors();
			for(Major major : majors){
				if(major.getZymc()!=null && !major.getZymc().equals("")){
					Major initmajor = this.majorDao.getMajorByName(major.getZymc());
					initmajor.setCollege(college);
				}
			}
		}	
	}
	/*
	@Transactional
	public void saveRelation(Long id, List<Major> majors) {
		College college = this.collegeDao.getEntryBId(id);
		if(college!=null){
			Set<Major> allmajors = college.getMajors();
			for(Major major : majors){
				if(major.getZymc()!=null && !major.getZymc().equals("")){
					Major initmajor = this.majorDao.getMajorByName(major.getZymc());
					allmajors.add(initmajor);
				}
			}
			//this.collegeDao.updateEntry(college);
		}	
	}
	*/

	@Transactional
	public String releaseAll(Long id) {
		College college = this.collegeDao.getEntryBId(id);
		college.setMajors(null);//级联更新，将专业设置为空
		return "deleteOk";
	}

	@Transactional
	public String releaseOne(Major major) {
		major.setCollege(null);
		return "deleteOk";
	}

}
