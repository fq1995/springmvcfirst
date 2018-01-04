package com.fu.ssm.service;

import java.util.List;

import com.fu.ssm.po.ItemsCustom;
import com.fu.ssm.po.ItemsQueryVO;

public interface ItemsService {

	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVO itemsQueryVO) throws Exception;

}
