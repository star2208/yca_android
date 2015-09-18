package com.yca.adapter;

import com.yca.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
		TextView titleTextView = holder.obtainView(convertView, R.id.tv_item_main_list_title);
		titleTextView.setText("病急投医的庞氏游戏");
		return convertView;
	}

}
