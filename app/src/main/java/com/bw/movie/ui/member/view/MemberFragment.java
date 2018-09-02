package com.bw.movie.ui.member.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.mvpbase.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemberFragment extends BaseFragment {

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        //initToolbar
        initToolbar(R.id.frg_member_toolBar, R.string.member_title);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_member;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
