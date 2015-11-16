package com.example.administrator.BaiDuWaiMai.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.BaiDuWaiMai.Bean.GridIcon;
import com.example.administrator.BaiDuWaiMai.R;

import java.util.List;

/**
 * Created by Administrator on 2015/10/4 0004.
 */
public class GridHolder extends RecyclerView.ViewHolder {
    TextView icontv;
    ImageView iconiv;
    List<GridIcon> mIconInfo;

    public GridHolder(View itemView, List<GridIcon> gridInfo) {
        super(itemView);
        this.mIconInfo = gridInfo;
        icontv = (TextView) itemView.findViewById(R.id.grid_item_icon_iv);
        iconiv = (ImageView) itemView.findViewById(R.id.grid_item_icon_iv);


    }

    public void setdata(GridHolder holder, int position) {
        holder.iconiv.setImageResource(mIconInfo.get(position).getIcon());
        holder.icontv.setText(mIconInfo.get(position).getName());
    }
}
