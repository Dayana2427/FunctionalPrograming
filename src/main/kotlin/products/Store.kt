package products

fun main() {
    val products = ProductsRepository.products
        .filter {it.productCategory == ProductCategory.CLOTHING}
        .transform {it.copy(productPrice = it.productPrice * 2)}
        .transform { "${it.id} - ${it.productName} - ${it.productPrice}" }
    for (productCard in products){
        println(productCard)
    }
}

fun <P> List<ProductCard>.transform (operation: (ProductCard) -> P): List<P>{
    val result = mutableListOf<P>()
    for (productCard in this){
        result.add(operation(productCard))
    }
    return result
}


fun List<ProductCard>.filter(isSuitable: (ProductCard) -> Boolean): List<ProductCard> {
    val result = mutableListOf<ProductCard>()
    for (productCard in this){
        if (isSuitable(productCard)){
            result.add(productCard)
        }
    }
    return result
}