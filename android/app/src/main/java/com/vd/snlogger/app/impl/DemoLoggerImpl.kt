package com.vd.snlogger.app.impl

import android.util.Log
import com.vd.snlogger.app.util.SaveFileUtils
import com.vd.snlogger.base.ILog
import com.vd.snlogger.base.T
import com.vd.snlogger.util.SNLogLevel
import com.vd.snlogger.util.SNLogMethodInfo
import com.vd.snlogger.util.SNLogUtils

class DemoLoggerImpl : ILog {
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
        val content = "TAG: " + SNLogUtils.parseTAG(tag) + ", content: " + SNLogUtils.parseContent(
            message,
            methodInfo
        )
        SaveFileUtils.save(content)
    }
}