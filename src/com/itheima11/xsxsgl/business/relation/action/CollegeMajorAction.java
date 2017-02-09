package com.itheima11.xsxsgl.business.relation.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.baseData.service.CollegeService;
import com.itheima11.xsxsgl.baseData.service.MajorService;
import com.itheima11.xsxsgl.business.relation.service.CollegeMajorService;
import com.itheima11.xsxsgl.domain.basedata.College;
import com.itheima11.xsxsgl.domain.basedata.Major;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.CollegeQuery;
import com.itheima11.xsxsgl.query.basedata.MajorQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("collegeMajorAction")
@Scope("prototype")
public class CollegeMajorAction {
	private CollegeQuery query_zhu = new CollegeQuery();
	private MajorQuery query_zhi = new MajorQuery();
	private List<Major> majors;
	private Long id;//学院id
	@Resource(name="collegeMajorService")
	private CollegeMajorService collegeMajorService;
	@Resource(name="majorService")
	private MajorService majorService;
	@Resource(name="collegeService")
	private CollegeService collegeService;
	public CollegeQuery getQuery_zhu() {
		return query_zhu;
	}

	public void setQuery_zhu(CollegeQuery query_zhu) {
		this.query_zhu = query_zhu;
	}

	public MajorQuery getQuery_zhi() {
		return query_zhi;
	}

	public void setQuery_zhi(MajorQuery query_zhi) {
		this.query_zhi = query_zhi;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String addUI(){
		return "addUI";
	}
	
	public String saveRelation(){
		this.collegeMajorService.saveRelation(id,majors);
		return "action2action";
	}
	
	//展现学院与专业列表
	public String showCMGX(){
		PageResult<College> pageResult_zhub = this.collegeService.getPageResult(query_zhu);
		if(query_zhi.getId()!=null){//子表的query_zhi.id的值不为空，这个if和上面的if只会执行一个
			PageResult<Major> pageResult_zhib = this.majorService.getPageResult(query_zhi);
			ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		}
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		return "listAction";
	}
	//get页面的学院div提供选择
	public String showCollegeDivFrame(){
		Collection<College> colleges = this.collegeMajorService.getColleges();
		ActionContext.getContext().getValueStack().push(colleges);
		return "success";
	}
	//获取专业
	public String getMajor(){
		Major major = this.collegeMajorService.getMajorByName(this.query_zhi.getZymc());
		if(major!=null){
			ActionContext.getContext().getValueStack().push(major);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	//解除全部关系
	public String releaseAll(){
		String str = this.collegeMajorService.releaseAll(this.id);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
	//解除一个关系
	public String releaseOne(){
		Major major = this.collegeMajorService.getMajorByName(this.query_zhi.getZymc());
		String str = this.collegeMajorService.releaseOne(major);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
	
}
