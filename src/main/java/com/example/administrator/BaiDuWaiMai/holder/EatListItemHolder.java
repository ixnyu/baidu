package com.example.administrator.BaiDuWaiMai.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.BaiDuWaiMai.Base.BaseHolder;
import com.example.administrator.BaiDuWaiMai.Bean.StoreInfo;
import com.example.administrator.BaiDuWaiMai.R;
import com.example.administrator.BaiDuWaiMai.tools.LogUtils;
import com.example.administrator.BaiDuWaiMai.tools.UiUtils;

/**
 * Created by Administrator on 2015/10/6 0006.
 */
public class EatListItemHolder extends BaseHolder<StoreInfo> {
    ImageView item_first_icon, item_second_icon, item_third_icon;
    TextView item_title, item_des, item_firsttitle, item_secondtitle, item_thirdtitle, item_firsprice, item_secondprice, item_thirdprice;
    RatingBar item_ratingbar;

    @Override
    public View initView() {
        View contentView = View.inflate(UiUtils.getContext(), R.layout.eat_list_item, null);
        item_first_icon = (ImageView) contentView.findViewById(R.id.eat_list_item_firsticon);
        item_second_icon = (ImageView) contentView.findViewById(R.id.eat_list_item_secondicon);
        item_third_icon = (ImageView) contentView.findViewById(R.id.eat_list_item_thirdticon);
        item_title = (TextView) contentView.findViewById(R.id.eat_list_item_title);
        item_des = (TextView) contentView.findViewById(R.id.eat_list_item_des);
        item_firsttitle = (TextView) contentView.findViewById(R.id.eat_list_item_firsttitle);
        item_secondtitle = (TextView) contentView.findViewById(R.id.eat_list_item_secondtitle);
        item_thirdtitle = (TextView) contentView.findViewById(R.id.eat_list_item_thirdtitle);
        item_firsprice = (TextView) contentView.findViewById(R.id.eat_list_item_firstprice);
        item_secondprice = (TextView) contentView.findViewById(R.id.eat_list_item_secondprice);
        item_thirdprice = (TextView) contentView.findViewById(R.id.eat_list_thirdprice);
        item_ratingbar = (RatingBar) contentView.findViewById(R.id.eat_list_item_rating);

        return contentView;
    }

    @Override
    public void refreshView(StoreInfo storeInfo) {
        LogUtils.w("StoreInfoTitle=" + storeInfo.getTitle() + "firstPrice" + storeInfo.getFirstprice());
        item_title.setText(storeInfo.getTitle());
        item_des.setText(storeInfo.getDes());
        item_ratingbar.setRating(storeInfo.getRatingbar());
        item_firsprice.setText("￥"+storeInfo.getFirstprice());
        LogUtils.w("item_firsprice=" + item_firsprice.getText());

//        item_firsprice.setTextColor(UiUtils.getResource().getColor(R.color.color1));
        item_firsttitle.setText(storeInfo.getFirsttitle());
        item_first_icon.setImageResource(storeInfo.getFirsticon());
        item_secondtitle.setText(storeInfo.getSecondtitle());
        item_second_icon.setImageResource(storeInfo.getSecondicon());

        item_secondprice.setText("￥" + storeInfo.getSecondprice());
        item_thirdtitle.setText(storeInfo.getThirdtitle());
        item_third_icon.setImageResource(storeInfo.getThirdicon());
        item_thirdprice.setText("￥" + storeInfo.getThirdprice());



    }


}
