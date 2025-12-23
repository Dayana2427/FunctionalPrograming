package products

fun main() {
    val products = ProductsRepository.products

    var filtered = filter(products) {it.productRating > 4}
    filtered = filter(filtered) {it.productPrice > 500}
    filtered = filter(filtered) {it.productCategory == ProductCategory.SPORTS}
    for (productCard in filtered){
        println(productCard)
    }
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