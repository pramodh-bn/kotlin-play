data class Grocery(val name: String, val category: String, val unit: String, val unitPrice: Double, val quantity: Int) 

fun main() {
  val grocerties = listOf(
    Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),
    Grocery("Mushrooms", "Vegetable", "lb", 4.0, 1),
    Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
    Grocery("Olive Oil", "Pantry", "Bottle", 6.0, 1),
    Grocery("Ice Cream", "Frozen", "Pack", 3.0, 2)
  )
}