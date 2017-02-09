package com.itheima11.xsxsgl.baseData.action;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.baseData.service.ClassService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Major;
import com.itheima11.xsxsgl.domain.basedata.Student;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.ClassQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("classAction")
@Scope("prototype")
public class ClassAction extends BaseAction<Class>{
	@Resource(name="classService")
	private ClassService classService;
	private ClassQuery baseQuery = new ClassQuery();
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		Class clazz = new Class();
		BeanUtils.copyProperties(this.getModel(), clazz);
		this.classService.saveEntry(clazz);
		return action2action;
	}
	
	public String showPageResult(){
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Class> classes = this.classService.getPageResult(baseQuery);
		ActionContext.getContext().put("classes", classes);
		return listAction;
	}
	
	public String updateUI(){
		Class clazz = this.classService.getEntryById(this.getModel().getBjbh());
		ActionContext.getContext().getValueStack().push(clazz);
		return updateUI;
	}
	
	public String update(){
		Class clazz = this.classService.getEntryById(this.getModel().getBjbh());
		clazz.setBjmc(this.getModel().getBjmc());
		this.classService.updateEntry(clazz);
		return action2action;
	}
	
	public String deleteClasses(){
		String str = this.classService.checkTeachersSetIsNot(this.getCheckedStr().split(","));
		if(str.equals("pass")){//表示可以删除
			this.classService.deleteEntriesByIds(this.getCheckedStr().split(","));
			ActionContext.getContext().getValueStack().push("deleteOK");
		}else{
			ActionContext.getContext().getValueStack().push(str);
		}
		return "delJson";
	}
	
	public String deleteOne(){
		String str = this.classService.checkSetIsNot(this.getModel().getBjbh());
		if(str.equals("pass")){
			this.classService.deleteEntyById(this.getModel().getBjbh());
			ActionContext.getContext().getValueStack().push("deleteOK");
		}else{
			ActionContext.getContext().getValueStack().push(str);
		}
		return "delJson";
	}
}
