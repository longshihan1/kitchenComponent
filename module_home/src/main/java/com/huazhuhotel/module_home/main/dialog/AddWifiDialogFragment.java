package com.huazhuhotel.module_home.main.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;

/**
 * Created by LONGHE001.
 *
 * @time 2019/4/17 0017
 * @des
 * @function
 */

public class AddWifiDialogFragment extends DialogFragment implements View.OnClickListener {

    private View view;
    TextView mDialogWifiTitle;
    EditText mDialogWifiPwd;
    TextView mDialogWifiOk;
    TextView mDialogWifiCancel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.control_dialogwifi, container);
        this.mDialogWifiTitle = (TextView) view.findViewById(R.id.dialog_wifi_title);
        this.mDialogWifiPwd = (EditText) view.findViewById(R.id.dialog_wifi_pwd);
        this.mDialogWifiOk = (TextView) view.findViewById(R.id.dialog_wifi_ok);
        this.mDialogWifiCancel = (TextView) view.findViewById(R.id.dialog_wifi_cancel);
        initListener();
        return view;
    }

    private void initListener() {
        mDialogWifiOk.setOnClickListener(this);
        mDialogWifiCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialog_wifi_ok:
                if (!TextUtils.isEmpty(mDialogWifiPwd.getText())){
                    if (listener!=null){
                        dismiss();
                        listener.onSuccessClick();
                    }
                }
                break;
            case R.id.dialog_wifi_cancel:
                dismiss();
                break;
        }
    }
    private OnDialogListener listener;

    public void setListener(OnDialogListener listener) {
        this.listener = listener;
    }

    public interface OnDialogListener{
        void onSuccessClick();
    }
}
