data class Grocery(val name: String, val category: String, val unit: String, val unitPrice: Double, val quantity: Int) 

fun main() {
  val groceries = listOf(
    Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),
    Grocery("Mushrooms", "Vegetable", "lb", 4.0, 1),
    Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
    Grocery("Olive Oil", "Pantry", "Bottle", 6.0, 1),
    Grocery("Ice Cream", "Frozen", "Pack", 3.0, 2)
  )

  val ints = listOf(1, 2, 3, 4)
  val maxInt = ints.maxOrNull()
  println("This is the max of $ints ---> $maxInt")
  val highestUnitPrice = groceries.maxByOrNull { it.unitPrice }
  val lowestQuantity = groceries.minByOrNull { it.quantity }
  println("$highestUnitPrice --- $lowestQuantity")
  val sumQuantities = groceries.sumOf {
    it.quantity
  }
  val totalPrice = groceries.sumOf {
    it.quantity * it.unitPrice
  }
  println("$totalPrice for all the $sumQuantities")

  val vegetables = groceries.filter { it.category ==  "Vegetable" }
  println("${vegetables}")
  val unitPriceCover3 = groceries.filter { it.unitPrice > 3}
  println("${unitPriceCover3}")
  val notFrozen = groceries.filterNot {
    it.category == "Frozen"
  }
  println("${notFrozen}")
  val doubleInts = ints.map { it * 2}
  println("${doubleInts}")
  println("${groceries.map{it.name}}")
  val newPrices = groceries.filter { it.unitPrice > 3.0 }.map { it.unitPrice * 2 }
  println("${newPrices}")
  groceries.forEach { println(it.name) }

  var itemNames = ""
  groceries.forEach({ itemNames += "${it.name} "})
  println("itemNames: ${itemNames}")
  groceries.groupBy { it.category }.forEach {
    println(it.key)
    it.value.forEach { println("      ${it.name}")}
  }

  val allNames = groceries.fold("") { runningString, item -> runningString + " ${item.name}" }
  println("All Item names ${allNames}")

  val subtractFromFifty = groceries.fold(50.0) { change, item -> change - item.quantity * item.unitPrice}
  println("The change you get if you pay Fifty dollars for all groceries is ${subtractFromFifty}")
}