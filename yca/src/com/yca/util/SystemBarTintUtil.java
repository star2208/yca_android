package com.yca.util;

import com.yca.R;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;


public class SystemBarTintUtil {
	public static void setSystemBarTintColor(Activity activity){
		if(SystemBarTintManager.isKitKat()){
			SystemBarTintManager tintManager = new SystemBarTintManager(activity);  
			tintManager.setStatusBarTintEnabled(true);
			tintManager.setStatusBarTintDrawable(new ColorDrawable(activity.getResources().getColor(R.color.mxx_item_theme_color_alpha)));
		}
	}
}
