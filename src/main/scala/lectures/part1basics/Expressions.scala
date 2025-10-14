package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)

  // Instructions(DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)

  // EVERYTHING IN SCALA IS AN EXPRESSION

  // side effects: println(), whiles, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye" // The last expression is the value
  }

  // exercise:

  // 1. difference between "hello world" vs println("hello world")?
  // 2.

  val someValue = {
    2 < 3
  } // TRUE

  val someOtherValue = {
    if (someValue) 239 else 986
  } // 239

}
