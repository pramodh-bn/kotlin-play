fun main(args: Array<String>){
    val ints = listOf(1,3, 4, 5)
    val sumOfInts = ints.fold(0) {runningSum, item -> runningSum + item}
    println("Sum of ints via fold ${sumOfInts}")
    val prodOfInts = ints.fold(1) { runningProd, item -> runningProd * item}
    println("Product of ints via fold ${prodOfInts}")
}