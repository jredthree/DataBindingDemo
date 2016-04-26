package com.red.databindingdemo;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.adapters.ListenerUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

/**
 * 作者：ZQH
 * 时间：2016/4/25
 * 邮箱：redthree3333@gmail.com
 */
public class SwipeRefreshBindingAdapters {

    @BindingAdapter("refreshing")
    public static void setRefreshing(SwipeRefreshLayout view, boolean refreshing) {

        if (refreshing != view.isRefreshing()) {
            view.setRefreshing(refreshing);
        }
    }

    @InverseBindingAdapter(attribute="refreshing")
    public static boolean isRefreshing(SwipeRefreshLayout view) {
        //不返回false 会一直是true
        return false;
    }

    @BindingAdapter(value = {"onRefreshListener", "refreshingAttrChanged"}, requireAll = false)
    public static void setOnRefreshListener(final SwipeRefreshLayout view,
                                            final OnRefreshListener listener,
                                            final InverseBindingListener refreshingAttrChanged) {
        OnRefreshListener newValue = new OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (listener != null) {
                    listener.onRefresh();
                }
                if (refreshingAttrChanged != null) {
                    refreshingAttrChanged.onChange();
                }
            }
        };

       OnRefreshListener oldValue = ListenerUtil.trackListener(view, newValue, R.id.onRefreshListener);
        if (oldValue != null) {
            view.setOnRefreshListener(null);
        }
        view.setOnRefreshListener(newValue);
    }

}
