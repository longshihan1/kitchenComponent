package com.huazhuhotel.module_home.main.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.main.adapter.HomeAdapter;
import com.huazhuhotel.module_home.main.adapter.VideoAdapter;
import com.huazhuhotel.module_home.main.persenter.DOUGUOContract;
import com.huazhuhotel.module_home.main.persenter.DOUGUOMANINPersenter;
import com.huazhuhotel.module_home.main.persenter.VideoContract;
import com.huazhuhotel.module_home.main.persenter.VideoPersenter;
import com.huazhuhotel.module_home.mvp.model.VideoListInfo;
import com.huazhuhotel.module_home.utils.UserInfo;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.di.component.AppComponent;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoListFragment extends BaseMVPFragment<VideoPersenter> implements VideoContract.View{

    private RecyclerView recyclerView;
    private VideoAdapter adapter;
    private int pageIndex=0;

    public VideoListFragment() {
        // Required empty public constructor
    }


    @Override
    public void getVideoInfo(VideoListInfo info) {
        if (info!=null&&info.getResult()!=null&&info.getResult().getVideo_list()!=null){
            adapter.setListData(info.getResult().getVideo_list());
        }
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
             return inflater.inflate(R.layout.fragment_video_list, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        recyclerView=mRootview.findViewById(R.id.video_recy);

        adapter=new VideoAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        mPresenter.getVideoInfo(UserInfo.getUserId(),pageIndex);
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter=new VideoPersenter(this,appComponent.repositoryManager());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(int type, String message) {

    }

    @Override
    public void closeActivity() {

    }
}
