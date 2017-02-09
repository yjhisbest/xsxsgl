package com.itheima11.xsxsgl.baseData.action;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.baseData.service.TeacherService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.College;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.TeacherQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("teacherAction")
@Scope("prototype")
public class TeacherAction extends BaseAction<Teacher>{
	@Resource(name="teacherService")
	private TeacherService teacherService;
	private TeacherQuery baseQuery = new TeacherQuery();
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(this.getModel(), teacher);
		this.teacherService.saveEntry(teacher);
		return action2action;
	}
	
	public String showPageResult(){
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Teacher> teachers = this.teacherService.getPageResult(baseQuery);
		ActionContext.getContext().put("teachers", teachers);
		return listAction;
	}
	
	public String updateUI(){
		Teacher teacher = this.teacherService.getEntryById(this.getModel().getJsbh());
		ActionContext.getContext().getValueStack().push(teacher);
		return updateUI;
	}
	
	public String update(){
		Teacher teacher = this.teacherService.getEntryById(this.getModel().getJsbh());
		teacher.setPassword(this.getModel().getPassword());
		teacher.setJsmc(this.getModel().getJsmc());
		teacher.setSex(this.getModel().getSex());
		teacher.setAge(this.getModel().getAge());
		teacher.setJszc(this.getModel().getJszc());
		teacher.setCellphone(this.getModel().getCellphone());
		this.teacherService.updateEntry(teacher);
		return action2action;
	}
	
	public String deleteTeachers(){
		String str = this.teacherService.checkTeachersSetIsNot(this.getCheckedStr().split(","));
		if(str.equals("pass")){//表示可以删除
			this.teacherService.deleteEntriesByIds(this.getCheckedStr().split(","));
			ActionContext.getContext().getValueStack().push("deleteOK");
		}else{
			ActionContext.getContext().getValueStack().push(str);
		}
		return "delJson";
	}
	
	public String deleteOne(){
		String str = this.teacherService.checkSetIsNot(this.getModel().getJsbh());
		if(str.equals("pass")){
			this.teacherService.deleteEntyById(this.getModel().getJsbh());
			ActionContext.getContext().getValueStack().push("deleteOK");
		}else{
			ActionContext.getContext().getValueStack().push(str);
		}
		return "delJson";
	}
	
	public String showPersonalMess(){
		Teacher teacher = (Teacher) this.getSession().getAttribute("teacher");
		ActionContext.getContext().getValueStack().push(teacher);
		return "personalMess";
	}
	public String updatePersonalMess(){
		Teacher teacher = (Teacher) this.getSession().getAttribute("teacher");
		if(!this.getModel().getPassword().equals("")){
			teacher.setJsmc(this.getModel().getPassword());
		}
		teacher.setJsmc(this.getModel().getJsmc());
		teacher.setSex(this.getModel().getSex());
		teacher.setAge(this.getModel().getAge());
		teacher.setJszc(this.getModel().getJszc());
		teacher.setCellphone(this.getModel().getCellphone());
		this.teacherService.updateEntry(teacher);
		return "personalMess";
	}
}

