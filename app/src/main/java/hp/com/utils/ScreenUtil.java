package hp.com.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 屏幕适配的工具类
 * @author tangdekun
 *
 */
public class ScreenUtil {

	/**
	 * dip2px换算
	 * @param context
	 * @param dipValue
	 * @return
	 */
	public static int dip2px(Context context,float dipValue){
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (scale*dipValue);
	}
	
	
	/**
	 * dip2px换算
	 * @param windowManager
	 * @param dipValue
	 * @return
	 */
	public static int dip2px(WindowManager windowManager,float dipValue){
		DisplayMetrics dm = new DisplayMetrics();
		windowManager.getDefaultDisplay().getMetrics(dm);
		return (int)(dipValue * dm.density + 0.5f);
	}
	
	/**
	 * 像素px转换成尺寸dp
	 * @param context
	 * @param px
	 * @return
	 */
	public static int Px2Dp(Context context, float px) { 
	    final float scale = context.getResources().getDisplayMetrics().density; 
	    return (int) (px / scale + 0.5f); 
	} 
	
	
	public static int getScreenWidth(Context context){
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager wm=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(dm);
		int width=dm.widthPixels;
		return width;
	}
	
	
	public static int getScreenHeight(Context context){
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager wm=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(dm);
		int height = dm.heightPixels;
		return height;
	}
	
	public static int getScreenDensity(Context context){
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager wm  = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(dm);
		return dm.densityDpi;
	}
	
	public static String getScreenDensity1(Context context){
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager wm  = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(dm);
		Configuration con = context.getResources().getConfiguration();
	    int smallestWidth = con.smallestScreenWidthDp;	
		return "density:"+dm.densityDpi+"width:"+dm.widthPixels+"height:"+dm.heightPixels+"smallestWidth:"+smallestWidth;
	}
	
	public static int  getSmallestWidth(Context context){ 
		Configuration con = context.getResources().getConfiguration();
	    int smallestWidth = con.smallestScreenWidthDp;	
		return smallestWidth;
	}
}
