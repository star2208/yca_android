package com.yca.activity;

import java.util.ArrayList;

import com.yca.R;
import com.yca.adapter.MainViewPagerAdapter;
import com.yca.info.TabInfo;
import com.yca.tool.YLog;
import com.yca.widget.CirclePageIndicator;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
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
	private ArrayList<TabInfo> tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
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
		tabs = new ArrayList<TabInfo>();
		tabs.add(new TabInfo(0 , 1 , getResources().getString(R.string.index_title)));
		tabs.add(new TabInfo(1 , 1 , getResources().getString(R.string.article_title)));
		tabs.add(new TabInfo(2 , 1 , getResources().getString(R.string.review_title)));
		adapter = new MainViewPagerAdapter(this, tabs);
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
		tv_actiongbar.setText(tabs.get(0).getTitle());
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
		tv_actiongbar.setText(tabs.get(position).getTitle());
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
