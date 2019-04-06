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

import cn.jzvd.Jzvd;

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

        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                Jzvd jzvd = view.findViewById(R.id.item_video_player);
                if (jzvd != null && Jzvd.CURRENT_JZVD != null &&
                        jzvd.jzDataSource.containsTheUrl(Jzvd.CURRENT_JZVD.jzDataSource.getCurrentUrl())) {
                    if (Jzvd.CURRENT_JZVD != null && Jzvd.CURRENT_JZVD.currentScreen != Jzvd.SCREEN_WINDOW_FULLSCREEN) {
                        Jzvd.resetAllVideos();
                    }
                }
            }
        });
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter=new VideoPersenter(this,appComponent.repositoryManager());
    }

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.resetAllVideos();
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
