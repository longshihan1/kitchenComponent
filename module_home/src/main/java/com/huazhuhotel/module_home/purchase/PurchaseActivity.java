package com.huazhuhotel.module_home.purchase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.Gson;
import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.ui.GoodsDetailActivity;
import com.huazhuhotel.module_home.list.ui.ListActivity;
import com.huazhuhotel.module_home.mvp.model.MajorInfo;
import com.huazhuhotel.module_home.purchase.adapter.PurchaseAdapter;
import com.huazhuhotel.module_home.utils.CacheConstancts;
import com.huazhuhotel.module_home.utils.GsonUtils;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.huazhuhotel.module_home.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class PurchaseActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PurchaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        recyclerView=findViewById(R.id.purchase_recy);
        adapter=new PurchaseAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        adapter.setOnViewClick(new PurchaseAdapter.OnViewClick() {
            @Override
            public void click(String id) {
                Intent intent=new Intent(PurchaseActivity.this, GoodsDetailActivity.class);
                intent.putExtra(IntentContancts.GOODSDETAIL_VALUE,id);
                startActivity(intent);
            }

            @Override
            public void refreshData(MajorInfo info) {
                List<MajorInfo> majorInfos=new ArrayList<>();
                String majorStr= (String) SPUtils.get(PurchaseActivity.this, CacheConstancts.COOKLISTMAGJOR,"");
                if (!TextUtils.isEmpty(majorStr)){
                    majorInfos= GsonUtils.jsonToArrayList(majorStr,MajorInfo.class);
                    if (majorInfos!=null&&majorInfos.size()>0){
                        for (int i = 0; i <majorInfos.size(); i++) {
                            if (info!=null&&!TextUtils.isEmpty(info.getId())&&majorInfos.get(i)!=null&&
                            !TextUtils.isEmpty(majorInfos.get(i).getId())&&majorInfos.get(i).getId().equals(info.getId())){
                                majorInfos.get(i).setMajorBean(info.getMajorBean());
                                break;
                            }
                        }
                        adapter.setData(majorInfos);
                        Gson gson=new Gson();
                        String json= gson.toJson(majorInfos);
                        SPUtils.put(PurchaseActivity.this,CacheConstancts.COOKLISTMAGJOR,json);
                    }
                }

            }
        });
        List<MajorInfo> majorInfos=new ArrayList<>();
        String majorStr= (String) SPUtils.get(this, CacheConstancts.COOKLISTMAGJOR,"");
        if (!TextUtils.isEmpty(majorStr)){
            majorInfos= GsonUtils.jsonToArrayList(majorStr,MajorInfo.class);
            if (majorInfos!=null&&majorInfos.size()>0){
                adapter.setData(majorInfos);
            }
        }

    }
}
