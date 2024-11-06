package com.vd.snlogger.app.impl;

import com.vd.snlogger.base.ILog;
import com.vd.snlogger.base.T;
import com.vd.snlogger.util.SNLogLevel;
import com.vd.snlogger.util.SNLogMethodInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 一个SNLogger扩展例子
 *
 * @author leftatrium2@vip.qq.com
 */
public class DemoSNLoggerImpl implements ILog {
    @Override
    public boolean enable() {
        return true;
    }

    @Override
    public void onLog(@NonNull T tag, @NonNull SNLogLevel logLevel, @NonNull String message, @Nullable Throwable tr, @Nullable SNLogMethodInfo methodInfo) {

    }
}
