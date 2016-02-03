package com.yca.activity;

import java.util.List;

import org.apache.http.Header;

import android.content.Intent;
import android.os.Handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.review.youngchina.R;
import com.yca.bean.BeanTopic;
import com.yca.httpapi.RESTClient;
import com.yca.info.TabList;


/**
 * 欢迎页界面
 * 
 */
public class SplashActivity extends BaseActivity {

	@Override
	protected void setLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_splash); 
	}
	
	@Override
	protected void FindID() {
		// TODO Auto-generated method stub
		
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
		if (!TabList.getInstance().isLoaded()) {
			RESTClient.Topics(new AsyncHttpResponseHandler() {

				@Override
				public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
					List<BeanTopic> topiclist = JSON.parseArray(new String(arg2), BeanTopic.class);
					if (TabList.getInstance() != null && TabList.getInstance().size() == 0) {
						TabList.getInstance().addBeanTopicList(topiclist);
					}
				}

				@Override
				public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {

				}
			});
		}
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				RESTClient.cancelAllRequest();
				startActivity(new Intent(SplashActivity.this, MainActivity.class));
				SplashActivity.this.finish();
			}
		}, 2000);
	}
}
