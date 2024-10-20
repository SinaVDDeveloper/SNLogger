package com.vd.snlogger.app;

import com.vd.snlogger.base.T;

/**
 * SNLogger的TAG设置例子
 *
 * @author leftatrium2@vip.qq.com
 */
public enum DemoLogT implements T {
    DEMO_LOG_T;

    @Override
    public String tag() {
        return toString();
    }
}
