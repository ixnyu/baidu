package com.example.administrator.BaiDuWaiMai.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by Administrator on 2015/10/4 0004.
 */
public class GridViewForListView extends GridView {
    public GridViewForListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewForListView(Context context) {
        super(context);
    }

    public GridViewForListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = View.MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}