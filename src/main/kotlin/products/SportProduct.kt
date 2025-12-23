package products

class SportProduct: Conditions {
    override fun isSuitable(productCard: ProductCard): Boolean {
        return productCard.productCategory == ProductCategory.SPORTS
    }
}