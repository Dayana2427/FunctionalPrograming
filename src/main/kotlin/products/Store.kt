package products

import extensions.myAlso

fun main() {
    ProductsRepository.products.myAlso {
        println("Flitrado por categoría: CLOTHING")
    }.filter { it.productCategory == ProductCategory.CLOTHING }.myAlso {
        println("Incremento de precio")
    }.map {it.copy(productPrice = it.productPrice * 2)}.myAlso {
        println("Covertir a String")
    }.map { "${it.id} - ${it.productName} - ${it.productPrice}" }.myAlso {
        println("Imprimir información")
    }.forEach { println(it) }



}

