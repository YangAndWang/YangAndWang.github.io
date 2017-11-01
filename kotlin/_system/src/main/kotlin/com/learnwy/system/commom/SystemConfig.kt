package com.learnwy.system.commom

import com.learnwy.system.fileMaps.CssFileMap
import org.springframework.web.bind.annotation.RequestMethod

class SystemConfig {
    companion object {
        const val PREFIX = "learnwy";
        const val DELIMITER = "_";
        val fileMaps: MutableList<out FileMap> = mutableListOf<FileMap>(CssFileMap());
    }
}