package lectures.part4pm

object BracelessSyntax extends App {

  // --------------------------------------------
  // 1️⃣ What is braceless syntax?
  // --------------------------------------------
  // In Scala 3, you can often omit `{}` braces by relying on indentation.
  // This makes the code cleaner, more readable, and closer to natural language.

  // ✅ Old Scala 2 style:
  def greetOld(name: String): String = {
    if (name.isEmpty) {
      "Hello, Stranger!"
    } else {
      s"Hello, $name!"
    }
  }

  // ✅ New Scala 3 braceless style:
  def greet(name: String): String =
    if name.isEmpty then "Hello, Stranger!"
    else s"Hello, $name!"

  println(greet("Alice"))
  println(greet(""))

  // --------------------------------------------
  // 2️⃣ if / else expressions
  // --------------------------------------------
  // In braceless syntax, 'then' replaces '{' and indentation replaces '}'.

  val age = 20

  val status =
    if age >= 18 then "Adult"
    else "Minor"

  println(status)

  // --------------------------------------------
  // 3️⃣ for-comprehension
  // --------------------------------------------
  // You can also use indentation instead of braces in for loops

  val numbers = List(1, 2, 3)

  for n <- numbers do println(s"Number: $n")

  // --------------------------------------------
  // 4️⃣ match expressions
  // --------------------------------------------
  // One of the cleanest uses of braceless syntax is with pattern matching

  val day = "Mon"

  val typeOfDay = day match
    case "Mon" | "Tue" | "Wed" | "Thu" | "Fri" => "Weekday"
    case "Sat" | "Sun"                         => "Weekend"
    case _                                     => "Unknown"

  println(typeOfDay)

  // --------------------------------------------
  // 5️⃣ Classes, traits, and objects
  // --------------------------------------------
  // You can define classes without braces too!

  class Person(name: String, age: Int):
    def introduce(): String =
      s"Hi, I'm $name and I'm $age years old."

  val p = Person("Bob", 25)
  println(p.introduce())

  // --------------------------------------------
  // 6️⃣ Try it with given/using (advanced topic)
  // --------------------------------------------
  // Even given instances and extension methods can use braceless syntax:

  given defaultGreeting: String = "Hello from the given!"

  def greetGiven(using greeting: String): Unit =
    println(greeting)

  greetGiven

  // --------------------------------------------
  // 📊 Summary
  // --------------------------------------------
  /*
    ✅ Scala 3 braceless syntax replaces `{}` with indentation.
    ✅ 'then' is used in if/else, but not required in other cases.
    ✅ Works with: if/else, match, for, classes, objects, givens, etc.
    ✅ Cleaner and more readable, but indentation becomes significant.
    ✅ Be careful: incorrect indentation = incorrect scope.
   */
}
