package com.huazhuhotel.module_home.Mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.list.adapter.SearchListAdapter;
import com.huazhuhotel.module_home.list.ui.ListActivity;
import com.huazhuhotel.module_home.mvp.model.MajorInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.huazhuhotel.module_home.utils.CacheConstancts;
import com.huazhuhotel.module_home.utils.GsonUtils;
import com.huazhuhotel.module_home.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class RecentLookActivity extends AppCompatActivity {

    private RecyclerView mRecenterRecy;
    private SearchListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_look);
        initView();
    }

    private void initView() {
        mRecenterRecy = (RecyclerView) findViewById(R.id.recenter_recy);
        adapter = new SearchListAdapter();
        mRecenterRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecenterRecy.setAdapter(adapter);
        String recentCache= (String) SPUtils.get(this, CacheConstancts.RECENTCACHE,"");
        if (!TextUtils.isEmpty(recentCache)) {
            List<SearchInfo.ResultBean.ListBean> listBeans = new ArrayList<>();
            listBeans = GsonUtils.jsonToArrayList(recentCache, SearchInfo.ResultBean.ListBean.class);
            adapter.setListData(listBeans);
        }
    }
}
