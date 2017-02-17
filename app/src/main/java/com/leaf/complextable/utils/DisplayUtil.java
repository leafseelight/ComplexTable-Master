/**   
* @Title: DisplayUtil.java 
* @Package com.dzq.client.lxq.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wcp   
* @date 2014年9月1日 下午12:03:33 
* @version 2014年9月1日 下午12:03:33  
*/
package com.leaf.complextable.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;


/** 
 * @ClassName: DisplayUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wcp 
 * @date 2014年9月1日 下午12:03:33 
 *  
 */
public class DisplayUtil {

	// 屏幕基准
	public static final Double BASE_SCREEN_WIDTH = 320.0D;
	public static final Double BASE_SCREEN_HEIGHT = 480.0D;

	public static int dip2px(Context context, double dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}
	/**
     * 描述：dip转换为px.
     *
     * @param context the context
     * @param dipValue the dip value
     * @return px值
     */
    public static int dip2px(Context context, float dipValue) {
        DisplayMetrics mDisplayMetrics = getDisplayMetrics(context);
        return (int) applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, mDisplayMetrics);
    }

    /**
     * 描述：px转换为dip.
     *
     * @param context the context
     * @param pxValue the px value
     * @return dip值
     */
    public static float px2dip(Context context, float pxValue) {
        DisplayMetrics mDisplayMetrics = getDisplayMetrics(context);
        return pxValue / mDisplayMetrics.density;
    }
    
    /**
     * 描述：sp转换为px.
     *
     * @param context the context
     * @param spValue the sp value
     * @return sp值
     */
    public static float sp2px(Context context, float spValue) {
        DisplayMetrics mDisplayMetrics = getDisplayMetrics(context);
        return applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, mDisplayMetrics);
    }
    
    /**
     * 描述：px转换为sp.
     *
     * @param context the context
     * @param pxValue the sp value
     * @return sp值
     */
    public static float px2sp(Context context, float pxValue) {
        DisplayMetrics mDisplayMetrics = getDisplayMetrics(context);
        return pxValue / mDisplayMetrics.scaledDensity;
    }
	
    /**
     * 缩放文字大小,这样设置的好处是文字的大小不和密度有关，
     * 能够使文字大小在不同的屏幕上显示比例正确
     * @param textView button
     * @param sizePixels px值
     * @return
     */
    public static void setTextSize(TextView textView, float sizePixels) {
    	float scaledSize = scaleTextValue(textView.getContext(),sizePixels);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, scaledSize);
    }
    
	/**
	 * TypedValue官方源码中的算法，任意单位转换为PX单位
	 * @param unit  TypedValue.COMPLEX_UNIT_DIP
	 * @param value 对应单位的值
	 * @param metrics 密度
	 * @return px值
	 */
    public static float applyDimension(int unit, float value,
                                       DisplayMetrics metrics){
        switch (unit) {
        case TypedValue.COMPLEX_UNIT_PX:
            return value;
        case TypedValue.COMPLEX_UNIT_DIP:
            return value * metrics.density;
        case TypedValue.COMPLEX_UNIT_SP:
            return value * metrics.scaledDensity;
        case TypedValue.COMPLEX_UNIT_PT:
            return value * metrics.xdpi * (1.0f/72);
        case TypedValue.COMPLEX_UNIT_IN:
            return value * metrics.xdpi;
        case TypedValue.COMPLEX_UNIT_MM:
            return value * metrics.xdpi * (1.0f/25.4f);
        }
        return 0;
    }
    
	

	/**
	 * 描述：根据屏幕大小缩放.
	 *
	 * @param context the context
	 * @param value the px value
	 * @return the int
	 */
	public static int scaleValue(Context context, float value) {
		DisplayMetrics mDisplayMetrics = getDisplayMetrics(context);
		//为了兼容尺寸小密度大的情况
		if(mDisplayMetrics.scaledDensity > 2){
			//缩小到密度分之一
			value = value*(1.1f - 1.0f/mDisplayMetrics.scaledDensity);
		}
		return scale(mDisplayMetrics.widthPixels,
				mDisplayMetrics.heightPixels, value);
	}
	
	/**
	 * 描述：根据屏幕大小缩放文本.
	 *
	 * @param context the context
	 * @param value the px value
	 * @return the int
	 */
	public static int scaleTextValue(Context context, float value) {
		DisplayMetrics mDisplayMetrics = getDisplayMetrics(context);
		//为了兼容尺寸小密度大的情况
		if(mDisplayMetrics.scaledDensity > 2){
			//缩小到密度分之一
			//value = value*(1.1f - 1.0f/mDisplayMetrics.scaledDensity);
		}
		return scale(mDisplayMetrics.widthPixels,
				mDisplayMetrics.heightPixels, value);
	}
	
	/**
	 * 描述：根据屏幕大小缩放.
	 *
	 * @param displayWidth the display width
	 * @param displayHeight the display height
	 * @param pxValue the px value
	 * @return the int
	 */
	public static int scale(int displayWidth, int displayHeight, float pxValue) {
		if(pxValue == 0 ){
			return 0;
		}
		float scale = 1;
		try {
			float scaleWidth = (float) (displayWidth / BASE_SCREEN_WIDTH);
			float scaleHeight = (float) (displayHeight /  BASE_SCREEN_HEIGHT);
			scale = Math.min(scaleWidth, scaleHeight);
		} catch (Exception e) {
		}
		return Math.round(pxValue * scale + 0.5f);
	}

	
	/**
     * 获取屏幕尺寸与密度.
     *
     * @param context the context
     * @return mDisplayMetrics
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        Resources mResources;
        if (context == null){
            mResources = Resources.getSystem();
            
        }else{
            mResources = context.getResources();
        }
        //DisplayMetrics{density=1.5, width=480, height=854, scaledDensity=1.5, xdpi=160.421, ydpi=159.497}
        //DisplayMetrics{density=2.0, width=720, height=1280, scaledDensity=2.0, xdpi=160.42105, ydpi=160.15764}
        DisplayMetrics mDisplayMetrics = mResources.getDisplayMetrics();
        return mDisplayMetrics;
    }
    
    /**
	 * 设置PX padding.
	 *
	 * @param view the view
	 * @param left the left padding in pixels
     * @param top the top padding in pixels
     * @param right the right padding in pixels
     * @param bottom the bottom padding in pixels
	 */
	public static void setPadding(View view, int left,
								  int top, int right, int bottom) {
		int scaledLeft = scaleValue(view.getContext(), left);
		int scaledTop = scaleValue(view.getContext(), top);
		int scaledRight = scaleValue(view.getContext(), right);
		int scaledBottom = scaleValue(view.getContext(), bottom);
		view.setPadding(scaledLeft, scaledTop, scaledRight, scaledBottom);
	}
	
	/**
	 * 测量这个view
	 * 最后通过getMeasuredWidth()获取宽度和高度.
	 * @param view 要测量的view
	 * @return 测量过的view
	 */
	public static void measureView(View view) {
		ViewGroup.LayoutParams p = view.getLayoutParams();
		if (p == null) {
			p = new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
		}

		int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
		int lpHeight = p.height;
		int childHeightSpec;
		if (lpHeight > 0) {
			childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
														  MeasureSpec.EXACTLY);
		} else {
			childHeightSpec = MeasureSpec.makeMeasureSpec(0,
														  MeasureSpec.UNSPECIFIED);
		}
		view.measure(childWidthSpec, childHeightSpec);
	}

}
