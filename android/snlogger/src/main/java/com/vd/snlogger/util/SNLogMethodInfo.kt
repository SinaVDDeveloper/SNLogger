package com.vd.snlogger.util

import android.text.TextUtils
import com.vd.snlogger.SNLogger

class SNLogMethodInfo() {
    var clsName: String = "<unknown>"
    var lineNumber: Int = 0
    var methodName: String = "<unknown>"

    constructor(clsName: String, lineNumber: Int, methodName: String) : this() {
        this.clsName = clsName
        this.lineNumber = lineNumber
        this.methodName = methodName
    }

    companion object {
        fun methodInfo(): SNLogMethodInfo {
            return methodInfo(SNLogger::class.java)
        }

        fun methodInfo(cls: Class<*>): SNLogMethodInfo {
            val trace = Throwable().fillInStackTrace().stackTrace
            var info = SNLogMethodInfo()
            var isSNLog = false
            for (i in 1..trace.size) {
                if (trace[i].className == SNLogger::class.java.name) {
                    isSNLog = true
                }
                if (isSNLog && trace[i].className != SNLogger::class.java.name) {
                    var callingClass = trace[i].className
                    callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1)
                    if (!TextUtils.isEmpty(callingClass) && callingClass.contains("$")) {
                        callingClass = callingClass.substring(0, callingClass.indexOf("$"))
                    }
                    // Logcat中可点击
                    info.clsName = "$callingClass.java"
                    info.lineNumber = trace[i].lineNumber
                    info.methodName = trace[i].methodName
                    break
                }
            }
            return info
        }
    }
}