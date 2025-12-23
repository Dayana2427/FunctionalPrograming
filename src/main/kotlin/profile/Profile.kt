package profile

fun main() {
    val profiles = ProfilesRepository.profiles
    var filtered = filter(profiles, ConditionOlderThan25())
    filtered = filter(filtered, ConditionMale())
    filtered = filter(filtered, ConditionA())
    for(person in filtered){
        println(person)
    }
}

fun filter(profiles: List<Person>, condition: Condition): List<Person> {
    val result = mutableListOf<Person>()
    for (person in profiles){
        if (condition.isSuitable(person)){
            result.add(person)
        }
    }
    return result
}



