package com.itheima11.xsxsgl.baseData.action;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.baseData.service.CollegeService;
import com.itheima11.xsxsgl.domain.basedata.College;
import com.itheima11.xsxsgl.domain.basedata.Major;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.CollegeQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("collegeAction")
@Scope("prototype")
public class CollegeAction extends BaseAction<College>{
	@Resource(name="collegeService")
	private CollegeService collegeService;
	private CollegeQuery baseQuery = new CollegeQuery();
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		College college = new College();
		BeanUtils.copyProperties(this.getModel(), college);
		this.collegeService.saveEntry(college);
		return action2action;
	}
	
	//展示学院列表
	public String showPageResult(){
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<College> colleges = this.collegeService.getPageResult(baseQuery);
		ActionContext.getContext().put("colleges", colleges);
		return listAction;
	}
	
	public String updateUI(){
		College college = this.collegeService.getEntryById(this.getModel().getId());
		ActionContext.getContext().getValueStack().push(college);
		return updateUI;
	}
	public String update(){
		College college = this.collegeService.getEntryById(this.getModel().getId());
		college.setXymc(this.getModel().getXymc());
		college.setYz(this.getModel().getYz());
		college.setSj(this.getModel().getSj());
		this.collegeService.updateEntry(college);
		return action2action;
	}
	public String deleteColleges(){
		String str = this.collegeService.checkCollegesSetIsNot(this.getCheckedStr().split(","));
		if(str.equals("pass")){
			this.collegeService.deleteEntriesByIds(this.getCheckedStr().split(","));
			ActionContext.getContext().getValueStack().push("deleteOK");
		}else{
			ActionContext.getContext().getValueStack().push(str);
		}
		return "delJson";
	}
	
	public String deleteOne(){
		String str = this.collegeService.checkSetIsNot(this.getModel().getId());
		if(str.equals("pass")){
			this.collegeService.deleteEntyById(this.getModel().getId());
			ActionContext.getContext().getValueStack().push("deleteOK");
		}else{
			ActionContext.getContext().getValueStack().push(str);
		}
		return "delJson";
	}
}
