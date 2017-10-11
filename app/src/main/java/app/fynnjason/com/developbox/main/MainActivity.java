package app.fynnjason.com.developbox.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import app.fynnjason.com.developbox.R;
import app.fynnjason.com.developbox.databinding.ActivityMainBinding;
import app.fynnjason.com.developbox.thirdview.ThirdViewActivity;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemClickListener {

    private ActivityMainBinding mBinding;
    private List<MainModel> mClassifyList = new ArrayList<>();
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBinding.rvMain.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvMain.setHasFixedSize(true);
        mAdapter = new MainAdapter(mClassifyList);
        View view = getLayoutInflater().inflate(R.layout.layout_header, null);
        ImageView iv = view.findViewById(R.id.iv_header);
        Glide.with(this).load(R.drawable.ic_main_2).into(iv);
        mAdapter.addHeaderView(view);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setOnItemClickListener(this);
        loadData();
        mBinding.rvMain.setAdapter(mAdapter);
    }

    private void loadData() {
        mClassifyList.add(new MainModel(getString(R.string.name_1), getString(R.string.description_1)));
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, ThirdViewActivity.class));
                break;
        }
    }
}
