/**
 * @author fu
 * @data   2018-1-4
 * @version 1.0
 * @Description: 商品包装对象
 */
package com.fu.ssm.po;

import java.util.List;

public class ItemsQueryVO {

	// 商品信息
	private Items items;

	// 为了系统扩展性，对原始po进行扩展
	private ItemsCustom itemsCustom;

	// 批量商品信息
	private List<ItemsCustom> itemsList;

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

}
