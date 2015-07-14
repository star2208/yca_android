package com.yca.content;

import android.view.View;

import com.yca.R;
import com.yca.activity.BaseActivity;
import com.yca.adapter.MainListAdapter;
import com.yca.util.ScreenUtil;
import com.yca.util.SystemBarTintManager;
import com.yca.widget.XListView;
import com.yca.widget.XListView.IXListViewListener;

public class IndexContent extends BaseContent implements IXListViewListener{

	private MainListAdapter adapter;
	private XListView listView;

	public IndexContent(BaseActivity activity) {
		// TODO Auto-generated constructor stub
		super(activity, R.layout.view_index_content);
	}

	@Override
	public void findID() {
		// TODO Auto-generated method stub
		listView = (XListView) findViewById(R.id.listview);
	}

	@Override
	public void Listener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InData() {
		// TODO Auto-generated method stub
		adapter = new MainListAdapter(activity);
		listView.setAdapter(adapter);
		initInsetTop();
		
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		
	}
	
	private void initInsetTop(){
		SystemBarTintManager tintManager = new SystemBarTintManager(activity);  
		SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();  
		listView.setClipToPadding(false);
		listView.setClipChildren(false);
		listView.setPadding(0, config.getPixelInsetTop(true) , config.getPixelInsetRight(), config.getPixelInsetBottom());
		listView.requestLayout();
	}
}
