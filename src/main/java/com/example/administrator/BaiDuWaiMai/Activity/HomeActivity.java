package com.example.administrator.BaiDuWaiMai.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.view.View.OnClickListener;

import com.example.administrator.BaiDuWaiMai.Base.BaseActivity;

import com.example.administrator.BaiDuWaiMai.Base.BaseFragment;
import com.example.administrator.BaiDuWaiMai.Fragment.FragmentFactory;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.View.LoadingPage;
import com.example.administrator.BaiDuWaiMai.View.TabIndicatorView;
import com.example.administrator.BaiDuWaiMai.adapter.FragmentAdapter;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;


public class HomeActivity extends BaseActivity implements OnClickListener {
    public static final int TAB_HOME = 0;
    public static final int TAB_RANK = 1;
    public static final int TAB_DINGDAN = 2;
    public static final int TAB_ME = 3;

    private ViewPager mViewPager;
    private String[] tab_names;  // 标签的名字
    //4个radiobutton
    private RadioButton mHomeButton;
    private RadioButton mEatButton;
    private RadioButton mDingDanButton;
    private RadioButton mMeButton;

    public void initView() {

        setContentView(R.layout.home_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_content);
        mViewPager.setAdapter(new MainAdpater(getSupportFragmentManager()));
        //获取RadioButton对象
        mHomeButton = (RadioButton) findViewById(R.id.rb_home);
        mEatButton = (RadioButton) findViewById(R.id.rb_eat);
        mDingDanButton = (RadioButton) findViewById(R.id.rb_dingdan);
        mMeButton = (RadioButton) findViewById(R.id.rb_me);
        //设置监听
        mHomeButton.setOnClickListener(this);
        mEatButton.setOnClickListener(this);
        mDingDanButton.setOnClickListener(this);
        mMeButton.setOnClickListener(this);
        mViewPager.setAdapter(new MainAdpater(getSupportFragmentManager()));
        mViewPager.setCurrentItem(0);//设置当前viewpager位置为首页
        mHomeButton.setChecked(true);
        BaseFragment HomeFragment= FragmentFactory.createFragment(0);
        HomeFragment.show();
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BaseFragment createFragment = FragmentFactory.createFragment(position);
                LogUtils.w("通过HomeActivity 执行了了shou方法");
                createFragment.show();//
            }

        });
        //获取loadingpage对象


    }

    public void init() {
        tab_names = new String[]{"首页", "吃啥", "订单", "我的"};
    }

    // RadionButton 点击事件
    @Override
    public void onClick(View v) {
        if (v.getId() == mHomeButton.getId()) {
            mViewPager.setCurrentItem(0, true);//是否平滑

        } else if (v.getId() == mEatButton.getId()) {
            mViewPager.setCurrentItem(1, true);//是否平滑
        } else if (v.getId() == mDingDanButton.getId()) {
            mViewPager.setCurrentItem(2, true);//是否平滑
        } else if (v.getId() == mMeButton.getId()) {
            mViewPager.setCurrentItem(3, true);//是否平滑
        }


    }



    private class MainAdpater extends FragmentPagerAdapter {
        public MainAdpater(FragmentManager fm) {
            super(fm);
        }

        // 每个条目返回的fragment
        @Override
        public Fragment getItem(int position) {
            //  通过Fragment工厂  生产Fragment
            LogUtils.w("通过Fragment工厂 生产Fragment 当前position:" + position);
            BaseFragment fragment = FragmentFactory.createFragment(position);

                return fragment;

        }

        // 一共有几个条目
        @Override
        public int getCount() {
            return tab_names.length;
        }

        // 返回每个条目的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return tab_names[position];
        }
    }
    //获取HomeFragment

}





