package com.kn.builder

import java.util.*

enum class Gender {
    MALE, FEMALE
}

data class Person(val name: String,
                  val birth: Date,
                  val gender: Gender,
                  val country: String = "UKR")

fun main(args: Array<String>) {
    val person = Person(name = "Victor", birth = Date(), gender = Gender.MALE)
    print(person)
}
