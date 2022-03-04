fun main(args: Array<String>) {
  val addFive = {x:Int -> x + 5}
  println("Hello world!")
  val addSomething = addFive(10)
  println(addSomething)
  println(addFive.invoke(18))
  val addInts = {x: Int, y: Int -> x+y}
  println(addInts(5,6))
}
