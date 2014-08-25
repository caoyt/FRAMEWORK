package com.caoyt.framework.utils;

import java.util.Date;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * 日期转换器
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-7-26
 */
@SuppressWarnings("unchecked")
public class DateConverter extends DefaultTypeConverter{

	
	@Override
	public Object convertValue(Object value, Class toType) {
		
		System.out.println("value-->"+value);
		System.out.println("toType---->"+toType);
		
		return new Date();
	}

	
	
}
