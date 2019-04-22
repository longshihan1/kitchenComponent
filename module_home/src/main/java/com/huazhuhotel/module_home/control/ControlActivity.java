package com.huazhuhotel.module_home.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.control.service.ClockService;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.huazhuhotel.module_home.widget.CustomCircleProgressBar;

import static com.huazhuhotel.module_home.utils.BrocastConstances.CLOCK_ACTION;

public class ControlActivity extends AppCompatActivity implements View.OnClickListener {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        initView();
        regReceiver();
    }

    private void initView() {
        mControlProgress = (CustomCircleProgressBar) findViewById(R.id.control_progress);
        mControlProgressTxt = (TextView) findViewById(R.id.control_progress_txt);
        mControlProgressImg = (ImageView) findViewById(R.id.control_progress_img);
        mControlModel1 = (TextView) findViewById(R.id.control_model1);
        mControlModel1.setOnClickListener(this);
        mControlModel2 = (TextView) findViewById(R.id.control_model2);
        mControlModel2.setOnClickListener(this);
        mControlModel3 = (TextView) findViewById(R.id.control_model3);
        mControlModel3.setOnClickListener(this);
        mControlStart = (TextView) findViewById(R.id.control_start);
        mControlStart.setOnClickListener(this);
        mControlStop = (TextView) findViewById(R.id.control_stop);
        mControlStop.setOnClickListener(this);
        mControlModel4 = findViewById(R.id.control_model4);
        mControlModel4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.control_model1:
                //4D热风、顶部加热、底部加热、风焙烤、风扇烤、焙烤、烧烤、预热
                final String[] items = {"4D热风", "顶部加热", "底部加热", "风焙烤", "风扇烤", "焙烤", "烧烤", "预热"};
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
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
                AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(this);
                alertBuilder2.setTitle("烘焙时间");
                alertBuilder2.setItems(items2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mControlModel2.setText(items2[i]);
                        alertDialog2.dismiss();
                        switch (i) {
                            case 0:
                                countTime = 30;
                                break;
                            case 1:
                                countTime = 60;
                                break;
                            case 2:
                                countTime = 5 * 60;
                                break;
                            case 3:
                                countTime = 10 * 60;
                                break;
                            case 4:
                                countTime = 20 * 60;
                                break;
                            case 5:
                                countTime = 30 * 60;
                                break;
                            case 6:
                                countTime = 40 * 60;
                                break;
                            case 7:
                                countTime = 50 * 60;
                                break;
                            case 8:
                                countTime = 60 * 60;
                                break;
                            case 9:
                                countTime = 90 * 60;
                                break;
                            case 10:
                                countTime = 120 * 60;
                                break;
                            case 11:
                                countTime = 150 * 60;
                                break;
                            case 12:
                                countTime = 180 * 60;
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
                AlertDialog.Builder alertBuilder3 = new AlertDialog.Builder(this);
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
                AlertDialog.Builder alertBuilder4 = new AlertDialog.Builder(this);
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
                    pause();
                } else if ("继续".equals(mControlStart.getText())) {
                    mControlStart.setText("暂停");
                    restart();
                } else if ("开始".equals(mControlStart.getText())) {
                    mControlStart.setText("暂停");
                    initStart();
                }
                break;
            case R.id.control_stop:
                mControlStart.setText("开始");
                break;
        }
    }

    private void initStart() {
        Intent intent = new Intent(this, ClockService.class);
        intent.getIntExtra(IntentContancts.TIME, countTime);
        startService(intent);//启动计时服务
    }

    private void regReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CLOCK_ACTION);
        registerReceiver(clockReceiver, intentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        super.unregisterReceiver(clockReceiver);
//        Intent intent = new Intent();
//        intent.setAction(ClockService.CLOCK_SERVICE_ACTION);
//        intent.putExtra("method", "stop");
//        super.sendBroadcast(intent);
    }


    /**
     * 广播接受者，接受来自ClockService（计时服务）的广播，ClockService每隔一秒
     * 钟发一次广播
     */
    private BroadcastReceiver clockReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int currentTime = intent.getIntExtra(IntentContancts.COUNTTIME, 0);
            mControlProgressTxt.setText("::" + currentTime);
        }
    };

    //通过发送广播，控制计时服务
    //继续计时
    public void restart() {
        Intent intent = new Intent();
        intent.setAction(ClockService.CLOCK_SERVICE_ACTION);
        intent.putExtra("method", "continue");
        super.sendBroadcast(intent);
    }

    //通过发送广播，控制计时服务
    //暂停计时
    public void pause() {
        Intent intent = new Intent();
        intent.setAction(ClockService.CLOCK_SERVICE_ACTION);
        intent.putExtra("method", "pause");
        super.sendBroadcast(intent);
    }

}
