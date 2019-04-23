package com.huazhuhotel.module_home.main.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.control.ControlDialogFragment;
import com.huazhuhotel.module_home.main.ui.fragment.ControlFragment;
import com.huazhuhotel.module_home.main.ui.fragment.HomeFragment;
import com.huazhuhotel.module_home.main.ui.fragment.MINEFragment;
import com.huazhuhotel.module_home.main.ui.fragment.VideoListFragment;
import com.huazhuhotel.module_home.widget.HomeNavLinearLayout;
import com.longshihan.mvpcomponent.base.BaseActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class DOUGUOActivity extends BaseActivity  implements ControlFragment.onControlClickListener,ControlDialogFragment.OnCountTimeListener{

    private FrameLayout mainFragment;
    HomeNavLinearLayout navLinearLayout;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private VideoListFragment noticeFragment;
    private ControlFragment communityFragment;
    private MINEFragment mineFragment;
    private List<Fragment> fragmentList;
    private int index=-1;
    private MyHandle handle;
    private int clockTime=0;
    public   ControlDialogFragment controlDialogFragment;



    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_douguo;
    }

    @Override
    public void initData() {
        mainFragment=findViewById(R.id.activity_mainfragment);
        navLinearLayout=findViewById(R.id.activity_mainnavlayout);

        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        noticeFragment = new VideoListFragment();
        communityFragment = new ControlFragment();
        mineFragment = new MINEFragment();

        communityFragment.setListener(this);

        fragmentList = new ArrayList<>();
        fragmentList.add(homeFragment);
        fragmentList.add(noticeFragment);
        fragmentList.add(communityFragment);
        fragmentList.add(mineFragment);
        addFragmentStack(0);

        navLinearLayout.setListener(new HomeNavLinearLayout.OnSelectListener() {
            @Override
            public void OnSelectView(final int index) {
                //点击了第几个
                addFragmentStack(index);
            }

            @Override
            public boolean OnInterceptorListener(final int index) {
                return false;
            }
        });

        handle=new MyHandle(this);
    }

    public void addFragmentStack(int position) {
        if (position == index) {
            return;
        }
        this.index = position;
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment fragment = fragmentList.get(position);
        if (!fragment.isAdded()) {
            ft.add(R.id.activity_mainfragment, fragment);
        }
        for (int i = 0; i < fragmentList.size(); i++) {
            if (i == position) {
                ft.show(fragmentList.get(i));
            } else {
                ft.hide(fragmentList.get(i));
            }
        }
        ft.commitAllowingStateLoss();

        if (position == 0) {

        } else if (position == 1) {

        } else if (position == 2) {

        }else if (position==3){
//            startActivity(new Intent(this, AttentionActivity.class));
        }
    }
    @Override
    public boolean useFragment() {
        return true;
    }


    @Override
    public void onClickContriol() {
        controlDialogFragment=new ControlDialogFragment();
        controlDialogFragment.setListener(this);
        controlDialogFragment.show(getFragmentManager(),ControlDialogFragment.class.getSimpleName());
    }

    @Override
    public void onStartTime(int time) {
        clockTime=time;
        handle.sendEmptyMessageDelayed(2,1000);
    }

    @Override
    public void onPauseTime() {
        handle.setIntercept(true);
    }

    @Override
    public void onResumeTime() {
        handle.setIntercept(false);
    }

    @Override
    public void onStop() {

    }

    public class MyHandle extends Handler{
        private boolean intercept;

        private WeakReference<DOUGUOActivity> douguoActivityWeakReference;

       public MyHandle(DOUGUOActivity activity) {
           douguoActivityWeakReference=new WeakReference<DOUGUOActivity>(activity);
       }

       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           if (!intercept){
               if (douguoActivityWeakReference!=null&&douguoActivityWeakReference.get()!=null
                       &&douguoActivityWeakReference.get().controlDialogFragment!=null
                       &&douguoActivityWeakReference.get().controlDialogFragment.isVisible()){
                   douguoActivityWeakReference.get().controlDialogFragment.setTime(clockTime--);
               }
           }
       }

       public void setIntercept(boolean intercept){
           this.intercept=intercept;
       }
   }
}
