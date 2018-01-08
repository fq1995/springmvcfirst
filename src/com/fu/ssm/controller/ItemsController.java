package com.fu.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fu.ssm.po.ItemsCustom;
import com.fu.ssm.service.ItemsService;

/**
 * 实现Controller接口
 * 
 * @author fu
 *
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	// 商品查询列表
	// RequestMapping实现对queryItems方法和url进行映射，一个方法对应一个url
	// 一般url和方法名一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception {
		
		//测试forward请求转发request共享
		System.out.println(request.getParameter("id"));
		
		// 调用service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定试图
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

	/*
	 * // 根据ID查询商品信息
	 * 
	 * @RequestMapping(value="/editItems",
	 * method={RequestMethod.POST,RequestMethod.GET}) public ModelAndView
	 * editItems() throws Exception { //调用service根据id查询商品信息 ItemsCustom
	 * itemsCustom = itemsService.findItemsById(1);
	 * 
	 * // 返回ModelAndView ModelAndView modelAndView = new ModelAndView();
	 * 
	 * //将商品信息放入model modelAndView.addObject("itemsCustom", itemsCustom);
	 * 
	 * // 指定试图 modelAndView.setViewName("items/editItems");
	 * 
	 * return modelAndView; }
	 */

	// 根据ID查询商品信息，返回视图名
	@RequestMapping(value = "/editItems", method = { RequestMethod.POST, RequestMethod.GET })
	public String editItems(Model model, @RequestParam(value="id",required=true,defaultValue="1") Integer id) throws Exception {
		// 调用service根据id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);

		// 将商品信息放入model
		model.addAttribute("itemsCustom", itemsCustom);

		return "items/editItems";
	}

	/*
	 * // 修改商品信息
	 * 
	 * @RequestMapping("/editItemsSubmit") public ModelAndView editItemsSubmit()
	 * throws Exception { 
	 * // 调用service根据id更新商品信息 
	 * ItemsCustom itemsCustom =
	 * itemsService.findItemsById(1);
	 * 
	 * // 返回ModelAndView ModelAndView modelAndView = new ModelAndView();
	 * 
	 * // 将商品信息放入model modelAndView.addObject("itemsCustom", itemsCustom);
	 * 
	 * // 指定试图 modelAndView.setViewName("success");
	 * 
	 * return modelAndView; }
	 */

	// 修改商品信息
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request, Integer id, ItemsCustom itemsCustom) throws Exception {
		itemsService.updateItems(id, itemsCustom);
		
		//重定向 ：浏览器地址栏中的url会变化。修改提交的request数据无法传到重定向的地址
//		return "redirect:queryItems.action";
		//页面转发: 浏览器地址栏url不变，request可以共享。
		return "forward:queryItems.action";
	}
}
