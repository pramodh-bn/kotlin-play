fun main(args: Array<String>) {
  val addFive = {x:Int -> x + 5}
  println("Hello world!")
  val addSomething = addFive(10)
  println(addSomething)
  println(addFive.invoke(18))
  val addInts = {x: Int, y: Int -> x+y}
  println(addInts(5,6))
  val greeting: () -> String = {"Hello"}
  println(greeting())
  val myLambda: () -> Unit = { println("Hello Lambda")}
  myLambda()
  val converter = {x: Double -> x*x}
  println(convert(100.25, converter))
  convert(20.0) { it * 20.0 + 6.1}
  convertFive { it * 4.5 + 10000.09999}
}

fun convert(x: Double, converter: (Double)-> Double): Double {
  // code to convert the Double
  val result = converter(x)
  println("$x is convereted to $result")
  return result
}

fun convertFive(converter: (Int) -> Double): Double {
  val result = converter(5)
  println("5 is converted to $result")
  return result
}
