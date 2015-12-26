package com.dcbd.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.dcbd.R;
import com.dcbd.activity.mainfragment.FragmentMap;
import com.dcbd.activity.mainfragment.FragmentMe;
import com.dcbd.activity.mainfragment.FragmentTopics;
import com.dcbd.base.BaseActivity;

/**
 * 主界面MainActivity
 */
public class MainActivity extends BaseActivity {

    private Button[] mTabs;
    private FragmentMap fragmentMap;
    private FragmentMe fragmentMe;
    private FragmentTopics fragmentTopics;

    private Fragment[] fragments;
    /**
     * 点击的界面
     */
    private int index;
    /**
     * 当前的界面
     */
    private int currentTabIndex;


    @Override
    public void setContentView(Bundle savedInstanceState) {
        mactivityview = minflater.inflate(R.layout.activity_main, null);
    }

    @Override
    public void findViews() {

        initView();

    }

    @Override
    public void addListener() {

    }

    @Override
    public void initData() {

    }

    /**
     * 初始化组件
     */
    private void initView() {
        mTabs = new RadioButton[3];
        mTabs[0] = (RadioButton) findViewById(R.id.radio_map);
        mTabs[1] = (RadioButton) findViewById(R.id.radio_topics);
        mTabs[2] = (RadioButton) findViewById(R.id.radio_me);
        // 把第一个tab设为选中状态
        mTabs[0].setSelected(true);

        fragmentMap = new FragmentMap();
        fragmentTopics = new FragmentTopics();
        fragmentMe = new FragmentMe();

        fragments = new Fragment[]{fragmentMap, fragmentTopics,
                fragmentMe};
        // 添加显示第一个fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragmentMap)
                .add(R.id.fragment_container, fragmentTopics)
                .add(R.id.fragment_container, fragmentMe)
                .hide(fragmentMe)
                .hide(fragmentTopics)
                .show(fragmentMap).commit();

        mTabs[currentTabIndex].setTextColor(this.getResources().getColor(
                R.color.red));
    }

    /**
     * RadioButton点击事件
     *
     * @param view
     */
    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_map:
                index = 0;
                break;
            case R.id.radio_topics:
                index = 1;
                break;
            case R.id.radio_me:
                index = 2;
                break;
        }
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager()
                    .beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        mTabs[currentTabIndex].setSelected(false);
        mTabs[currentTabIndex].setTextColor(this.getResources().getColor(
                R.color.black));
        mTabs[index].setTextColor(this.getResources().getColor(
                R.color.red));
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }
}