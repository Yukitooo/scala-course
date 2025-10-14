package playground

object ValueVariablesTypes extends App {
  val x: Int = 42

  println(x)

  // VALS ARE IMMUTABLE
  // COMPILER can infer types

  // string

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x

}
