package com.example.administrator.BaiDuWaiMai.holder;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.BaiDuWaiMai.Base.BaseHolder;
import com.example.administrator.BaiDuWaiMai.Bean.GridIcon;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.View.GridViewForListView;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/4 0004.
 */
public class ItemGridNavigateHolder extends BaseHolder {

    RecyclerView mRecyclerView;
    List<GridIcon> mGridInfo;
    private String title;
    private Integer icon;
    GridView mGridView;
    private static final String[] GRID_TITLE = new String[]{"餐饮", "超市购", "水果生鲜", "下午茶", "土豪特供", "新店", "百度配送", "夜宵"};
    protected static final int[] GRID_ICON = new int[]{
            R.mipmap.canyin, R.mipmap.shop, R.mipmap.shuiguo, R.mipmap.xiawucha,
            R.mipmap.tuhaotegong, R.mipmap.newstore, R.mipmap.baidupeisong, R.mipmap.yexiao};

    @Override
    public View initView() {

        mGridInfo = getGridInfo();
        mGridView = new GridViewForListView(UiUtils.getContext());
        mGridView.setNumColumns(4);
        mGridView.setStretchMode(mGridView.STRETCH_COLUMN_WIDTH);
        mGridView.setBackgroundColor(Color.WHITE);
        mGridView.setHorizontalSpacing(UiUtils.dip2px(10));
        mGridView.setAdapter(new GridViewAdapter(mGridInfo));
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UiUtils.showToast("当前GridView="+position);
            }
        });
        return mGridView;
        //   mRecyclerView.setLayoutManager(new GridLayoutManager(UiUtils.getContext(),4));
//        mRecyclerView.setAdapter(new GridAdapter(gridInfo));

    }

    @Override
    public void refreshView(Object o) {

    }


    public class GridViewAdapter extends BaseAdapter {
        View view;
        List<GridIcon> list;

        public GridViewAdapter(List<GridIcon> mGridInfo) {
            this.list= mGridInfo;
        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;

            if (convertView == null) {
                convertView = View.inflate(UiUtils.getContext(),R.layout.grid_item,null);
                holder = new ViewHolder();
                holder.mTextView = (TextView)convertView.findViewById(R.id.grid_item__icon_tv);
                holder.mImageView = (ImageView) convertView.findViewById(R.id.grid_item_icon_iv);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.mTextView.setText(list.get(position).getName());
            holder.mImageView.setImageResource(list.get(position).getIcon());
            return convertView;
        }
        public class ViewHolder {
            TextView mTextView;
            ImageView mImageView;


        }


    }

    //*获取数据*/
    public List<GridIcon> getGridInfo() {
        List<GridIcon> mIconInfo = new ArrayList<>();
        for (int i = 0; i < GRID_TITLE.length; i++) {
            title = GRID_TITLE[i];
            icon = GRID_ICON[i];
            GridIcon mGridIcon = new GridIcon(title, icon);
            mIconInfo.add(mGridIcon);
            LogUtils.w("info------" + mGridIcon.getName() + "------" + mGridIcon.getIcon());
        }

        return mIconInfo;
    }
}
