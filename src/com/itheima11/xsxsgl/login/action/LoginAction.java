package com.itheima11.xsxsgl.login.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.login.service.LoginService;
import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.domain.basedata.Teacher;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<Teacher>{
	@Resource(name="loginService")
	private LoginService loginService;
	public String authentication(){
		Teacher teacher = this.loginService.authentication(this.getModel().getJsmc(), this.getModel().getPassword());
		if(teacher==null){
			this.addActionError("用户名或者密码错误");
			return "login";
		}else{
			this.getSession().setAttribute("teacher", teacher);
			return "index";
		}
	}
	
	public String logout(){
		HttpSession session = this.getSession();
		if(session != null || session.getAttribute("teacher") != null){
			session.invalidate();
		}
		return "logout";
	}
}
