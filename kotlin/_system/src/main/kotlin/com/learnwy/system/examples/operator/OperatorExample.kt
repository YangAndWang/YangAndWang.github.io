package com.learnwy.system.examples.operator

class OperatorExample {
    class MyValPoint(val x: Int, val y: Int) {
        operator fun plus(point: MyValPoint): MyValPoint {
            return MyValPoint(this.x + point.x, this.y + point.y);
        }

        override fun toString(): String {
            return "MyValPoint(x=$x, y=$y)"
        }

    }

    class MyVarPoint(var x: Int, var y: Int) {
        operator fun plus(point: MyVarPoint): MyVarPoint {
            return MyVarPoint(this.x + point.x, this.y + point.y);
        }

        override fun toString(): String {
            return "MyVarPoint(x=$x, y=$y)"
        }

    }

    fun plus() {
        val vlP1 = MyValPoint(1, 1)
        val vlP2 = MyValPoint(2, 2)
        var vrP1 = MyVarPoint(1, 1)
        var vrP2 = MyVarPoint(2, 2)

        val vlP3 = vlP1 + vlP2

        var vrP3 = vrP1 + vrP2


        println("vlp1:$vlP1,vlp2:$vlP2,vlp3:$vlP3")
        println("vrp1:$vrP1,vrp2:$vrP2,vrp3:$vrP3")


    }

}