package com.example.administrator.BaiDuWaiMai.Fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.BaiDuWaiMai.Base.BaseHolder;
import com.example.administrator.BaiDuWaiMai.Bean.ViewPagerInfo;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/5 0005.
 */
public class ViewPagerHolder extends BaseHolder {
    private  ViewPager mViewPager;
    private List<ViewPagerInfo> mInfo;
    private int icon;
    private LinearLayout llyout;
    private CirclePageIndicator mCirclePageIndicator;

    protected static final int[] VIEW_PAGER_ICONS = new int[]{
            R.mipmap.viewpage1, R.mipmap.viewpager2, R.mipmap.viewpager3};

    @Override
    public View initView() {

        mInfo = getmInfo();
        LogUtils.w("走了");

        View view  =View.inflate(UiUtils.getContext(),R.layout.home_viewpager,null);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager_1);

        mViewPager.setAdapter(new HomeAdapter());
        mCirclePageIndicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
        mCirclePageIndicator.setViewPager(mViewPager);





        //第一种方法
//        llyout = new LinearLayout(UiUtils.getContext());
//
//       llyout.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, UiUtils.getDimens(R.dimen.home_picture_height)));
//        mViewPager = new ViewPager(UiUtils.getContext());
//       mCirclePageIndicator = new CirclePageIndicator(UiUtils.getContext());
//        mViewPager.setLayoutParams(new AbsListView.LayoutParams(
//                AbsListView.LayoutParams.MATCH_PARENT, UiUtils.getDimens(R.dimen.home_picture_height)));
//        llyout.addView(mViewPager);
//        llyout.addView(mCirclePageIndicator);
//        mViewPager.setAdapter(new HomeAdapter());
//        mCirclePageIndicator.setViewPager(mViewPager);
        return view;
    }

    @Override
    public void refreshView(Object o) {

        mViewPager.setCurrentItem(2000*mInfo.size());// 设置起始的位置   Integer.Max_Vlue/2
        mViewPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        runTask.stop();
                        break;
                    case MotionEvent.ACTION_CANCEL:  // 事件的取消
                    case MotionEvent.ACTION_UP:
                        runTask.start();
                        break;
                }

                return false; // viewPager 触摸事件 返回值要是false
            }
        });
        runTask = new AuToRunTask();
        runTask.start();
    }
    boolean flag;
    private AuToRunTask runTask;
    public class AuToRunTask implements Runnable{

        @Override
        public void run() {
            if(flag){
                UiUtils.cancel(this);  // 取消之前
                int currentItem = mViewPager.getCurrentItem();
                currentItem++;
                mViewPager.setCurrentItem(currentItem);
                //  延迟执行当前的任务
                UiUtils.postDelayed(this, 2000);// 递归调用
            }
        }
        public void start(){
            if(!flag){
                UiUtils.cancel(this);  // 取消之前
                flag=true;
                UiUtils.postDelayed(this, 2000);// 递归调用
            }
        }
        public  void stop(){
            if(flag){
                flag=false;
                UiUtils.cancel(this);
            }
        }

    }

    class HomeAdapter extends PagerAdapter {
        // 当前viewPager里面有多少个条目
        LinkedList<ImageView> convertView=new LinkedList<ImageView>();
        // ArrayList
        @Override
        public int getCount() {
            return	Integer.MAX_VALUE;
        }

        /* 判断返回的对象和 加载view对象的关系 */
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ImageView view=(ImageView) object;
            convertView.add(view);// 把移除的对象 添加到缓存集合中
            container.removeView(view);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int index=position%mInfo.size();
            ImageView view;
            if(convertView.size()>0){
                view=convertView.remove(0);
            }else{
                view= new ImageView(UiUtils.getContext());
            }
            view.setImageResource(mInfo.get(index).getIcon());
//            bitmapUtils.display(view, HttpHelper.URL + "image?name="
//                    + datas.get(index));
            container.addView(view); // 加载的view对象
            return view; // 返回的对象
        }

    }


    public List<ViewPagerInfo> getmInfo(){
        List<ViewPagerInfo> list  = new ArrayList<>();
        for (int i=0; i<VIEW_PAGER_ICONS.length ;i++){
            icon = VIEW_PAGER_ICONS[i];
            ViewPagerInfo mInfo = new ViewPagerInfo(icon);
            list.add(mInfo);
           LogUtils.w("minfo---------------"+mInfo.getIcon());
        }
        return list;
    }
}
