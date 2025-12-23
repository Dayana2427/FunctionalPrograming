package products

fun main() {
    val products = ProductsRepository.products
    var filtered = filter(products, object: Conditions {
        override fun isSuitable(productCard: ProductCard): Boolean {
            return productCard.productRating > 4
        }
    })
    filtered = filter(filtered, object: Conditions {
        override fun isSuitable(productCard: ProductCard): Boolean {
            return productCard.productPrice > 500
        }
    })
    filtered = filter(filtered, object: Conditions {
        override fun isSuitable(productCard: ProductCard): Boolean {
            return productCard.productCategory == ProductCategory.SPORTS
        }
    })
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