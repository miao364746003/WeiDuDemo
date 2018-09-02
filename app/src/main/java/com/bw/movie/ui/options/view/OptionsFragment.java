package com.bw.movie.ui.options.view;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.mvpbase.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OptionsFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.genernal_tool_bar_title)
    TextView genernalToolBarTitle;

    @Override
    protected void initView(View view) {
        //initToolbar
        Toolbar toolbar = initToolbar(R.id.frg_options_toolBar, R.string.options_title);
        genernalToolBarTitle.setText(R.string.options_title);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    protected int provideLayoutId() {
        return R.layout.fragment_options;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
