package com.itheima11.xsxsgl.baseData.action;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.baseData.service.CourseService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.CourseQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("courseAction")
@Scope("prototype")
public class CourseAction extends BaseAction<Course>{
	@Resource(name="courseService")
	private CourseService courseService;
	private CourseQuery baseQuery = new CourseQuery();
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		Course course = new Course();
		BeanUtils.copyProperties(this.getModel(), course);
		this.courseService.saveEntry(course);
		return action2action;
	}
	//展示课程列表
	public String showPageResult(){
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Course> courses = this.courseService.getPageResult(baseQuery);
		ActionContext.getContext().put("courses", courses);
		return listAction;
	}
	
	public String updateUI(){
		Course course = this.courseService.getEntryById(this.getModel().getKcbh());
		ActionContext.getContext().getValueStack().push(course);
		return updateUI;
	}
	
	public String update(){
		Course course = this.courseService.getEntryById(this.getModel().getKcbh());
		Teacher teacher = course.getTeacher();
		Set<Class> classes = course.getClasses();
		BeanUtils.copyProperties(this.getModel(), course);
		course.setTeacher(teacher);
		course.setClasses(classes);
		this.courseService.updateEntry(course);
		return action2action;
	}
	
	public String deleteCourses(){
		String str = this.courseService.checkCollegesSetIsNot(this.getCheckedStr().split(","));
		if(str.equals("pass")){
			this.courseService.deleteEntriesByIds(this.getCheckedStr().split(","));
			ActionContext.getContext().getValueStack().push("deleteOK");
		}else{
			ActionContext.getContext().getValueStack().push(str);
		}
		return "delJson";
	}
	public String deleteOne(){
		String str = this.courseService.checkSetIsNot(this.getModel().getKcbh());
		if(str.equals("pass")){
			this.courseService.deleteEntyById(this.getModel().getKcbh());
			ActionContext.getContext().getValueStack().push("deleteOK");
		}else{
			ActionContext.getContext().getValueStack().push(str);
		}
		return "delJson";
	}
}
