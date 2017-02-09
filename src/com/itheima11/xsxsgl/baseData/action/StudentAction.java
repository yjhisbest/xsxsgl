package com.itheima11.xsxsgl.baseData.action;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.baseData.service.StudentService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Student;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.StudentQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("studentAction")
@Scope("prototype")
public class StudentAction extends BaseAction<Student>{
	@Resource(name="studentService")
	private StudentService studentService;
	StudentQuery baseQuery = new StudentQuery();
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		Student student = new Student();
		BeanUtils.copyProperties(this.getModel(), student);
		this.studentService.saveEntry(student);
		return action2action;
	}
	
	public String showPageResult(){
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Student> students = this.studentService.getPageResult(baseQuery);
		ActionContext.getContext().put("students", students);
		return listAction;
	}
	
	public String updateUI(){
		Student student = this.studentService.getEntryById(this.getModel().getXuehao());
		ActionContext.getContext().getValueStack().push(student);
		return updateUI;
	}
	
	public String update(){
		Student student = this.studentService.getEntryById(this.getModel().getXuehao());
		Class clazz = student.getClazz();
		BeanUtils.copyProperties(this.getModel(), student);
		student.setClazz(clazz);
		this.studentService.updateEntry(student);
		return action2action;
	}
	
	public String deleteStudents(){
		this.studentService.deleteEntriesByIds(this.getCheckedStr().split(","));
		ActionContext.getContext().getValueStack().push("deleteOK");
		return "delJson";
	}
	
	public String deleteOne(){
		this.studentService.deleteEntyById(this.getModel().getXuehao());
		ActionContext.getContext().getValueStack().push("deleteOK");
		return "delJson";
	}
}
