package com.yca.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


/**
 * 获取屏幕 宽度和高度
 * 
 * @author iverson_573
 * 
 */
public class ScreenUtil {

	public static int getScreenWidth(Context context) {
		final WindowManager windowManager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		final Display display = windowManager.getDefaultDisplay();
		DisplayMetrics dm = new DisplayMetrics();
		display.getMetrics(dm);
		boolean isPortrait = dm.widthPixels < dm.heightPixels;
		int mScreenWidth = isPortrait ? dm.widthPixels : dm.heightPixels;
		return mScreenWidth;
	}

	public static int getScreenHeight(Context context) {
		final WindowManager windowManager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		final Display display = windowManager.getDefaultDisplay();
		DisplayMetrics dm = new DisplayMetrics();
		display.getMetrics(dm);
		boolean isPortrait = dm.widthPixels < dm.heightPixels;
		int mScreenHeight = isPortrait ? dm.heightPixels : dm.widthPixels;
		return mScreenHeight;
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

    /**
     * 将px值转换为sp值，保证文字大小不变
     * 
     * @param pxValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */ 
    public static int px2sp(Context context, float pxValue) { 
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity; 
        return (int) (pxValue / fontScale + 0.5f); 
    } 
   
    /**
     * 将sp值转换为px值，保证文字大小不变
     * 
     * @param spValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */ 
    public static int sp2px(Context context, float spValue) { 
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity; 
        return (int) (spValue * fontScale + 0.5f); 
    } 

	/**
	 ***************************************************************************************************************************************** 
	 ***************************************************************************************************************************************** 
	 * 图片 的使用
	 */

	/**
	 * 获取100*100固定大小图片地址
	 * 
	 * @param url
	 * @param width
	 * @param height
	 * @return
	 */
	public static String getCusPictureUrlOneHundred(String url) {// http://192.168.1.55:80/api/file?id=2&width=100&height=100

		StringBuffer str = new StringBuffer();
		if (!TextUtils.isEmpty(url))// 判断图片是否为空
		{
			str.append(url);
			str.append("&width=" + 100);
			str.append("&height=" + 100);
			return str.toString();
		}

		return url;
	}

	/**
	 * 获取 200*200固定大小图片地址
	 * 
	 * @param url
	 * @param width
	 * @param height
	 * @return
	 */
	public static String getCusPictureUrlTwoHundred(String url) {// http://192.168.1.55:80/api/file?id=2&width=100&height=100

		StringBuffer str = new StringBuffer();
		if (!TextUtils.isEmpty(url))// 判断图片是否为空
		{
			str.append(url);
			str.append("&width=" + 200);
			str.append("&height=" + 200);
			return str.toString();
		}

		return url;
	}

	/**
	 * 获取 500*500固定大小图片地址
	 * 
	 * @param url
	 * @param width
	 * @param height
	 * @return
	 */
	public static String getCusPictureUrlFiveHundred(String url) {// http://192.168.1.55:80/api/file?id=2&width=100&height=100

		StringBuffer str = new StringBuffer();
		if (!TextUtils.isEmpty(url))// 判断图片是否为空
		{
			str.append(url);
			str.append("&width=" + 500);
			str.append("&height=" + 500);
			return str.toString();
		}

		return url;
	}

	/**
	 * 获取固定大小图片地址
	 * 
	 * @param url
	 * @param width
	 * @param height
	 * @return
	 */
	public static String getCusPictureUrl(String url, Integer width,
			Integer height) {// http://192.168.1.55:80/api/file?id=2&width=100&height=100

		StringBuffer str = new StringBuffer();
		if (!TextUtils.isEmpty(url))// 判断图片是否为空
		{
			str.append(url);
			str.append("&width=" + width);
			str.append("&height=" + height);
			return str.toString();
		}

		return url;
	}


//	public static String getPictureWithMin(BeanUserFile base, double min) {
//		StringBuffer str = new StringBuffer();
//		if (base != null && !TextUtils.isEmpty(base.getUrl())) {
//			str.append(base.getUrl());
//
//			BeanStorage beanStorage = base.getStorage();
//			if (beanStorage != null) {
//				int srcWidth = beanStorage.getWidth();
//				int srcHeight = beanStorage.getHeight();
//
//				if (srcWidth > 0 && srcHeight > 0) {
//					double scale = 1;
//
//					if (srcWidth > srcHeight) {
//						scale = min / srcHeight;
//					} else {
//						scale = min / srcWidth;
//					}
//
//					str.append("&width=" + (int) (srcWidth * scale));
//					str.append("&height=" + (int) (srcHeight * scale));
//				}
//			}
//
//			return str.toString();
//		}
//
//		return "";
//	}
	
	
	
	public static int getStatusBarHeight(Context context) {
		   int result = 0;
		   int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		   if (resourceId > 0) {
		      result = context.getResources().getDimensionPixelSize(resourceId);
		   }
		   return result;
		}

}
