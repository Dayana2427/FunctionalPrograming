package products

fun main() {
    val products = ProductsRepository.products
    var filtered = filter(products, HighlyRatedProducts())
    filtered = filter(filtered, ProductGreaterThan500())
    filtered = filter(filtered, SportProduct())
    for (productCard in filtered){
        println(productCard)
    }
}


fun filter(products: List<ProductCard>, condition: Conditions): List<ProductCard> {
    val result = mutableListOf<ProductCard>()
    for (productCard in products){
        if (condition.isSuitable(productCard)){
            result.add(productCard)
        }
    }
    return result
}