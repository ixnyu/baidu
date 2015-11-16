package com.example.administrator.BaiDuWaiMai.Fragment;

import java.util.List;

import android.widget.ListView;

import com.example.administrator.BaiDuWaiMai.Base.BaseHolder;
import com.example.administrator.BaiDuWaiMai.Bean.Info;
import com.example.administrator.BaiDuWaiMai.Bean.StoreInfo;
import com.example.administrator.BaiDuWaiMai.adapter.DefaultAdapter;
import com.example.administrator.BaiDuWaiMai.holder.EatListItemHolder;
import com.example.administrator.BaiDuWaiMai.holder.ListBaseHolder;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;


public abstract class EatFragmentAdapter extends DefaultAdapter<StoreInfo> {
    public EatFragmentAdapter(List<StoreInfo> datas,ListView listView) {
        super(datas,listView);
    }

    @Override
    protected BaseHolder<StoreInfo> getHolder() {
        return new EatListItemHolder();
    }


    //加载更多数据 由调用者实现
    @Override
    protected abstract List<StoreInfo> onload();



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
