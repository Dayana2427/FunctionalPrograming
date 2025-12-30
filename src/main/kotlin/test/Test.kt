package test

var age: Int? = 20

fun main() {
    val result = age?.let {
        if (it >= 18) {
            "Eres un adulto"
        } else {
            "Serás un adulto en ${18 - it} años"
        }
    }
    result?.let {
        println(it)
    }
}