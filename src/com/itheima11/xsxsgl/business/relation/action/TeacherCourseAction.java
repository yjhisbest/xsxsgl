package com.itheima11.xsxsgl.business.relation.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hxtt.concurrent.q;
import com.itheima11.xsxsgl.baseData.service.CourseService;
import com.itheima11.xsxsgl.baseData.service.TeacherService;
import com.itheima11.xsxsgl.business.relation.service.TeacherCourseService;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Major;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.CourseQuery;
import com.itheima11.xsxsgl.query.basedata.TeacherQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("teacherCourseAction")
@Scope("prototype")
public class TeacherCourseAction {
	private TeacherQuery query_zhu = new TeacherQuery();
	private CourseQuery query_zhi = new CourseQuery();
	private String jsbh;
	private List<Course> courses;
	public TeacherQuery getQuery_zhu() {
		return query_zhu;
	}
	public void setQuery_zhu(TeacherQuery query_zhu) {
		this.query_zhu = query_zhu;
	}
	public CourseQuery getQuery_zhi() {
		return query_zhi;
	}
	public void setQuery_zhi(CourseQuery query_zhi) {
		this.query_zhi = query_zhi;
	}
	public String getJsbh() {
		return jsbh;
	}
	public void setJsbh(String jsbh) {
		this.jsbh = jsbh;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Resource(name="teacherCourseService")
	private TeacherCourseService teacherCourseService;
	@Resource(name="teacherService")
	private TeacherService teacherService;
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
	public String getTeacher(){
		Teacher teacher = this.teacherService.getEntryById(jsbh);
		if(teacher!=null){
			ActionContext.getContext().getValueStack().push(teacher);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	public String saveRelation(){
		this.teacherCourseService.saveRelation(jsbh,courses);
		return "action2action";
	}
	public String showTCSGX(){
		PageResult<Teacher> pageResult_zhub = this.teacherService.getPageResult(query_zhu);
		if(query_zhi.getJsbh()!=null){
			PageResult<Course> pageResult_zhib = this.courseService.getPageResult(query_zhi);
			ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		}
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		return "listAction";
	}
	public String releaseAllCourse(){
		String str = this.teacherCourseService.releaseAllCourse(this.jsbh);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
	public String releaseOneCourse(){
		Course course = this.courseService.getEntryById(this.query_zhi.getKcbh());
		String str = this.teacherCourseService.releaseOneCourse(course);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
}
