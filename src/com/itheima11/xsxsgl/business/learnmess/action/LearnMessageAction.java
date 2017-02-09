package com.itheima11.xsxsgl.business.learnmess.action;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.baseData.service.CourseService;
import com.itheima11.xsxsgl.baseData.service.StudentService;
import com.itheima11.xsxsgl.baseData.service.TeacherService;
import com.itheima11.xsxsgl.business.learnmess.service.LearnMessageService;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.LearnMessage;
import com.itheima11.xsxsgl.domain.basedata.Student;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.LearnMessageQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("learnMessageAction")
@Scope("prototype")
public class LearnMessageAction extends BaseAction<LearnMessage>{
	@Resource(name="learnMessageService")
	private LearnMessageService learnMessageService;
	@Resource(name="studentService")
	private StudentService studentService;
	@Resource(name="courseService")
	private CourseService courseService;
	
	private String dealXH;//处理的学号
	private String dealKCBH;//处理的课程编号
	public String getDealXH() {
		return dealXH;
	}
	public void setDealXH(String dealXH) {
		this.dealXH = dealXH;
	}
	public String getDealKCBH() {
		return dealKCBH;
	}
	public void setDealKCBH(String dealKCBH) {
		this.dealKCBH = dealKCBH;
	}


	private LearnMessageQuery baseQuery = new LearnMessageQuery();
	
	public LearnMessageQuery getBaseQuery() {
		return baseQuery;
	}
	public void setBaseQuery(LearnMessageQuery baseQuery) {
		this.baseQuery = baseQuery;
	}
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		//checkLearnMess,该学习信息是否存在，为空，不存在，可以添加新的学习信息
		LearnMessage checkLearnMess = this.learnMessageService.seekLearnMessByXueHaoKcbh(this.getModel().getXuehao(), this.getModel().getKcbh());
		if(checkLearnMess==null){
			Student student = this.studentService.getEntryById(this.getModel().getXuehao());
			if(student!=null){
				LearnMessage learnMessage = new LearnMessage();
				BeanUtils.copyProperties(this.getModel(), learnMessage);
				Course course = this.courseService.getEntryById(learnMessage.getKcbh());
				Teacher teacher = this.learnMessageService.getTeacher(course.getKcbh(),course.getJsmc());
				if(teacher!=null){
					learnMessage.setJsmc(teacher.getJsmc());
					learnMessage.setJsbh(teacher.getJsbh());
					this.learnMessageService.saveEntry(learnMessage);
					if(learnMessage.getCj()>=60){//及格，增加学分
						student.setYxxf(student.getYxxf()+course.getCredit());//把学生的之前的学分加上这门课程的学分
						this.studentService.updateEntry(student);
					}
					return action2action;
				}else{
					this.addActionError("请先把"+course.getJsmc()+"和一个教师绑定关系");
					return "error";
				}
				
			}else{
				ActionContext.getContext().getValueStack().push("该学生不存在！！");//做拦截器的时在弄
				return "error";
			}
		}else{
			ActionContext.getContext().getValueStack().push("该学习信息已经存在！！");//做拦截器的时在弄
			return "error";
		}
		
		
	}
	
	public String showPageResult(){
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<LearnMessage> learnMessages = this.learnMessageService.getPageResult(baseQuery);
		ActionContext.getContext().put("learnMessages", learnMessages);
		return listAction;
	}
	
	public String updateUI(){
		LearnMessage learnMessage = this.learnMessageService.getEntryById(this.getModel().getLid());
		ActionContext.getContext().getValueStack().push(learnMessage);
		return updateUI;
	}
	
	public String update(){
			Teacher teacher = (Teacher) this.getSession().getAttribute("teacher");
			LearnMessage learnMessage = this.learnMessageService.getEntryById(this.getModel().getLid());
			learnMessage.setJsmc(teacher.getJsmc());
			learnMessage.setJsbh(teacher.getJsbh());
			learnMessage.setPscj(this.getModel().getPscj());
			learnMessage.setKscj(this.getModel().getKscj());
			learnMessage.setCj(this.getModel().getCj());
			Student student = this.studentService.getEntryById(learnMessage.getXuehao());
			if(learnMessage.getCj()<60){//及格，增加学分
				Course course = this.courseService.getEntryById(learnMessage.getKcbh());
				student.setYxxf(student.getYxxf()-course.getCredit());//把学生的之前的学分加上这门课程的学分
				this.studentService.updateEntry(student);
			}
			this.learnMessageService.updateEntry(learnMessage);
			return action2action;
	}
	
	public String deleteLearnMessages(){
		Set<LearnMessage> learnMessages = this.learnMessageService.getEntriesByIds(this.getCheckedStr().split(","));
		for(LearnMessage learnMessage : learnMessages){
			Student student = this.studentService.getEntryById(learnMessage.getXuehao());
			Course course = this.courseService.getEntryById(learnMessage.getKcbh());
			student.setYxxf(student.getYxxf()-course.getCredit());//把学生的之前的学分加上这门课程的学分
			this.studentService.updateEntry(student);
		}
		this.learnMessageService.deleteEntriesByIds(this.getCheckedStr().split(","));
		ActionContext.getContext().getValueStack().push("deleteOK");
		return "delJson";
	}
	
	public String deleteOne(){
		LearnMessage learnMessage = this.learnMessageService.getEntryById(this.getModel().getLid());
		Student student = this.studentService.getEntryById(learnMessage.getXuehao());
		Course course = this.courseService.getEntryById(learnMessage.getKcbh());
		student.setYxxf(student.getYxxf()-course.getCredit());//把学生的之前的学分加上这门课程的学分
		this.studentService.updateEntry(student);
		this.learnMessageService.deleteEntyById(learnMessage.getLid());
		ActionContext.getContext().getValueStack().push("deleteOK");
		return "delJson";
	}
	
	//获取学生的名字
	public String getXSMZ(){
		Student student = this.studentService.getEntryById(this.dealXH);
		if(student!=null){
			ActionContext.getContext().getValueStack().push(student.getName());
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return SUCCESS;
	}
	//获取课程的名字
		public String getKCMC(){
			Course course = this.courseService.getEntryById(this.dealKCBH);
			if(course!=null){
				ActionContext.getContext().getValueStack().push(course.getKcmc());
			}else{
				ActionContext.getContext().getValueStack().push("*bcz*");
			}
			return SUCCESS;
		}
}
