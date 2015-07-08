package com.yca.adapter;

import java.util.List;

import com.yca.activity.BaseActivity;
import com.yca.content.BaseContent;
import com.yca.content.ChannelContent;
import com.yca.content.FavoriteContent;
import com.yca.content.IndexContent;
import com.yca.info.TabInfo;

import android.provider.ContactsContract.Contacts.Data;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;


public class MainViewPagerAdapter extends PagerAdapter {
	
	private List<TabInfo> Tabs = null;
	private BaseActivity activity;
	public MainViewPagerAdapter(BaseActivity activity, List<TabInfo> tabs)
	{
		this.Tabs = tabs;
		this.activity = activity;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Tabs.size();
	}
	
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		TabInfo tabInfo = Tabs.get(position);
		BaseContent content = null;
		switch (tabInfo.getType()) {
		case 0://首页
			content = new IndexContent(activity);
			break;
		case 1://列表
			content = new ChannelContent(activity, tabInfo.getID());
			break;
		case 2://收藏
			content = new FavoriteContent(activity);
			break;
		case 3://待定
			
			break;
		default:
			break;
		}
		View view = content.getView();
		((ViewPager) container).addView(view);
		return view;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView((View) object);
	}
	
	
}
