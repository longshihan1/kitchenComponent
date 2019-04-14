package com.huazhuhotel.module_home.main.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailContract;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailPersenter;
import com.huazhuhotel.module_home.attention.ui.AttentionActivity;
import com.huazhuhotel.module_home.collect.ui.CollectionActivity;
import com.huazhuhotel.module_home.login.LoginActivity;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;
import com.huazhuhotel.module_home.purchase.PurchaseActivity;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class MINEFragment extends BaseMVPFragment<AttentionDetailPersenter> implements AttentionDetailContract.View, View.OnClickListener {

    private ImageView mMineImg;
    private TextView mMineName;
    private TextView mMinePhone;
    private ImageView mMineRight;
    private LinearLayout mMimeCaipu;
    private LinearLayout mMimeNote;
    private LinearLayout mMimeAtten;
    private LinearLayout mMineCollection;
    private LinearLayout mMineRecentlook;
    private LinearLayout mMineBuy;
    private LinearLayout mMineWork;
    private RelativeLayout nologin_rl;
    private LinearLayout login_ll;
    private TextView caipuCountTv, NoteCountTv, attenCountTv,goLogin;

    public MINEFragment() {
        // Required empty public constructor
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

    @Override
    public void getUserInfo(UserInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getUser() != null) {
            UserInfo.ResultBean.UserBean userBean = info.getResult().getUser();
            mMineName.setText(userBean.getNick());
            if (!TextUtils.isEmpty(userBean.getMobile())) {
                mMinePhone.setText(userBean.getMobile());
            } else {
                mMinePhone.setText(userBean.getAge());
            }
            caipuCountTv.setText("" + userBean.getRecipes_count());

            attenCountTv.setText("" + userBean.getFavorites_count());
            NoteCountTv.setText("" + userBean.getNotes_count());
            ArmsUtils.getImageLoader(mActivity)
                    .loadImage(mActivity, ImageConfigImpl.builder()
                            .url(userBean.getUser_photo())
                            .imageView(mMineImg)
                            .transformation(new CenterCrop())
                            .build());

        }
    }

    @Override
    public void getUnRecipesListInfo(UnRecipesListInfo info) {

    }

    @Override
    public void getUserNoteListInfo(UserNoteInfo info) {
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mMineImg = (ImageView) mRootview.findViewById(R.id.mine_img);
        mMineName = (TextView) mRootview.findViewById(R.id.mine_name);
        mMinePhone = (TextView) mRootview.findViewById(R.id.mine_phone);
        mMineRight = (ImageView) mRootview.findViewById(R.id.mine_right);
        mMineRight.setOnClickListener(this);
        mMimeCaipu = (LinearLayout) mRootview.findViewById(R.id.mime_caipu);
        mMimeCaipu.setOnClickListener(this);
        mMimeNote = (LinearLayout) mRootview.findViewById(R.id.mime_note);
        mMimeNote.setOnClickListener(this);
        mMimeAtten = (LinearLayout) mRootview.findViewById(R.id.mime_atten);
        mMimeAtten.setOnClickListener(this);
        mMineCollection = (LinearLayout) mRootview.findViewById(R.id.mine_collection);
        mMineCollection.setOnClickListener(this);
        mMineRecentlook = (LinearLayout) mRootview.findViewById(R.id.mine_recentlook);
        mMineRecentlook.setOnClickListener(this);
        mMineBuy = (LinearLayout) mRootview.findViewById(R.id.mine_buy);
        mMineBuy.setOnClickListener(this);
        mMineWork = (LinearLayout) mRootview.findViewById(R.id.mine_work);
        mMineWork.setOnClickListener(this);
        caipuCountTv = (TextView) mRootview.findViewById(R.id.mime_caipu_count);
        NoteCountTv = (TextView) mRootview.findViewById(R.id.mime_note_count);
        attenCountTv = (TextView) mRootview.findViewById(R.id.mime_atten_count);
        goLogin=mRootview.findViewById(R.id.mine_nologin_gologin);
        nologin_rl = mRootview.findViewById(R.id.mine_nologinrl);
        login_ll = mRootview.findViewById(R.id.mine_loginll);
        if (!TextUtils.isEmpty(com.huazhuhotel.module_home.utils.UserInfo.getUserId())) {
            login_ll.setVisibility(View.VISIBLE);
            nologin_rl.setVisibility(View.GONE);
            mPresenter.getUserInfo(com.huazhuhotel.module_home.utils.UserInfo.getUserId());
        } else {
            login_ll.setVisibility(View.GONE);
            nologin_rl.setVisibility(View.VISIBLE);
        }

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, LoginActivity.class));
            }
        });
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter = new AttentionDetailPersenter(this, appComponent.repositoryManager());
    }


    @Override
    public void onClick(View v) {
        if (!TextUtils.isEmpty(com.huazhuhotel.module_home.utils.UserInfo.getUserId())) {
            switch (v.getId()) {
                default:
                    break;
                case R.id.mine_right:
                    break;
                case R.id.mime_caipu:
                    break;
                case R.id.mime_note:
                    break;
                case R.id.mime_atten:
                    startActivity(new Intent(mActivity, AttentionActivity.class));
                    break;
                case R.id.mine_collection:
                    startActivity(new Intent(mActivity, CollectionActivity.class));
                    break;
                case R.id.mine_recentlook:
                    break;
                case R.id.mine_buy:
                    startActivity(new Intent(mActivity, PurchaseActivity.class));
                    break;
                case R.id.mine_work:
                    break;
            }
        } else {
            Toast.makeText(mActivity, "暂未登陆", Toast.LENGTH_SHORT).show();
        }
    }
}
