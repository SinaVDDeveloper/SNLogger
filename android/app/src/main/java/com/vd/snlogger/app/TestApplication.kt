package com.vd.snlogger.app

import android.app.Application
import com.vd.snlogger.SNLogger
import com.vd.snlogger.app.impl.DemoLoggerImpl
import com.vd.snlogger.app.util.SaveFileUtils

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SaveFileUtils.init(applicationContext)
        SNLogger.addLogImpl(DemoLoggerImpl())
    }
}