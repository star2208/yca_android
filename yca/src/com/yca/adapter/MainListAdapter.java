package com.yca.adapter;

import com.yca.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class MainListAdapter extends YBaseAdapter {
	
	public MainListAdapter(Context context) {
		super(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
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
		return convertView;
	}

}
