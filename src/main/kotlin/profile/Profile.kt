package profile

import extensions.transform

fun main() {
    val profiles = ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.gender == Gender.MALE }
        .filter { it.firstName.startsWith("A") }
        .filter { it.age <30 }
        .toSet()
        .transform { it.copy(age = it.age + 1) }
        .map { it.firstName }

    for(person in profiles){
        println(person)
    }
}




