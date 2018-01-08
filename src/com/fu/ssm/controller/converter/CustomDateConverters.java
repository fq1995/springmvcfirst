package com.fu.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换器
 * @author fu
 *
 */
public class CustomDateConverters implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		
		//日期字符串转成日期类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//如果参数绑定失败，返回null
		return null;
	}

}
