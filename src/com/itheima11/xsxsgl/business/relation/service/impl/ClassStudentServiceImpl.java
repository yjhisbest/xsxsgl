package com.itheima11.xsxsgl.business.relation.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.baseData.dao.ClassDao;
import com.itheima11.xsxsgl.baseData.dao.StudentDao;
import com.itheima11.xsxsgl.basebusiness.service.impl.BaseBusinessSeviceImpl;
import com.itheima11.xsxsgl.business.relation.service.ClassStudentService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Student;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.StudentQuery;

@Service("classStudentService")
public class ClassStudentServiceImpl extends BaseBusinessSeviceImpl<Class, Student> implements ClassStudentService{
	@Resource(name="classDao")
	private ClassDao classDao;
	@Resource(name="studentDao")
	private StudentDao studentDao;
	@Override
	public BaseDao<Class> getBaseDao_zhu() {
		return this.classDao;
	}

	@Override
	public BaseDao<Student> getBaseDao_zi() {
		return this.studentDao;
	}
	@Transactional
	public void saveRelation(String bjbh, List<Student> students) {
		Class clazz = this.classDao.getEntryBId(bjbh);
		if(clazz!=null){
			Set<Student> allstudents = clazz.getStudents();
			int size = 0;
			if(!allstudents.isEmpty()){
				size = allstudents.size();
			}
			for(Student student : students){
				if(student.getXuehao()!=null && !student.getXuehao().equals("")){
					Student initstudent = this.studentDao.getEntryBId(student.getXuehao());
					initstudent.setClazz(clazz);
					size++;
				}
			}
			clazz.setNumber(size);
		}
	}

	//还没有写完
	@Transactional
	public String releaseAllStudent(String bjbh) {
		Class clazz = this.classDao.getEntryBId(bjbh);
		clazz.setStudents(null);
		clazz.setNumber(0);
		return "deleteOk";
	}
	@Transactional
	public String releaseOne(Student student, String bjbh) {
		
		Class clazz = student.getClazz();
		int number = clazz.getNumber();
		if(number>=1){
			student.setClazz(null);
			clazz.setNumber(number-1);
		}
		
		return "deleteOk";
	}

}
