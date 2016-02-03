package com.channelsoft.usercenter.consumable.po;

/***
 * 用于消费数据的表单提交
 * @author Administrator
 *
 */
public class ConsumableFormPo {
	private String productId;
	private String consumableId;
	private String consumableName;
	private String consumableNumber;
	private String consumablePrice;
	private String consumableResource;
	private int entId;
	
	public int getEntId() {
		return entId;
	}
	public void setEntId(int entId) {
		this.entId = entId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getConsumableId() {
		return consumableId;
	}
	public void setConsumableId(String consumableId) {
		this.consumableId = consumableId;
	}
	public String getConsumableName() {
		return consumableName;
	}
	public void setConsumableName(String consumableName) {
		this.consumableName = consumableName;
	}
	public String getConsumableNumber() {
		return consumableNumber;
	}
	public void setConsumableNumber(String consumableNumber) {
		this.consumableNumber = consumableNumber;
	}
	public String getConsumablePrice() {
		return consumablePrice;
	}
	public void setConsumablePrice(String consumablePrice) {
		this.consumablePrice = consumablePrice;
	}
	public String getConsumableResource() {
		return consumableResource;
	}
	public void setConsumableResource(String consumableResource) {
		this.consumableResource = consumableResource;
	}
	
	
}
