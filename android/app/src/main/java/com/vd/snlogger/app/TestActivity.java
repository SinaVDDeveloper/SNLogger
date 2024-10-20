package com.vd.snlogger.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vd.snlogger.SNLogger;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    private Button mBtn1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_layout);

        mBtn1 = findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mBtn1) {
                    SNLogger.i(DemoLogT.DEMO_LOG_T, "测试日志");
                }
            }
        });
    }
}
