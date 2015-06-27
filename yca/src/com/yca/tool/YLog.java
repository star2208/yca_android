package com.yca.tool;

import android.util.Log;

/**
 * @author 吕天成 E-mail:star2208@126.com
 * @version 创建时间：2015-6-24 下午8:50:56
 */
public class YLog {
	
	private static final boolean isShow = true;

	public static void e(String tag, String msg)
	{
		if (isShow)
		{
			Log.e(tag, msg);
		}
	}

	public static void d(String tag, String msg)
	{
		if (isShow)
		{
			Log.d(tag, msg);
		}
	}

	public static void w(String tag, String msg)
	{
		if (isShow)
		{
			Log.w(tag, msg);
		}
	}

	public static void i(String tag, String msg)
	{
		if (isShow)
		{
			Log.i(tag, msg);
		}
	}

	public static void v(String tag, String msg)
	{
		if (isShow)
		{
			Log.v(tag, msg);
		}
	}
}
