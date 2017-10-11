package app.fynnjason.com.developbox.thirdview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import app.fynnjason.com.developbox.base.BaseActivity;
import app.fynnjason.com.developbox.main.MainAdapter;
import app.fynnjason.com.developbox.main.MainModel;
import app.fynnjason.com.developbox.R;
import app.fynnjason.com.developbox.databinding.ActivityThirdViewBinding;

public class ThirdViewActivity extends BaseActivity<ActivityThirdViewBinding> implements BaseQuickAdapter.OnItemClickListener {

    private MainAdapter mAdapter;
    private List<MainModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_view);
        initView();
    }

    private void initView() {
        mBinding.rvThirdview.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvThirdview.setHasFixedSize(true);
        mAdapter = new MainAdapter(mList);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setOnItemClickListener(this);
        loadData();
        mBinding.rvThirdview.setAdapter(mAdapter);
    }

    private void loadData() {
        mList.add(new MainModel(getString(R.string.name_1_1), getString(R.string.description_1_1)));
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public String getTitleName() {
        return getString(R.string.name_1);
    }
}
