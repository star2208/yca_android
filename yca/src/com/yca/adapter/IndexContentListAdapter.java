package com.yca.adapter;

import java.util.List;


import com.review.youngchina.R;
import com.yca.activity.BaseActivity;
import com.yca.bean.BeanArticleCover;
import com.yca.manager.ImageLoaderMgr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class IndexContentListAdapter extends YBaseAdapter {
	
	private List<BeanArticleCover> articleCovers;

	public IndexContentListAdapter(BaseActivity activity, List<BeanArticleCover> articleCovers) {
		super(activity);
		this.articleCovers = articleCovers;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return articleCovers.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int itemLayoutRes() {
		// TODO Auto-generated method stub
		return R.layout.view_item_mainlist;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent,
			ViewHolder holder) {
		// TODO Auto-generated method stub
		TextView titleTextView = holder.obtainView(convertView, R.id.tv_item_main_list_title);
		ImageView coverImageView = holder.obtainView(convertView, R.id.iv_item_main_list_cover);
		titleTextView.setText(articleCovers.get(position).title);
		ImageLoaderMgr.getInstance().display(articleCovers.get(position).cover, coverImageView);
		return convertView;
	}

}
