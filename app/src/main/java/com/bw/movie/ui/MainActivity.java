package com.bw.movie.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.mvpbase.BasePresenter;
import com.bw.movie.ui.cinema.CinemaFragment;
import com.bw.movie.ui.member.view.MemberFragment;
import com.bw.movie.ui.movie.MovieFragment;
import com.bw.movie.ui.options.view.OptionsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author BySevenGroup
 * @create 2018/8/31 15:12
 * @Description
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.act_main_beer_belly)
    FrameLayout beerBelly;
    @BindView(R.id.act_main_bottomNavigationBar)
    BottomNavigationBar navigationBar;

    //init Fragment
    MovieFragment movieFragment;
    CinemaFragment cinemaFragment;
    MemberFragment memberFragment;
    OptionsFragment optionsFragment;
    //
    private FragmentManager manager;

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {
        navigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                //每次点击切换对应一个新创建的事务，一个事务对应一个commit
                FragmentTransaction tr = manager.beginTransaction();
                //隐藏所有fragment
                HideAllFragment(tr);
                switch (position) {
                    case 0:
                        if (movieFragment.isHidden()) {
                            //如果隐藏，则显示，
                            //显示，则不做操作
                            show(tr, movieFragment);
                        }
                        break;
                    case 1:
                        if (cinemaFragment == null) {
                            addToBeerBelly(tr, cinemaFragment = new CinemaFragment());
                        } else {
                            if (cinemaFragment.isHidden()) {
                                show(tr, cinemaFragment);
                            }
                        }
                        break;
                    case 2:
                        if (memberFragment == null) {
                            addToBeerBelly(tr, memberFragment = new MemberFragment());
                        } else {
                            if (memberFragment.isHidden()) {
                                show(tr, memberFragment);
                            }
                        }
                        break;
                    case 3:
                        if (optionsFragment == null) {
                            addToBeerBelly(tr, optionsFragment = new OptionsFragment());
                        } else {
                            if (optionsFragment.isHidden()) {
                                show(tr, optionsFragment);
                            }
                        }
                        break;
                }
                tr.commit();
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initNavigationBar();
        //初始化Fragment
        initFragment();
    }

    private void initNavigationBar() {
        navigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor(R.color.colorNavRed);
        navigationBar.addItem(new BottomNavigationItem(R.drawable.img_movie_checked,"影片")
        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this,R.drawable.img_movie_nomal)))

        .addItem(new BottomNavigationItem(R.drawable.img_cinema_checked,"影院")
        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this,R.drawable.img_cinema_nomal)))

        .addItem(new BottomNavigationItem(R.drawable.img_vip_checked,"会员")
        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this,R.drawable.img_vip_nomal)))

        .addItem(new BottomNavigationItem(R.drawable.img_set_checked,"设置")
        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this,R.drawable.img_set_nomal)))

        .setFirstSelectedPosition(0)
        .initialise();
    }

    /**
     * 1、初始化碎片，并展示movie页面
     * 2、初始化rg的点击监听
     */
    private void initFragment() {
        manager = getSupportFragmentManager();
        //  准备工作完毕
        FragmentTransaction tr = manager.beginTransaction();
        //添加到头像
        addToBeerBelly(tr, movieFragment = new MovieFragment());
        tr.commit();

    }

    /**
     * @param tr
     * @param fragment
     */
    private void show(FragmentTransaction tr, Fragment fragment) {
        tr.show(fragment);
    }

    //隐藏所有fragment
    private void HideAllFragment(FragmentTransaction tr) {
        if (movieFragment != null)
            tr.hide(movieFragment);
        if (cinemaFragment != null)
            tr.hide(cinemaFragment);
        if (memberFragment != null)
            tr.hide(memberFragment);
        if (optionsFragment != null)
            tr.hide(optionsFragment);
    }

    /**
     * @param tr        //事务
     * @param //盛放碎片的容器
     * @param fragment  //碎片
     */
    private void addToBeerBelly(FragmentTransaction tr, Fragment fragment) {
        tr.add(R.id.act_main_beer_belly, fragment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

}