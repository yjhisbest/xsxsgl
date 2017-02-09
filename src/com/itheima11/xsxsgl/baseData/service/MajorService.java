package com.itheima11.xsxsgl.baseData.service;

import com.itheima11.xsxsgl.base.service.BaseSerivce;
import com.itheima11.xsxsgl.domain.basedata.Major;

public interface MajorService extends BaseSerivce<Major>{

	Major getMajorByZymc(String zymc);

}
