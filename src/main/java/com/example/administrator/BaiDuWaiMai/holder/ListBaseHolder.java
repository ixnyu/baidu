package com.example.administrator.BaiDuWaiMai.holder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.BaiDuWaiMai.Base.BaseHolder;
import com.example.administrator.BaiDuWaiMai.Bean.Info;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;


public class ListBaseHolder extends BaseHolder<Info> {
	ImageView item_icon;
	TextView item_title;
	//初始化视图
	@Override
	public View initView() {
		View contentView =View.inflate(UiUtils.getContext(), R.layout.home_rcyview_item,null);
		this.item_icon = (ImageView) contentView.findViewById(R.id.home_item_iv);
		this.item_title = (TextView) contentView.findViewById(R.id.home_item_tv);
		return contentView;
	}

	@Override
	public void refreshView(Info info) {
		this.item_title.setText(info.getName());
		this.item_icon.setImageResource(info.getIcon());
	}

}
