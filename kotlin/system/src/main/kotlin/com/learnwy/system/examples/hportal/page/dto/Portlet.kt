package com.learnwy.system.examples.hportal.page.dto

import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Portlet(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = -1,
        @NotNull
        var left: Int = 0,
        @NotNull
        var top: Int = 0,
        @NotNull
        var width: Int = 200,
        @NotNull
        var height: Int = 100,
        @NotNull
        var zIndex: Int = 0,
        @NotNull
        var pageId: Long = 1
) {
}