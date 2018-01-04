package com.fu.ssm.mapper;

import java.util.List;

import com.fu.ssm.po.ItemsCustom;
import com.fu.ssm.po.ItemsQueryVO;

public interface ItemsMapperCustom {

	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVO itemsQueryVO) throws Exception;
}
