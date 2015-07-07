package com.yca.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.yca.app.Constants;
import com.yca.bean.BaseBean;
import com.yca.bean.NetWorkInfo;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;


/**
 * @author 吕天成
 * @time 
 */
public class Tool {
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	private static Tool comment;
	private Toast mToast;
	private Activity activity;
	private Context context;
	private int Width;
	private int Height;
	private ViewGroup layout;
	private View view;
	public final static String ImagePath = "/mumbuy";
	public final static String ImageName = "/guy_pic.png";

	private Tool() {

	}


	public static Tool getInstance() {
		if (comment == null) {
			comment = new Tool();
		}
		return comment;
	}


	@SuppressLint({ "CommitPrefEdits", "WorldReadableFiles" })
	@SuppressWarnings("deprecation")
	public void init(Activity activity) {
		this.activity = activity;
		this.context = activity;
		preferences = activity.getSharedPreferences(Constants.APPLICATIONNAME,
				Context.MODE_WORLD_READABLE);
		editor = preferences.edit();
		// 获取屏幕尺寸
		WindowManager windowManager = activity.getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		// 宽度
		Width = display.getWidth();
		// 高度
		Height = display.getHeight();
	}

	/**
	 * 返回屏幕�?
	 * 
	 * @return
	 */
	public int GetWidth() {
		return Width;
	}

	/**
	 * 返回屏幕�?
	 * 
	 * @return
	 */
	public int GetHeight() {
		return Height;
	}

	/**
	 * 存储本地数据
	 * 
	 * @param id
	 * @param value
	 */
	public void setShareValue(String id, String value) {
		editor.putString(id, value);
	}

	public void setIntShareValue(String id, int value) {
		editor.putInt(id, value);
	}

	/**
	 * 获取本地数据
	 * 
	 * @param id
	 * @return
	 */
	public String getShareValue(String id) {
		return preferences.getString(id, "");
	}

	public int getIntShareValue(String id) {
		return preferences.getInt(id, 0);
	}

	/**
	 * 提交修改 Commit
	 */
	public void setCommit() {
		editor.commit();
	}

	/**
	 * 清空本地缓存
	 */
	public void clearEditor() {
		editor.clear();
		editor.commit();
	}

	/**
	 * 显示提示信息
	 * 
	 * @param 提示信息
	 */
	public void ShowToast(String text) {
		if (mToast == null) {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
		}
		mToast.show();
	}

	/**
	 * 清空Toast
	 */
	private void CancelToast() {
		if (mToast != null) {
			mToast.cancel();
		}
	}

	/**
	 * 清空数据
	 */
	public void Cancle() {
		CancelToast();
	}

//	/**
//	 * 设置�?��刷新时间
//	 */
//	public void setLastUpdateTime(Activity activity,
//			PullToRefreshListView pullToRefreshListView) {
//		String text = DateUtils.formatDateTime(activity,
//				System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
//						| DateUtils.FORMAT_SHOW_DATE
//						| DateUtils.FORMAT_ABBREV_ALL);
//		pullToRefreshListView.setLastUpdatedLabel(text);
//	}

//	/**
//	 * 显示动画Dialog
//	 * 
//	 * @param view
//	 * @param layout
//	 */
//	public void ShowDialog(View view, ViewGroup layout) {
//		this.layout = layout;
//		if (layout != null && view != null) {
//			this.view = view;
//			layout.addView(this.view, 0, new ViewGroup.LayoutParams(Width, Height
//					- (int) activity.getResources().getDimension(
//							R.dimen.view_head_height)));
//			layout.bringChildToFront(this.view);
//		}
//
//	}
	
	public void ShowDialog2(View view, ViewGroup layout) {
		this.layout = layout;
		if (layout != null && view != null) {
			this.view = view;
			this.view.setLayoutParams(new ViewGroup.LayoutParams(Width, Height));
			layout.addView(this.view,0);
		}

	}
	/**
	 * 清除Dialog
	 */
	public void CancelDialog() {
		if (layout != null) {
			layout.removeView(view);
			layout = null;
		}
	}

	/**
	 * md5加密
	 * 
	 * @param str
	 *            �?��加密的内�?
	 * @return
	 */
	public String MD5(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = str.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * 判断获取数据状�?
	 * 
	 * @param arg0
	 * @throws JSONException
	 */
	public <T extends BaseBean<T>> boolean IsTrue(BaseBean<T> info) {
		if (info.Error() == 0) {
			return true;
		} else {
			ShowToast(info.Msg());
			return false;

		}
	}

	/**
	 * 获取网络数据
	 * 
	 * @param arg0
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> BaseBean<T> CreateJsonObject(Class<T> cls, String arg0) {
		BaseBean<T> t = null;
		NetWorkInfo netWork = new NetWorkInfo();
		JSONObject jsonObject;
		try {
			t = (BaseBean<T>) cls.newInstance();
			jsonObject = JSON.parseObject(arg0);

			if (jsonObject.containsKey("data")) {
				netWork.data = jsonObject.getString("data");
			}
			if (jsonObject.containsKey("msg")) {
				netWork.msg = jsonObject.getString("msg");
			}
			if (jsonObject.containsKey("error")) {
				netWork.error = jsonObject.getString("error");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		t.NetWok = netWork;
		return t;
	}

	private DisplayImageOptions displayImageOptions;

	/**
	 * 图片获取失败替换图片
	 * 
	 * @param res
	 *            替换资源.
	 * @return
	 */
	public DisplayImageOptions GetDisPlayOptions(int res) {
		displayImageOptions = new DisplayImageOptions.Builder()
				.resetViewBeforeLoading(true)
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.showImageForEmptyUri(res)
				.showImageOnLoading(res)
				.showImageForEmptyUri(res)
				.showImageOnFail(res)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.build();
		return displayImageOptions;

	}
	public DisplayImageOptions GetDisPlayOptions2(int res) {
		displayImageOptions = new DisplayImageOptions.Builder()
				.resetViewBeforeLoading(true)
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				//.imageScaleType(ImageScaleType.EXACTLY)
				.cacheInMemory(false)
				.cacheOnDisk(false)
				.showImageForEmptyUri(res)
				.showImageOnLoading(res)
				.showImageForEmptyUri(res)
				.showImageOnFail(res)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.build();
		return displayImageOptions;

	}
	/**
	 * 设置界面显示隐藏
	 * 
	 * @param data
	 * @param layout
	 */
	public <T extends BaseBean<T>> void VisibleView(List<T> data, View layout) {
		if (data != null) {
			if (data.size() == 0) {
				layout.setVisibility(View.VISIBLE);
			} else {
				layout.setVisibility(View.GONE);
			}
		} else {
			layout.setVisibility(View.VISIBLE);
		}

	}

	/**
	 * 获取设备id mac 信息
	 */
	public void getDeviceID() {
		WifiManager wifiMgr = (WifiManager) activity
				.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiinfo = (null == wifiMgr ? null : wifiMgr
				.getConnectionInfo());
		if (null != wifiinfo) {
			Constants.Mac = wifiinfo.getMacAddress();
		}
		final TelephonyManager tm = (TelephonyManager) activity
				.getApplicationContext().getSystemService(
						Context.TELEPHONY_SERVICE);
		Constants.IDFA = tm.getDeviceId();
		isPad();

	}

	/**
	 * 判断是pad 还是phone
	 */
	private void isPad() {
		WindowManager wm = (WindowManager) activity.getApplicationContext()
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		DisplayMetrics dm = new DisplayMetrics();
		display.getMetrics(dm);
		double x = Math.pow(dm.widthPixels / dm.xdpi, 2);
		double y = Math.pow(dm.heightPixels / dm.ydpi, 2);
		double screenInches = Math.sqrt(x + y);
		if (screenInches >= 6.0) {
			Constants.DeviceType = "Pad";
		} else {
			Constants.DeviceType = "Phone";
		}
	}

	/**
	 * 取double数的精度
	 * 
	 * @param num
	 *            double
	 * @param scale
	 *            小数点后几位
	 * @return double
	 */
	public double BigDecimalDouble(double num, int scale) {
		BigDecimal bd = new BigDecimal(num);
		return bd.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 隐藏软键�?
	 * 
	 * @param activity
	 */
	public void StopKeyBoard(Activity activity) {
		InputMethodManager im = (InputMethodManager) activity
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		im.hideSoftInputFromWindow(activity.getCurrentFocus()
				.getApplicationWindowToken(), 0);

	}

	/**
	 * �?��软键�?
	 * 
	 * @param activity
	 * @param editText
	 */
	public void StartKeyBoard(Activity activity, EditText editText) {
		InputMethodManager im = (InputMethodManager) activity
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		im.showSoftInput(editText, 0);
	}

	/**
	 * 处理时间
	 * 
	 * @param time
	 *            �?��处理的时�?
	 */
	@SuppressLint("SimpleDateFormat")
	public String GetTime(String time) {
		String str = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy年MM月dd�?HH:mm");
		SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm");

		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		Date times = null;

		try {
			times = formatter.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Log.e("TAG", "times" + times.getTime());
		long lt = (times.getTime() + 8 * 60 * 60 * 1000) / 86400000;
		long ct = (curDate.getTime() + 8 * 60 * 60 * 1000) / 86400000;
		//Log.e("TAG", "CurTime" + lt);
		//Log.e("TAG", "times" + ct);
		int days = (int) (ct - lt);
		if (days == 0) {
			str = "今天 " + formatter2.format(times);
			Log.e("TAG", formatter1.format(curDate));
			Log.e("TAG", formatter1.format(times));
		} else if (days == 1) {
			str = "昨天 " + formatter2.format(times);
		} else if (days == 2) {
			str = "前天 " + formatter2.format(times);
		} else {
			str = formatter1.format(times);
		}
		return str;
	}

/*
	public boolean IsLogin2(Activity activity) {
		this.activity = activity;
		if ("".equals(getShareValue("user_id"))) {
			Intent intent = new Intent(activity, LoginActivity.class);
			activity.startActivity(intent);
			ShowToast("");
			return false;
		} else {
			return true;
		}
	}
	
	public boolean IsLoginFavourite(Activity activity) {
		this.activity = activity;
		if ("".equals(getShareValue("user_id"))) {
			Intent intent = new Intent(activity, LoginActivity.class);
			activity.startActivity(intent);
			ShowToast("");
			return false;
		} else {
			return true;
		}
	}
	
	public boolean IsLoginComment(Activity activity) {
		this.activity = activity;
		if ("".equals(getShareValue("user_id"))) {
			Intent intent = new Intent(activity, LoginActivity.class);
			activity.startActivity(intent);
			ShowToast("");
			return false;
		} else {
			return true;
		}
	}
*/

	/*
	 * 获取当前程序的版本号
	 */
	public String getVersionName(Activity activity) {

		// 获取packagemanager的实�?
		PackageManager packageManager = activity.getPackageManager();
		// getPackageName()是你当前类的包名�?代表是获取版本信�?
		PackageInfo packInfo = null;
		try {
			packInfo = packageManager.getPackageInfo(activity.getPackageName(),
					0);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return "";
		}
		return packInfo.versionName;
	}
	public void copyGloab2Databases() {
		  String SDurl = Environment.getExternalStorageDirectory() + "/";
		  File file = new File(SDurl + ImagePath);
		  // 不存在则创建，存在就返回
		  if (!file.exists())
			  file.mkdirs();
		  File copyFile = new File(SDurl + ImagePath + ImageName);
		  if (!copyFile.exists()) {
		  try {
			  copyFile.createNewFile(); 
		  } catch (IOException e1) {
			  // TODO Auto-generated catch block
			  e1.printStackTrace();
		  }
		  InputStream in = null;
		  OutputStream out = null;
		  try {
			  // 获取图片，将图片copy到sdcard
			  in = activity.getAssets().open("ic_launcher.png");
			  out = new FileOutputStream(copyFile);
			  byte[] buff = new byte[1024];
			  int len;
			  while ((len = in.read(buff)) > 0) {
				  out.write(buff, 0, len);
			   }
		   } catch (IOException e) {
			   e.printStackTrace();
		  } finally { 
			  try {
				  if (out != null)
					  out.close();
				  if (in != null)
					  in.close();
				  } catch (IOException e) 
				  {
					  e.printStackTrace();
					  }
			  }
		 }
	}
	public String getImagePath()
	{
		return Environment.getExternalStorageDirectory() + "/" + ImagePath + ImageName;
	}
	

}
