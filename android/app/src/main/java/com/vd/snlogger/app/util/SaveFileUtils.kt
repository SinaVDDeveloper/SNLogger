package com.vd.snlogger.app.util

import android.content.Context
import java.io.File
import java.nio.charset.StandardCharsets

class SaveFileUtils {
    companion object {
        private lateinit var file: File

        @JvmStatic
        fun init(context: Context) {
            val fileName = "snlogger.log"
            file = File(context.filesDir, fileName)
        }

        @JvmStatic
        fun save(msg: String) {
            if (file.canWrite()) {
                file.appendText(msg + "\n", StandardCharsets.UTF_8)
            }
        }
    }
}