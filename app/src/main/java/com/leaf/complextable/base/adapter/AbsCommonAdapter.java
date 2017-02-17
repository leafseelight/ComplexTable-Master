package com.leaf.complextable.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.leaf.complextable.AppContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbsCommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutId;
    protected AppContext app;

    public AbsCommonAdapter(Context context, int itemLayoutId, AppContext app) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mItemLayoutId = itemLayoutId;
        this.app = app;
        mDatas = new ArrayList<T>();
    }

    public AbsCommonAdapter(Context context, int itemLayoutId) {
        this(context, itemLayoutId, null);
    }

    public void addItemData(T mBean, boolean isRefresh) {

        mDatas.add(mBean);
        if (isRefresh) {
            notifyDataSetChanged();
        }
    }

    public void addItemData(T mBean, int index, boolean isRefresh) {

        mDatas.add(index, mBean);
        if (isRefresh) {
            notifyDataSetChanged();
        }
    }

    public void addItemData(Collection<? extends T> mCommonbeans, int index, boolean isRefresh) {

        mDatas.addAll(index, mCommonbeans);
        if (isRefresh) {
            notifyDataSetChanged();
        }
    }

    public void addItemData(Collection<? extends T> mCommonbeans, boolean isRefresh) {

        mDatas.addAll(mCommonbeans);
        if (isRefresh) {
            notifyDataSetChanged();
        }
    }

    public void addData(List<T> mCommonbeans, boolean isMore) {

        if (isMore) {
            if (mCommonbeans != null) {

                mDatas.addAll(mCommonbeans);
            }
        } else {

            mDatas.clear();
            if (mCommonbeans != null) {
                mDatas.addAll(mCommonbeans);
            }
        }
        notifyDataSetChanged();
    }

    public void remove(int pos) {
        if (mDatas != null && mDatas.size() > 0) {
            mDatas.remove(pos);
            notifyDataSetChanged();
        }
    }

    public void clearData(boolean clear) {
        if (clear) {
            if (mDatas != null && mDatas.size() > 0) {
                mDatas.clear();
                notifyDataSetChanged();
            }
        }
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        if(mDatas!= null &&position>=0&&position<=(mDatas.size()-1)){
            return mDatas.get(position);
        }
        return null ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final AbsViewHolder viewHolder = getViewHolder(
                position, convertView, parent
        );
        convert(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();

    }

    public abstract void convert(AbsViewHolder helper, T item, int pos);

    private AbsViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return AbsViewHolder.get(
                mContext, convertView, parent, mItemLayoutId, position
        );
    }

    public List<T> getDatas() {
        return mDatas;
    }

}
