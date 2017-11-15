package com.learnwy.spring.boot.demo.mvn.dtos

import java.io.Serializable


class Book(var isbn: String?, var title: String?) : Serializable {

    override fun toString(): String {
        return "Book{isbn='$isbn', title='$title'}"
    }

}