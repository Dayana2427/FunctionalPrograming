package extensions

fun <R, T> Iterable<T>.transform (operation: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (person in this){
        result.add(operation(person))
    }
    return result
}

inline fun <T> Iterable<T>.filter(isSuitable: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this){
        if (isSuitable(item)){
            result.add(item)
        }
    }
    return result
}

inline fun <T> Iterable<T>.myForEach(operation: (T) -> Unit) {
    for (item in this){
        operation(item)
    }
}

fun <T, R> T.myLet(block: (T) -> R): R {
    return block(this)
}

fun <T> T.myAlso(block: (T) -> Unit): T {
    block(this)
    return this
}
