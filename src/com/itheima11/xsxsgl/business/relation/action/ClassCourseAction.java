package com.itheima11.xsxsgl.business.relation.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.baseData.service.ClassService;
import com.itheima11.xsxsgl.baseData.service.CourseService;
import com.itheima11.xsxsgl.business.relation.service.ClassCourseService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.ClassQuery;
import com.itheima11.xsxsgl.query.basedata.CourseQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("classCourseAction")
@Scope("prototype")
public class ClassCourseAction {
	private ClassQuery query_zhu = new ClassQuery();
	private CourseQuery query_zhi = new CourseQuery();
	public ClassQuery getQuery_zhu() {
		return query_zhu;
	}
	public void setQuery_zhu(ClassQuery query_zhu) {
		this.query_zhu = query_zhu;
	}
	public CourseQuery getQuery_zhi() {
		return query_zhi;
	}
	public void setQuery_zhi(CourseQuery query_zhi) {
		this.query_zhi = query_zhi;
	}
	private String bjbh;
	private List<Course> courses;
	public String getBjbh() {
		return bjbh;
	}
	public void setBjbh(String bjbh) {
		this.bjbh = bjbh;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	@Resource(name="classCourseService")
	private ClassCourseService classCourseService;
	@Resource(name="classService")
	private ClassService classService;
	@Resource(name="courseService")
	private CourseService courseService;
	
	public String addUI(){
		return "addUI";
	}
	
	public String getCourse(){
		Course course = this.courseService.getEntryById(this.query_zhi.getKcbh());
		if(course!=null){
			ActionContext.getContext().getValueStack().push(course);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	public String getClazz(){
		Class clazz = this.classService.getEntryById(this.bjbh);
		if(clazz!=null){
			ActionContext.getContext().getValueStack().push(clazz);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	//建立班级和课程之间的联系
	public String saveRelation(){
		this.classCourseService.saveRelation(bjbh,courses);
		return "action2action";
	}
	public String showCCGX(){
		PageResult<Class> pageResult_zhub = this.classService.getPageResult(query_zhu);
		if(this.bjbh!=null && !this.bjbh.equals("")){
			//PageResult<Teacher> pageResult_zhib = this.teacherService.getPageResult(query_zhi);
			PageResult<Course> pageResult_zhib = this.classCourseService.getCourseListById(bjbh, query_zhi);
			ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		}
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		return "listAction";
	}
	public String releaseAllCourse(){
		String str = this.classCourseService.relationAllCourse(bjbh);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
	public String releaseOneCourse(){
		Course course = this.courseService.getEntryById(this.query_zhi.getKcbh());
		String str = this.classCourseService.releaseOneCourse(course, bjbh);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
}
