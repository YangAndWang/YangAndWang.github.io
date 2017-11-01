package com.learnwy.system.commom

import java.awt.Color

interface FileMap {
    fun mapSuffix(fileType: String): String? {
        return null;
    };
    fun mapPrefix(path: String): String? {
        return null;
    };
    fun map(path: String): String? {
        return null;
    };
    enum class FileType(suffix: String) {
        PNG("png"),
        JPEG("jpeg"),
        HTML("html"),
        CSS("css"),
        JS("js")
    }
}