package com.mgtv.nunaios.tabimpl;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mgtv.tv.base.core.fragment.DesktopFragment;
import com.mgtv.tv.base.core.fragment.PageEntry;

/**
 * NunaiTestFragment Copyright by MGTV.COM in TabinsertDemo
 * Created by liyaoyan on 2019/2/27 10:33.
 * Email:helloalvin@163.com
 * Modify time:
 * 备注：
 */

public class NunaiTabDemoFragment extends DesktopFragment {

    private String TAG = NunaiTabDemoFragment.class.getSimpleName();

    private View tv1, tv2, tv3, tv4;

    private boolean dispatchKey = true;

    @Override
    public View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.layout_nunai_tab_demo_fragment, container, false);
        initView();
        setContentView(mRootView);
        return mRootView;
    }

    private void initView() {
        tv1 = mRootView.findViewById(R.id.testTv1);
        tv2 = mRootView.findViewById(R.id.testTv2);
        tv3 = mRootView.findViewById(R.id.testTv3);
        tv4 = mRootView.findViewById(R.id.testTv4);


        ((TextView)tv1).setText("隐藏TabBar");
        ((TextView)tv2).setText("显示TabBar");
        ((TextView)tv3).setText("获取当前TabId");

        ((TextView)tv4).setText(dispatchKey?"处理按键":"不处理按键");

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallback!=null){
                    mCallback.onHiddenNavigate();
                }
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(mCallback!=null){
                        mCallback.onShowNavigate();
                    }
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"getChannelId:"+getPageEntry().getChannelId(),Toast.LENGTH_LONG).show();
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchKey = !dispatchKey;
                ((TextView)tv4).setText(dispatchKey?"处理按键":"不处理按键");
            }
        });
    }


    @Override
    public PageEntry getPageEntry() {
        PageEntry pageEntry = super.getPageEntry();
        return pageEntry==null?new PageEntry():pageEntry;
    }

    @Override
    public boolean isNeedRefresh() {
        return super.isNeedRefresh();
    }

    @Override
    public void fetchInternetData() {
        super.fetchInternetData();
    }

    @Override
    public void onPageEnter() {
        super.onPageEnter();
        Log.i(TAG, "onPageEnter:" + getPageEntry().getDataType().name());
    }

    @Override
    public void onPageLeave() {
        super.onPageLeave();
        Log.i(TAG, "onPageLeave");
    }


    @Override
    public void enterDesktop() {
        Log.i(TAG, "enterDesktop");
    }

    @Override
    public void exitDesktop() {
        Log.i(TAG, "exitDesktop");
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i(TAG, "dispatchKeyEvent:" + event.getKeyCode());
        return dispatchKey;
    }

}
