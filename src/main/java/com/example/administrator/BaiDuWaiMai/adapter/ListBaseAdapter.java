package com.example.administrator.BaiDuWaiMai.adapter;

import java.util.List;

import android.widget.ListView;

import com.example.administrator.BaiDuWaiMai.Base.BaseHolder;
import com.example.administrator.BaiDuWaiMai.Bean.Info;
import com.example.administrator.BaiDuWaiMai.holder.ListBaseHolder;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;


public abstract class ListBaseAdapter extends DefaultAdapter<Info> {
    public ListBaseAdapter(List<Info> datas,ListView listView) {
        super(datas,listView);
    }

    @Override
    protected BaseHolder<Info> getHolder() {
        return new ListBaseHolder();
    }


    //加载更多数据 由调用者实现
    @Override
    protected abstract List<Info> onload();



    @Override
    public void onInnerItemClick(int position) {
        super.onInnerItemClick(position);
        UiUtils.showToast("position="+position);
//        AppInfo appInfo = datas.get(position);
//        Intent intent=new Intent(UiUtils.getContext(), DetailActivity.class);
//        intent.putExtra("packageName", appInfo.getPackageName());
//        UiUtils.startActivity(intent);
    }



}
