package com.vd.snlogger

import com.vd.snlogger.base.ILog
import com.vd.snlogger.base.T
import com.vd.snlogger.impl.PrintLogImpl
import com.vd.snlogger.util.SNLogLevel
import com.vd.snlogger.util.SNLogMethodInfo
import com.vd.snlogger.util.SNLogSDKT

object SNLogger {
    const val TAG = "SNLogger"
    private var sLogList: MutableList<ILog> = mutableListOf()
    private lateinit var sLogExeI: LogExecute
    private lateinit var sLogExeD: LogExecute
    private lateinit var sLogExeV: LogExecute
    private lateinit var sLogExeW: LogExecute
    private lateinit var sLogExeE: LogExecute
    private lateinit var sLogExeCrash: LogExecute
    private lateinit var sLogExeWTF: LogExecute

    init {
        addLogImpl(PrintLogImpl())

        sLogExeI = object : LogExecute {
            override fun execute(
                log: ILog,
                tag: T,
                content: String,
                tr: Throwable?,
                info: SNLogMethodInfo?,
            ) {
                log.onLog(tag, SNLogLevel.i, content, tr, info)
            }
        }

        sLogExeD = object : LogExecute {
            override fun execute(
                log: ILog,
                tag: T,
                content: String,
                tr: Throwable?,
                info: SNLogMethodInfo?,
            ) {
                log.onLog(tag, SNLogLevel.d, content, tr, info)
            }
        }

        sLogExeV = object : LogExecute {
            override fun execute(
                log: ILog,
                tag: T,
                content: String,
                tr: Throwable?,
                info: SNLogMethodInfo?,
            ) {
                log.onLog(tag, SNLogLevel.v, content, tr, info)
            }
        }

        sLogExeW = object : LogExecute {
            override fun execute(
                log: ILog,
                tag: T,
                content: String,
                tr: Throwable?,
                info: SNLogMethodInfo?,
            ) {
                log.onLog(tag, SNLogLevel.w, content, tr, info)
            }

        }

        sLogExeE = object : LogExecute {
            override fun execute(
                log: ILog,
                tag: T,
                content: String,
                tr: Throwable?,
                info: SNLogMethodInfo?,
            ) {
                log.onLog(tag, SNLogLevel.e, content, tr, info)
            }

        }

        sLogExeCrash = object : LogExecute {
            override fun execute(
                log: ILog,
                tag: T,
                content: String,
                tr: Throwable?,
                info: SNLogMethodInfo?,
            ) {
                log.onLog(tag, SNLogLevel.crash, content, tr, info)
            }

        }

        sLogExeWTF = object : LogExecute {
            override fun execute(
                log: ILog,
                tag: T,
                content: String,
                tr: Throwable?,
                info: SNLogMethodInfo?,
            ) {
                log.onLog(tag, SNLogLevel.wtf, content, tr, info)
            }

        }
    }

    @JvmStatic
    fun addLogImpl(log: ILog) {
        sLogList.add(log)
    }


    @JvmStatic
    fun d(content: String) {
        log(sLogExeD, SNLogSDKT.CODE, content, null, null)
    }

    @JvmStatic
    fun d(tag: T, content: String) {
        log(sLogExeD, tag, content, null, null)
    }

    @JvmStatic
    fun d(tag: T, tr: Throwable, content: String) {
        log(sLogExeD, tag, content, tr, null)
    }

    @JvmStatic
    fun d(tag: T, content: String, clsName: String, lineNumber: Int, methodName: String) {
        log(sLogExeD, tag, content, null, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun d(
        tag: T,
        tr: Throwable,
        content: String,
        clsName: String,
        lineNumber: Int,
        methodName: String,
    ) {
        log(sLogExeD, tag, content, tr, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun i(content: String) {
        log(sLogExeI, SNLogSDKT.CODE, content, null, null)
    }

    @JvmStatic
    fun i(tag: T, content: String) {
        log(sLogExeI, tag, content, null, null)
    }

    @JvmStatic
    fun i(tag: T, tr: Throwable, content: String) {
        log(sLogExeI, tag, content, tr, null)
    }

    @JvmStatic
    fun i(tag: T, content: String, clsName: String, lineNumber: Int, methodName: String) {
        log(sLogExeI, tag, content, null, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun i(
        tag: T,
        tr: Throwable,
        content: String,
        clsName: String,
        lineNumber: Int,
        methodName: String,
    ) {
        log(sLogExeI, tag, content, tr, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun v(content: String) {
        log(sLogExeV, SNLogSDKT.CODE, content, null, null)
    }

    @JvmStatic
    fun v(tag: T, content: String) {
        log(sLogExeV, tag, content, null, null)
    }

    @JvmStatic
    fun v(tag: T, tr: Throwable, content: String) {
        log(sLogExeV, tag!!, content, tr, null)
    }

    @JvmStatic
    fun v(tag: T, content: String, clsName: String, lineNumber: Int, methodName: String) {
        log(sLogExeV, tag, content, null, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun v(
        tag: T,
        tr: Throwable,
        content: String,
        clsName: String,
        lineNumber: Int,
        methodName: String,
    ) {
        log(sLogExeV, tag, content, tr, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun w(content: String) {
        log(sLogExeW, SNLogSDKT.CODE, content, null, null)
    }

    @JvmStatic
    fun w(tag: T, content: String) {
        log(sLogExeW, tag, content, null, null)
    }

    @JvmStatic
    fun w(tag: T, tr: Throwable, content: String) {
        log(sLogExeW, tag, content, tr, null)
    }

    @JvmStatic
    fun w(tag: T, content: String, clsName: String, lineNumber: Int, methodName: String) {
        log(sLogExeW, tag, content, null, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun w(
        tag: T,
        tr: Throwable,
        content: String,
        clsName: String,
        lineNumber: Int,
        methodName: String,
    ) {
        log(sLogExeW, tag, content, tr, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun e(content: String) {
        log(sLogExeE, SNLogSDKT.CODE, content, null, null)
    }

    @JvmStatic
    fun e(tag: T, content: String) {
        log(sLogExeE, tag, content, null, null)
    }

    @JvmStatic
    fun e(tag: T, tr: Throwable, content: String) {
        log(sLogExeE, tag, content, tr, null)
    }

    @JvmStatic
    fun e(tag: T, content: String, clsName: String, lineNumber: Int, methodName: String) {
        log(sLogExeE, tag, content, null, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun e(
        tag: T,
        tr: Throwable,
        content: String,
        clsName: String,
        lineNumber: Int,
        methodName: String,
    ) {
        log(sLogExeE, tag, content, tr, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun crash(tag: T, content: String) {
        log(sLogExeCrash, tag, content, null, null)
    }

    @JvmStatic
    fun crash(tag: T, tr: Throwable) {
        log(sLogExeCrash, tag, "", tr, null)
    }

    @JvmStatic
    fun crash(tag: T, tr: Throwable, content: String) {
        log(sLogExeCrash, tag, content, tr, null)
    }

    @JvmStatic
    fun crash(
        tag: T,
        content: String,
        clsName: String,
        lineNumber: Int,
        methodName: String,
    ) {
        log(sLogExeCrash, tag, content, null, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun crash(tag: T, tr: Throwable, clsName: String, lineNumber: Int, methodName: String) {
        log(sLogExeCrash, tag, "", tr, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun crash(
        tag: T,
        tr: Throwable,
        content: String,
        clsName: String,
        lineNumber: Int,
        methodName: String,
    ) {
        log(sLogExeCrash, tag, content, tr, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun wtf(tag: T, msg: String) {
        log(sLogExeWTF, tag, msg, null, null)
    }

    @JvmStatic
    fun wtf(tag: T, tr: Throwable, msg: String) {
        log(sLogExeWTF, tag, msg, tr, null)
    }

    @JvmStatic
    fun wtf(tag: T, msg: String, clsName: String, lineNumber: Int, methodName: String) {
        log(sLogExeWTF, tag, msg, null, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    @JvmStatic
    fun wtf(
        tag: T,
        tr: Throwable,
        msg: String,
        clsName: String,
        lineNumber: Int,
        methodName: String,
    ) {
        log(sLogExeWTF, tag, msg, tr, SNLogMethodInfo(clsName, lineNumber, methodName))
    }

    private fun log(
        logExecute: LogExecute,
        tag: T,
        content: String,
        tr: Throwable?,
        info: SNLogMethodInfo?,
    ) {
        try {
            for (log in sLogList) {
                if (!log.enable()) {
                    continue
                }
                logExecute.execute(log, tag, content, tr, info)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    interface LogExecute {
        fun execute(log: ILog, tag: T, content: String, tr: Throwable?, info: SNLogMethodInfo?)
    }
}