package com.yca.content;

import java.util.List;

import org.apache.http.Header;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.review.youngchina.R;
import com.yca.activity.BaseActivity;
import com.yca.adapter.CardsAnimationAdapter;
import com.yca.adapter.IndexContentListAdapter;
import com.yca.bean.BeanArticleCover;
import com.yca.httpapi.RESTClient;
import com.yca.util.LogUtil;
import com.yca.util.SystemBarTintManager;
import com.yca.widget.XListView;
import com.yca.widget.XListView.IXListViewListener;

public class IndexContent extends BaseContent implements IXListViewListener{

	private IndexContentListAdapter listAdapter;
	private CardsAnimationAdapter animationAdapter;
	private XListView listView;
	private List<BeanArticleCover> articleCovers;

	public IndexContent(BaseActivity activity) {
		// TODO Auto-generated constructor stub
		super(activity, R.layout.view_index_content);
	}

	@Override
	public void findID() {
		// TODO Auto-generated method stub
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
		RESTClient.HomePage(new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				LogUtil.i("onSuccess",new String(arg2));
				articleCovers = JSON.parseArray(new String(arg2), BeanArticleCover.class);
				listAdapter = new IndexContentListAdapter(activity,articleCovers);
				animationAdapter = new CardsAnimationAdapter(listAdapter);
				animationAdapter.setAbsListView(listView);
				listView.setAdapter(animationAdapter);
				listView.setDividerHeight(0);
				initInsetTop();
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				
			}
		});
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		LogUtil.i("onRefresh","onRefresh");
		RESTClient.HomePage(new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				articleCovers.clear();
				articleCovers.addAll(JSON.parseArray(new String(arg2), BeanArticleCover.class));
				listAdapter = new IndexContentListAdapter(activity,articleCovers);
				animationAdapter.notifyDataSetChanged();
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				
			}

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				super.onFinish();
				listView.stopRefresh();
			}
			
		});
	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		LogUtil.i("onLoadMore","onLoadMore");
		RESTClient.HomePage(new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				articleCovers.addAll(JSON.parseArray(new String(arg2), BeanArticleCover.class));
				listAdapter = new IndexContentListAdapter(activity,articleCovers);
				animationAdapter.notifyDataSetChanged();
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				super.onFinish();
				listView.stopLoadMore();
			}
		});
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
