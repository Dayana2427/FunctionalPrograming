package products

fun main() {
    val products = ProductsRepository.products
    var filtered = filter(products) {it.productCategory == ProductCategory.CLOTHING}
    filtered = transform(filtered) {it.copy(productPrice = it.productPrice * 2)}
    val information = transform(filtered) {"${it.id} - ${it.productName} - ${it.productPrice}"}
    for (productCard in information){
        println(productCard)
    }
}

fun <P> transform (products: List<ProductCard>, operation: (ProductCard) -> P): List<P>{
    val result = mutableListOf<P>()
    for (productCard in products){
        result.add(operation(productCard))
    }
    return result
}


fun filter(products: List<ProductCard>, isSuitable: (ProductCard) -> Boolean): List<ProductCard> {
    val result = mutableListOf<ProductCard>()
    for (productCard in products){
        if (isSuitable(productCard)){
            result.add(productCard)
        }
    }
    return result
}