package com.itheima11.xsxsgl.business.relation.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.baseData.service.ClassService;
import com.itheima11.xsxsgl.baseData.service.TeacherService;
import com.itheima11.xsxsgl.business.relation.service.ClassTeacherService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.ClassQuery;
import com.itheima11.xsxsgl.query.basedata.TeacherQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("classTeacherAction")
@Scope("prototype")
public class ClassTeacherAction {
	private ClassQuery query_zhu = new ClassQuery();
	private TeacherQuery query_zhi = new TeacherQuery();
	public ClassQuery getQuery_zhu() {
		return query_zhu;
	}
	public void setQuery_zhu(ClassQuery query_zhu) {
		this.query_zhu = query_zhu;
	}
	public TeacherQuery getQuery_zhi() {
		return query_zhi;
	}
	public void setQuery_zhi(TeacherQuery query_zhi) {
		this.query_zhi = query_zhi;
	}

	private String bjbh;
	private List<Teacher> teachers;
	public String getBjbh() {
		return bjbh;
	}
	public void setBjbh(String bjbh) {
		this.bjbh = bjbh;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Resource(name="classTeacherService")
	private ClassTeacherService classTeacherService;
	@Resource(name="classService")
	private ClassService classService;
	@Resource(name="teacherService")
	private TeacherService teacherService;
	public String addUI(){
		return "addUI";
	}
	
	//获取教师
	public String getTeacher(){
		Teacher teacher = this.teacherService.getEntryById(this.query_zhi.getJsbh());
		if(teacher!=null){
			ActionContext.getContext().getValueStack().push(teacher);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	//获取课程
	public String getClazz(){
		Class clazz = this.classService.getEntryById(this.bjbh);
		if(clazz!=null){
			ActionContext.getContext().getValueStack().push(clazz);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	//建立教师与班级之间的关系
	public String saveRelation(){
		this.classTeacherService.saveRelation(bjbh,teachers);
		return "action2action";
	}
	
	public String showCTGX(){
		PageResult<Class> pageResult_zhub = this.classService.getPageResult(query_zhu);
		if(this.bjbh!=null && !this.bjbh.equals("")){
			//PageResult<Teacher> pageResult_zhib = this.teacherService.getPageResult(query_zhi);
			PageResult<Teacher> pageResult_zhib = this.classTeacherService.getTeacherListById(bjbh, query_zhi);
			ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		}
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		return "listAction";
	}
	
	//解除全部关系
	public String releaseAllTeacher(){
		String str = this.classTeacherService.releaseAllTeacher(this.bjbh);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
	//解除一个关系
	public String releaseOneTeacher(){
		Teacher teacher = this.teacherService.getEntryById(this.query_zhi.getJsbh());
		String str = this.classTeacherService.releaseOneTeacher(teacher,this.bjbh);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
}
