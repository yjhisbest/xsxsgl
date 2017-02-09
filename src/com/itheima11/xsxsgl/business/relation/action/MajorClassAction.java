package com.itheima11.xsxsgl.business.relation.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.baseData.service.ClassService;
import com.itheima11.xsxsgl.baseData.service.MajorService;
import com.itheima11.xsxsgl.business.relation.service.MajorClassService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Major;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.ClassQuery;
import com.itheima11.xsxsgl.query.basedata.MajorQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("majorClassAction")
@Scope("prototype")
public class MajorClassAction {
	private MajorQuery query_zhu = new MajorQuery();
	private ClassQuery query_zhi = new  ClassQuery();
	private String zymc;
	private Long mid;
	private List<Class> classes;
	public MajorQuery getQuery_zhu() {
		return query_zhu;
	}
	public void setQuery_zhu(MajorQuery query_zhu) {
		this.query_zhu = query_zhu;
	}
	public ClassQuery getQuery_zhi() {
		return query_zhi;
	}
	public void setQuery_zhi(ClassQuery query_zhi) {
		this.query_zhi = query_zhi;
	}
	public String getZymc() {
		return zymc;
	}
	public void setZymc(String zymc) {
		this.zymc = zymc;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}	
	public List<Class> getClasses() {
		return classes;
	}
	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	@Resource(name="majorClassService")
	private MajorClassService majorClassService;
	@Resource(name="majorService")
	private MajorService majorService;
	@Resource(name="classService")
	private ClassService classService;
	
	public String addUI(){
		return "addUI";
	}
	public String getClazz(){
		Class clazz = this.classService.getEntryById(this.query_zhi.getBjbh());
		if(clazz!=null){
			ActionContext.getContext().getValueStack().push(clazz);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	public String getMajor(){
		Major major = this.majorService.getMajorByZymc(this.zymc);
		if(major!=null){
			ActionContext.getContext().getValueStack().push(major);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	public String saveRelation(){
		this.majorClassService.saveRelation(mid,classes);
		return "action2action";
	}
	public String showMCGX(){
		PageResult<Major> pageResult_zhub = this.majorService.getPageResult(this.query_zhu);
		if(query_zhi.getMid()!=null){
			PageResult<Class> pageResult_zhib = this.classService.getPageResult(query_zhi);
			ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		}
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		return "listAction";
	}
	public String releaseAllClass(){
		String str = this.majorClassService.releaseAllClass(this.mid);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
	public String releaseOneClass(){
		Class clazz = this.classService.getEntryById(this.query_zhi.getBjbh());
		String str = this.majorClassService.releaseOneClass(clazz);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
}
