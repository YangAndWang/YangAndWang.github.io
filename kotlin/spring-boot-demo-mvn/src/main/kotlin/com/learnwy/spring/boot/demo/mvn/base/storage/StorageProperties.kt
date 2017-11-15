package com.learnwy.spring.boot.demo.mvn.base.storage


import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("storage")
data class StorageProperties(var location: String = "/learnwy/temp") {

}
