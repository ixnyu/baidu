package com.example.administrator.BaiDuWaiMai.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.example.administrator.BaiDuWaiMai.Base.BaseFragment;
import com.example.administrator.BaiDuWaiMai.Bean.Info;

import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.View.DividerItemDecoration;
import com.example.administrator.BaiDuWaiMai.View.LoadingPage;


import com.example.administrator.BaiDuWaiMai.adapter.ListBaseAdapter;
import com.example.administrator.BaiDuWaiMai.holder.GridHolder;
import com.example.administrator.BaiDuWaiMai.holder.ItemGridNavigateHolder;
import com.example.administrator.BaiDuWaiMai.holder.ItemNavigateHolder;
import com.example.administrator.BaiDuWaiMai.holder.ItemSelectHolder;
import com.example.administrator.BaiDuWaiMai.holder.PagerHolder;
import com.example.administrator.BaiDuWaiMai.manager.ThreadManager;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;
import com.example.administrator.BaiDuWaiMai.tools.ViewUtils;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/28 0028.
 */
public class HomeFragment extends BaseFragment {

    private ListView mListView;
    //虚拟数据
    //虚拟店名
    private static final String[] TITLE = new String[]{"鸡排大亨", "茶之道", "回味面馆", "水果巴巴", "肯德基", "谷谷丰登", "拓荣牛肉面馆", "鸡排风云",
            "必胜客", "鼎红面馆"};
    //虚拟图标
    protected static final int[] ICONS = new int[]{
            R.mipmap.home_item_list1, R.mipmap.home_item_list2, R.mipmap.home_item_list3, R.mipmap.list4,
            R.mipmap.list4, R.mipmap.list6, R.mipmap.list7, R.mipmap.list8,
            R.mipmap.list9, R.mipmap.list10};
    private int mCount = ICONS.length;

    //下拉刷新的数据
    private static final String[] NEW_TITLE = new String[]{"好味道酸辣粉", "一米香", "这一家", "林记", "鸡排风云", "青草吃补店", "港式奶茶", "好事来",
            "什么鬼", "比萨"};
    protected static final int[] NEW_ICONS = new int[]{
            R.mipmap.new_list1, R.mipmap.new_list2, R.mipmap.new_list3, R.mipmap.new_list4,
            R.mipmap.new_list5, R.mipmap.new_list6, R.mipmap.new_list7, R.mipmap.new_list8,
            R.mipmap.new_list9, R.mipmap.new_list10};


    private String title;
    private Integer icon;
    private List<Info> list;
    private List<Info> refreshdata;
    private CircleRefreshLayout mCircleRefreshLayout;


    /**
     * 当Fragment挂载的activity创建的时候调用
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show(); //为了使第一次加载HomeFragment的时候可以正常显示 执行以下shouw方法.

    }

    /**
     * load方法执行后才调用此方法
     *
     * @return
     */
    @Override
    public View createSuccessView() {

        View view = View.inflate(UiUtils.getContext(), R.layout.home_detail, null);
        //数据封装进对象 添加到集合中
        list = new ArrayList<>();
        for (int i = 0; i < mCount; i++) {
            title = TITLE[i];
            icon = ICONS[i];
            Info info = new Info(title, icon);
            list.add(info);
            LogUtils.w("info------" + info.getName() + "------" + info.getIcon());
        }

        refreshdata = new ArrayList<>();
        for (int i = 0; i < mCount; i++) {
            title = NEW_TITLE[i];
            icon = NEW_ICONS[i];
            Info info = new Info(title, icon);
            refreshdata.add(info);
            LogUtils.w("info------" + info.getName() + "------" + info.getIcon());
        }
        //重新设置下EditText 的宽高 兼容适配
        setEditTextWidth(view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mCircleRefreshLayout = (CircleRefreshLayout) view.findViewById(R.id.refresh_layout);
        mListView = (ListView) view.findViewById(R.id.home_listview);
        final ListBaseAdapter adapter = new ListBaseAdapter(list, mListView) {
            //加载更多回调 在此添加数据
            @Override
            protected List<Info> onload() {
                return list;
            }

            //下拉刷新的回调. 在此添加数据
            @Override
            protected List<Info> refreshData() {

                return refreshdata;
            }
        };
        //添加Viewpager 导航
        PagerHolder mPagerHolder = new PagerHolder();
//        ViewPagerHolder mViewPagerHolder = new ViewPagerHolder();
        //添加GridView导航
        ItemGridNavigateHolder mItemGridNavigateHolder = new ItemGridNavigateHolder();
        //添加热销菜品导航
        ItemNavigateHolder mItemNavigateHolder = new ItemNavigateHolder();
        //添加分类导航
        ItemSelectHolder mSelectHolder = new ItemSelectHolder();
        mListView.addHeaderView(mPagerHolder.getContentView(),null,true); // 选这个构造方法的原因是, 为true的话 此item可以拥有自己的点击事件

//        mListView.addHeaderView(mViewPagerHolder.getContentView(),null,true);
        mListView.addHeaderView(mItemGridNavigateHolder.getContentView(),null,true);
        mListView.addHeaderView(mItemNavigateHolder.getContentView(), null, true);
        mListView.addHeaderView(mSelectHolder.getContentView(), null, true);

        mListView.setAdapter(adapter);

        mCircleRefreshLayout.setOnRefreshListener(
                new CircleRefreshLayout.OnCircleRefreshListener() {
                    @Override
                    public void refreshing() {
                        // do something  when refresh starts
                        UiUtils.showToast("下拉刷新");
                        LogUtils.w("下拉刷新");
                        adapter.refreshData(mCircleRefreshLayout);

                    }

                    @Override
                    public void completeRefresh() {

                        // do something when refresh complete
                        UiUtils.showToast("completeRefresh");
                        LogUtils.w("completeRefresh");
                    }
                });

    }

    /**
     * 从此方法里获取数据,传递给createSuccessView,让其显示具体布局
     *
     * @return
     */
    @Override
    protected LoadingPage.LoadResult load() {
//        AppProtocol protocol=new AppProtocol();
//        datas = protocol.load(0);
//        return checkData(datas); // 检查数据 有三种结果  成功, 错误,空
        LogUtils.w("HomeFragment load 方法执行了");
        return LoadingPage.LoadResult.success;
    }


    //兼容各类手机的适配---> 标题宽
    private void setEditTextWidth(View view) {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        //得到屏幕宽
        int width = wm.getDefaultDisplay().getWidth();
        //它的宽度等于屏幕宽减40dp
        EditText mEditText = (EditText) view.findViewById(R.id.home_et);

        mEditText.setWidth(width - UiUtils.dip2px(40));
        LinearLayout.LayoutParams mEditTextLayoutParams = (LinearLayout.LayoutParams) mEditText.getLayoutParams();
        int left = UiUtils.dip2px(20);
        int right = UiUtils.dip2px(20);
        int top = UiUtils.dip2px(5);
        int bottom = UiUtils.dip2px(5);

        mEditTextLayoutParams.setMargins(left, top, right, bottom);
        mEditText.setLayoutParams(mEditTextLayoutParams);
    }


}
