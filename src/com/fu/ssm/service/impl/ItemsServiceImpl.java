package com.fu.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fu.ssm.mapper.ItemsMapper;
import com.fu.ssm.mapper.ItemsMapperCustom;
import com.fu.ssm.mapper.OrderDetailMapper;
import com.fu.ssm.po.Items;
import com.fu.ssm.po.ItemsCustom;
import com.fu.ssm.po.ItemsQueryVO;
import com.fu.ssm.po.OrderDetailExample;
import com.fu.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom ItemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVO itemsQueryVO) throws Exception {
		return ItemsMapperCustom.findItemsList(itemsQueryVO);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//校验ID是否为空
		
		itemsCustom.setId(id);
		//可以更新所以字段，包括大文本类型
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		
	}

	@Override
	public int deleteItems(Integer[] ids) throws Exception {
		//级联删除.....
		
		return ItemsMapperCustom.deleteByPrimaryKeys(ids);
	}

}
