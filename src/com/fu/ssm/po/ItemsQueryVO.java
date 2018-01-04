/**
 * @author fu
 * @data   2018-1-4
 * @version 1.0
 * @Description: 商品包装对象
 */
package com.fu.ssm.po;

public class ItemsQueryVO {

	//商品信息
	private Items items;
	
	//为了系统扩展性，对原始po进行扩展
	private ItemsCustom itemsCustom;

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
