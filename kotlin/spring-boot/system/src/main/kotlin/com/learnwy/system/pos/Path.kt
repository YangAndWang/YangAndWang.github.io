package com.learnwy.system.pos

import com.learnwy.system.SystemConst
import java.util.*
import javax.persistence.*

@Entity(name = Path.TABLE_NAME)
data class Path(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = -1L,

        @Column(nullable = false)
        var name: String = "",

        @Column(nullable = false)
        var userPermission: Long = 7L,

        @Column(nullable = false)
        var groupPermission: Long = 7L,

        @Column(nullable = false)
        var otherPermission: Long = 7L,

        var createDate: Date = Date(),


        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "create_main_user_id", referencedColumnName = "id")
        var createUser: User?,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "create_main_group_id", referencedColumnName = "id")
        var createGroup: Group?,

        var updateDate: Date = Date(),

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "update_main_user_id", referencedColumnName = "id")
        var updateUser: User?,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "update_main_group_id", referencedColumnName = "id")
        var updateGroup: Group?
) {
    companion object {
        const val TABLE_NAME = "${SystemConst.tablePrefix}${SystemConst.tableSeparator}path"
    }
}