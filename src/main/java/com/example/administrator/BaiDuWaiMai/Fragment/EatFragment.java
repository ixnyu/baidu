package com.example.administrator.BaiDuWaiMai.Fragment;

import android.view.View;
import android.widget.ListView;


import com.example.administrator.BaiDuWaiMai.Base.BaseFragment;
import com.example.administrator.BaiDuWaiMai.Bean.StoreInfo;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.View.LoadingPage;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/28 0028.
 */
public class EatFragment extends BaseFragment {

    private CircleRefreshLayout mCircleRefreshLayout;
    private ListView mListView;
    private String title;
    private String des;
    private float ratingbar;
    private String firstprice;
    private String secondprice;
    private String thirdprice;
    private String firsttitle;
    private String secondtitle;
    private String thirdtitle;
    private int firsticon;
    private int secondicon;
    private int thirdicon;

    //数据
    private static final String[] TITLE = new String[]{"红仁小吃", "豪大大鸡排", "鸡排风云", "八百碗", "肥味烧"};
    private static final String[] DES = new String[]{"根据热门餐厅推荐", "因为你选择清单滋补变美推荐给你", "因为你选择减肥挺不来推荐给你", "根据热门餐厅推荐",
            "根据热门餐厅推荐"};
    //评价
    private static final float[] RATINGBAR = new float[]{(float) 4.5, (float) 4.8, (float) 5.0, (float) 4.5, (float) 4};

    //价格
    private static final String[] FIRSTPRICE = new String[]{"15", "13", "8","20" , "35"};
    private static final String[] SECONDPRICE = new String[]{"25", "9", "12", "8", "11"};
    private static final String[] THIRDPRICE = new String[]{"10", "15", "5", "10", "15"};

    //标题
    private static final String[] FIRSTTITLE = new String[]{"扬州炒饭", "豪大大鸡排", "香酥鱿鱼", "溜溜肉", "干拌牛肉片"};
    private static final String[] SECONDTTITLE = new String[]{"鸡块套餐饭", "香酥鸡排", "盐鸡块", "酸菜肉饭", "鸡排套装"};
    private static final String[] THIRDTITLE = new String[]{"麻辣烫", "香酥鸡块", "凤爪", "炒竹笋", "牛肉面"};


    //虚拟图标
    protected static final int[] FIRSTICONS = new int[]{
            R.mipmap.hongren01, R.mipmap.haodada01, R.mipmap.jipaifengyun01, R.mipmap.babaiwan01, R.mipmap.feiweishao01
    };
    //虚拟图标
    protected static final int[] SECONDICONS = new int[]{
            R.mipmap.hongren02, R.mipmap.haodada02, R.mipmap.jipaifengyun02, R.mipmap.babaiwan02, R.mipmap.feiweishao02
    };
    //虚拟图标
    protected static final int[] THIRDICONS = new int[]{
            R.mipmap.hognren03, R.mipmap.haodada03, R.mipmap.jipaifengyun03, R.mipmap.babaiwan03, R.mipmap.feiweishao03
    };
    private int mCount = TITLE.length;
    private  List<StoreInfo> mStoreInfo;

    @Override
    public View createSuccessView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.eat_home, null);
        initView(view);
        return view;
    }


    private void initView(View view) {
        mCircleRefreshLayout = (CircleRefreshLayout) view.findViewById(R.id.eat_fra_refresh);
        mListView = (ListView) view.findViewById(R.id.eat_fra_listview);
        mStoreInfo =getStroInfo();

        final EatFragmentAdapter eatFragmentAdapter = new EatFragmentAdapter(mStoreInfo, mListView) {
            //*加载更多数据/
            @Override
            protected List<StoreInfo> onload() {
                return mStoreInfo;
            }

            //下拉刷新数据*/
            @Override
            protected List<StoreInfo> refreshData() {

                return getStroInfo();
            }
        };
        mListView.setAdapter(eatFragmentAdapter);
        mCircleRefreshLayout.setOnRefreshListener(
                new CircleRefreshLayout.OnCircleRefreshListener() {
                    @Override
                    public void refreshing() {
                        // do something  when refresh starts
                        UiUtils.showToast("下拉刷新");
                        LogUtils.w("下拉刷新");
                        eatFragmentAdapter.refreshData(mCircleRefreshLayout);

                    }

                    @Override
                    public void completeRefresh() {

                        // do something when refresh complete
                        UiUtils.showToast("completeRefresh");
                        LogUtils.w("completeRefresh");
                    }
                });

    }


    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.success;
    }


    public List<StoreInfo> getStroInfo() {
        List<StoreInfo> list = new ArrayList<>();

        for (int i = 0; i < mCount; i++) {
            title = TITLE[i];
            des = DES[i];
            ratingbar = RATINGBAR[i];
            firstprice = FIRSTPRICE[i];
            firsticon=FIRSTICONS[i];
            firsttitle=FIRSTTITLE[i];
            secondicon =SECONDICONS[i];
            secondprice= SECONDPRICE[i];
            secondtitle=SECONDTTITLE[i];
            thirdicon=THIRDICONS[i];
            thirdprice=THIRDPRICE[i];
            thirdtitle=THIRDTITLE[i];
            StoreInfo storeInfo = new StoreInfo(title, des, ratingbar, firstprice, secondprice, thirdprice,
                    secondtitle, firsttitle, thirdtitle, firsticon, secondicon, thirdicon);
            list.add(storeInfo);
            LogUtils.w("info------" + storeInfo.getTitle() + "------" + storeInfo.getFirstprice());
        }


        return list;
    }
}
