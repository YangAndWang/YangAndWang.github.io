package com.learnwy.system.commom

class OrObject<One, Other>(var one: One? = null, var other: Other? = null) {
    fun getOneOrErr(): One {
        if (one !== null) {
            return one as One;
        }
        throw RuntimeException("one is null");
    }

    fun getOtherOrErr(): Other {
        if (other !== null) {
            return other as Other;
        }
        throw RuntimeException("other is null");
    }

    fun getOneOrNull(): One? {
        return one;
    }

    fun getOtherOrNull(): Other? {
        return other;
    }

    fun getOneOrAs(any: Any): Any {
        if (one !== null) {
            return one as Any;
        }
        return any;
    }

    fun getOtherOrAs(any: Any): Any {
        if (other !== null) {
            return other as Any;
        }
        return any;
    }
}