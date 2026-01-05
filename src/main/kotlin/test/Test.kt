package test

fun main() {
    val dictionary = mutableMapOf<String, String>()
    dictionary["hello"] = "bojour"
    val keys = dictionary.keys
    for (key in keys){
        println(key)
    }
    val values = dictionary.values
    for (value in values){
        println(value)
    }
}