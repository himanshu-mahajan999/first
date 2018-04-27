package com.it.himanshu.crudsqllite;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Himanshu on 26/01/2018.
 */

public class MyTask extends AsyncTask<Void,Integer,String> {
    Context context;
    TextView textView;
    Button button;
    ProgressDialog progressDialog;


    MyTask(Context context, TextView textView, Button button)
    {
        this.context = context;
        this.textView = textView;
        this.button = button;
    }

    @Override
    protected String doInBackground(Void[] objects) {

        int i = 0;

        synchronized (this)
        {

            while (i<10)
            {
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        return "download";
    }

    @Override
    protected void onPreExecute() {
     progressDialog = new ProgressDialog(context);
        progressDialog.setMax(10);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Process");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
     progressDialog.show();
    }

    @Override
    protected void onPostExecute(String cv) {
        textView.setText(cv);
   //     progressBar.hide();
    }

    @Override
    protected void onProgressUpdate(Integer[] values) {
       int mn = values[0];
        progressDialog.setProgress(mn);
    }
}
