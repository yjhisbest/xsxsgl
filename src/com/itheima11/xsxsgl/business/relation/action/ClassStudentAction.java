package com.itheima11.xsxsgl.business.relation.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.baseData.service.ClassService;
import com.itheima11.xsxsgl.baseData.service.StudentService;
import com.itheima11.xsxsgl.business.relation.service.ClassStudentService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.College;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Major;
import com.itheima11.xsxsgl.domain.basedata.Student;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.ClassQuery;
import com.itheima11.xsxsgl.query.basedata.StudentQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("classStudentAction")
@Scope("prototype")
public class ClassStudentAction {
	private ClassQuery query_zhu = new ClassQuery();
	private StudentQuery query_zhi = new StudentQuery();
	private String bjbh;
	private List<Student> students;
	public ClassQuery getQuery_zhu() {
		return query_zhu;
	}
	public void setQuery_zhu(ClassQuery query_zhu) {
		this.query_zhu = query_zhu;
	}
	public StudentQuery getQuery_zhi() {
		return query_zhi;
	}
	public void setQuery_zhi(StudentQuery query_zhi) {
		this.query_zhi = query_zhi;
	}
	public String getBjbh() {
		return bjbh;
	}
	public void setBjbh(String bjbh) {
		this.bjbh = bjbh;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Resource(name="classStudentService")
	private ClassStudentService classStudentService;
	@Resource(name="classService")
	private ClassService classService;
	@Resource(name="studentService")
	private StudentService studentService;
	
	public String addUI(){
		return "addUI";
	}
	public String getStudent(){
		Student student = this.studentService.getEntryById(this.query_zhi.getXuehao());
		if(student!=null){
			ActionContext.getContext().getValueStack().push(student);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	public String getClazz(){
		Class clazz = this.classService.getEntryById(this.bjbh);
		if(clazz!=null){
			ActionContext.getContext().getValueStack().push(clazz);
		}else{
			ActionContext.getContext().getValueStack().push("*bcz*");
		}
		return "success";
	}
	public String saveRelation(){
		this.classStudentService.saveRelation(bjbh,students);
		return "action2action";
	}
	public String showCSGX(){
		PageResult<Class> pageResult_zhub = this.classService.getPageResult(query_zhu);
		if(query_zhi.getBjbh()!=null){//子表的query_zhi.id的值不为空，这个if和上面的if只会执行一个
			PageResult<Student> pageResult_zhib = this.studentService.getPageResult(query_zhi);
			ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		}
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		return "listAction";
	}
	public String releaseAllStudent(){
		String str = this.classStudentService.releaseAllStudent(this.bjbh);
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
	public String releaseOneStudent(){
		Student student = this.studentService.getEntryById(this.query_zhi.getXuehao());
		String str = this.classStudentService.releaseOne(student,this.query_zhi.getBjbh());
		ActionContext.getContext().getValueStack().push(str);
		return "success";
	}
}
