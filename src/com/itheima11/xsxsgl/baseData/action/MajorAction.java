package com.itheima11.xsxsgl.baseData.action;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.baseData.service.MajorService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Major;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.MajorQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("majorAction")
@Scope("prototype")
public class MajorAction extends BaseAction<Major>{
	@Resource(name="majorService")
	private MajorService majorService;
	private MajorQuery baseQuery = new MajorQuery();
	public MajorQuery getBaseQuery() {
		return baseQuery;
	}
	public void setBaseQuery(MajorQuery baseQuery) {
		this.baseQuery = baseQuery;
	}
	public String addUI(){
		return addUI;
	}
	public String add(){
		Major major = new Major();
		BeanUtils.copyProperties(this.getModel(), major);
		this.majorService.saveEntry(major);
		return action2action;
	}
	public String showPageResult(){
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Major> majors = this.majorService.getPageResult(baseQuery);
		ActionContext.getContext().put("majors", majors);
		return listAction;
	}
	public String updateUI(){
		Major major = this.majorService.getEntryById(this.getModel().getMid());
		ActionContext.getContext().getValueStack().push(major);
		return updateUI;
	}
	public String update(){
		Major major = this.majorService.getEntryById(this.getModel().getMid());
		major.setZymc(this.getModel().getZymc());
		major.setZylb(this.getModel().getZylb());
		this.majorService.updateEntry(major);
		return action2action;
	}
	public String deleteMajors(){
		this.majorService.deleteEntriesByIds(this.getCheckedStr().split(","));
		ActionContext.getContext().getValueStack().push("deleteOK");
		return "delJson";
	}
	public String deleteOne(){
		this.majorService.deleteEntyById(this.getModel().getMid());
		ActionContext.getContext().getValueStack().push("deleteOK");
		return "delJson";
	}
}
