package com.yca.app;

import org.apache.http.Header;


import com.loopj.android.http.AsyncHttpResponseHandler;
import com.umeng.analytics.AnalyticsConfig;
import com.yca.httpapi.RESTClient;
import com.yca.info.TabList;
import com.yca.manager.ImageLoaderMgr;

import android.app.Application;

/**
 * @author 吕天成 E-mail:star2208@126.com
 * @version 创建时间：2015-6-27 上午9:40:07
 */
public class YCAApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		AnalyticsConfig.enableEncrypt(true);
		TabList.getInstance().init(this);
		ImageLoaderMgr.getInstance().init(this);
		RESTClient.StartUp(new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				
			}
		});
	}

}
