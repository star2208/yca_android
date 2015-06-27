package com.yca;

import com.loopj.android.http.AsyncHttpClient;

/**
 * @author 吕天成 E-mail:star2208@126.com
 * @version 创建时间：2015-6-25 下午8:07:49
 */
public class Constants {
	public static final String APPLICATIONNAME = "YoungChinaAcademy";
//	public static String DATA_PORT = "http://rest.lenlv.net/";
	public static String DATA_PORT = "http://dev.lenlv.net/";
	/** 异步任务下载器 */
	public static AsyncHttpClient httpClient = new AsyncHttpClient();
	public static String DeviceType;
	public static String Mac;
	public static String IDFA;
}
