package com.red.databindingdemo.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;


/**
 * 作者：ZQH
 * 时间：2016/4/25
 * 邮箱：redthree3333@gmail.com
 */
public class MyViewModel extends BaseObservable {


    public final ObservableBoolean swipeRefreshViewRefreshing = new ObservableBoolean(false);


    public void load() {
        swipeRefreshViewRefreshing.set(true);

        //网络执行

        swipeRefreshViewRefreshing.set(false);

    }

    public OnRefreshListener onRefreshListener() {
        return new OnRefreshListener() {
            @Override
            public void onRefresh() {
                load();
            }
        };
    }

}
