package com.fu.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.fu.ssm.po.Items;

/**
 * 实现HttpRequestHandler接口
 * @author fu
 *
 */
public class ItemsController2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) {

		//调用service查找数据库，查询商品列表
		List<Items> itemsList = new ArrayList<Items>();
		//向list中填充静态数据
		
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
		
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		
		itemsList.add(items_1);
		itemsList.add(items_2);

		request.setAttribute("itemsList", itemsList);

		try {
			request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
			//使用此方法可以通过修改response,设置相应的数据格式，比如响应json数据
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("application/json;charset=utf-8");
//			response.getWriter().write("json串");
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
