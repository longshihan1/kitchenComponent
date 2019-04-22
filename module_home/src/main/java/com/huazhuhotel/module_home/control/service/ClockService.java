package com.huazhuhotel.module_home.control.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.huazhuhotel.module_home.utils.BrocastConstances;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.orhanobut.logger.Logger;

public class ClockService extends Service {
    public static final String CLOCK_SERVICE_ACTION="clock_service_actoin";
    private boolean controllOpt=true;
    private int time=0;
    private String TAG=ClockService.class.getSimpleName();
    public ClockService() { }
    @Override
    public void onCreate(){
        Logger.d("onCreate");
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(CLOCK_SERVICE_ACTION);
        //在service中注册广播（serviceController）,接受来自ClockActivity中
        //的广播信息，实现对计时服务的控制（暂停、继续）
        super.registerReceiver(serviceController,intentFilter);
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        time = intent.getIntExtra(IntentContancts.TIME,0);
        Logger.d("onStartCommand");
        controllOpt=true;
        countTime();//执行计时功能
        return Service.START_STICKY;
    }
    //实现计时功能，每隔一秒减少总时间并ClockActivity发送广播
    private void countTime(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(BrocastConstances.CLOCK_ACTION);
                while(controllOpt){
                    try {
                        Thread.sleep(1000);
                        if(time<=0){
                            sendBroadcast(intent);
                            stopSelf();
                            break;
                        }
                        time-=1000;
                        intent.getIntExtra(IntentContancts.COUNTTIME,time);
                        sendBroadcast(intent);
                        if (time<=0){
                            //播放震动
                            Log.d(TAG,"结束");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    //广播接受者，接受来自ClockActivity的广播以便暂停、继续、停止广播
    private BroadcastReceiver serviceController=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String method=intent.getStringExtra("method");
            switch (method){
                case "pause":
                    controllOpt=false;
                    break;
                case "continue":
                    controllOpt=true;
                    countTime();
                    break;
                case "stop":
                    controllOpt=false;
                    stopSelf();
                    break;
            }
        }
    };
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onDestroy(){
        super.unregisterReceiver(serviceController);
    }
}