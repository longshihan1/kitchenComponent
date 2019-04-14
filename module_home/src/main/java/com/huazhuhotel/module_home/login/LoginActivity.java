package com.huazhuhotel.module_home.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.utils.UserInfo;
import com.huazhuhotel.module_home.widget.LoadingDialog;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView;
    /**
     * LOGIN
     */
    private TextView mLayoutLogintv;
    /**
     * SIGN UP
     */
    private TextView mLayoutRegistertv;
    private View mLayoutLoginline;
    private View mLayoutRegisterline;
    /**
     * PHONE number
     */
    private EditText mLayoutLoginPhonetv;
    /**
     * PASSWORD
     */
    private EditText mLayoutLoginPasswordtv;
    /**
     * USER NAME
     */
    private EditText mLayoutLoginNametv;
    /**
     * Forget PASSWORD?
     */
    private TextView mLayoutLoginForgettv;
    /**
     * LOGIN
     */
    private TextView mLayoutLoginLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mLayoutLogintv = (TextView) findViewById(R.id.layout_logintv);
        mLayoutLogintv.setOnClickListener(this);
        mLayoutRegistertv = (TextView) findViewById(R.id.layout_registertv);
        mLayoutRegistertv.setOnClickListener(this);
        mLayoutLoginline = (View) findViewById(R.id.layout_loginline);
        mLayoutRegisterline = (View) findViewById(R.id.layout_registerline);
        mLayoutLoginPhonetv = (EditText) findViewById(R.id.layout_login_phonetv);
        mLayoutLoginPasswordtv = (EditText) findViewById(R.id.layout_login_passwordtv);
        mLayoutLoginNametv = (EditText) findViewById(R.id.layout_login_nametv);
        mLayoutLoginForgettv = (TextView) findViewById(R.id.layout_login_forgettv);
        mLayoutLoginForgettv.setOnClickListener(this);
        mLayoutLoginLogin = (TextView) findViewById(R.id.layout_login_login);
        mLayoutLoginLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_logintv:
                mLayoutLoginline.setVisibility(View.VISIBLE);
                mLayoutRegisterline.setVisibility(View.INVISIBLE);
                mLayoutLoginNametv.setVisibility(View.GONE);
                mLayoutLoginForgettv.setVisibility(View.VISIBLE);
                break;
            case R.id.layout_registertv:
                mLayoutLoginline.setVisibility(View.INVISIBLE);
                mLayoutRegisterline.setVisibility(View.VISIBLE);
                mLayoutLoginForgettv.setVisibility(View.GONE);
                mLayoutLoginNametv.setVisibility(View.VISIBLE);
                break;
            case R.id.layout_login_forgettv:
                //忘记密码
                break;
            case R.id.layout_login_login:
                if (mLayoutRegisterline.getVisibility() == View.VISIBLE) {//注册

                } else if (mLayoutLoginline.getVisibility() == View.VISIBLE) {//登陆
                    if (!TextUtils.isEmpty(mLayoutLoginPhonetv.getText()) && "18321783767".equals(mLayoutLoginPhonetv.getText().toString())
                            && !TextUtils.isEmpty(mLayoutLoginPasswordtv.getText()) && "123456".equals(mLayoutLoginPasswordtv.getText().toString())) {
                        LoadingDialog.Builder loadBuilder = new LoadingDialog.Builder(this)
                                .setMessage("登陆中...")
                                .setCancelable(true)
                                .setCancelOutside(true);
                        LoadingDialog dialog = loadBuilder.create();
                        dialog.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                UserInfo.setUserINFO();
                                Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }, 2000);
                    } else {
                        LoadingDialog.Builder loadBuilder = new LoadingDialog.Builder(this)
                                .setMessage("登陆中...")
                                .setCancelable(true)
                                .setCancelOutside(true);
                        LoadingDialog dialog = loadBuilder.create();
                        dialog.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(LoginActivity.this, "手机号码或密码错误", Toast.LENGTH_SHORT).show();
                            }
                        }, 2000);
                    }
                }
                break;
            default:
                break;
        }
    }
}
