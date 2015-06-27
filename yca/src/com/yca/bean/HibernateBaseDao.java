package com.yca.bean;
import java.lang.reflect.ParameterizedType;

/**
 * @author 吕天成 E-mail:star2208@126.com
 * @version 创建时间：2015-6-25 下午8:32:02
 */
public class HibernateBaseDao<T> implements BaseInterface<T> {
	private Class<T> entityClass;

	@Override
	public T get() {
		try {
			return entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public HibernateBaseDao() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
