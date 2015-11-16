package com.example.administrator.BaiDuWaiMai.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.BaiDuWaiMai.R;

/**
 * Created by Administrator on 2015/9/28 0028.
 */
public class TabIndicatorView extends RelativeLayout {
    private ImageView ivTabIcon;
    private TextView tvTabHint;
    private int focusId = -1, normalId = -1;

    private int IconID;


    public TabIndicatorView(Context context) {
        this(context, null);
    }

    public TabIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 将布局文件和 代码进行绑定
        View.inflate(context, R.layout.tab_indicator, this);

        ivTabIcon = (ImageView) findViewById(R.id.tab_indicator_icon);
        tvTabHint = (TextView) findViewById(R.id.tab_indicator_hint);
        //设置默认图标
    }

    /*设置图标*/
    public void setTabIcon(int focusId, int normalId) {
        this.normalId = normalId;
        this.focusId = focusId;
    }
    /*设置文字*/
    public void setTabText(String string) {
        tvTabHint.setText(string);
    }



    // 设置选中
    public void setTabSelected(boolean selected) {
        if (selected) {
            ivTabIcon.setImageResource(focusId);
        } else {
            ivTabIcon.setImageResource(normalId);
        }
    }

//    // 设置未读数
//    public void setTabUnreadCount(int unreadCount) {
//        if (unreadCount <= 0) {
//            tvTabUnRead.setVisibility(View.GONE);
//        } else {
//            if (unreadCount <= 99) {
//                tvTabUnRead.setText(unreadCount + "");
//            } else {
//                tvTabUnRead.setText("99+");
//            }
//
//            tvTabUnRead.setVisibility(View.VISIBLE);
//        }
//    }


}
