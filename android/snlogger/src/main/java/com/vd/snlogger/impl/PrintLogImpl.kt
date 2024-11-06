package com.vd.snlogger.impl

import android.util.Log
import com.vd.snlogger.base.ILog
import com.vd.snlogger.base.T
import com.vd.snlogger.util.SNLogLevel
import com.vd.snlogger.util.SNLogMethodInfo
import com.vd.snlogger.util.SNLogUtils

class PrintLogImpl : ILog {
    override fun enable(): Boolean {
        return true
    }

    override fun onLog(
        tag: T,
        logLevel: SNLogLevel,
        message: String,
        tr: Throwable?,
        methodInfo: SNLogMethodInfo?,
    ) {
        when (logLevel) {
            SNLogLevel.v -> Log.v(
                SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr
            )

            SNLogLevel.d -> Log.d(
                SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr
            )

            SNLogLevel.i -> Log.i(
                SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr
            )

            SNLogLevel.w -> Log.w(
                SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr
            )

            SNLogLevel.e -> Log.e(
                SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr
            )

            SNLogLevel.crash -> Log.e(
                SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr
            )

            SNLogLevel.wtf -> Log.e(
                SNLogUtils.parseTAG(tag), SNLogUtils.parseContent(message, methodInfo), tr
            )
        }
    }
}