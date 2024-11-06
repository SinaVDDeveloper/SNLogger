package com.vd.snlogger.util

import com.vd.snlogger.base.T


enum class SNLogSDKT : T {
    CODE;

    override fun tag(): String {
        return toString()
    }
}