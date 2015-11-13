package com.yca.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;


import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.review.youngchina.R;
import com.yca.adapter.MainViewPagerAdapter;
import com.yca.bean.BeanTopic;
import com.yca.httpapi.RESTClient;
import com.yca.info.TabInfo;
import com.yca.info.TabList;
import com.yca.util.LogUtil;
import com.yca.widget.CirclePageIndicator;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends BaseActivity implements OnPageChangeListener{
	private ViewPager viewPager;
	private MainViewPagerAdapter adapter;
	private TextView tv_actiongbar;

	@Override
	protected void setLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void FindID() {
		// TODO Auto-generated method stub
		viewPager = (ViewPager) findViewById(R.id.main_viewpager);
	}


	@Override
	protected void Listener() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void InitIntent() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void InData() {
		// TODO Auto-generated method stub
		if (TabList.getInstance().isLoaded()) {
			InitTabView();
		}
		else {
			requestTabInfo();
		}
	}

	private void requestTabInfo() {
		// TODO Auto-generated method stub
		RESTClient.Topics(new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				List<BeanTopic> topiclist = JSON.parseArray(new String(arg2), BeanTopic.class);
				TabList.getInstance().addBeanTopicList(topiclist);
				InitTabView();
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				//占坑
				LogUtil.i("onFailure", "onFailure");
			}
		});
	}

	private void InitTabView() {
		adapter = new MainViewPagerAdapter(this, TabList.getInstance());
		viewPager.setAdapter(adapter);
		setActionbar();
	}

	private void setActionbar() {
		// TODO Auto-generated method stub
		ActionBar.LayoutParams params = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				Gravity.CENTER);
		View view = LayoutInflater.from(this).inflate(R.layout.view_main_action, null);
		tv_actiongbar = (TextView) view.findViewById(R.id.tv_actionbar_content);
		tv_actiongbar.setText(TabList.getInstance().get(0).getTitle());
		CirclePageIndicator mIndicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
		mIndicator.setViewPager(viewPager);
		mIndicator.setOnPageChangeListener(this);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(view, params);
	}

	@Override
	public void onPageScrollStateChanged(int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int position, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		tv_actiongbar.setText(TabList.getInstance().get(position).getTitle());
	}


//  @Override
//  public boolean onCreateOptionsMenu(Menu menu) {
//      // Inflate the menu; this adds items to the action bar if it is present.
//      getMenuInflater().inflate(R.menu.main, menu);
//      return true;
//  }
//
//  @Override
//  public boolean onOptionsItemSelected(MenuItem item) {
//      // Handle action bar item clicks here. The action bar will
//      // automatically handle clicks on the Home/Up button, so long
//      // as you specify a parent activity in AndroidManifest.xml.
//      int id = item.getItemId();
//      if (id == R.id.action_settings) {
//          return true;
//      }
//      return super.onOptionsItemSelected(item);
//  }

}
