package com.vd.snlogger.app

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.vd.snlogger.SNLogger.i

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity_layout)

        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener(View.OnClickListener {
            if (it === btn1) {
                i("测试日志1")
                i(DemoLogT.DEMO_LOG_T, "测试日志")
                i(DemoLogT.DEMO_LOG_T, Exception("abc"), "测试日志")
                i(DemoLogT.DEMO_LOG_T, Exception("abc"), "测试日志", "test class", 10, "test name")
            }
        })
    }
}