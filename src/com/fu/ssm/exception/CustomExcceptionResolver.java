package com.fu.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @author fu
 *
 */
public class CustomExcceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		CustomException customException = null;
		//解析异常类型
		//如果是自定义异常
		if(ex instanceof CustomException){
			customException = (CustomException) ex;
		}else{
			customException = new CustomException("未知错误");
		}
		ModelAndView model = new ModelAndView();
		model.addObject("message", customException.getMessage());
		model.setViewName("error");
		return model;
	}

}
