package com.fu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fu.ssm.po.ItemsCustom;

@Controller
public class JsonTest {
	
	//请求json,返回json
//	@RequestBody将请求的商品信息的json串转成对象
//	@ResponseBody将对象转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		
		return itemsCustom;
	}
	
	//请求key/value,返回json
//	@ResponseBody将对象转成json输出
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
		
		return itemsCustom;
	}
 }
