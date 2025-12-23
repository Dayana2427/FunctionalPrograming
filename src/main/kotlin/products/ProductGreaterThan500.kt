package products

class ProductGreaterThan500: Conditions {
    override fun isSuitable(productCard: ProductCard): Boolean {
        return productCard.productPrice > 500
    }
}