package lectures.part2oop

object Exceptions extends App {

  // 1 .throwing exceptions
//   val aWeirdValue = throw new NullPointerException

  // throwable classes extend the THrowable class
  // Exception and Error are the major Throwable subtypes

  // 2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  try {
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    println("finally")
  }

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new Exception

  throw exception

}
