package com.yca.content;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;

import com.lee.pullrefresh.ui.PullToRefreshBase;
import com.lee.pullrefresh.ui.PullToRefreshBase.OnRefreshListener;
import com.lee.pullrefresh.ui.PullToRefreshListView;
import com.yca.R;
import com.yca.activity.BaseActivity;
import com.yca.tool.YLog;
import com.yca.util.SystemBarTintManager;

public abstract class BaseListContent extends BaseContent {
	@SuppressLint("SimpleDateFormat")
	private SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm");
	// 列表
	protected PullToRefreshListView pullToRefreshListView;
	protected ListView listView;
	protected int start; // 起始位置
	protected int limit = 10; // 结束位置 

	public BaseListContent(BaseActivity activity, int resourceID) {
		super(activity, resourceID);
		Init();
		InitListView();
	}
	private void initInsetTop(View rootView){
		SystemBarTintManager tintManager = new SystemBarTintManager(activity);  
		SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();  
		rootView.setPadding(0, config.getPixelInsetTop(true) , config.getPixelInsetRight(), config.getPixelInsetBottom());
		rootView.requestLayout();
	}
	private void Init() {
		pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.listview);
		pullToRefreshListView.setPullLoadEnabled(false);
		pullToRefreshListView.setScrollLoadEnabled(true);
		listView = pullToRefreshListView.getRefreshableView();
		listView.setOnItemClickListener(this);
		listView.setDividerHeight(0);
		listView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		pullToRefreshListView
				.setOnRefreshListener(new OnRefreshListener<ListView>() {
					@Override
					public void onPullDownToRefresh(
							PullToRefreshBase<ListView> refreshView) {
						start = 0;
						new GetDataTask().execute();
					}

					@Override
					public void onPullUpToRefresh(
							PullToRefreshBase<ListView> refreshView) {
						start += limit;
						new GetDataTask().execute();
					}
				});
		initInsetTop(view);
	}

	private class GetDataTask extends AsyncTask<Void, Void, String[]> {

		@Override
		protected String[] doInBackground(Void... params) {
			return null;
		}

		@Override
		protected void onPostExecute(String[] result) {
			Getdata();
			setLastUpdateTime();
			super.onPostExecute(result);
		}
	}

	private void setLastUpdateTime() {
		String text = formatDateTime(System.currentTimeMillis());
		pullToRefreshListView.setLastUpdatedLabel(text);
	}

	private String formatDateTime(long time) {
		if (0 == time) {
			return "";
		}

		return mDateFormat.format(new Date(time));
	}

	protected abstract void Getdata();

	/**
	 * 显示动画
	 */
	public void ShowDiglog() {
		
	}

	/**
	 * 关于ListView 的处理
	 */
	public abstract void InitListView();


}
