package com.yca.app;

import java.util.ArrayList;
import java.util.List;

import com.yca.R;
import com.yca.activity.BaseActivity;
import com.yca.adapter.MainViewPagerAdapter;
import com.yca.info.TabInfo;
import com.yca.tool.YLog;

import android.os.Bundle;
import android.support.v4.view.ViewPager;


public class MainActivity extends BaseActivity {
	private ViewPager viewPager;
	private MainViewPagerAdapter adapter;
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
		List<TabInfo> tabs = new ArrayList<TabInfo>();
		tabs.add(new TabInfo(0 , 1));
		tabs.add(new TabInfo(1 , 1));
		tabs.add(new TabInfo(2 , 1));
		adapter = new MainViewPagerAdapter(this, tabs);
		viewPager.setAdapter(adapter);
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
