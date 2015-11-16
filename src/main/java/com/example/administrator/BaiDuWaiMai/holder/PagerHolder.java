package com.example.administrator.BaiDuWaiMai.holder;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.BaiDuWaiMai.Base.BaseHolder;
import com.example.administrator.BaiDuWaiMai.Bean.TestViewPagerInfo;
import com.example.administrator.BaiDuWaiMai.Bean.ViewPagerInfo;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;
import android.widget.LinearLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/5 0005.
 */
public class PagerHolder extends BaseHolder {
    protected static final int[] VIEW_PAGER_ICONS = new int[]{
            R.mipmap.viewpage1, R.mipmap.viewpager2, R.mipmap.viewpager3};
    protected static final String[] TITLES = new String[]{"肯德基宅急送","百度钱包用就返","包贝尔来啦"};
    private ViewPager viewPager;
    private TextView tv_intro;
    private LinearLayout dot_layout;
    private int icon;
    private String title;
    private  List<TestViewPagerInfo> mInfo;
    @Override
    public View initView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.test_viewpager,null);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tv_intro = (TextView) view.findViewById(R.id.tv_intro);
        dot_layout = (LinearLayout)view.findViewById(R.id.dot_layout);
        initListener();
        initData();
        return view;
    }

    private void initData() {
        mInfo = new ArrayList<>();
        mInfo=getmInfo();
        initDots();
        viewPager.setAdapter(new MyPagerAdapter());
        updateIntroAndDot();

    }

    //  初始化 标点
    private void initDots() {
        for (int i = 0; i < mInfo.size(); i++) {
            View view = new View(UiUtils.getContext());

            LayoutParams params = new LayoutParams(UiUtils.dip2px(10), UiUtils.dip2px(10));
            if(i!=0){
                //设置标点的边距
                params.leftMargin = UiUtils.dip2px(6);
            }
            //设置标点大小
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_dot);
            dot_layout.addView(view);
        }
    }

    private void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                LogUtils.w( "position: " + position);
                updateIntroAndDot();
            }
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /**
     * 更新文本
     */
    private void updateIntroAndDot(){
        //取摸  如5%5 =0  , 6%5=1 , 7%5=2.
        int currentPage = viewPager.getCurrentItem()%mInfo.size();//获取当前页
        //将文本内容改成当前页内容
        tv_intro.setText(mInfo.get(currentPage).getName());
        //修正标点位置与文本内容对其
        for (int i = 0; i < dot_layout.getChildCount(); i++) {
            dot_layout.getChildAt(i).setEnabled(i==currentPage);
        }
    }
    @Override
    public void refreshView(Object o) {

    }

    class MyPagerAdapter extends PagerAdapter {

        /**
         * 返回多少page
         */
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        /**
         * true: 表示不去创建，使用缓存  false:去重新创建
         * view： 当前滑动的view
         * object：将要进入的新创建的view，由instantiateItem方法创建
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        /**
         * 类似于BaseAdapger的getView方法
         * 用了将数据设置给view
         * 由于它最多就3个界面，不需要viewHolder
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(UiUtils.getContext(), R.layout.viewpager_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);

            TestViewPagerInfo ad = mInfo.get(position%mInfo.size());
            imageView.setImageResource(ad.getIcon());

            container.addView(view);//一定不能少，将view加入到viewPager中

            return view;
        }

        /**
         * 销毁page
         * position： 当前需要消耗第几个page
         * object:当前需要消耗的page
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//			super.destroyItem(container, position, object);
            container.removeView((View) object);
        }



    }





    public List<TestViewPagerInfo> getmInfo(){
        List<TestViewPagerInfo> list  = new ArrayList<>();
        for (int i=0; i<VIEW_PAGER_ICONS.length ;i++){
            icon = VIEW_PAGER_ICONS[i];
            title = TITLES[i];
            TestViewPagerInfo mInfo = new TestViewPagerInfo(title,icon);
            list.add(mInfo);
            LogUtils.w("minfo---------------"+mInfo.getName());
        }
        return list;
    }
}
