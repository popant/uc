package com.channelsoft.usercenter.common.po;

import java.io.Serializable;

/**
 * json 接口成功返回对象
  *<dl>
  *<dt>类名：AjaxResultPo</dt>
  *<dd>描述: </dd>
  *<dd>公司: 青牛（北京）技术有限公司</dd>
  *<dd>创建时间：2010-7-23  下午01:48:13</dd>
  *<dd>创建人： 韦水生 </dd>
  *</dl>
 */
public class AjaxResultPo implements Serializable {
	/**
	 * 消息串的最大长度
	 */
	public static Integer maxMassgeLength = 30;
	
	public AjaxResultPo() {
		super();
	}
	/**
	 * 返回一个成功的消息对象
	 * @param message
	 * @param data
	 * @return
	 * @CreateDate: 2013年11月7日 下午5:20:31
	 * @author 魏铭
	 */
	public static AjaxResultPo success(String message, long total, Object rows){
		return new AjaxResultPo(true, message, total, rows);
	}
	/**
	 * 缺省的成功消息对象
	 * @param data
	 * @return
	 * @CreateDate: 2013年11月7日 下午5:20:20
	 * @author 魏铭
	 */
	public static AjaxResultPo successDefault (){
		return new AjaxResultPo(true, "操作成功", 0, null);
	}
	private static final long serialVersionUID = -4148768233386711389L;
	private boolean success;
	private String msg;
	private long total = -1;
	private Object rows;
	private int count = 0;

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}

	public AjaxResultPo(boolean b){
		setSuccess(b);
		setMsg("");
	}
	
	
	public AjaxResultPo(boolean success, Object rows) {
		super();
		this.success = success;
		this.rows = rows;
	}
	public AjaxResultPo(boolean b, String msg, long total, Object rows){
		setSuccess(b);
		setMsg(msg);
		setTotal(total);
		setRows(rows);
	}
	
	public AjaxResultPo(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
//		msg = StringUtils.substring(msg, 0, maxMassgeLength);
		this.msg = msg;
	}
}
