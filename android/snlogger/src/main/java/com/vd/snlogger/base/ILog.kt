package com.vd.snlogger.base

import com.vd.snlogger.util.SNLogLevel
import com.vd.snlogger.util.SNLogMethodInfo

interface ILog {
    fun enable(): Boolean
    fun onLog(
        tag: T,
        logLevel: SNLogLevel,
        message: String,
        tr: Throwable?,
        methodInfo: SNLogMethodInfo?,
    )
}