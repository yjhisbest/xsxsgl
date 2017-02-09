package com.itheima11.xsxsgl.convertor;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
//自定义日期类型转化器
//String ---> java.util.Date   MM/dd/yyyy
//java.util.Date ---> String   MM/dd/yyyy
public class MyDateConvertor extends StrutsTypeConverter {
	
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	//String ---> java.util.Date   MM/dd/yyyy
	//context:类型转换的上下文 
	//values:用户输入的值
	//toClass:目标类型
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(toClass==Date.class){
			if(values!=null && values.length>0){
				String sdate = values[0];
				try {
					return df.parse(sdate);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Date){
			Date d = (Date) o;
			return df.format(d);
		}
		return null;
	}


}
