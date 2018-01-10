package com.fu.ssm.service;

import java.util.List;

import com.fu.ssm.po.ItemsCustom;
import com.fu.ssm.po.ItemsQueryVO;

public interface ItemsService {

	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVO itemsQueryVO) throws Exception;

	//根据ID查询商品信息
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品信息
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
	
	//删除商品
	public int deleteItems(Integer[] ids) throws Exception;
}
