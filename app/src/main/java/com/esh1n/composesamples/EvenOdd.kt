package com.esh1n.composesamples

class EvenOdd(private val isUpperCase: Boolean) {
    fun check(value: Int): String {
        val result = if (value % 2 == 0) {
            "even"
        } else {
            "odd"
        }
        return if (isUpperCase) {
            result.uppercase()
        } else {
            result
        }.plus("\n").plus(toString())
    }

    override fun toString(): String {
        return "EvenOdd(isUpperCase=$isUpperCase) hashcode ${hashCode()}"
    }
}