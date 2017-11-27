package com.learnwy.blog.pos

import com.fasterxml.jackson.annotation.JsonIgnore
import com.learnwy.blog.consts.Const.Companion.PREFIX
import com.learnwy.blog.consts.Const.Companion.SEPARATOR
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*
import kotlin.collections.HashMap

@Entity(name = Role.TABLE_NAME)
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null,
        var password: String? = null,
        var displayName: String? = null,
        @OneToOne
        @CreationTimestamp
        var createUser: User? = null,
        @Temporal(value = TemporalType.TIMESTAMP)
        var createDate: Date? = null,
        @OneToOne
        var updateUser: User? = null,
        @Temporal(value = TemporalType.TIMESTAMP)
        @CreationTimestamp
        @UpdateTimestamp
        var updateDate: Date? = null,
        @ManyToMany()
        @JsonIgnore
        var users: MutableList<User>
) {
    companion object {
        const val TABLE_NAME: String = "${PREFIX}${SEPARATOR}role"
        fun toTableColumns(): Map<String, String> {
            val ret: HashMap<String, String> = HashMap()
            ret.put("name", "s")
            return ret
        }
    }
}