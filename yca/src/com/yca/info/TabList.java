package com.yca.info;

import java.util.ArrayList;
import java.util.List;

import com.review.youngchina.R;
import com.yca.bean.BeanTopic;

import android.content.Context;


public class TabList extends ArrayList<TabInfo> {

	private static final long serialVersionUID = 1L;
	private static TabList sInstance = new TabList();
	private boolean isLoaded = false;
	public static final int HOME_PAGE = 0;
	public static final int TOPIC = 1;
	public static TabList getInstance() {
		return sInstance;
	}
	public void init(Context context) {
		sInstance.add(new TabInfo(HOME_PAGE , 0 , context.getResources().getString(R.string.index_title)));
	}
	public boolean isLoaded() {
		return isLoaded;
	}
	public void addBeanTopicList(List<BeanTopic> topiclist) {
		for (int i = 0; i < topiclist.size(); i++) {
			sInstance.add(new TabInfo(TOPIC , topiclist.get(i).id , topiclist.get(i).name));
			isLoaded = true;
		}
	}
}
