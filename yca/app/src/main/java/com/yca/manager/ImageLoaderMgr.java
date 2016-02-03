package com.yca.manager;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.L;
import com.review.youngchina.R;
import com.yca.app.APIContact;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/**
 * UIL管理类
 * 
 * @author Owen
 */
public class ImageLoaderMgr {

	private static ImageLoaderMgr sInstance = new ImageLoaderMgr();
	
	private ImageLoader mImageLoader;
	private DisplayImageOptions optionsUserAvatar;
	private DisplayImageOptions optionsProjectAvatar;
	private DisplayImageOptions options_normal;
	
	private ImageLoaderMgr() {
		mImageLoader = ImageLoader.getInstance();
	}
	
	public static ImageLoaderMgr getInstance() {
		return sInstance;
	}
	
	public void init(Context context) {
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.diskCacheSize(50 * 1024 * 1024)
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.build();
		ImageLoader.getInstance().init(config);
		L.writeDebugLogs(false);
		L.writeLogs(false);
	}
	
	public void clear() {
		mImageLoader.clearDiskCache();
	}
	
	public void display(String uuid, ImageView imageView) {
		mImageLoader.displayImage(APIContact.API_GET_FILE + uuid, imageView, getOptions());
	}
	/**
	 * 显示用户头像
	 */
	public void displayUserAvatar(String url, ImageView imageView) {
		mImageLoader.displayImage(url, imageView, getOptionsAvatar());
	}

	/**
	 * 显示项目头像
	 */
	public void displayProjectAvatar(String url, ImageView imageView) {
		mImageLoader.displayImage(url, imageView, getOpentionsProjectAvatar());
	}
	
	private DisplayImageOptions getOptionsAvatar() {
		if (optionsUserAvatar == null) {
			optionsUserAvatar = new DisplayImageOptions.Builder()
					.showImageOnLoading(R.drawable.loading_bg)
					.showImageForEmptyUri(R.drawable.loading_bg)
					.showImageOnFail(R.drawable.loading_bg)
					.cacheInMemory(true)
					.cacheOnDisk(true)
					.considerExifParams(true)
					.bitmapConfig(Bitmap.Config.RGB_565).build();
		}
		
		return optionsUserAvatar;
	}
	
	private DisplayImageOptions getOptions() {
		if (options_normal == null) {
			options_normal = new DisplayImageOptions.Builder()
					.showImageOnLoading(R.drawable.loading_bg)
					.showImageForEmptyUri(R.drawable.loading_bg)
					.showImageOnFail(R.drawable.loading_bg)
					.cacheInMemory(true).cacheOnDisk(true)
					.considerExifParams(true)
					.bitmapConfig(Bitmap.Config.RGB_565).build();
		}
		return options_normal;
	}
	
	private DisplayImageOptions getOpentionsProjectAvatar() {
		if (optionsProjectAvatar == null) {
			optionsProjectAvatar = new DisplayImageOptions.Builder()
					.showImageOnLoading(R.drawable.loading_bg)
					.showImageForEmptyUri(R.drawable.loading_bg)
					.showImageOnFail(R.drawable.loading_bg)
					.cacheInMemory(true)
					.cacheOnDisk(true)
					.considerExifParams(true)
					.bitmapConfig(Bitmap.Config.RGB_565).build();
		}
		
		return optionsProjectAvatar;
	}
	
}
