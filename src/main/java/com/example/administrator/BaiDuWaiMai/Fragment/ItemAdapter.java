package com.example.administrator.BaiDuWaiMai.Fragment;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.BaiDuWaiMai.Bean.Info;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.manager.ThreadManager;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

import java.util.List;

/**
 * Created by Administrator on 2015/10/4 0004.
 */
public class ItemAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private List<Info> Infolist;
    private String title;
    private Integer icon;
    private ListView lv;
    private static final int DEFAULT_ITEM = 0;
    private static final int MORE_ITEM = 1;
    //下拉刷新的数据
    private static final String[] NEW_TITLE = new String[]{"好味道酸辣粉", "一米香", "这一家", "林记", "鸡排风云", "青草吃补店", "港式奶茶", "好事来",
            "什么鬼", "比萨"};
    protected static final int[] NEW_ICONS = new int[]{
            R.mipmap.new_list1, R.mipmap.new_list2, R.mipmap.new_list3, R.mipmap.new_list4,
            R.mipmap.new_list5, R.mipmap.new_list6, R.mipmap.new_list7, R.mipmap.new_list8,
            R.mipmap.new_list9, R.mipmap.new_list10};

    public ItemAdapter(List<Info> list, ListView lv) {
        this.Infolist = list;
        //设置点击事件
        lv.setOnItemClickListener(this);
        this.lv = lv;
    }


    /*下拉刷新*/
    public void refreshdata(final CircleRefreshLayout mCircleRefreshLayout) {
        //请求数据
        ThreadManager.getInstance().createLongPool().execute(new Runnable() {

            @Override
            public void run() {
                SystemClock.sleep(1000);
                Infolist.clear();
//                ArrayList<Info> newInfo = new ArrayList<>();
                for (int i = 0; i < NEW_TITLE.length; i++) {
                    title = NEW_TITLE[i];
                    icon = NEW_ICONS[i];
                    Info info = new Info(title, icon);
                    Infolist.add(info);
                    LogUtils.w("info------" + info.getName() + "------" + info.getIcon());
                }
                //数据请求完毕.主线程中进行UI操作

                UiUtils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtils.w("Listsize" + Infolist.size());
                        mCircleRefreshLayout.finishRefreshing();
                        notifyDataSetChanged();
                    }
                });
            }
        });
    }


    // ListView 条目点击事件回调的方法
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        //Toast.makeText(UiUtils.getContext(), "position:"+position, 0).show();
        position = position - lv.getHeaderViewsCount();// 获取到顶部条目的数量   位置去掉顶部view的数量
        onInnerItemClick(position);
    }

    /**
     * 在该方法去处理条目的点击事件
     */
    public void onInnerItemClick(int position) {

    }

    @Override
    public int getCount() {
        return Infolist.size();
    }

    @Override
    public Object getItem(int position) {
        return Infolist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * 根据位置 判断当前条目是什么类型
     */
    @Override
    public int getItemViewType(int position) {  //20
        if (position + 1 == Infolist.size() + 1) { // 当前是最后一个条目
            return MORE_ITEM;
        }
        return getInnerItemViewType(position); // 如果不是最后一个条目 返回默认类型
    }

    protected int getInnerItemViewType(int position) {
        return DEFAULT_ITEM;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {  // 判断当前条目时什么类型
            case MORE_ITEM:
                if(convertView==null){
//                    convertView = View.inflate(UiUtils.getContext(),R.layout.)
                }else {

                }
                break;
            default:
                ViewHolder viewHolder = null;
                if (convertView == null) {
                    convertView = View.inflate(UiUtils.getContext(), R.layout.home_rcyview_item, null);
                    viewHolder = new ViewHolder();
                    viewHolder.mTextView = (TextView) convertView
                            .findViewById(R.id.home_item_tv);
                    viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.home_item_iv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.mTextView.setText(Infolist.get(position).getName());
                viewHolder.mImageView.setImageResource(Infolist.get(position).getIcon());
                return convertView;


        }
        return null;
    }

    private final class ViewHolder {
        TextView mTextView;
        ImageView mImageView;
    }
}
