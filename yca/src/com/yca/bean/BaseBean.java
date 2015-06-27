package com.yca.bean;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;


/**
 * @author 吕天成 E-mail:star2208@126.com
 * @version 创建时间：2015-6-25 下午8:30:38
 */
public class BaseBean<T> extends HibernateBaseDao<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	public NetWorkInfo NetWok;

	/**
	 * 获取实体对象列表
	 * 
	 * @return 实体对象列表
	 */
	@SuppressWarnings("unchecked")
	public List<T> GetListBean() {
		List<T> list = null;
		list = (List<T>) JSON.parseArray(NetWok.data, get().getClass());
		return list;
	}

	/**
	 * 获取实体对象
	 * 
	 * @return 实体对象
	 */
	@SuppressWarnings("unchecked")
	public T GetBean() {
		T t = null;
		t = (T) JSON.parseObject(NetWok.data, get().getClass());
		return t;
	}

	/**
	 * 是否获取到数据
	 * 
	 * @return
	 */
	public int Error() {

		try {
			return Integer.parseInt(NetWok.error);
		} catch (Exception e) {

		}
		return 1;
	}

	/**
	 * 获取到信息
	 * 
	 * @return
	 */
	public String Msg() {
		try {
			return NetWok.msg;
		} catch (Exception e) {
			return "网络数据异常";
		}

	}

}