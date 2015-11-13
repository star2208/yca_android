package com.yca.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.umeng.analytics.MobclickAgent;
import com.yca.util.SystemBarTintUtil;


/**
 * @author 吕天成
 * @time 2014.12.15
 * @描述 基类
 * @遗留BUG
 */
public abstract class BaseActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	@SuppressWarnings("unused")
	private Bundle savedInstanceState;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SystemBarTintUtil.setSystemBarTintColor(this);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		this.savedInstanceState = savedInstanceState;
		setLayout();
		FindID();
		Listener();
		InitIntent();
		InData();
	}
	
	protected abstract void setLayout();

	/**
	 * 获取资源文件
	 */
	protected abstract void FindID();

	/**
	 * 添加监听事件
	 */
	protected abstract void Listener();

	/**
	 * 获取前一个界面的数据
	 */
	protected abstract void InitIntent();

	/**
	 * 初始化界面
	 */
	protected abstract void InData();

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

	}

	@Override
	public void onClick(View arg0) {

	}

	public void setActionbarTitile(String title, int position) {
		// TODO Auto-generated method stub

	}

	public void setActionbarHomeButtonNumber(int number) {
		// TODO Auto-generated method stub

	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		MobclickAgent.onResume(this); //统计页面
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MobclickAgent.onPause(this);
	}
	
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
}
