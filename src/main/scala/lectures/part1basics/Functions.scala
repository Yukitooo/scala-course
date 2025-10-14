package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  // exercises

  // 1. A greeting function (name, age) => "Hi! My name is $name and I am $age years old"
  def greeting(name: String, age: Int): String = {
    s"Hi my name is $name and I am $age years old"
  }

  // 2. Factorial function 1*2*3*4 .. *n

  def factorial(n: Int): Int = {
    if (n == 1) n
    else n * factorial(n - 1)
  }

  println(factorial(5))

  // 3, A fibonacci function

  def fibonacci(n: Int): Int = {
    if (n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(4))

  // 4. Test if the number is prime

  def prime(n: Int): Boolean = {
    if (n % 2 == 0) true else false
  }

  println(prime(4))

}
