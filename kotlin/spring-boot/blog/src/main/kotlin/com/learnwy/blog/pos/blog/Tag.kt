package com.learnwy.blog.pos.blog

import com.learnwy.blog.consts.Const
import com.learnwy.blog.pos.blog.Tag.Companion.TABLE_NAME
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = TABLE_NAME)
data class Tag(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null,
        var displayName: String? = null
) {
    companion object {
        const val TABLE_NAME: String = "${Const.PREFIX}${Const.SEPARATOR}${Package.PACKAGE_LOWER_CASE}${Const.SEPARATOR}tag"
    }
}