package com.learnwy.system.fileMaps

import com.learnwy.system.commom.FileMap

class CssFileMap : FileMap {
    override fun mapSuffix(path: String): String? {
        var fileType = ("\\.(\\S*$)".toRegex()).find(path)?.groupValues?.get(0) ?: "";
        if (fileType === FileMap.FileType.CSS.name) {
            return "/static/css/${path}";
        }
        return null;
    }
}

