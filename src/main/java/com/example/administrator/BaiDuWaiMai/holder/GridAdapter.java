package com.example.administrator.BaiDuWaiMai.holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.BaiDuWaiMai.Bean.GridIcon;
import com.example.administrator.BaiDuWaiMai.Bean.Info;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/4 0004.
 */
public class GridAdapter extends RecyclerView.Adapter<GridHolder> {

    GridHolder mGridHolder;
    LayoutInflater mInflater;
    List<GridIcon> IconInfo;

    public GridAdapter(List<GridIcon> gridInfo) {
        this.IconInfo=gridInfo;

    }


    @Override
    public GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = mInflater.from(UiUtils.getContext()).inflate(R.layout.grid_item, parent, false);
        mGridHolder = new GridHolder(view,IconInfo);
        return mGridHolder;
    }

    @Override
    public void onBindViewHolder(GridHolder holder, int position) {
        holder.setdata(holder,position);
    }

    @Override
    public int getItemCount() {
        return IconInfo.size();
    }


}
