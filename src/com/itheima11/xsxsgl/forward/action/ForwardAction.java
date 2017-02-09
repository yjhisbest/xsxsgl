package com.itheima11.xsxsgl.forward.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("forwardAction")
@Scope("prototype")
public class ForwardAction {
	private String method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String forward(){
		return this.method;
	}
}
