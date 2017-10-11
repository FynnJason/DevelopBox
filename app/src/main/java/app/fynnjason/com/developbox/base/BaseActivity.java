package app.fynnjason.com.developbox.base;

import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import app.fynnjason.com.developbox.R;
import app.fynnjason.com.developbox.databinding.LayoutToolbarBinding;

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 * function：Activity基类
 */

public abstract class BaseActivity<SV extends ViewDataBinding> extends AppCompatActivity {
    public SV mBinding;
    private LayoutToolbarBinding mToolbarBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mToolbarBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.layout_toolbar, null, false);
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mBinding.getRoot().setLayoutParams(params);
        RelativeLayout mContainer = mToolbarBinding.getRoot().findViewById(R.id.mContainer);
        mContainer.addView(mBinding.getRoot());
        getWindow().setContentView(mToolbarBinding.getRoot());

        initLayoutToolbar();
    }

    private void initLayoutToolbar() {
        setSupportActionBar(mToolbarBinding.mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mToolbarBinding.tvTitle.setText(getTitleName());
        mToolbarBinding.mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public abstract String getTitleName();
}
