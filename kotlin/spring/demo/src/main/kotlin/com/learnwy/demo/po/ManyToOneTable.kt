package com.learnwy.demo.po;

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Entity
import com.learnwy.demo.consts.Const


@Entity()
data class ManyToOneTable(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null

) {
 companion object {
           const val TABLE_NAME = "${Const.PREFIX}${Const.SEPARATOR}manyToOneTable"
       }
}