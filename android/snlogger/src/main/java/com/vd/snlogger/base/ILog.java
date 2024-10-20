package com.vd.snlogger.base;

import com.vd.snlogger.util.SNLogLevel;
import com.vd.snlogger.util.SNLogMethodInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * SNLogger 扩展接口
 *
 * @author leftatrium2@vip.qq.com
 */
public interface ILog {
    /**
     * 可用
     *
     * @return true&false
     */
    boolean enable();

    /**
     * 日志记录
     *
     * @param tag        enum T或者继承类
     * @param logLevel   enum SNLogLevel
     * @param message    message
     * @param tr         Throwable,传递异常信息
     * @param methodInfo cls跟踪类
     */
    void onLog(T tag, SNLogLevel logLevel, @NonNull String message, @Nullable Throwable tr, @Nullable SNLogMethodInfo methodInfo);
}
