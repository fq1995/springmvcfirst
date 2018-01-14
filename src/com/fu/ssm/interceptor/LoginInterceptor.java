package com.fu.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

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
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否是公开地址，（实际使用中将公开地址配置在配置文件）
		if(url.indexOf("login.action")!=-1){
			return true;
		}
		//判断session、
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username != null){
			return true;
		}
		
		//跳转登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		return false;
	}

}
