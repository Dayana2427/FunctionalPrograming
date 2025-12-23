package products

class HighlyRatedProducts: Conditions {
    override fun isSuitable(productCard: ProductCard): Boolean {
        return productCard.productRating > 4
    }
}