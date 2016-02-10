package com.kn.decorator

interface Car {
    fun go()
}

class Mercedes : Car {
    override fun go() {
        System.out?.print("Get out of the way ")
    }
}

class Ambulance(car: Car) : Decorator(car) {
    override fun go() {
        super.go()
        System.out?.print("beeee beee beee")
    }
}

open class Decorator(val car: Car) : Car {
    override fun go() {
        car.go()
    }
}

fun main(args: Array<String>) {
    val ambulance = Ambulance(Mercedes())
    ambulance.go()
}