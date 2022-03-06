fun unless(condition:Boolean, code: () -> Unit) {
  if(!condition) {
    code()
  }
}

fun getConversionLambda(str: String): (Double) -> Double {
  if(str == "CentigradeToFahrenheit") {
    return { it * 1.8 + 32 }
  } else if(str == "KgsToPounds") {
    return { it * 2.20463}
  } else if(str == "PoundsToUSTons") {
    return { it / 2000.0 }
  } else {
    return { it }
  }
}

fun combine(lambda1: (Double) -> Double, lambda2: (Double) -> Double): (Double) -> Double {
  return {x:Double -> lambda2(lambda1(x)) }
}

typealias DoubleConversion = (Double) -> Double

fun convert(x: Double, converter: DoubleConversion): Double {
  val result = converter(x)
  println("$x is converted to $result")
  return result
}

fun combine1(lambda1: DoubleConversion, lambda2: DoubleConversion): DoubleConversion {
  return {x: Double -> lambda2(lambda1(x))}
} 

fun getConversionLambda1(str: String): DoubleConversion {
  if(str == "CentigradeToFahrenheit") {
    return { it * 1.8 + 32 }
  } else if(str == "KgsToPounds") {
    return { it * 2.20463}
  } else if(str == "PoundsToUSTons") {
    return { it / 2000.0 }
  } else {
    return { it }
  }
}

fun main() {
  val options = arrayOf("Red", "Amber", "Green")
  var crossWalk = options[(Math.random() * options.size).toInt()]
  if(crossWalk == "Green") {
    println("Walk!")
  } 
  unless(crossWalk == "Green") {
    println("Stop")
  }

  val pounds = getConversionLambda("KgsToPounds")(2.5)
  println("These are the $pounds")
// Define two conversion lambdas
  val kgsToPounds = { x: Double -> x * 2.204623 }
  val poundsToUSTons = { x: Double -> x / 2000.0}
  // Combine the two lambdas to create a new1
  val kgsToUsTons = combine(kgsToPounds, poundsToUSTons)
  // invoke the kgsToUsTons lambda
  val usTons = kgsToUsTons(10000.0)
  println("This is usTons $usTons")

  // convert 2.5kgs to Pounds
  println("Convert 2.5kgs to Pounds: ${getConversionLambda1("KgsToPounds")(2.5)}")
  // Define 2 conversion lambdas
  val kgsToPoundsLambda = getConversionLambda1("KgsToPounds")
  val poundsToUsTonsLambda = getConversionLambda1("poundsToUSTons")

  //combine the lambdas to create new ones
  val kgsToUsTonsLambda = combine1(kgsToPoundsLambda, poundsToUsTonsLambda)
  val value = 17.4
  println("$value of kgs is ${convert(value, kgsToUsTonsLambda)} US Tons")
}

