package com.fu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fu.ssm.mapper.ItemsMapperCustom;
import com.fu.ssm.po.ItemsCustom;
import com.fu.ssm.po.ItemsQueryVO;
import com.fu.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom ItemsMapperCustom;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVO itemsQueryVO) throws Exception {
		return ItemsMapperCustom.findItemsList(itemsQueryVO);
	}

}
