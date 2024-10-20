package com.vd.snlogger.util;

import com.vd.snlogger.base.T;

public enum SNLogSDKT implements T {
    CODE;

    @Override
    public String tag() {
        return toString();
    }
}
