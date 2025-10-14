package lectures.part1basics

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println(
        "Computing factorial of " + n + " - I first need factorial of " + (n - 1)
      )
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }
  println(factorial(10))

  def anotherFactorial(n: Int): Int = {
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else
        factHelper(
          x - 1,
          x * accumulator
        ) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)

  }

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
    1. Concatenate a string n times.
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive.
   */

  def stringConcatenate(aString: String, n: Int): String = {
    if (n <= 1) aString
    else aString + stringConcatenate(aString, n - 1)
  }

  println(stringConcatenate("Yuki", 4))

}
