package com.yca.httpapi;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.yca.app.APIContact;
import com.yca.util.LogUtil;

import android.content.Context;

/**
 * REST网络接口请求类
 * 
 * @author Owen
 */
public class RESTClient {

	private static AsyncHttpClient sClient = new AsyncHttpClient();

	static {
		sClient.addHeader("Accept", "application/json");
		sClient.setTimeout(20000);
	}
	
	/**
	 * HTTP-GET
	 */
	private static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		LogUtil.i(url,params.toString());
		sClient.get(url, params, responseHandler);
	}

	/**
	 * HTTP-POST
	 */
	private static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		LogUtil.i(url,params.toString());
		sClient.post(url, params, responseHandler);
	}

	/**
	 * HTTP-DELETE
	 */
	@SuppressWarnings("unused")
	private static void delete(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		sClient.delete(url, params, responseHandler);
	}

	/**
	 * 取消所有网络请求
	 */
	public static void cancelAllRequest() {
		sClient.cancelAllRequests(true);
	}

	/**
	 * post 备用
	 */
	public static void putOrderToDesignDepartment(String orderId, AsyncHttpResponseHandler onResponse) {
		RequestParams params = new RequestParams();
		params.put("order_id", orderId);
		
		post(APIContact.API_GET_APP_STARTUP, params, onResponse);
	}

	/**
	 * 启动请求
	 */
	public static void StartUp(AsyncHttpResponseHandler onResponse) {
		RequestParams params = new RequestParams();
		get(APIContact.API_GET_APP_STARTUP, params, onResponse);
	}
		/**
		 * 启动请求
		 */
	public static void Topics(AsyncHttpResponseHandler onResponse) {
		RequestParams params = new RequestParams();
		get(APIContact.API_GET_ARTICLES_TOPICS, params, onResponse);
	}
	
	public static void HomePage(AsyncHttpResponseHandler onResponse) {
		RequestParams params = new RequestParams();
		get(APIContact.API_GET_HOMEPAGE, params, onResponse);
	}

}
