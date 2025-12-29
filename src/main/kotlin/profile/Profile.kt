package profile

import extensions.myForEach
import extensions.transform

fun main() {
    ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.gender == Gender.MALE }
        .filter { it.firstName.startsWith("A") }
        .filter { it.age <30 }
        .toSet()
        .transform { it.copy(age = it.age + 1) }
        .sortedByDescending { it.age }
        .myForEach { println(it) }
}




