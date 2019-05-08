package com.huazhuhotel.module_home.control;

import android.app.DialogFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.control.service.ClockService;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.huazhuhotel.module_home.widget.CustomCircleProgressBar;

import static com.huazhuhotel.module_home.utils.BrocastConstances.CLOCK_ACTION;

/**
 * Created by LONGHE001.
 *
 * @time 2019/4/18 0018
 * @des
 * @function
 */

public class ControlDialogFragment extends DialogFragment implements View.OnClickListener {

    private View view;
    private CustomCircleProgressBar mControlProgress;
    private TextView mControlProgressTxt;
    private ImageView mControlProgressImg;
    /**
     * 上下火
     */
    private TextView mControlModel1;
    /**
     * 30分钟
     */
    private TextView mControlModel2;
    /**
     * 100
     */
    private TextView mControlModel3;

    /**
     * 关闭
     */
    private TextView mControlModel4;

    /**
     * 开始
     */
    private TextView mControlStart;
    /**
     * 关闭
     */
    private TextView mControlStop;

    private AlertDialog alertDialog1; //信息框
    private AlertDialog alertDialog2; //信息框
    private AlertDialog alertDialog3; //信息框
    private AlertDialog alertDialog4; //信息框
    private int countTime = 30 * 60;
    private boolean isWarn = false;


    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Window win = getDialog().getWindow();
        // 一定要设置Background，如果不设置，window属性设置无效
        win.setBackgroundDrawable( new ColorDrawable(getResources().getColor(R.color.white)));

        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );

        android.view.WindowManager.LayoutParams params = win.getAttributes();
        params.gravity = Gravity.BOTTOM;
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width =  ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        win.setAttributes(params);

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_control, container, false);
        initView();
        return view;
    }


    private void initView() {
        mControlProgress = (CustomCircleProgressBar) view.findViewById(R.id.control_progress);
        mControlProgressTxt = (TextView) view.findViewById(R.id.control_progress_txt);
        mControlProgressImg = (ImageView) view.findViewById(R.id.control_progress_img);
        mControlModel1 = (TextView) view.findViewById(R.id.control_model1);
        mControlModel1.setOnClickListener(this);
        mControlModel2 = (TextView) view.findViewById(R.id.control_model2);
        mControlModel2.setOnClickListener(this);
        mControlModel3 = (TextView) view.findViewById(R.id.control_model3);
        mControlModel3.setOnClickListener(this);
        mControlStart = (TextView) view.findViewById(R.id.control_start);
        mControlStart.setOnClickListener(this);
        mControlStop = (TextView) view.findViewById(R.id.control_stop);
        mControlStop.setOnClickListener(this);
        mControlModel4 = view.findViewById(R.id.control_model4);
        mControlModel4.setOnClickListener(this);
        Bundle bundle = getArguments();
        if (bundle != null) {
           countTime= bundle.getInt(ControlDialogFragment.class.getSimpleName(),30*60);
           //{"30秒", "1min", "5min", "10min", "20min", "30min", "40min", "50min", "1h", "1h30min", "2h", "2h30min", "3h"}
           if (countTime+1==30){
               mControlModel2.setText("30秒");
           }else if (countTime+1==60){
               mControlModel2.setText("1min");
           }else if (countTime+1==5*60){
               mControlModel2.setText("5min");
           }else if (countTime+1==10*60){
               mControlModel2.setText("10min");
           }else if (countTime+1==20*60){
               mControlModel2.setText("20min");
           }else if (countTime+1==30*60){
               mControlModel2.setText("30min");
           }else if (countTime+1==40*60){
               mControlModel2.setText("40min");
           }else if (countTime+1==50*60){
               mControlModel2.setText("50min");
           }else if (countTime+1==60*60){
               mControlModel2.setText("1h");
           }else if (countTime+1==90*60){
               mControlModel2.setText("1h30min");
           }else if (countTime+1==120*60){
               mControlModel2.setText("2h");
           }else if (countTime+1==150*60){
               mControlModel2.setText("2h30min");
           }else if (countTime+1==180*60){
               mControlModel2.setText("3h");
           }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.control_model1:
                //4D热风、顶部加热、底部加热、风焙烤、风扇烤、焙烤、烧烤、预热
                final String[] items = {"4D热风", "顶部加热", "底部加热", "风焙烤", "风扇烤", "焙烤", "烧烤", "预热"};
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
                alertBuilder.setTitle("模式");
                alertBuilder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mControlModel1.setText(items[i]);
                        alertDialog1.dismiss();
                    }
                });
                alertDialog1 = alertBuilder.create();
                alertDialog1.show();

                break;
            case R.id.control_model2:
                //30s,1,5，10，20，30，40，50，1h。。。间隔10分钟，最长3h
                final String[] items2 = {"30秒", "1min", "5min", "10min", "20min", "30min", "40min", "50min", "1h", "1h30min", "2h", "2h30min", "3h"};
                AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(getActivity());
                alertBuilder2.setTitle("烘焙时间");
                alertBuilder2.setItems(items2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mControlModel2.setText(items2[i]);
                        alertDialog2.dismiss();
                        switch (i) {
                            case 0:
                                countTime = 30-1;
                                mControlProgressTxt.setText("30秒");
                                break;
                            case 1:
                                countTime = 60-1;
                                mControlProgressTxt.setText("1min");
                                break;
                            case 2:
                                countTime = 5 * 60-1;
                                mControlProgressTxt.setText("5min");
                                break;
                            case 3:
                                countTime = 10 * 60-1;
                                mControlProgressTxt.setText("10min");
                                break;
                            case 4:
                                countTime = 20 * 60-1;
                                mControlProgressTxt.setText("20min");
                                break;
                            case 5:
                                countTime = 30 * 60-1;
                                mControlProgressTxt.setText("30min");
                                break;
                            case 6:
                                countTime = 40 * 60-1;
                                mControlProgressTxt.setText("40min");

                                break;
                            case 7:
                                countTime = 50 * 60-1;
                                mControlProgressTxt.setText("50min");

                                break;
                            case 8:
                                countTime = 60 * 60-1;
                                mControlProgressTxt.setText("1h");

                                break;
                            case 9:
                                countTime = 90 * 60-1;
                                mControlProgressTxt.setText("1h30min");

                                break;
                            case 10:
                                countTime = 120 * 60-1;
                                mControlProgressTxt.setText("2h");

                                break;
                            case 11:
                                countTime = 150 * 60-1;
                                mControlProgressTxt.setText("2h30min");

                                break;
                            case 12:
                                countTime = 180 * 60-1;
                                mControlProgressTxt.setText("3h");

                                break;
                        }

                    }
                });
                alertDialog2 = alertBuilder2.create();
                alertDialog2.show();
                break;
            case R.id.control_model3:
                //100°-250°间隔10°
                final String[] items3 = {"100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200", "210", "220", "230", "240", "250"};
                AlertDialog.Builder alertBuilder3 = new AlertDialog.Builder(getActivity());
                alertBuilder3.setTitle("温度");
                alertBuilder3.setItems(items3, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mControlModel3.setText(items3[i]);
                        alertDialog3.dismiss();
                    }
                });
                alertDialog3 = alertBuilder3.create();
                alertDialog3.show();
                break;
            case R.id.control_model4:
                //关
                final String[] items4 = {"开", "关"};
                AlertDialog.Builder alertBuilder4 = new AlertDialog.Builder(getActivity());
                alertBuilder4.setTitle("完成提醒");
                alertBuilder4.setItems(items4, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mControlModel4.setText(items4[i]);
                        if (i == 0) {
                            isWarn = true;
                        } else {
                            isWarn = false;
                        }
                        alertDialog4.dismiss();
                    }
                });
                alertDialog4 = alertBuilder4.create();
                alertDialog4.show();
                break;
            case R.id.control_start:
                if ("暂停".equals(mControlStart.getText())) {
                    mControlStart.setText("继续");
                    if (listener!=null){
                        listener.onPauseTime();
                    }
                } else if ("继续".equals(mControlStart.getText())) {
                    mControlStart.setText("暂停");
                    if (listener!=null){
                        listener.onResumeTime();
                    }
                } else if ("开始".equals(mControlStart.getText())) {
                    mControlStart.setText("暂停");
                    if (listener!=null){
                        listener.onStartTime(countTime);
                    }
                }
                break;
            case R.id.control_stop:
                mControlStart.setText("开始");
                mControlProgress.setProgress(0);
                mControlProgressTxt.setText("30分钟");
                if (listener!=null){
                    listener.onStopTime();
                }
                break;
        }
    }

   private OnCountTimeListener listener;

    public void setListener(OnCountTimeListener listener) {
        this.listener = listener;
    }

    public interface OnCountTimeListener{
        void onStartTime(int time);
        void onPauseTime();
        void onResumeTime();
        void onStopTime();
    }

    public void setTime(int time){
        if (time<=1){
            if (listener!=null){
                listener.onStopTime();
            }
            mControlStart.setText("开始");
            mControlProgress.setProgress(0);
            mControlProgressTxt.setText("30分钟");
        }else {
            mControlStart.setText("暂停");
            float rate=(time*1.0f)/countTime;
            mControlProgress.setProgress(100-(int) (rate*100));
            if (time >= 3600) {
                int hourStr = time / 3600;
                int minStr = (time % 3600) / 60;
                int serendStr = time - hourStr * 3600 - minStr * 60;
                if (serendStr==0){
                    mControlProgressTxt.setText(hourStr + "时" + minStr + "分");
                }else {
                    mControlProgressTxt.setText(hourStr + "时" + minStr + "分" + serendStr+"秒");
                }
            } else if (time >= 60) {
                int minStr = time / 60;
                int serendStr = time - minStr * 60;
                if (serendStr==0) {
                    mControlProgressTxt.setText(minStr + "分" );
                }else {
                    mControlProgressTxt.setText(minStr + "分" + serendStr + "秒");
                }
            } else {
                mControlProgressTxt.setText(time + "秒");
            }
        }
    }
}
