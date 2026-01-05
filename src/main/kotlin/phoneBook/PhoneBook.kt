package phoneBook

fun main() {
    val contacts = mutableMapOf(
        "Alex" to "3134567890",
        "Nick" to "3234325676",
        "John" to "3256849708"
    )
    print("Ingrese el nombre: ")
    val name = readln()
    print("Ingrese el teléfono: ")
    val number = readln()
    contacts[name] = number
    showContact(contacts)
}

fun showContact (contacts: Map<String, String>) {
    while (true){
        print("Ingrese el nombre o 0 para salir: ")
        val name = readln()
        if (name == "0") break
            println(contacts[name] ?: "Not found")
    }
}