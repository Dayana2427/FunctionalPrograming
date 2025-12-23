package profile

import jdk.dynalink.Operation

fun main() {
    val profiles = ProfilesRepository.profiles

    var filtered = filter(profiles) { it.age > 25 }
    filtered = filter(filtered) {it.gender == Gender.MALE }
    filtered = filter(filtered) {it.firstName.startsWith("A")}
    filtered = filter(filtered) {it.age <30}
    val names = transform(filtered) {it.firstName}
    val lastNames = transform(filtered) {it.lastName}
    val fullNames = transform(filtered) {"${it.firstName} ${it.lastName}"}
    for(person in fullNames){
        println(person)
    }
}

fun transform (profiles: List<Person>, operation: (Person) -> String): List<String> {
    val result = mutableListOf<String>()
    for (person in profiles){
        result.add(operation(person))
    }
    return result
}

fun filter(profiles: List<Person>, isSuitable: (Person) -> Boolean): List<Person> {
    val result = mutableListOf<Person>()
    for (person in profiles){
        if (isSuitable(person)){
            result.add(person)
        }
    }
    return result
}



