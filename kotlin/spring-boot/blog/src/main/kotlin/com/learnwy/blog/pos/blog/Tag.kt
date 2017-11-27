package com.learnwy.blog.pos.blog

import com.learnwy.blog.consts.Const
import javax.persistence.Entity

@Entity()
data class Tag(
        var id: Long? = null
) {
    companion object {
        const val TABLE_NAME:String = "${Const.PREFIX}${Const.SEPARATOR}tag"
    }
}