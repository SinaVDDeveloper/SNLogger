package com.vd.snlogger.app;

import android.app.Application;

import com.vd.snlogger.SNLogger;
import com.vd.snlogger.app.impl.DemoLoggerImpl;
import com.vd.snlogger.app.util.SaveFileUtils;

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SaveFileUtils.init(getApplicationContext());
        SNLogger.addLogImpl(new DemoLoggerImpl());
    }
}
