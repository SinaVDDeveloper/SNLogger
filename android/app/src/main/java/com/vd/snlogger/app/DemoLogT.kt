package com.vd.snlogger.app

import com.vd.snlogger.base.T

enum class DemoLogT : T {
    DEMO_LOG_T;

    override fun tag(): String {
        return toString()
    }
}