package dictionary

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import kotlin.time.measureTime

fun main() {
    val file = File("dictionary.json")
    val content = file.readText().trim()
    val dictionary = Json.decodeFromString<Map<String, String>>(content)
    showDescription(dictionary)
}

fun showDescription (dictionary: Map<String, String>){
    while (true){
        print("Ingrese la palabra o cero para salir: ")
        val input = readln().lowercase()
        if (input == "0") break
        val time = measureTime {
            dictionary[input]?.let { println(it) } ?: println("No encontrado")
        }
        println("Duración $time")
    }
}