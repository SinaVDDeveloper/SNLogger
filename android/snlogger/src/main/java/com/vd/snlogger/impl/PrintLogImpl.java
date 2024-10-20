package com.vd.snlogger.impl;

import android.util.Log;

import com.vd.snlogger.base.ILog;
import com.vd.snlogger.base.T;
import com.vd.snlogger.util.SNLogLevel;
import com.vd.snlogger.util.SNLogMethodInfo;
import com.vd.snlogger.util.SNLogUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * SNLogger的 LogCat 标准扩展
 *
 * @author leftatrium2@vip.qq.com
 */
public class PrintLogImpl implements ILog {

    @Override
    public boolean enable() {
        return true;
    }

    @Override
    public void onLog(T tag, SNLogLevel logLevel, @NonNull String message, @Nullable Throwable tr, @Nullable SNLogMethodInfo methodInfo) {
        switch (logLevel) {

            case v:
                Log.v(SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr);
                break;
            case d:
                Log.d(SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr);
                break;
            case i:
                Log.i(SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr);
                break;
            case w:
                Log.w(SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr);
                break;
            case e:
                Log.e(SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr);
                break;
            case crash:
                Log.e(SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr);
                break;
            case wtf:
                Log.e(SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr);
                break;
        }
    }
}
