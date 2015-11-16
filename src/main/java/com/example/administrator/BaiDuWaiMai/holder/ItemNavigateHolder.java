package com.example.administrator.BaiDuWaiMai.holder;

import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.BaiDuWaiMai.Base.BaseHolder;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;

/**
 * Created by Administrator on 2015/10/4 0004.
 */
public class ItemNavigateHolder extends BaseHolder implements View.OnClickListener {
    RelativeLayout mRelativeLayou_1, mRelativeLayou_2;

    @Override
    public View initView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.home_navigate, null);
        mRelativeLayou_1 = (RelativeLayout) view.findViewById(R.id.item_navigate1);
        mRelativeLayou_2 = (RelativeLayout) view.findViewById(R.id.item_navigate2);
        mRelativeLayou_1.setOnClickListener(this);
        mRelativeLayou_2.setOnClickListener(this);
        return view;
    }

    @Override
    public void refreshView(Object o) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_navigate1:
                UiUtils.showToast("热销菜品被点击了");
                break;
            case R.id.item_navigate2:
                UiUtils.showToast("超市被点击了");
                break;
        }
    }
}