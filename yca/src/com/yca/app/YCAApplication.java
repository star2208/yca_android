package com.yca.app;

import com.umeng.analytics.AnalyticsConfig;

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
		//友盟移动统计
		AnalyticsConfig.enableEncrypt(true);
	}

}
