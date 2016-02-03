/**
 * 
 */
package com.channelsoft.usercenter.common.status;


public class IntegerBeanLabelItem extends IntegerBeanLabel {
	
	private static final long serialVersionUID = -769945821003341103L;


	protected IntegerBeanLabelItem(String className, String name, int value) {
		super(className, name, value);
	}

	public static IntegerBeanLabelItem getResult(String className, int value) {
		IntegerBeanLabelItem result = (IntegerBeanLabelItem)get(className, value);
		if (result == null) {
			throw new RuntimeException("Result for Value = " + value + " not defind");
		}
		return result;
	}
	public static IntegerBeanLabelItem getResult(String className, String name) {
		IntegerBeanLabelItem result = (IntegerBeanLabelItem)get(className, name);
		if (result == null) {
			throw new RuntimeException("Result for name = " + name + " not defind");
		}
		return result;
	}
}
