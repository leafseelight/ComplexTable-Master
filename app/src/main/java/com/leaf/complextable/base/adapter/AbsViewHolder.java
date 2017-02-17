package com.leaf.complextable.base.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AbsViewHolder {
	private final SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;

	private AbsViewHolder(Context context, ViewGroup parent, int layoutId,
						  int position) {
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		// setTag
		mConvertView.setTag(this);
	}

	/**
	 * 拿到一个ViewHolder对象
	 * 
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return
	 */
	public static AbsViewHolder get(Context context, View convertView,
			ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			synchronized (AbsViewHolder.class) {
				if (convertView == null) {
					return new AbsViewHolder(context, parent, layoutId, position);
				}
			}
		}
		return (AbsViewHolder) convertView.getTag();
	}

	public View getConvertView() {
		return mConvertView;
	}

	/**
	 * 通过控件的Id获取对于的控件，如果没有则加入views
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId) {

		return getView(viewId,null);
	}

	/**
	 * 通过控件的Id获取对于的控件，如果没有则加入views
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId, ViewGroup.LayoutParams mParams) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			if (mParams != null) {
				view.setLayoutParams(mParams);
			}
			mViews.put(viewId, view);
		}
		return (T) view;
	}
	/**
	 * 通过控件的Id获取对于的控件，如果没有则加入views
	 * 
	 * @param viewId
	 * @param isSt boolean 是否加中横线
	 * @return
	 */
	public <T extends View> T getView(int viewId, boolean isSt) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			if (isSt&&view instanceof TextView) {
				setTxtThru((TextView)view);
			}
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 设置中划线
	 *
	 * @param view
	 */
	public void setTxtThru(TextView view) {
		view.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		view.getPaint().setAntiAlias(true);
	}

	/**
	 * 为TextView设置字符串
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public AbsViewHolder setText(int viewId, String text) {
		TextView view = getView(viewId);
		view.setText(text);
		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public AbsViewHolder setImageResource(int viewId, int drawableId) {

		return setImageResource(viewId, drawableId, null);
	}

	/**
	 * @Title: setImageResource
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param viewId
	 * @param drawableId
	 * @param mParams
	 *            ViewGroup
	 * @return
	 * @return ViewHolder 返回类型
	 */
	public AbsViewHolder setImageResource(int viewId, int drawableId,
			ViewGroup.LayoutParams mParams) {
		ImageView view = getView(viewId,mParams);
		view.setImageResource(drawableId);

		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @param mParams
	 * @return
	 */
	public AbsViewHolder setImageBitmap(int viewId, Bitmap bm,ViewGroup.LayoutParams mParams) {
		ImageView view = getView(viewId,mParams);
		view.setImageBitmap(bm);
		return this;
	}
	
	/** 
	* @Title: setImageBitmap 
	* @Description: (这里用一句话描述这个方法的作用)
	* @param viewId
	* @param bm
	* @return
	* @return ViewHolder    返回类型 
	*/
	public AbsViewHolder setImageBitmap(int viewId, Bitmap bm) {
		return setImageBitmap(viewId, bm, null);
	}



	public int getPosition() {
		return mPosition;
	}

}
