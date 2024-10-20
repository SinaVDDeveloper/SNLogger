package com.vd.snlogger.util;

import android.text.TextUtils;

import com.vd.snlogger.SNLogger;

import androidx.annotation.Nullable;

public class SNLogMethodInfo {
    public String clsName = "<unknown>";
    public int lineNumber = 0;
    public String methodName = "<unknown>";

    /**
     * 取消默认构造函数
     */
    private SNLogMethodInfo() {

    }

    public SNLogMethodInfo(String clsName, int lineNumber, String methodName) {
        this.clsName = clsName;
        this.lineNumber = lineNumber;
        this.methodName = methodName;
    }

    @Nullable
    public static SNLogMethodInfo methodInfo() {
        return methodInfo(SNLogger.class);
    }

    @Nullable
    public static SNLogMethodInfo methodInfo(Class cls) {
        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();

        SNLogMethodInfo info = new SNLogMethodInfo();
        boolean isSNLog = false;
        for (int i = 1; i < trace.length; i++) {
            if (trace[i].getClassName().equals(SNLogger.class.getName())) {
                isSNLog = true;
            }
            if (isSNLog && !trace[i].getClassName().equals(SNLogger.class.getName())) {
                String callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
                if (!TextUtils.isEmpty(callingClass) && callingClass.contains("$")) {
                    callingClass = callingClass.substring(0, callingClass.indexOf("$"));
                }
                // Logcat中可点击
                info.clsName = callingClass + ".java";
                info.lineNumber = trace[i].getLineNumber();
                info.methodName = trace[i].getMethodName();
                break;
            }
        }
        return info;
    }
}
