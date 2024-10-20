package com.vd.snlogger.util;


import com.vd.snlogger.SNLogger;
import com.vd.snlogger.base.T;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class SNLogUtils {
    public static String parseContent(@NonNull String content, @Nullable SNLogMethodInfo methodInfo) {
        if (methodInfo != null) {
            return "[" +
                    Thread.currentThread().getId() +
                    "](" +
                    methodInfo.clsName +
                    ":" +
                    methodInfo.lineNumber +
                    ")" +
                    methodInfo.methodName +
                    ": " +
                    content;
        }
        return content;
    }

    public static String parseTAG(T appTag) {
        return SNLogger.TAG + "::" + appTag.toString();
    }
}
