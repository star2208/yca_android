package com.yca.activity;

import java.util.Stack;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.umeng.analytics.MobclickAgent;
import com.yca.R;
import com.yca.content.BaseContent;
import com.yca.fragment.BaseFragment;
import com.yca.tool.Tool;
import com.yca.util.SystemBarTintManager;
import com.yca.util.SystemBarTintUtil;

import de.greenrobot.event.EventBus;

/**
 * @author 吕天成
 * @time 2014.12.15
 * @描述 基类
 * @遗留BUG
 */
public abstract class BaseActivity extends Activity implements OnClickListener,
		OnItemClickListener {
	public Tool tool = null;

	private Bundle savedInstanceState;
	
	private Stack<BaseContent> EventViews = null;
	private Stack<BaseFragment> EventFragments = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.savedInstanceState = savedInstanceState;
		SystemBarTintUtil.setSystemBarTintColor(this);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		tool = Tool.getInstance();
		tool.init(this);
		FindID();
		Listener();
		InitIntent();
		InData();
	}

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

	/**
	 * 添加第一个fragment
	 * 
	 * @param fragment
	 *            需要显示的fragment
	 * @param name
	 *            fragment的名字
	 * @param res
	 *            显示面板
	 */
	public void AddFragment(Fragment fragment, String name, int res) {
		if (savedInstanceState == null) {
			if(!fragment.isAdded()){
				FragmentManager fm = getFragmentManager();
				FragmentTransaction tx = fm.beginTransaction();
				tx.add(res, fragment, name);
				tx.commit();
			}
		}
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
	
	
	public void registerEventBugs(BaseContent baseContent)
	{
		if (EventViews == null) {
			EventViews = new Stack<BaseContent>();
		}
		EventBus.getDefault().register(baseContent);
		EventViews.push(baseContent);
		//Log.i("registerEventBugs", baseContent.toString());
	}
	
	public void registerEventBugs(BaseFragment baseFragment)
	{
		if (EventFragments == null) {
			EventFragments = new Stack<BaseFragment>();
		}
		EventBus.getDefault().register(baseFragment);
		EventFragments.push(baseFragment);
		//Log.i("registerEventBugs", baseContent.toString());
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if (EventViews != null) {
			while (!EventViews.empty()) {
				BaseContent baseContent = EventViews.pop();
				EventBus.getDefault().unregister(baseContent);
				//Log.i("unregisterEventBugs", baseContent.toString());
			}
		}
		if (EventFragments != null) {
			while (!EventFragments.empty()) {
				BaseFragment baseFragment = EventFragments.pop();
				EventBus.getDefault().unregister(baseFragment);
				//Log.i("unregisterEventBugs", baseContent.toString());
			}
		}
		super.onDestroy();
	}
	
}
