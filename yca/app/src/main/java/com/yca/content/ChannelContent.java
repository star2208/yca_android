package com.yca.content;

import com.review.youngchina.R;
import com.yca.activity.BaseActivity;
import com.yca.adapter.CardsAnimationAdapter;
import com.yca.adapter.IndexContentListAdapter;
import com.yca.bean.BeanArticleCover;
import com.yca.widget.XListView;

import java.util.List;

public class ChannelContent extends BaseContent  implements XListView.IXListViewListener {
	private IndexContentListAdapter listAdapter;
	private CardsAnimationAdapter animationAdapter;
	private XListView listView;
	private List<BeanArticleCover> articleCovers;
	public ChannelContent(BaseActivity activity, int id) {
		super(activity, R.layout.view_channel_content);
	}

	@Override
	public void findID() {
		listView = (XListView) findViewById(R.id.listview);
		listView.setXListViewListener(this);
	}

	@Override
	public void Listener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRefresh() {

	}

	@Override
	public void onLoadMore() {

	}
}
