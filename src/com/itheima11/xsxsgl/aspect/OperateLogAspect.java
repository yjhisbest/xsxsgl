package com.itheima11.xsxsgl.aspect;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OperateLogAspect {
	
	@After("execution(* com.itheima11.xsxsgl.baseData.action.*.add(..))")
	public void doAfteraddSuccess(JoinPoint joinPoint) throws Exception {
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		System.out.println(parameterMap.get("xuehao")[0]);
	}
}
