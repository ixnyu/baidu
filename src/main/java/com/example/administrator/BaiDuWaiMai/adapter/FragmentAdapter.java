package com.example.administrator.BaiDuWaiMai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.BaiDuWaiMai.Activity.HomeActivity;
import com.example.administrator.BaiDuWaiMai.Fragment.DingDanFragment;
import com.example.administrator.BaiDuWaiMai.Fragment.HomeFragment;
import com.example.administrator.BaiDuWaiMai.Fragment.MeFragment;
import com.example.administrator.BaiDuWaiMai.Fragment.EatFragment;

public class FragmentAdapter extends FragmentPagerAdapter{
	public final static int TAB_COUNT = 4;
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int id) {
		switch (id) {

		case HomeActivity.TAB_HOME:
			HomeFragment homeFragment = new HomeFragment();
			return homeFragment;
		case HomeActivity.TAB_RANK:
			EatFragment eatFragment = new EatFragment();
			return eatFragment;
		case HomeActivity.TAB_DINGDAN:
			DingDanFragment dingDanFragment = new DingDanFragment();
			return dingDanFragment;
		case HomeActivity.TAB_ME:
			MeFragment meFragment = new MeFragment();
			return meFragment;

		}
		return null;
	}

	@Override
	public int getCount() {
		return TAB_COUNT;
	}
}
