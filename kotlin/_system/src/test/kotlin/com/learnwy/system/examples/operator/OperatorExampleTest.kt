package com.learnwy.system.examples.operator

import org.junit.Test

import org.junit.Assert.*

class OperatorExampleTest {
    @Test
    fun plus() {
        var list = arrayListOf<Int>(1, 2, 3)
        var new1List = list + listOf<Int>(4, 5)
        println("list:$list,new1List:$new1List")
        val new2List = list + arrayListOf<Int>(4, 5)
        println("list:$list,new1List:$new1List,new2List:$new2List")
        new1List -= listOf<Int>(4, 5)
//        new2List -= listOf<Int>(4, 5)
        val new3List = new1List - listOf<Int>(4, 5)
//        new3List += listOf<Int>(4, 5)
        println("list:$list,new1List:$new1List,new2List:$new2List,new3List:$new3List")
    }

    @Test
    fun getIndex() {
        operator fun OperatorExample.MyVarPoint.get(index: Int): Int {
            return when (index) {
                0 -> x
                1 -> y
                else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
            }
        }

        var vrP1 = OperatorExample.MyVarPoint(1, 2)
        println("vrp1:${vrP1[0]},${vrP1[1]}")

    }
}