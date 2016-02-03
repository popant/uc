package com.channelsoft.usercenter.pay.po;
import java.sql.Timestamp;

public class Order {

	private Integer order_id;
	private Integer product_id;
	private Double totle_price;
	private Short order_status;
	private Timestamp pay_time;
	private Timestamp create_time;
	private Integer enterprise_id;
	private Long total_resource;
	
	
	public Long getTotal_resource() {
		return total_resource;
	}
	public void setTotal_resource(Long total_resource) {
		this.total_resource = total_resource;
	}
	public void setEnterprise_id(Integer enterprise_id) {
		this.enterprise_id = enterprise_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Double getTotle_price() {
		return totle_price;
	}
	public void setTotle_price(Double totle_price) {
		this.totle_price = totle_price;
	}
	public Short getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Short order_status) {
		this.order_status = order_status;
	}
	public Timestamp getPay_time() {
		return pay_time;
	}
	public void setPay_time(Timestamp pay_time) {
		this.pay_time = pay_time;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public Integer getEnterprise_id() {
		return enterprise_id;
	}
	public void setEnterprise_id(int enterprise_id) {
		this.enterprise_id = enterprise_id;
	}
	@Override
	public String toString() {
		return "[order_id=" + order_id + ", product_id=" + product_id
				+ ", totle_price=" + totle_price + ", order_status="
				+ order_status + ", pay_time=" + pay_time+ ", create_time="
				+ create_time + ", enterprise_id=" + enterprise_id + "]";
	}
	
	
	
	
}
