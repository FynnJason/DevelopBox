package app.fynnjason.com.developbox.main;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import app.fynnjason.com.developbox.R;

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 * function：主界面RecyclerView适配器
 */

public class MainAdapter extends BaseQuickAdapter<MainModel,BaseViewHolder> {
    public MainAdapter(@Nullable List<MainModel> data) {
        super(R.layout.item_main,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainModel item) {
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_description, item.getDescription());
    }
}
