package com.learnwy.blog.pos

import com.fasterxml.jackson.annotation.JsonIgnore
import com.learnwy.blog.consts.SystemConst.Companion.PREFIX
import com.learnwy.blog.consts.SystemConst.Companion.SEPARATOR
import java.util.*
import javax.persistence.*

@Entity(name = User.TABLE_NAME)
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null,
        var email: String? = null,
        var password: String? = null,
        var displayName: String? = null,
        @OneToOne
        var createUser: User? = null,
        var createDate: Date? = null,
        @OneToOne
        var updateUser: User? = null,
        var updateDate: Date? = null,

        @ManyToMany(mappedBy = "users")
        @JsonIgnore
        var roles: MutableList<Role>? = null
) {
    companion object {
        const val TABLE_NAME: String = "${PREFIX}${SEPARATOR}user"
    }
}