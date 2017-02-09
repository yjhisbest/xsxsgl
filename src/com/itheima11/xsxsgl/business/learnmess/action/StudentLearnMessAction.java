package com.itheima11.xsxsgl.business.learnmess.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.baseData.service.StudentService;
import com.itheima11.xsxsgl.business.learnmess.service.LearnMessageService;
import com.itheima11.xsxsgl.domain.basedata.LearnMessage;
import com.itheima11.xsxsgl.domain.basedata.Student;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.LearnMessageQuery;
import com.itheima11.xsxsgl.query.basedata.StudentQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("studentLearnMessAction")
@Scope("prototype")
public class StudentLearnMessAction {
	private StudentQuery query_zhu = new StudentQuery();
	private LearnMessageQuery query_zhi = new LearnMessageQuery();
	private String xuehao;
	public StudentQuery getQuery_zhu() {
		return query_zhu;
	}
	public void setQuery_zhu(StudentQuery query_zhu) {
		this.query_zhu = query_zhu;
	}
	public LearnMessageQuery getQuery_zhi() {
		return query_zhi;
	}
	public void setQuery_zhi(LearnMessageQuery query_zhi) {
		this.query_zhi = query_zhi;
	}
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	@Resource(name="studentService")
	private StudentService studentService;
	@Resource(name="learnMessageService")
	private LearnMessageService learnMessageService;
	
	public String showStuentLearnMess(){
		PageResult<Student> pageResult_zhub = this.studentService.getPageResult(query_zhu);
		if(this.query_zhi.getXuehao()!=null && !this.query_zhi.getXuehao().equals("")){
			PageResult<LearnMessage> pageResult_zhib = this.learnMessageService.getPageResult(query_zhi);
			ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		}
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		return "listAction";
	}
	
	public String getLearnMessData(){
		String str = this.learnMessageService.getStudentCJDATA(query_zhi.getXuehao());
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
}
