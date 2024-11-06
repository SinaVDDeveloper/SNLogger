package com.vd.snlogger.util

import com.vd.snlogger.SNLogger
import com.vd.snlogger.base.T

class SNLogUtils {
    companion object {
        fun parseContent(content: String, methodInfo: SNLogMethodInfo?): String {
            if (methodInfo != null) {
                return "[" + Thread.currentThread().id + "](" + methodInfo.clsName + ":" + methodInfo.lineNumber + ")" + methodInfo.methodName + ": " + content
            }
            return "[" + Thread.currentThread().id + "]" + ": " + content;
        }

        fun parseTAG(appTag: T): String {
            return SNLogger.TAG + "::" + appTag.toString()
        }
    }
}