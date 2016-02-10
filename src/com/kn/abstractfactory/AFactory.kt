package com.kn.abstractfactory

interface Bear {
    fun greeting(): String = "Hi!"
}

interface Cat {
    fun greeting(): String = "Hi!"
}

interface ToyFactory {
    fun getBear(): Bear
    fun getCat(): Cat
}

class TeddyBear : Bear {
    override fun greeting(): String = "${super.greeting()} I'm teddy bear"
}

class TeddyCat : Cat {
    override fun greeting(): String = "${super.greeting()} I'm teddy cat"
}

class WoodenCat : Cat {
    override fun greeting(): String = "${super.greeting()} I'm wooden cat"
}

class WoodenBear : Bear {
    override fun greeting(): String = "${super.greeting()} I'm wooden bear"
}

class TeddyToyFactory : ToyFactory {
    override fun getBear(): Bear = TeddyBear()
    override fun getCat(): Cat = TeddyCat()
}

class WoodenToyFactoryToyFactory : ToyFactory {
    override fun getBear(): Bear = WoodenBear()
    override fun getCat(): Cat = WoodenCat()
}

fun main(args: Array<String>) {
    val toyFactory = WoodenToyFactoryToyFactory()
    val bear = toyFactory.getBear()

    print(bear.greeting())
}


