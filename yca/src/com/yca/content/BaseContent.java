package com.yca.content;

import com.yca.activity.BaseActivity;
import com.yca.tool.Tool;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author 吕天成 E-mail:star2208@126.com
 * @version 创建时间：2015-6-26 上午11:58:49
 */
public abstract class BaseContent  implements OnClickListener,OnItemClickListener {
	protected View view;
	protected Tool tool;
	protected BaseActivity activity;
	protected View loadingview;

	public BaseContent(BaseActivity activity, int resourceID) {
		this.activity = activity;
		view = View.inflate(activity, resourceID, null);
		tool = activity.tool;
		findID();
		Listener();
		InData();
	}

	protected View findViewById(int id) {
		return view.findViewById(id);
	}

	public View getView() {
		return view;
	}

	/**
	* 获取资源
	*/
	public abstract void findID();

	/**
	* 添加监听
	*/
	public abstract void Listener();

	/**
	* 初始化
	*/
	public abstract void InData();

	/**
	* 单击事件
	*/
	@Override
	public void onClick(View v) {

	}

	/**
	* list 点击事件
	*/
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
		long id) {
	}

	public void startActivity(Intent intent) {
		activity.startActivity(intent);
	}

	public void startActivityForResult(Intent intent, int requestCode) {
		activity.startActivityForResult(intent, requestCode);
	}
}