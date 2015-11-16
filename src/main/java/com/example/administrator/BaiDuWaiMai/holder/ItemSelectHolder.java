package com.example.administrator.BaiDuWaiMai.holder;

import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.BaiDuWaiMai.Base.BaseHolder;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;

import static com.example.administrator.BaiDuWaiMai.R.layout.list_select;

/**
 * Created by Administrator on 2015/10/4 0004.
 */
public class ItemSelectHolder extends BaseHolder implements View.OnClickListener {
    RelativeLayout mRelativeLayou_1,mRelativeLayou_2,mRelativeLayou_3;
    @Override
    public View initView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.list_select, null);
        mRelativeLayou_1 = (RelativeLayout) view.findViewById(R.id.item_select_rll_01);
        mRelativeLayou_2 = (RelativeLayout) view.findViewById(R.id.item_select_rll_02);
        mRelativeLayou_3 = (RelativeLayout) view.findViewById(R.id.item_select_rll_03);
        mRelativeLayou_1.setOnClickListener(this);
        mRelativeLayou_2.setOnClickListener(this);
        mRelativeLayou_3.setOnClickListener(this);
        return view;
    }

    @Override
    public void refreshView(Object o) {



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_select_rll_01:
                UiUtils.showToast("分类被点击了");
                break;
            case R.id.item_select_rll_02:
                UiUtils.showToast("排序被点击了");
                break;
            case R.id.item_select_rll_03:
                UiUtils.showToast("配送被点击了");
                break;
        }
    }
}
