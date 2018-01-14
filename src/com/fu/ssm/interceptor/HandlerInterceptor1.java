package com.fu.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1 implements HandlerInterceptor {

	// 执行Handler方法完成之后执行
	// 比如统一异常处理、统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("1......afterCompletion");
	}

	// 进入Handler方法之后执行
	// 比如将公共的模型数据传到视图
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("1........postHandle");

	}

	// 进入Handler方法之前执行
	// 比如用于身份认证、身份授权
	// return false 表示拦截，不再执行
	// return true 表示放行
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("1.........preHandle");
		return true;
	}

}
