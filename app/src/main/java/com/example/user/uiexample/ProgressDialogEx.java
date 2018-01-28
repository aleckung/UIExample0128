package com.example.user.uiexample;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ProgressDialogEx extends AppCompatActivity {

    int nowProgressStatus;
    Handler myHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressdialog);

        final ProgressDialog dialog02 = new ProgressDialog(this);
        dialog02.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog02.setMessage("讀取中...");
        dialog02.show();

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (nowProgressStatus < 100) {
                    try{ Thread.sleep(500);}
                    catch (InterruptedException e) {  e.printStackTrace();      }
                    nowProgressStatus += 2;
                    myHandler.post(new Runnable() {
                        public void run() { dialog02.setProgress(nowProgressStatus);}
                    });
                }
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                      dialog02.cancel();
                        Toast.makeText(ProgressDialogEx.this, "任務完成!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        thread02.start();
    }
}
