package com.example.administrator.BaiDuWaiMai.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.administrator.BaiDuWaiMai.Base.BaseFragment;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.View.LoadingPage;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;

/**
 * Created by Administrator on 2015/9/28 0028.
 */
public class DingDanFragment extends BaseFragment {

    @Override
    public View createSuccessView() {
        View view = View.inflate(UiUtils.getContext(),R.layout.layout,null);
        TextView tv= (TextView) view.findViewById(R.id.detail_tv);
        tv.setText("我是dingdan啊");
        LogUtils.w("DingDanFragment加载了");
        return view;
    }

    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.success;
    }
}
