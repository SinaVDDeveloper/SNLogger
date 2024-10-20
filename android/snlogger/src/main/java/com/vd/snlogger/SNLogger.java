package com.vd.snlogger;


import com.vd.snlogger.base.ILog;
import com.vd.snlogger.base.T;
import com.vd.snlogger.impl.PrintLogImpl;
import com.vd.snlogger.util.SNLogLevel;
import com.vd.snlogger.util.SNLogMethodInfo;
import com.vd.snlogger.util.SNLogSDKT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SNLogger主入口
 *
 * @author leftatrium2@vip.qq.com
 */
public class SNLogger {
    public final static String TAG = "SNLogger";

    private static List<ILog> sLogList = Collections.synchronizedList(new ArrayList<ILog>());

    private static LogExecute sLogExeI, sLogExeD, sLogExeV, sLogExeW, sLogExeE, sLogExeCrash, sLogExeWTF;

    static {
        addLogImpl(new PrintLogImpl());
        sLogExeD = new LogExecute() {
            @Override
            public void execute(ILog log, T tag, Throwable tr, String content, SNLogMethodInfo info) {
                if (info == null) {
                    info = SNLogMethodInfo.methodInfo();
                }
                log.onLog(tag, SNLogLevel.d, content, tr, info);
            }
        };
        sLogExeI = new LogExecute() {
            @Override
            public void execute(ILog log, T tag, Throwable tr, String content, SNLogMethodInfo info) {
                if (info == null) {
                    info = SNLogMethodInfo.methodInfo();
                }
                log.onLog(tag, SNLogLevel.i, content, tr, info);
            }
        };
        sLogExeV = new LogExecute() {
            @Override
            public void execute(ILog log, T tag, Throwable tr, String content, SNLogMethodInfo info) {
                if (info == null) {
                    info = SNLogMethodInfo.methodInfo();
                }
                log.onLog(tag, SNLogLevel.v, content, tr, info);
            }
        };
        sLogExeW = new LogExecute() {
            @Override
            public void execute(ILog log, T tag, Throwable tr, String content, SNLogMethodInfo info) {
                if (info == null) {
                    info = SNLogMethodInfo.methodInfo();
                }
                log.onLog(tag, SNLogLevel.w, content, tr, info);
            }
        };
        sLogExeE = new LogExecute() {
            @Override
            public void execute(ILog log, T tag, Throwable tr, String content, SNLogMethodInfo info) {
                if (info == null) {
                    info = SNLogMethodInfo.methodInfo();
                }
                log.onLog(tag, SNLogLevel.e, content, tr, info);
            }
        };
        sLogExeCrash = new LogExecute() {
            @Override
            public void execute(ILog log, T tag, Throwable tr, String content, SNLogMethodInfo info) {
                if (info == null) {
                    //在crash以及WTF情况下，不管是否打开ismethodinfo，都默认上报当前class信息
                    info = SNLogMethodInfo.methodInfo();
                }
                log.onLog(tag, SNLogLevel.crash, content, tr, info);
            }
        };
        sLogExeWTF = new LogExecute() {
            @Override
            public void execute(ILog log, T tag, Throwable tr, String content, SNLogMethodInfo info) {
                if (info == null) {
                    //在crash以及WTF情况下，不管是否打开ismethodinfo，都默认上报当前class信息
                    info = SNLogMethodInfo.methodInfo();
                }
                log.onLog(tag, SNLogLevel.wtf, content, tr, info);
            }
        };
    }

    //**********************debug级别log日志************************
    @Deprecated
    public static void d(String content) {
        log(sLogExeD, SNLogSDKT.CODE, null, content, null);
    }

    @Deprecated
    public static void d(String tag, String content) {
        log(sLogExeD, SNLogSDKT.CODE, null, content, null);
    }

    public static void d(T tag, String content) {
        log(sLogExeD, tag, null, content, null);
    }

    public static void d(T tag, Throwable tr, String content) {
        log(sLogExeD, tag, tr, content, null);
    }

    public static void d(T tag, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeD, tag, null, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    public static void d(T tag, Throwable tr, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeD, tag, tr, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    //**********************info级别log日志*************************
    @Deprecated
    public static void i(String content) {
        log(sLogExeI, SNLogSDKT.CODE, null, content, null);
    }

    @Deprecated
    public static void i(String tag, String content) {
        log(sLogExeI, SNLogSDKT.CODE, null, content, null);
    }

    public static void i(T tag, String content) {
        log(sLogExeI, tag, null, content, null);
    }

    public static void i(T tag, Throwable tr, String content) {
        log(sLogExeI, tag, tr, content, null);
    }

    public static void i(T tag, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeI, tag, null, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    public static void i(T tag, Throwable tr, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeI, tag, tr, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    //*********************verbose级别log日志***********************
    @Deprecated
    public static void v(String content) {
        log(sLogExeV, SNLogSDKT.CODE, null, content, null);
    }

    @Deprecated
    public static void v(String tag, String content) {
        log(sLogExeV, SNLogSDKT.CODE, null, content, null);
    }

    public static void v(T tag, String content) {
        log(sLogExeV, tag, null, content, null);
    }

    public static void v(T tag, Throwable tr, String content) {
        log(sLogExeV, tag, tr, content, null);
    }

    public static void v(T tag, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeV, tag, null, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    public static void v(T tag, Throwable tr, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeV, tag, tr, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    //**********************warn级别log日志*************************
    @Deprecated
    public static void w(String content) {
        log(sLogExeW, SNLogSDKT.CODE, null, content, null);
    }

    @Deprecated
    public static void w(final Throwable tr, String content) {
        log(sLogExeW, SNLogSDKT.CODE, null, content, null);
    }

    @Deprecated
    public static void w(String tag, final Throwable tr, String content) {
        log(sLogExeW, SNLogSDKT.CODE, tr, content, null);
    }

    public static void w(T tag, String content) {
        log(sLogExeW, tag, null, content, null);
    }

    public static void w(T tag, final Throwable tr, String content) {
        log(sLogExeW, tag, tr, content, null);
    }

    public static void w(T tag, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeW, tag, null, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    public static void w(T tag, final Throwable tr, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeW, tag, tr, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    //***********************error级别日志**************************
    @Deprecated
    public static void e(String content) {
        log(sLogExeE, SNLogSDKT.CODE, null, content, null);
    }

    @Deprecated
    public static void e(final Throwable tr, String content) {
        log(sLogExeE, SNLogSDKT.CODE, null, content, null);
    }

    @Deprecated
    public static void e(String tag, final Throwable tr, String content) {
        log(sLogExeE, SNLogSDKT.CODE, tr, content, null);
    }

    public static void e(T tag, String content) {
        log(sLogExeE, tag, null, content, null);
    }

    public static void e(T tag, final Throwable tr, String content) {
        log(sLogExeE, tag, tr, content, null);
    }

    public static void e(T tag, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeE, tag, null, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    public static void e(T tag, final Throwable tr, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeE, tag, tr, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    //***********************crash异常日志**************************
    @Deprecated
    public static void crash(String tag, final Throwable tr, String content) {
        log(sLogExeCrash, SNLogSDKT.CODE, null, content, null);
    }

    public static void crash(T tag, String content) {
        log(sLogExeCrash, tag, null, content, null);
    }

    public static void crash(T tag, final Throwable tr) {
        log(sLogExeCrash, tag, tr, "", null);
    }

    public static void crash(T tag, final Throwable tr, String content) {
        log(sLogExeCrash, tag, tr, content, null);
    }

    public static void crash(T tag, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeCrash, tag, null, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    public static void crash(T tag, final Throwable tr, String clsName, int lineNumber, String methodName) {
        log(sLogExeCrash, tag, tr, "", new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    public static void crash(T tag, final Throwable tr, String content, String clsName, int lineNumber, String methodName) {
        log(sLogExeCrash, tag, tr, content, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    //***********************非常严重级别，需要上报到code中**************************
    public static void wtf(T tag, String msg) {
        log(sLogExeWTF, tag, null, msg, null);
    }

    public static void wtf(T tag, final Throwable tr, String msg) {
        log(sLogExeWTF, tag, tr, msg, null);
    }

    public static void wtf(T tag, String msg, String clsName, int lineNumber, String methodName) {
        log(sLogExeWTF, tag, null, msg, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    public static void wtf(T tag, final Throwable tr, String msg, String clsName, int lineNumber, String methodName) {
        log(sLogExeWTF, tag, tr, msg, new SNLogMethodInfo(clsName, lineNumber, methodName));
    }

    //***********************内部方法**************************
    private static void log(LogExecute logExecute, T tag, Throwable tr, String content, SNLogMethodInfo info) {
        try {
            if (logExecute == null) {
                return;
            }
            if (sLogList == null || sLogList.isEmpty()) {
                return;
            }
            for (ILog log : sLogList) {
                if (log == null || !log.enable()) {
                    continue;
                }
                logExecute.execute(log, tag, tr, content, info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface LogExecute {
        void execute(ILog log, T tag, Throwable tr, String content, SNLogMethodInfo info);
    }

    public static void addLogImpl(ILog log) {
        if (log != null) {
            sLogList.add(log);
        }
    }

}
