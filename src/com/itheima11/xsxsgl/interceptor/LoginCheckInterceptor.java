package com.itheima11.xsxsgl.interceptor;

import org.apache.struts2.ServletActionContext;

import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginCheckInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Teacher teacher = (Teacher) ServletActionContext.getRequest().getSession().getAttribute("teacher");
		 if(teacher == null){
	            return "logon";
	      }
	     return invocation.invoke();
	}

}
