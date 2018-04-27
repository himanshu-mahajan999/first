package com.it.himanshu.crudsqllite;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Himanshu on 06/02/2018.
 */

public class MyService extends Service {

    private static final String TAG = "HelloService";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
        Log.v("ab", "Service onCreate");

        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.v("ab", "Service onStartCommand");
        Toast.makeText(this, "Service onStartCommand", Toast.LENGTH_SHORT).show();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    try {
                        while (isRunning){
                            for (int is = 0 ; isRunning ; is++) {
                                Thread.sleep(6000);
                                Log.v("ab", "Service running");
                                //         Toast.makeText(MyService.this, "Service onStartCommand12", 10*100).show();
                            }
                        }
                    } catch (Exception e) {
                    }


                }
                stopSelf();
            }
        }).start();

        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent arg0) {
        Log.v("ab", "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {

        isRunning = false;

        Log.v("ab", "Service onDestroy");
        Toast.makeText(this, "Service ", Toast.LENGTH_SHORT).show();
    }

}
/*
    private boolean isRunning  = false;
    @Override
    public void onCreate() {
        //Log.i(TAG, "Service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        isRunning  = true;

            loop(true);
        this.stopSelf();
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        //Log.i(TAG, "Service onBind");
        return null;
    }
    public void loop(boolean b)
    {
        for (int i = 0 ; b ; i++)
        {
            Log.v("ab","ab");
            Toast.makeText(MyService.this,"vv",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loop(true);
      //  Log.i(TAG, "Service onDestroy");
    }*/

//Log.i(TAG, "Service onStartCommand");

       /* for (int i = 0; i < 3; i++)
        {
            Toast.makeText(MyService.this,"hh11",Toast.LENGTH_SHORT).show();
            long endTime = System.currentTimeMillis() ;
            while (System.currentTimeMillis() == endTime) {
                synchronized (this) {
                    try {
                        wait(10000);
                        Toast.makeText(MyService.this,"hh",Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                }
            }
          //  Log.i(TAG, "Service running");
        }*/


   /* private static final String TAG = "HelloService";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(MyService.this,"Service Start",Toast.LENGTH_SHORT).show();

        while (isRunning)
        {
            loop();
        }
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }
    @Override
    public void onDestroy() {
        Toast.makeText(MyService.this,"Service Destroy",Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Service onDestroy");
    }
    public void loop()
    {
        for (int i = 0 ; i<5 ; i++)
        {
            Toast.makeText(MyService.this,"vv",Toast.LENGTH_SHORT).show();
        }
    }*/
/*
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //getting systems default ringtone
        player = MediaPlayer.create(this,
                Settings.System.DEFAULT_RINGTONE_URI);
        //setting loop play to true
        //this will make the ringtone continuously playing
        player.setLooping(true);

        //staring the player
        player.start();

        //we have some options for service
        //start sticky means service will be explicity started and stopped
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //stopping the player when service is destroyed
        player.stop();
    }*/


/*new Thread(new Runnable() {
            @Override
            public void run() {


                //Your logic that service will perform will be placed here
                //In this example we are just looping and waits for 1000 milliseconds in each loop.
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        Toast.makeText(MyService.this,i,Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }

                    if(isRunning){
                        Log.i(TAG, "Service running");
                    }
                }

                //Stop service once it finishes its task
                stopSelf();
            }
        }).start();*/