package lectures.part3fp

import scala.util.{Try, Success, Failure}

object HandlingFailure extends App {

  // --------------------------------------------
  // 1️⃣ WHAT IS Try?
  // --------------------------------------------
  // Try is a wrapper for computations that might throw exceptions.
  // - Success(value): if the computation succeeds
  // - Failure(exception): if it throws an error

  def unsafeMethod(): String = throw new RuntimeException("BOOM 💥")

  val attempted = Try(unsafeMethod()) // This won't crash the program
  println(attempted) // Failure(java.lang.RuntimeException: BOOM 💥)

  val safeCall = Try("Hello Scala!") // Success(Hello Scala!)
  println(safeCall)

  // --------------------------------------------
  // 2️⃣ WORKING WITH Try
  // --------------------------------------------
  // You can check success or failure using pattern matching

  attempted match {
    case Success(value) => println(s"Computation succeeded: $value")
    case Failure(ex)    => println(s"Computation failed: ${ex.getMessage}")
  }

  // --------------------------------------------
  // 3️⃣ getOrElse - Default if it fails
  // --------------------------------------------
  val result = Try(unsafeMethod()).getOrElse("Default Value")
  println(result) // ✅ "Default Value" instead of crashing

  // --------------------------------------------
  // 4️⃣ map, flatMap, filter - Same as Option
  // --------------------------------------------
  def safeDivide(a: Int, b: Int): Try[Int] = Try(a / b)

  val division = safeDivide(10, 2).map(_ * 10)
  println(division) // Success(50)

  val failedDivision = safeDivide(10, 0).map(_ * 10)
  println(failedDivision) // Failure(java.lang.ArithmeticException: / by zero)

  // flatMap - chain risky computations
  val chained = safeDivide(10, 2).flatMap(x => safeDivide(x, 2))
  println(chained) // Success(2)

  // filter - keep result only if condition holds
  val filtered = safeDivide(10, 2).filter(_ > 5)
  println(filtered) // Success(5) ✅ condition true

  val filteredFail = safeDivide(10, 2).filter(_ > 10)
  println(
    filteredFail
  ) // Failure(java.util.NoSuchElementException: Predicate does not hold)

  // --------------------------------------------
  // 5️⃣ for-comprehension - Clean chaining
  // --------------------------------------------
  val computation: Try[Int] = for {
    a <- safeDivide(20, 2)
    b <- safeDivide(a, 2)
  } yield b

  println(computation) // Success(5)

  // --------------------------------------------
  // 6️⃣ Recover and recoverWith - graceful error handling
  // --------------------------------------------
  val riskyResult = safeDivide(10, 0).recover { case _: ArithmeticException =>
    0
  }
  println(riskyResult) // Success(0) ✅ handled gracefully

  val riskyResult2 = safeDivide(10, 0).recoverWith {
    case _: ArithmeticException => Try(10 / 2)
  }
  println(riskyResult2) // Success(5)

  // --------------------------------------------
  // 📊 Summary
  // --------------------------------------------
  /*
    ✅ Try is a safer alternative to throwing exceptions.
    ✅ Success(value): computation succeeded
    ✅ Failure(exception): computation failed
    ✅ Use:
        - getOrElse: default value if it fails
        - map/flatMap: transform successful results
        - filter: keep only results that pass a condition
        - recover/recoverWith: handle specific errors gracefully
        - for-comprehension: chain multiple risky computations
   */
}
