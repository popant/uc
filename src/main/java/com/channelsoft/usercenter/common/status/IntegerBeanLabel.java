package com.channelsoft.usercenter.common.status;

//import org.hibernate.HibernateException;
//import org.hibernate.usertype.ParameterizedType;
//import org.hibernate.usertype.UserType;

import java.io.ObjectStreamException;
//import java.io.Serializable;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
//import java.util.Properties;

public class IntegerBeanLabel  {

	/**
	 * 根据名称的map
	 */
	protected static Map<String, Map<String, IntegerBeanLabel>> nameMap = new HashMap<String, Map<String, IntegerBeanLabel>>(16);
	protected static Map<String, Map<Integer, IntegerBeanLabel>> valueMap = new HashMap<String, Map<Integer, IntegerBeanLabel>>(16);
    protected int value;
    protected transient String name;
    protected String className;

	public IntegerBeanLabel() {
	}

	protected IntegerBeanLabel(String className,String name, int value) {
    	this.className = className;
        this.value = value;
        this.name = name;
        add();
    }

    protected void add() {
		if (nameMap.containsKey(this.className)) {
			nameMap.get(this.className).put(this.name, this);
			valueMap.get(this.className).put(new Integer(this.value), this);
		} else {
			Map<String, IntegerBeanLabel> nameMaps = new HashMap<String, IntegerBeanLabel>();
			Map<Integer, IntegerBeanLabel> valueMaps = new HashMap<Integer, IntegerBeanLabel>();
			nameMaps.put(this.name, this);
			valueMaps.put(new Integer(this.value), this);
			nameMap.put(this.className, nameMaps);
			valueMap.put(this.className, valueMaps);
		}
    }

	public static IntegerBeanLabel get(String className, String name) {
		return nameMap.get(className).get(name);
	}

	public static IntegerBeanLabel get(String className, int value) {
		return valueMap.get(className).get(new Integer(value));
	}
	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	protected Object readResolve() throws ObjectStreamException {
		return get(this.className, this.value);
	}

	private static final int[] SQL_TYPES = new int[]{Types.INTEGER};
	private Class targetClass;
//	@Override
//	public void setParameterValues(Properties properties) {
//		String targetClassName = properties.getProperty("targetClass");
//		try {
//			targetClass = Class.forName(targetClassName);
//		} catch (ClassNotFoundException e) {
//			throw new HibernateException("Class " + targetClassName + " not found ", e);
//		}
//	}
//
//	@Override
//	public int[] sqlTypes() {
//		return SQL_TYPES;
//	}
//
//	@Override
//	public Class returnedClass() {
//		return targetClass;
//	}
//
//	@Override
//	public boolean equals(Object o, Object o1) throws HibernateException {
//		return (o == o1);
//	}
//
//	@Override
//	public int hashCode(Object o) throws HibernateException {
//		return o.hashCode();
//	}
//
//	@Override
//	public Object nullSafeGet(ResultSet rs, String[] names, Object o) throws HibernateException, SQLException {
//		int value = rs.getInt(names[0]);
//		return rs.wasNull() ? null : IntegerBeanLabel.get(targetClass.getName(),value);
//	}
//
//	@Override
//	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
//		if (value == null) {
//			st.setNull(index, Types.INTEGER);
//		} else {
//			st.setInt(index, ((IntegerBeanLabel)value).getValue());
//		}
//	}
//
//	@Override
//	public Object deepCopy(Object o) throws HibernateException {
//		return o;
//	}
//
//	@Override
//	public boolean isMutable() {
//		return false;
//	}
//
//	@Override
//	public Serializable disassemble(Object o) throws HibernateException {
//		return (Serializable) value;
//	}
//
//	@Override
//	public Object assemble(Serializable serializable, Object o) throws HibernateException {
//		return serializable;
//	}
//
//	@Override
//	public Object replace(Object o, Object o1, Object o2) throws HibernateException {
//		return o;
//	}
}
