package com.learnwy.blog.pos.blog

import com.learnwy.blog.consts.Const
import com.learnwy.blog.pos.blog.Language.Companion.TABLE_NAME
import javax.persistence.*

@Entity(name = TABLE_NAME)
data class Language(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @OneToOne
        var type: Type? = null,
        var value: String? = null
) {
    companion object {
        const val TABLE_NAME: String = "${Const.PREFIX}${Const.SEPARATOR}${Package.PACKAGE_LOWER_CASE}${Const.SEPARATOR}language"

    }
}