package com.glg.easyloading;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.glg.easyloading.lib.EasyLoading;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyLoading.showLoading();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        EasyLoading.dismissLoading();
                    }
                },3000);

            }
        });
    }
}