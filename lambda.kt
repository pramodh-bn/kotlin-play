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
}